// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/test/TestPersistence.proto

package com.palantir.atlasdb.protos.generated;

public final class TestPersistence {
  private TestPersistence() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface TestObjectOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.palantir.atlasdb.protos.generated.TestObject)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required fixed64 id = 1;</code>
     */
    boolean hasId();
    /**
     * <code>required fixed64 id = 1;</code>
     */
    long getId();

    /**
     * <code>required int64 type = 2;</code>
     */
    boolean hasType();
    /**
     * <code>required int64 type = 2;</code>
     */
    long getType();

    /**
     * <code>required bool is_group = 3;</code>
     */
    boolean hasIsGroup();
    /**
     * <code>required bool is_group = 3;</code>
     */
    boolean getIsGroup();

    /**
     * <code>required int64 deleted = 4;</code>
     */
    boolean hasDeleted();
    /**
     * <code>required int64 deleted = 4;</code>
     */
    long getDeleted();

    /**
     * <code>optional int64 data_event_id = 5;</code>
     */
    boolean hasDataEventId();
    /**
     * <code>optional int64 data_event_id = 5;</code>
     */
    long getDataEventId();
  }
  /**
   * Protobuf type {@code com.palantir.atlasdb.protos.generated.TestObject}
   */
  public static final class TestObject extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.palantir.atlasdb.protos.generated.TestObject)
      TestObjectOrBuilder {
    // Use TestObject.newBuilder() to construct.
    private TestObject(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private TestObject(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final TestObject defaultInstance;
    public static TestObject getDefaultInstance() {
      return defaultInstance;
    }

    public TestObject getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private TestObject(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 9: {
              bitField0_ |= 0x00000001;
              id_ = input.readFixed64();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              type_ = input.readInt64();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              isGroup_ = input.readBool();
              break;
            }
            case 32: {
              bitField0_ |= 0x00000008;
              deleted_ = input.readInt64();
              break;
            }
            case 40: {
              bitField0_ |= 0x00000010;
              dataEventId_ = input.readInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.palantir.atlasdb.protos.generated.TestPersistence.internal_static_com_palantir_atlasdb_protos_generated_TestObject_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.palantir.atlasdb.protos.generated.TestPersistence.internal_static_com_palantir_atlasdb_protos_generated_TestObject_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.palantir.atlasdb.protos.generated.TestPersistence.TestObject.class, com.palantir.atlasdb.protos.generated.TestPersistence.TestObject.Builder.class);
    }

    public static com.google.protobuf.Parser<TestObject> PARSER =
        new com.google.protobuf.AbstractParser<TestObject>() {
      public TestObject parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TestObject(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<TestObject> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    /**
     * <code>required fixed64 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required fixed64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }

    public static final int TYPE_FIELD_NUMBER = 2;
    private long type_;
    /**
     * <code>required int64 type = 2;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required int64 type = 2;</code>
     */
    public long getType() {
      return type_;
    }

    public static final int IS_GROUP_FIELD_NUMBER = 3;
    private boolean isGroup_;
    /**
     * <code>required bool is_group = 3;</code>
     */
    public boolean hasIsGroup() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required bool is_group = 3;</code>
     */
    public boolean getIsGroup() {
      return isGroup_;
    }

    public static final int DELETED_FIELD_NUMBER = 4;
    private long deleted_;
    /**
     * <code>required int64 deleted = 4;</code>
     */
    public boolean hasDeleted() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required int64 deleted = 4;</code>
     */
    public long getDeleted() {
      return deleted_;
    }

    public static final int DATA_EVENT_ID_FIELD_NUMBER = 5;
    private long dataEventId_;
    /**
     * <code>optional int64 data_event_id = 5;</code>
     */
    public boolean hasDataEventId() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional int64 data_event_id = 5;</code>
     */
    public long getDataEventId() {
      return dataEventId_;
    }

    private void initFields() {
      id_ = 0L;
      type_ = 0L;
      isGroup_ = false;
      deleted_ = 0L;
      dataEventId_ = 0L;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasType()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasIsGroup()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasDeleted()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeFixed64(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt64(2, type_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBool(3, isGroup_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt64(4, deleted_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeInt64(5, dataEventId_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeFixed64Size(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, type_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, isGroup_);
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(4, deleted_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(5, dataEventId_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.palantir.atlasdb.protos.generated.TestPersistence.TestObject prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.palantir.atlasdb.protos.generated.TestObject}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.palantir.atlasdb.protos.generated.TestObject)
        com.palantir.atlasdb.protos.generated.TestPersistence.TestObjectOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.palantir.atlasdb.protos.generated.TestPersistence.internal_static_com_palantir_atlasdb_protos_generated_TestObject_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.palantir.atlasdb.protos.generated.TestPersistence.internal_static_com_palantir_atlasdb_protos_generated_TestObject_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.palantir.atlasdb.protos.generated.TestPersistence.TestObject.class, com.palantir.atlasdb.protos.generated.TestPersistence.TestObject.Builder.class);
      }

      // Construct using com.palantir.atlasdb.protos.generated.TestPersistence.TestObject.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        id_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000001);
        type_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        isGroup_ = false;
        bitField0_ = (bitField0_ & ~0x00000004);
        deleted_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000008);
        dataEventId_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.palantir.atlasdb.protos.generated.TestPersistence.internal_static_com_palantir_atlasdb_protos_generated_TestObject_descriptor;
      }

      public com.palantir.atlasdb.protos.generated.TestPersistence.TestObject getDefaultInstanceForType() {
        return com.palantir.atlasdb.protos.generated.TestPersistence.TestObject.getDefaultInstance();
      }

      public com.palantir.atlasdb.protos.generated.TestPersistence.TestObject build() {
        com.palantir.atlasdb.protos.generated.TestPersistence.TestObject result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.palantir.atlasdb.protos.generated.TestPersistence.TestObject buildPartial() {
        com.palantir.atlasdb.protos.generated.TestPersistence.TestObject result = new com.palantir.atlasdb.protos.generated.TestPersistence.TestObject(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.type_ = type_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.isGroup_ = isGroup_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.deleted_ = deleted_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.dataEventId_ = dataEventId_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.palantir.atlasdb.protos.generated.TestPersistence.TestObject) {
          return mergeFrom((com.palantir.atlasdb.protos.generated.TestPersistence.TestObject)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.palantir.atlasdb.protos.generated.TestPersistence.TestObject other) {
        if (other == com.palantir.atlasdb.protos.generated.TestPersistence.TestObject.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasType()) {
          setType(other.getType());
        }
        if (other.hasIsGroup()) {
          setIsGroup(other.getIsGroup());
        }
        if (other.hasDeleted()) {
          setDeleted(other.getDeleted());
        }
        if (other.hasDataEventId()) {
          setDataEventId(other.getDataEventId());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          
          return false;
        }
        if (!hasType()) {
          
          return false;
        }
        if (!hasIsGroup()) {
          
          return false;
        }
        if (!hasDeleted()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.palantir.atlasdb.protos.generated.TestPersistence.TestObject parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.palantir.atlasdb.protos.generated.TestPersistence.TestObject) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private long id_ ;
      /**
       * <code>required fixed64 id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required fixed64 id = 1;</code>
       */
      public long getId() {
        return id_;
      }
      /**
       * <code>required fixed64 id = 1;</code>
       */
      public Builder setId(long value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required fixed64 id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0L;
        onChanged();
        return this;
      }

      private long type_ ;
      /**
       * <code>required int64 type = 2;</code>
       */
      public boolean hasType() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required int64 type = 2;</code>
       */
      public long getType() {
        return type_;
      }
      /**
       * <code>required int64 type = 2;</code>
       */
      public Builder setType(long value) {
        bitField0_ |= 0x00000002;
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 type = 2;</code>
       */
      public Builder clearType() {
        bitField0_ = (bitField0_ & ~0x00000002);
        type_ = 0L;
        onChanged();
        return this;
      }

      private boolean isGroup_ ;
      /**
       * <code>required bool is_group = 3;</code>
       */
      public boolean hasIsGroup() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required bool is_group = 3;</code>
       */
      public boolean getIsGroup() {
        return isGroup_;
      }
      /**
       * <code>required bool is_group = 3;</code>
       */
      public Builder setIsGroup(boolean value) {
        bitField0_ |= 0x00000004;
        isGroup_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required bool is_group = 3;</code>
       */
      public Builder clearIsGroup() {
        bitField0_ = (bitField0_ & ~0x00000004);
        isGroup_ = false;
        onChanged();
        return this;
      }

      private long deleted_ ;
      /**
       * <code>required int64 deleted = 4;</code>
       */
      public boolean hasDeleted() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required int64 deleted = 4;</code>
       */
      public long getDeleted() {
        return deleted_;
      }
      /**
       * <code>required int64 deleted = 4;</code>
       */
      public Builder setDeleted(long value) {
        bitField0_ |= 0x00000008;
        deleted_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int64 deleted = 4;</code>
       */
      public Builder clearDeleted() {
        bitField0_ = (bitField0_ & ~0x00000008);
        deleted_ = 0L;
        onChanged();
        return this;
      }

      private long dataEventId_ ;
      /**
       * <code>optional int64 data_event_id = 5;</code>
       */
      public boolean hasDataEventId() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional int64 data_event_id = 5;</code>
       */
      public long getDataEventId() {
        return dataEventId_;
      }
      /**
       * <code>optional int64 data_event_id = 5;</code>
       */
      public Builder setDataEventId(long value) {
        bitField0_ |= 0x00000010;
        dataEventId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int64 data_event_id = 5;</code>
       */
      public Builder clearDataEventId() {
        bitField0_ = (bitField0_ & ~0x00000010);
        dataEventId_ = 0L;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.palantir.atlasdb.protos.generated.TestObject)
    }

    static {
      defaultInstance = new TestObject(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.palantir.atlasdb.protos.generated.TestObject)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_palantir_atlasdb_protos_generated_TestObject_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_palantir_atlasdb_protos_generated_TestObject_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\036src/test/TestPersistence.proto\022%com.pa" +
      "lantir.atlasdb.protos.generated\"`\n\nTestO" +
      "bject\022\n\n\002id\030\001 \002(\006\022\014\n\004type\030\002 \002(\003\022\020\n\010is_gr" +
      "oup\030\003 \002(\010\022\017\n\007deleted\030\004 \002(\003\022\025\n\rdata_event" +
      "_id\030\005 \001(\003"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_palantir_atlasdb_protos_generated_TestObject_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_palantir_atlasdb_protos_generated_TestObject_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_palantir_atlasdb_protos_generated_TestObject_descriptor,
        new java.lang.String[] { "Id", "Type", "IsGroup", "Deleted", "DataEventId", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
