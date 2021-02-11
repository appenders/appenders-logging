package org.appenders.core.logging;

/*-
 * #%L
 * appenders-logging
 * %%
 * Copyright (C) 2020 Appenders Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

public class LoggerTest {

    private static final String EXPECTED_MESSAGE = "Not implemented";

    @Test
    public void errorThrowsByDefault() {

        // given
        Logger logger = new Logger() {};

        InternalLogging.setLogger(new Logger() {
            @Override
            public void warn(String messageFormat, Object... parameters) {
                System.out.println(messageFormat);
            }
        });
        // when
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> logger.error("test"));

        // then
        assertThat(exception.getMessage(), containsString(EXPECTED_MESSAGE));

    }

    @Test
    public void warnThrowsByDefault() {

        // given
        Logger logger = new Logger() {};

        // when
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> logger.warn("test"));

        // then
        assertThat(exception.getMessage(), containsString(EXPECTED_MESSAGE));

    }

    @Test
    public void infoThrowsByDefault() {

        // given
        Logger logger = new Logger() {};

        // when
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> logger.info("test"));

        // then
        assertThat(exception.getMessage(), containsString(EXPECTED_MESSAGE));

    }

    @Test
    public void debugThrowsByDefault() {

        // given
        Logger logger = new Logger() {};

        // when
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> logger.debug("test"));

        // then
        assertThat(exception.getMessage(), containsString(EXPECTED_MESSAGE));

    }

    @Test
    public void traceThrowsByDefault() {

        // given
        Logger logger = new Logger() {};

        // when
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> logger.trace("test"));

        // then
        assertThat(exception.getMessage(), containsString(EXPECTED_MESSAGE));

    }

}
