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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class InternalLoggingTest {

    @Test
    public void allowsToSetLogger() {

        // given
        Logger expectedLogger = mockTestLogger();

        // when
        InternalLogging.setLogger(expectedLogger);

        // then
        assertEquals(expectedLogger, InternalLogging.getLogger());

    }

    @Test
    public void returnsDefaultImplWhenLoggerNotSetAndNullLoggerIsAllowed() {

        // given
        System.setProperty(InternalLogging.THROW_ON_NULL_LOGGER, "false");

        InternalLogging.setLogger(null);

        // when
        Logger logger = InternalLogging.getLogger();

        // then
        assertNotNull(logger);
        assertTrue(logger instanceof Log4j2StatusLoggerWrapper);

    }

    @Test
    public void throwsWhenLoggerNotSetAndNullLoggerNotAllowed() {

        // given
        System.setProperty(InternalLogging.THROW_ON_NULL_LOGGER, "true");

        InternalLogging.setLogger(null);

        // when
        IllegalStateException exception = assertThrows(IllegalStateException.class, InternalLogging::getLogger);

        // then
        assertThat(exception.getMessage(), containsString("Logger cannot be null. Set Logger instance with InternalLogging.setLogger()"));

    }

    public static Logger mockTestLogger() {
        Logger mockedLogger = mock(Logger.class);
        InternalLogging.setLogger(mockedLogger);
        return mockedLogger;
    }

}
