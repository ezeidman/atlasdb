/**
 * Copyright 2015 Palantir Technologies
 *
 * Licensed under the BSD-3 License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.palantir.atlasdb.transaction.service;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.palantir.atlasdb.keyvalue.api.Cell;
import com.palantir.atlasdb.keyvalue.api.KeyValueService;
import com.palantir.atlasdb.keyvalue.api.Value;
import com.palantir.atlasdb.transaction.impl.TransactionConstants;

public final class SimpleTransactionService extends AbstractTransactionService {
    public SimpleTransactionService(KeyValueService kvs) {
        super(kvs);
    }


    @Override
    public Long get(long startTimestamp) {
        Cell cell = getTransactionCell(startTimestamp);
        Map<Cell, Value> returnMap = kvs.get(
                TransactionConstants.TRANSACTION_TABLE,
                ImmutableMap.of(cell, MAX_TIMESTAMP));
        if (returnMap.containsKey(cell)) {
            return TransactionConstants.getTimestampForValue(returnMap
                    .get(cell).getContents());
        } else {
            return null;
        }
    }

    @Override
    public Map<Long, Long> get(Iterable<Long> startTimestamps) {
        Map<Cell, Long> startTsMap = Maps.newHashMap();
        for (Long startTimestamp : startTimestamps) {
            Cell cell = getTransactionCell(startTimestamp);
            startTsMap.put(cell, MAX_TIMESTAMP);
        }

        Map<Cell, Value> rawResults = kvs.get(
                TransactionConstants.TRANSACTION_TABLE, startTsMap);
        Map<Long, Long> result = Maps.newHashMapWithExpectedSize(rawResults
                .size());
        for (Map.Entry<Cell, Value> e : rawResults.entrySet()) {
            long startTs = TransactionConstants.getTimestampForValue(e.getKey()
                    .getRowName());
            long commitTs = TransactionConstants.getTimestampForValue(e
                    .getValue().getContents());
            result.put(startTs, commitTs);
        }

        return result;
    }

    @Override
    public void putUnlessExists(long startTimestamp, long commitTimestamp) {
        Cell key = getTransactionCell(startTimestamp);
        byte[] value = TransactionConstants
                .getValueForTimestamp(commitTimestamp);
        kvs.putUnlessExists(TransactionConstants.TRANSACTION_TABLE,
                ImmutableMap.of(key, value));
    }
}
