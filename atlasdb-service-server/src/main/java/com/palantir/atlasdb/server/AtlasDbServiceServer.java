/*
 * Copyright 2015 Palantir Technologies, Inc. All rights reserved.
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
package com.palantir.atlasdb.server;

import com.google.common.collect.ImmutableSet;
import com.palantir.atlasdb.factory.TransactionManagers;
import com.palantir.atlasdb.impl.AtlasDbServiceImpl;
import com.palantir.atlasdb.impl.TableMetadataCache;
import com.palantir.atlasdb.jackson.AtlasJacksonModule;
import com.palantir.atlasdb.transaction.impl.SerializableTransactionManager;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class AtlasDbServiceServer extends Application<AtlasDbServiceServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new AtlasDbServiceServer().run(args);
    }

    @Override
    public void run(AtlasDbServiceServerConfiguration config, final Environment environment) throws Exception {
        SerializableTransactionManager tm = TransactionManagers.create(
                config.getConfig(),
                ImmutableSet.of(),
                environment.jersey()::register,
                false);

        TableMetadataCache cache = new TableMetadataCache(tm.getKeyValueService());

        environment.jersey().register(new AtlasDbServiceImpl(tm.getKeyValueService(), tm, cache));
        environment.getObjectMapper().registerModule(new AtlasJacksonModule(cache).createModule());
    }

}
