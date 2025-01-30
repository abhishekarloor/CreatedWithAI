package org.AITest.com.utils;

import org.AITest.com.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties getProperty() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH)) {
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
        return properties;
    }
}
