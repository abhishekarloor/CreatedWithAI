package org.AITest.com.base;

import io.qameta.allure.Attachment;
import jdk.jfr.Frequency;
import org.AITest.com.constants.FrameworkConstants;
import org.AITest.com.strategy.*;
import org.AITest.com.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = LoggerUtil.getLogger(BaseTest.class);


    @BeforeMethod
    public void setUp() {

        String browser = System.getProperty("browser", FrameworkConstants.DEFAULT_BROWSER); // Default to Chrome if not provided
        driver = initializeDriver(browser);
        logger.info("Driver initiated Successfully");


// Set WebDriver configurations
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.PAGE_LOAD_TIMEOUT));

        // Navigate to the base URL
        driver.get(FrameworkConstants.BASE_URL);
        logger.info("Navigated to: " + FrameworkConstants.BASE_URL);


    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LoggerUtil.logToAllure("Test Failed: " + result.getName());
            attachScreenshot();
        }

        if (driver != null) {
            LoggerUtil.logToAllure("Closing WebDriver");
            driver.quit();
        }
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] attachScreenshot() {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }


    private WebDriver initializeDriver(String browser) {
        DriverContext context;

        switch (browser.toLowerCase()) {
            case "chrome":
                context = new DriverContext(new ChromeDriverStrategy());
                break;
            case "firefox":
                context = new DriverContext(new FirefoxDriverStrategy());
                break;
            case "edge":
                context = new DriverContext(new EdgeDriverStrategy());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return context.initializeDriver();
    }
}
