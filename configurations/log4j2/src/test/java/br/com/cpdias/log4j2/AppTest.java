package br.com.cpdias.log4j2;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void givenLoggerWithRollingFileConfig_whenLogToXMLFile_thanOK()
      throws Exception {
        Logger logger =  LoggerFactory.getLogger("XML_ROLLING_FILE_APPENDER");
        final int count = 10050;
        for (int i = 0; i < count; i++) {
            logger.info(
              "This is rolling file XML message #{} at INFO level.", i);
        }
    }
}
