package org.AITest.com.pages;

import org.AITest.com.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    // Locators using PageFactory annotations
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")  // Example locator
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log In']")  // Example locator
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='rightPanel']/p[contains(text(),'Please enter a username and password.')]")
    private WebElement errorMessageForBlankUserNamePwd;

    @FindBy(xpath = "//div[@id='rightPanel']/p[contains(text(),'The username and password could not be verified.')]")
    private WebElement errorMessageForInvalidUserNamePwd;

    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to enter username
    public void enterUsername(String username) {
        WaitUtils.waitForVisibility(driver, usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    // Method to enter password
    public void enterPassword(String password) {
        WaitUtils.waitForVisibility(driver, passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Method to click login button
    public void clickLoginButton() {
        WaitUtils.waitForClickability(driver, loginButton);
        loginButton.click();
    }

    // Method to perform login
    public HomePage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new HomePage(driver);  // Assuming a HomePage class exists
    }

    // Method to get error message
    public String getErrorMessageForBlankUserNamePwd() {
        return errorMessageForBlankUserNamePwd.getText();
    }

    public String getErrorMessageForInvalidUserNamePwd()
    {
        return errorMessageForInvalidUserNamePwd.getText();
    }
}




