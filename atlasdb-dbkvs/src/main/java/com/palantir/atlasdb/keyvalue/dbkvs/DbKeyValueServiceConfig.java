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
package com.palantir.atlasdb.keyvalue.dbkvs;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.service.AutoService;
import com.google.common.base.Preconditions;
import com.palantir.atlasdb.spi.KeyValueServiceConfig;
import com.palantir.nexus.db.pool.config.ConnectionConfig;

@AutoService(KeyValueServiceConfig.class)
@JsonDeserialize(as = ImmutableDbKeyValueServiceConfig.class)
@JsonSerialize(as = ImmutableDbKeyValueServiceConfig.class)
@JsonTypeName(DbAtlasDbFactory.TYPE)
@Value.Immutable
public abstract class DbKeyValueServiceConfig implements KeyValueServiceConfig {
    public abstract DdlConfig ddl();

    public abstract ConnectionConfig connection();

    @Override
    public final String type() {
        return DbAtlasDbFactory.TYPE;
    }

    @Value.Check
    protected final void check() {
        Preconditions.checkArgument(ddl().type().equals(connection().type()),
                "ddl config (%s) and connection config (%s) must be for the same physical store",
                ddl().type(), connection().type());
    }
}
