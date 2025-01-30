package org.AITest.com.strategy;


import org.openqa.selenium.WebDriver;

public class DriverContext {
    private WebDriverStrategy strategy;

    public DriverContext(WebDriverStrategy strategy) {
        this.strategy = strategy;
    }

    public WebDriver initializeDriver() {
        return strategy.initializeDriver();
    }
}

