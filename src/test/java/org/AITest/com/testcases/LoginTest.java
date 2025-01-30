package org.AITest.com.testcases;

import io.qameta.allure.*;
import org.AITest.com.base.BaseTest;
import org.AITest.com.constants.DataConstants;
import org.AITest.com.constants.FrameworkConstants;
import org.AITest.com.pages.LoginPage;
import org.AITest.com.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {
            private LoginPage loginPage;
            private static final Logger logger = LoggerUtil.getLogger(LoginTest.class);


    @Parameters("browser")
            @BeforeMethod
            public void setup(@Optional("chrome") String browser) {
                loginPage = new LoginPage(driver);
                driver.get(FrameworkConstants.BASE_URL);
            }

            @Test(priority = 1, description = "Verify login with valid credentials")
            public void testValidLogin() {
                LoggerUtil.logToAllure("Starting testValidLogin test");
                loginPage.login(DataConstants.VALID_USERNAME, DataConstants.INVALID_USERNAME);
                LoggerUtil.logToAllure("Attempted login with valid credentials");

                Assert.assertEquals(driver.getCurrentUrl(), "https://parabank.parasoft.com/parabank/overview.htm", "Login failed for valid credentials.");
                LoggerUtil.logToAllure("Login successful, redirected to home page");

            }

            @Test(priority = 2, description = "Verify login with invalid credentials")
            public void testInvalidLogin() {
                LoggerUtil.logToAllure("Starting testInValidLogin test");
                loginPage.login(DataConstants.INVALID_USERNAME, DataConstants.INVALID_PWD);
                LoggerUtil.logToAllure("Attempted login with invalid credentials");
                Assert.assertEquals(loginPage.getErrorMessageForInvalidUserNamePwd(), "The username and password could not be verified.");
                LoggerUtil.logToAllure("Login failed as expected with invalid credentials");

            }

            @Test(priority = 3, description = "Verify login with empty credentials")
            public void testEmptyLogin() {
                LoggerUtil.logToAllure("Starting testEmptyLogin test");
                loginPage.login("", "");
                LoggerUtil.logToAllure("Attempted login with empty credentials");
                Assert.assertEquals(loginPage.getErrorMessageForBlankUserNamePwd(), "123Please enter a username and password.");
                LoggerUtil.logToAllure("Validation message displayed for empty credentials");

            }

        }



