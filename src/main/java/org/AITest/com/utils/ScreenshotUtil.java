package org.AITest.com.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";

        try {
            FileUtils.copyFile(srcFile, new File(destPath));
            System.out.println("Screenshot saved at: " + destPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save screenshot: " + destPath);
        }
    }
}
