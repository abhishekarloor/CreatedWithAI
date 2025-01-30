package org.AITest.com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import java.util.Set;

public class BrowserUtils {

    /**
     * Maximizes the browser window.
     *
     * @param driver the WebDriver instance
     */
    public static void maximizeWindow(WebDriver driver) {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }

    /**
     * Navigates to a given URL.
     *
     * @param driver the WebDriver instance
     * @param url    the URL to navigate to
     */
    public static void navigateTo(WebDriver driver, String url) {
        if (driver != null && url != null && !url.isEmpty()) {
            driver.get(url);
        }
    }

    /**
     * Refreshes the current page.
     *
     * @param driver the WebDriver instance
     */
    public static void refreshPage(WebDriver driver) {
        if (driver != null) {
            driver.navigate().refresh();
        }
    }

    /**
     * Switches to a new tab in the browser.
     *
     * @param driver the WebDriver instance
     */
    public static void openNewTab(WebDriver driver) {
        if (driver != null) {
            driver.switchTo().newWindow(WindowType.TAB);
        }
    }

    /**
     * Switches to the specified browser window by handle.
     *
     * @param driver the WebDriver instance
     * @param windowHandle the handle of the window to switch to
     */
    public static void switchToWindow(WebDriver driver, String windowHandle) {
        if (driver != null && windowHandle != null) {
            driver.switchTo().window(windowHandle);
        }
    }

    /**
     * Gets the current window handle.
     *
     * @param driver the WebDriver instance
     * @return the current window handle
     */
    public static String getCurrentWindowHandle(WebDriver driver) {
        return driver != null ? driver.getWindowHandle() : null;
    }

    /**
     * Gets all window handles.
     *
     * @param driver the WebDriver instance
     * @return a set of window handles
     */
    public static Set<String> getAllWindowHandles(WebDriver driver) {
        return driver != null ? driver.getWindowHandles() : null;
    }

    /**
     * Closes the current browser window.
     *
     * @param driver the WebDriver instance
     */
    public static void closeWindow(WebDriver driver) {
        if (driver != null) {
            driver.close();
        }
    }

    /**
     * Deletes all cookies in the browser.
     *
     * @param driver the WebDriver instance
     */
    public static void clearCookies(WebDriver driver) {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    /**
     * Checks if the browser is currently on the given URL.
     *
     * @param driver the WebDriver instance
     * @param url    the expected URL
     * @return true if the current URL matches the expected URL, false otherwise
     */
    public static boolean isCurrentUrl(WebDriver driver, String url) {
        return driver != null && url != null && driver.getCurrentUrl().equals(url);
    }

    /**
     * Retrieves the title of the current page.
     *
     * @param driver the WebDriver instance
     * @return the page title
     */
    public static String getPageTitle(WebDriver driver) {
        return driver != null ? driver.getTitle() : null;
    }

    /**
     * Navigates back in the browser's history.
     *
     * @param driver the WebDriver instance
     */
    public static void navigateBack(WebDriver driver) {
        if (driver != null) {
            driver.navigate().back();
        }
    }

    /**
     * Navigates forward in the browser's history.
     *
     * @param driver the WebDriver instance
     */
    public static void navigateForward(WebDriver driver) {
        if (driver != null) {
            driver.navigate().forward();
        }
    }

    // Private constructor to prevent instantiation
    private BrowserUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
