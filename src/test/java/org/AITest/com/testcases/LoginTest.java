package org.AITest.com.testcases;

import io.qameta.allure.*;
import org.AITest.com.base.BaseTest;
import org.AITest.com.constants.DataConstants;
import org.AITest.com.constants.FrameworkConstants;
import org.AITest.com.pages.LoginPage;
import org.AITest.com.utils.ExcelDataProvider;
import org.AITest.com.utils.ExcelUtils;
import org.AITest.com.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginTest extends BaseTest {
            private LoginPage loginPage;
            private static final Logger logger = LoggerUtil.getLogger(LoginTest.class);

//    @DataProvider(name = "LoginData")
//    public Object[][] getData() throws IOException {
//        String filePath = "src/test/resources/testdata/TestData.xlsx";
//        String sheetName = "Login";
//
//        ExcelUtils.setExcelFile(filePath, sheetName);
//        int rowCount = ExcelUtils.getRowCount();
//
//        Object[][] data = new Object[rowCount][2];
//        for (int i = 1; i <= rowCount; i++) {
//            data[i - 1][0] = ExcelUtils.getCellData(i, 0); // Username
//            data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Password
//        }
//        return data;
//    }

    @Parameters("browser")
            @BeforeMethod
            public void setup(@Optional("chrome") String browser) {
                loginPage = new LoginPage(driver);
                driver.get(FrameworkConstants.BASE_URL);
            }


            @Test(priority = 1, description = "Verify login with valid credentials",
                    dataProvider = "ExcelData", dataProviderClass = ExcelDataProvider.class)
            public void testValidLogin(String username,String password){
                LoggerUtil.logToAllure("Starting testValidLogin test");
                loginPage.login(username,password);
                LoggerUtil.logToAllure("Attempted login with valid credentials");

                Assert.assertEquals(driver.getCurrentUrl(), "https://parabank.parasoft.com/parabank/overview.htm", "Login failed for valid credentials.");
                LoggerUtil.logToAllure("Login successful, redirected to home page");

            }

            @Test(priority = 2, description = "Verify login with invalid credentials",
                    dataProvider = "ExcelData", dataProviderClass = ExcelDataProvider.class)
            public void testInvalidLogin(String invalidUsername,String invalidPwd) {
                LoggerUtil.logToAllure("Starting testInValidLogin test");
                loginPage.login(invalidUsername,invalidPwd);
                LoggerUtil.logToAllure("Attempted login with invalid credentials");
                Assert.assertEquals(loginPage.getErrorMessageForInvalidUserNamePwd(), "The username and password could not be verified.");
                LoggerUtil.logToAllure("Login failed as expected with invalid credentials");

            }

            @Test(priority = 3, description = "Verify login with empty credentials")
            public void testEmptyLogin() {
                LoggerUtil.logToAllure("Starting testEmptyLogin test");
                loginPage.login("", "");
                LoggerUtil.logToAllure("Attempted login with empty credentials");
                Assert.assertEquals(loginPage.getErrorMessageForBlankUserNamePwd(), "Please enter a username and password.");
                LoggerUtil.logToAllure("Validation message displayed for empty credentials");

            }

        }



