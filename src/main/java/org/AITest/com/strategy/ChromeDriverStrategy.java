package org.AITest.com.strategy;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverStrategy implements WebDriverStrategy {
    @Override
    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
