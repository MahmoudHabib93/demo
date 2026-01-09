package com.guru99.tests;

import com.guru99.pages.DepositPage;
import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.pages.NewAccountPage;
import com.guru99.pages.NewCustomerPage;
import com.guru99.pages.WithdrawalPage;
import com.guru99.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransactionTest extends BaseTest {

    @Test(priority = 1)
    public void testTransactions() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        // Pre-requisite: Create Customer & Account
        NewCustomerPage newCustomerPage = homePage.clickNewCustomer();
        String email = "trans" + System.currentTimeMillis() + "@example.com";
        newCustomerPage.addNewCustomer("Trans User", "female", "10/10/1995", "101 Lane", "City", "State", "654321",
                "1122334455", email, "password");
        String customerId = newCustomerPage.getCustomerId();

        NewAccountPage newAccountPage = homePage.clickNewAccount();
        newAccountPage.createNewAccount(customerId, "Current", "5000");
        String accountId = newAccountPage.getAccountId();

        // 1. Deposit
        DepositPage depositPage = homePage.clickDeposit();
        depositPage.depositMethod(accountId, "2000", "Bonus");
        String depositMsg = depositPage.getSuccessMessage();
        Assert.assertTrue(depositMsg.contains("Transaction details of Deposit for Account"));

        // 2. Withdrawal
        WithdrawalPage withdrawalPage = homePage.clickWithdrawal();
        withdrawalPage.withdrawMethod(accountId, "1000", "Expense");
        String withdrawMsg = withdrawalPage.getSuccessMessage();
        Assert.assertTrue(withdrawMsg.contains("Transaction details of Withdrawal for Account"));
    }
}
