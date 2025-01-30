package org.AITest.com.listeners;

import io.qameta.allure.Attachment;
import org.AITest.com.base.BaseTest;
import org.AITest.com.utils.LoggerUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class AllureTestListener extends TestListenerAdapter{

    private final WebDriver driver;

    public AllureTestListener(WebDriver driver) {
        this.driver = driver;
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

}
