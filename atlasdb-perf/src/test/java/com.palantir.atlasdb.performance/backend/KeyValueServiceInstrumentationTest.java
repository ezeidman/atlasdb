/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
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
package com.palantir.atlasdb.performance.backend;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.Test;
import org.mockito.Mockito;

public class KeyValueServiceInstrumentationTest {

    @Test
    public void forDatabaseAddsInstrumentationFromCorrectClassName() {
        MockKeyValueServiceInstrumentation mockKeyValueServiceInstrumentation =
                new MockKeyValueServiceInstrumentation();

        KeyValueServiceInstrumentation.forDatabase(mockKeyValueServiceInstrumentation.getClassName());

        assertThat(KeyValueServiceInstrumentation.forDatabase(mockKeyValueServiceInstrumentation.getClassName()))
                .isExactlyInstanceOf(MockKeyValueServiceInstrumentation.class);
        assertThat(KeyValueServiceInstrumentation.forDatabase(mockKeyValueServiceInstrumentation.toString()))
                .isExactlyInstanceOf(MockKeyValueServiceInstrumentation.class);
    }

    @Test
    public void forDatabaseThrowsForInvalidClassName() {
        assertThatThrownBy(() -> KeyValueServiceInstrumentation.forDatabase("FAKE_BACKEND"))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("Exception trying to instantiate class FAKE_BACKEND");
    }

    @Test
    public void canAddNewBackendType() {
        KeyValueServiceInstrumentation mockKeyValueServiceInstrumentation =
                Mockito.mock(KeyValueServiceInstrumentation.class);
        Mockito.when(mockKeyValueServiceInstrumentation.toString()).thenReturn("MOCK2");
        Mockito.when(mockKeyValueServiceInstrumentation.getClassName()).thenReturn("mock_classname");

        KeyValueServiceInstrumentation.addNewBackendType(mockKeyValueServiceInstrumentation);

        assertThat(KeyValueServiceInstrumentation.forDatabase(mockKeyValueServiceInstrumentation.getClassName()))
                .isExactlyInstanceOf(mockKeyValueServiceInstrumentation.getClass());
        assertThat(KeyValueServiceInstrumentation.forDatabase(mockKeyValueServiceInstrumentation.toString()))
                .isExactlyInstanceOf(mockKeyValueServiceInstrumentation.getClass());
    }

}
