package org.AITest.com.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_EXPLICIT_WAIT = 20; // Default wait in seconds

    /**
     * Waits for the visibility of a WebElement using WebDriverWait.
     *
     * @param driver the WebDriver instance
     * @param element the WebElement to wait for
     * @param timeoutInSeconds the timeout in seconds
     * @return the WebElement after it becomes visible
     */
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the visibility of a WebElement using the default timeout.
     *
     * @param driver the WebDriver instance
     * @param element the WebElement to wait for
     * @return the WebElement after it becomes visible
     */
    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return waitForVisibility(driver, element, DEFAULT_EXPLICIT_WAIT);
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param driver the WebDriver instance
     * @param element the WebElement to wait for
     * @param timeoutInSeconds the timeout in seconds
     * @return the WebElement after it becomes clickable
     */
    public static WebElement waitForClickability(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for an element to be clickable using the default timeout.
     *
     * @param driver the WebDriver instance
     * @param element the WebElement to wait for
     * @return the WebElement after it becomes clickable
     */
    public static WebElement waitForClickability(WebDriver driver, WebElement element) {
        return waitForClickability(driver, element, DEFAULT_EXPLICIT_WAIT);
    }

    /**
     * Waits for the presence of an element located by a given locator.
     *
     * @param driver the WebDriver instance
     * @param locator the By locator of the element
     * @param timeoutInSeconds the timeout in seconds
     * @return the WebElement after it becomes present
     */
    public static WebElement waitForPresence(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Waits for a specific text to be present in an element.
     *
     * @param driver the WebDriver instance
     * @param element the WebElement
     * @param text the text to wait for
     * @param timeoutInSeconds the timeout in seconds
     * @return true if the text is present, false otherwise
     */
    public static boolean waitForTextToBePresent(WebDriver driver, WebElement element, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Waits for an alert to be present.
     *
     * @param driver the WebDriver instance
     * @param timeoutInSeconds the timeout in seconds
     * @return the Alert after it becomes present
     */
    public static Alert waitForAlert(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Implements a FluentWait for a WebElement with custom polling time.
     *
     * @param driver the WebDriver instance
     * @param element the WebElement to wait for
     * @param timeoutInSeconds the timeout in seconds
     * @param pollingTimeInMillis the polling time in milliseconds
     * @return the WebElement after it satisfies the condition
     */
    public static WebElement fluentWait(WebDriver driver, WebElement element, int timeoutInSeconds, int pollingTimeInMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofMillis(pollingTimeInMillis))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Implements a static wait.
     *
     * @param milliseconds the time in milliseconds to pause the execution
     */
    public static void staticWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted during static wait", e);
        }
    }

    // Private constructor to prevent instantiation
    private WaitUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
