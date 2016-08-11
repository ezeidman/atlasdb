package com.palantir.atlasdb.sql.jdbc.results;

import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.protobuf.Message;
import com.palantir.atlasdb.keyvalue.api.RowResult;
import com.palantir.atlasdb.proto.fork.ForkedJsonFormat;
import com.palantir.atlasdb.table.description.ColumnValueDescription;
import com.palantir.atlasdb.table.description.ValueType;
import com.palantir.common.annotation.Output;

public class ParsedRowResult {

    private final List<MetadataAndValue> result;
    private final List<String> colLabels;

    public static ParsedRowResult create(RowResult<byte[]> rawResult, List<JdbcColumnMetadata> columns) {
        if (columns.stream().anyMatch(c -> c.isDynCol())) {
            throw new UnsupportedOperationException("dynamic columns are not currently supported");
        }

        ImmutableList.Builder<MetadataAndValue> resultBuilder = ImmutableList.builder();
        ImmutableList.Builder<String> indexBuilder = ImmutableList.builder();
        parseRowComponents(rawResult.getRowName(),
                columns.stream().filter(JdbcColumnMetadata::isRowComp).collect(Collectors.toList()),
                resultBuilder,
                indexBuilder);
        parseColumns(rawResult,
                columns.stream().filter(JdbcColumnMetadata::isCol).collect(Collectors.toList()),
                resultBuilder,
                indexBuilder);
        return new ParsedRowResult(resultBuilder.build(), indexBuilder.build());
    }

    private static void parseColumns(RowResult<byte[]> rawResult,
                                     List<JdbcColumnMetadata> colsMeta,
                                     @Output ImmutableList.Builder<MetadataAndValue> resultBuilder,
                                     @Output ImmutableList.Builder<String> indexBuilder) {
        Map<ByteBuffer, byte[]> wrappedCols = Maps.newHashMap();
        for(Map.Entry<byte[], byte[]> entry : rawResult.getColumns().entrySet()) {
            wrappedCols.put(ByteBuffer.wrap(entry.getKey()), entry.getValue());
        }
        for (JdbcColumnMetadata meta : colsMeta) {
            Preconditions.checkState(meta.isCol(), "all metadata here is expected to be for columns");
            ByteBuffer shortName = ByteBuffer.wrap(meta.getName().getBytes());
            ByteBuffer longName = ByteBuffer.wrap(meta.getLabel().getBytes());
            if (wrappedCols.containsKey(shortName)) {
                resultBuilder.add(MetadataAndValue.create(meta, wrappedCols.get(shortName)));
            } else if (wrappedCols.containsKey(longName)) {
                resultBuilder.add(MetadataAndValue.create(meta, wrappedCols.get(longName)));
            } else {
                resultBuilder.add(MetadataAndValue.create(meta, null));  // put null for missing columns
            }
            indexBuilder.add(meta.getName());
        }
    }

    private static void parseRowComponents(byte[] row,
                                           List<JdbcColumnMetadata> colsMeta,
                                           @Output ImmutableList.Builder<MetadataAndValue> resultBuilder,
                                           @Output ImmutableList.Builder<String> indexBuilder) {
        int index = 0;
        for (int i = 0; i < colsMeta.size(); i++) {
            JdbcColumnMetadata meta = colsMeta.get(i);
            Preconditions.checkState(meta.isRowComp(), "all metadata here is expected to be for rows components");

            ValueType type = meta.getValueType();
            Object val = type.convertToJava(row, index);
            int len = type.sizeOf(val);
            if (len == 0) {
                Preconditions.checkArgument(type == ValueType.STRING || type == ValueType.BLOB,
                        "only BLOB and STRING can have unknown length");
                Preconditions.checkArgument(i == colsMeta.size() - 1, "only terminal types can have unknown length");
                len = row.length - index;
            }
            byte[] rowBytes = Arrays.copyOfRange(row, index, index + len);
            index += len;
            resultBuilder.add(new MetadataAndValue(meta, rowBytes));
            indexBuilder.add(meta.getName());
        }
    }

