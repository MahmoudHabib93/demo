package com.guru99.tests;

import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        HomePage homePage = new HomePage(driver);
        String managerId = homePage.getManagerIdText();

        Assert.assertTrue(managerId.contains(ConfigReader.getUsername()),
                "Test Failed: Manager ID mismatch. Expected '" + ConfigReader.getUsername() + "' to be present.");
    }
}
