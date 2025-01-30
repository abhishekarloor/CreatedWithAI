package org.AITest.com.listeners;

import io.qameta.allure.Attachment;
import org.AITest.com.base.BaseTest;
import org.AITest.com.utils.LoggerUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestListener extends BaseTest implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtil.logToAllure("Test Failed: " + result.getName());
        Object testClass = result.getInstance();
        if (driver != null) {
            attachScreenshot(driver);
        }
    }

    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public byte[] attachScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: " + result.getName());
        logger.warn("Reason: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test Partially Successful: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Execution Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Execution Finished: " + context.getName());
    }
}
