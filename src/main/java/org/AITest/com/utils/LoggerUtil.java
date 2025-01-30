package org.AITest.com.utils;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.ByteArrayInputStream;

public class LoggerUtil {

    private static Logger logger;

    public static Logger getLogger(Class<?> clazz) {
        if (logger == null) {
            logger = LogManager.getLogger(clazz);
        }
        return logger;
    }

    public static void logToAllure(String message) {
        logger.info(message);  // Log to console and file
        Allure.addAttachment("Log", new ByteArrayInputStream(message.getBytes())); // Add to Allure
    }
}
