package org.AITest.com.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverStrategy implements WebDriverStrategy {
    @Override
    public WebDriver initializeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
