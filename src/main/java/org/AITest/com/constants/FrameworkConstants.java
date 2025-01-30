package org.AITest.com.constants;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FrameworkConstants {

    // Base URL for the application
    public static final String BASE_URL = "https://parabank.parasoft.com/parabank/index.htm";

    // Path to resources directory
    private static final String RESOURCES_PATH = Paths.get(System.getProperty("user.dir"), "src", "main", "resources").toString();

    // Path to WebDriver executables (if required)
    public static final String CHROME_DRIVER_PATH = Paths.get(RESOURCES_PATH, "drivers", "chromedriver.exe").toString();
    public static final String FIREFOX_DRIVER_PATH = Paths.get(RESOURCES_PATH, "drivers", "geckodriver.exe").toString();
    public static final String EDGE_DRIVER_PATH = Paths.get(RESOURCES_PATH, "drivers", "msedgedriver.exe").toString();

    // Configuration file path
    public static final String CONFIG_FILE_PATH = Paths.get(RESOURCES_PATH, "config", "config.properties").toString();

    // Timeout constants
    public static final int IMPLICIT_WAIT = 10; // in seconds
    public static final int EXPLICIT_WAIT = 20; // in seconds
    public static final int PAGE_LOAD_TIMEOUT = 30; // in seconds

    // Reporting paths
    public static final String ALLURE_RESULTS_PATH = Paths.get(System.getProperty("user.dir"), "allure-results").toString();
    public static final String REPORTS_PATH = Paths.get(System.getProperty("user.dir"), "reports").toString();

    // Log file paths
    public static final String LOGS_PATH = Paths.get(System.getProperty("user.dir"), "logs").toString();

    // Other constants
    public static final String DEFAULT_BROWSER = "chrome";

    // Private constructor to prevent instantiation
    private FrameworkConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

