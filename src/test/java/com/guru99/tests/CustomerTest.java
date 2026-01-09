package com.guru99.tests;

import com.guru99.pages.DeleteCustomerPage;
import com.guru99.pages.EditCustomerPage;
import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.pages.NewCustomerPage;
import com.guru99.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    @Test(priority = 1)
    public void testCustomerLifecycle() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        // 1. Create New Customer
        NewCustomerPage newCustomerPage = homePage.clickNewCustomer();
        String email = "test" + System.currentTimeMillis() + "@example.com";
        // Passing date without slashes to use strict keypad entry simulation if needed,
        // but Page Object handles it.
        // Actually NewCustomerPage expects standard format, let's stick to what we have
        // or try strictly
        newCustomerPage.addNewCustomer("Jane Doe", "female", "01011990", "123 Street", "City", "State", "123456",
                "1234567890", email, "password");

        String successMsg = newCustomerPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Customer Registered Successfully!!!");

        String customerId = newCustomerPage.getCustomerId();
        System.out.println("Created Customer ID: " + customerId);

        // 2. Edit Customer
        EditCustomerPage editCustomerPage = homePage.clickEditCustomer();
        editCustomerPage.enterCustomerId(customerId);
        editCustomerPage.updateAddress("456 Avenue");
        String editSuccessMsg = editCustomerPage.getSuccessMessage();
        Assert.assertEquals(editSuccessMsg, "Customer details updated Successfully!!!");

        // 3. Delete Customer
        DeleteCustomerPage deleteCustomerPage = homePage.clickDeleteCustomer();
        deleteCustomerPage.deleteCustomer(customerId);
        // Note: Delete usually triggers an alert, we need to handle it.
        // BasePage or here? The page object currently just clicks submit.
        // We'll assert on the alert text 'Customer deleted Successfully' if possible,
        // or need to add alert handling to Page Object.
        // For now, let's assume it works or fails, iterating fast.
        driver.switchTo().alert().accept(); // Accept Confirmation
        String alertText = driver.switchTo().alert().getText(); // Get Success Message
        driver.switchTo().alert().accept(); // Accept Success
        Assert.assertEquals(alertText, "Customer deleted Successfully");
    }
}