    public ParsedRowResult(List<MetadataAndValue> result, ImmutableList<String> colLabels) {
        this.result = result;
        this.colLabels = colLabels;
    }

    public Object get(int index, JdbcReturnType returnType) throws SQLException {
        if (index > result.size()) {
            throw new SQLException(String.format("given column index %s, but there are only %s columns", index, result.size()));
        }

        MetadataAndValue r = result.get(index - 1);
        switch (returnType) {
            case BYTES:
                return r.getValueAsMessage();
            case STRING:
                switch (r.getFormat()) {
                    case PERSISTABLE:
                    case PERSISTER:
                    case PROTO:
                        if (r.meta.isCol()) {
                            Message proto = r.getValueAsMessage();
                            return ForkedJsonFormat.printToString(proto);
                        } else {
                            throw new UnsupportedOperationException("Cannot (yet) parse a PROTO row component as a string.");
                        }
                    case VALUE_TYPE:
                        return r.getValueType().convertToJava(r.getRawValue(), 0);
                }
                break;
            // TODO implement other types
            case BYTE:
                break;
            case BOOLEAN:
                break;
            case SHORT:
                break;
            case INT:
                break;
            case LONG:
                if (!EnumSet.of(ValueType.STRING, ValueType.VAR_STRING).contains(r.getValueType())) {
                    return r.getValueType().convertToJava(r.getRawValue(), 0);
                }
            case FLOAT:
                break;
            case DOUBLE:
                break;
            case BIG_DECIMAL:
                break;
            case OBJECT:
                switch (r.getFormat()) { // inspired by AtlasSerializers.serialize
                    case PROTO:
                        return r.getValueAsMessage();
                    case PERSISTABLE:
                        break;
                    case VALUE_TYPE:
                        break;
                    case PERSISTER:
                        return r.getValueAsMessage();
                }
                break;
            case TIME:
                break;
            case TIMESTAMP:
                break;
            case DATE:
                break;
            case ASCII_STREAM:
                break;
            case BINARY_STREAM:
                break;
            case CHAR_STREAM:
                break;
        }

        if (r.getFormat() == ColumnValueDescription.Format.VALUE_TYPE) {
            throw new UnsupportedOperationException(String.format("parsing format %s (%s) as type %s is unsupported",
                    r.getFormat(),
                    r.getValueType(),
                    returnType));
        } else {
            throw new UnsupportedOperationException(String.format("parsing format %s as type %s is unsupported", r.getFormat(), returnType));
        }
    }

    public Object get(String col, JdbcReturnType returnType) throws SQLException {
        return get(getIndexFromColumnLabel(col), returnType);
    }

    public int getIndexFromColumnLabel(String col) throws SQLException {
        int index = colLabels.indexOf(col);
        if (index == -1) {
            throw new SQLException(String.format("column '%s' is not found in results", col));
        }
        return index + 1;
    }

    private static class MetadataAndValue {
        private final JdbcColumnMetadata meta;
        private final byte[] rawVal;

        static MetadataAndValue create(JdbcColumnMetadata meta, byte[] rawVal) {
            return new MetadataAndValue(meta, rawVal);
        }

        MetadataAndValue(JdbcColumnMetadata meta, byte[] rawVal) {
            this.meta = meta;
            this.rawVal = rawVal;
        }

        ColumnValueDescription.Format getFormat() {
            return meta.getFormat();
        }

        ValueType getValueType() {
            return meta.getValueType();
        }

        public Message getValueAsMessage() {
            return meta.hydrateProto(rawVal);
        }

        public Object getValueAsSimpleType() {
            return getValueType().convertToJava(getRawValue(), 0);
        }

        public byte[] getRawValue() {
            return rawVal;
        }

        @Override
        public String toString() {
            return "{" +
                    "meta=" + meta +
                    ", rawVal=" + Arrays.toString(rawVal) +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ParsedRowResult{" +
                "result=" + result +
                ", colLabels=" + colLabels +
                '}';
    }
}
