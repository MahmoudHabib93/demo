package com.guru99.tests;

import com.guru99.pages.EditCustomerPage;
import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.pages.NewCustomerPage;
import com.guru99.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManagerTest extends BaseTest {

    @Test(priority = 1)
    public void testAddNewCustomer() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        String managerId = homePage.getManagerIdText();
        Assert.assertTrue(managerId.contains("mngr651780"), "Manager ID mismatch!");

        NewCustomerPage newCustomerPage = homePage.clickNewCustomer();

        // Randomize email to avoid duplicates
        String email = "test" + System.currentTimeMillis() + "@example.com";
        newCustomerPage.addNewCustomer("John Doe", "male", "01/01/1990", "123 Street", "City", "State", "123456",
                "1234567890", email, "password");

        String successMsg = newCustomerPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Customer Registered Successfully!!!");

        String customerId = newCustomerPage.getCustomerId();
        System.out.println("Created Customer ID: " + customerId);

        // Store customerId for next test if needed?
        // Better to make tests independent, but for flow demonstration we might chain
        // or use a context.
        // For simplicity here, I'll attempt edit in the same test or separate if I can
        // pass data.
        // Let's do edit in a separate test if we can ensure data persistence or create
        // another one.
        // For this demo, I'll just verify adding works.
    }

    @Test(priority = 2)
    public void testEditCustomer() {
        // Limitation: We need a valid Customer ID to edit.
        // In a real framework we'd create one in @BeforeClass or use a known data set.
        // For now, let's create one first (repeating steps) or just skip if we want to
        // keep it simple.
        // I will implement a flow that creates then edits to be safe.

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        NewCustomerPage newCustomerPage = homePage.clickNewCustomer();
        String email = "edit" + System.currentTimeMillis() + "@example.com";
        newCustomerPage.addNewCustomer("Jane Doe", "female", "02/02/1992", "456 Avenue", "Town", "Region", "654321",
                "0987654321", email, "password");
        String customerId = newCustomerPage.getCustomerId();

        EditCustomerPage editCustomerPage = homePage.clickEditCustomer();
        editCustomerPage.enterCustomerId(customerId);
        editCustomerPage.updateAddress("789 Boulevard");

        String successMsg = editCustomerPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Customer details updated Successfully!!!");
    }
}
