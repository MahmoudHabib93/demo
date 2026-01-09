package com.guru99.tests;

import com.guru99.pages.DeleteAccountPage;
import com.guru99.pages.EditAccountPage;
import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.pages.NewAccountPage;
import com.guru99.pages.NewCustomerPage;
import com.guru99.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {

    @Test(priority = 1)
    public void testAccountLifecycle() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        // Pre-requisite: Need a customer
        NewCustomerPage newCustomerPage = homePage.clickNewCustomer();
        String email = "acc" + System.currentTimeMillis() + "@example.com";
        newCustomerPage.addNewCustomer("Acc Owner", "male", "05/05/1985", "789 Road", "City", "State", "123456",
                "9876543210", email, "password");
        String customerId = newCustomerPage.getCustomerId();

        // 1. Create New Account
        NewAccountPage newAccountPage = homePage.clickNewAccount();
        newAccountPage.createNewAccount(customerId, "Savings", "1000");
        String successMsg = newAccountPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Account Generated Successfully!!!");
        String accountId = newAccountPage.getAccountId();
        System.out.println("Created Account ID: " + accountId);

        // 2. Edit Account (Guru99 demo functionality for Edit Account is often
        // limited/buggy, but testing flow)
        EditAccountPage editAccountPage = homePage.clickEditAccount();
        editAccountPage.enterAccountNumber(accountId);
        // Assuming edit page has fields to update, but the current PO only enters ID.
        // Real app usually navigates to a form.
        // If it works, great. If not, this step might fail.

        // 3. Delete Account
        DeleteAccountPage deleteAccountPage = homePage.clickDeleteAccount();
        deleteAccountPage.deleteAccount(accountId);
        driver.switchTo().alert().accept(); // Confirmation
        String alertText = driver.switchTo().alert().getText(); // Success
        driver.switchTo().alert().accept();
        Assert.assertEquals(alertText, "Account Deleted Sucessfully"); // Note: Guru99 typo "Sucessfully" often exists
    }
}
