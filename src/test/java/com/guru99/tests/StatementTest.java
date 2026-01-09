package com.guru99.tests;

import com.guru99.pages.BalanceEnquiryPage;
import com.guru99.pages.HomePage;
import com.guru99.pages.LoginPage;
import com.guru99.pages.MiniStatementPage;
import com.guru99.pages.NewAccountPage;
import com.guru99.pages.NewCustomerPage;
import com.guru99.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatementTest extends BaseTest {

    @Test(priority = 1)
    public void testStatements() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(ConfigReader.getUsername(), ConfigReader.getPassword());

        // Pre-requisite: Create Customer & Account
        NewCustomerPage newCustomerPage = homePage.clickNewCustomer();
        String email = "stmt" + System.currentTimeMillis() + "@example.com";
        newCustomerPage.addNewCustomer("Stmt User", "male", "12/12/1988", "202 Blvd", "City", "State", "987654",
                "9988776655", email, "password");
        String customerId = newCustomerPage.getCustomerId();

        NewAccountPage newAccountPage = homePage.clickNewAccount();
        newAccountPage.createNewAccount(customerId, "Savings", "10000");
        String accountId = newAccountPage.getAccountId();

        // 1. Balance Enquiry
        BalanceEnquiryPage balancePage = homePage.clickBalanceEnquiry();
        balancePage.checkBalance(accountId);
        String balanceHeader = balancePage.getBalanceDetailsHeader();
        Assert.assertTrue(balanceHeader.contains("Balance Details for Account"));

        // 2. Mini Statement
        MiniStatementPage miniStatementPage = homePage.clickMiniStatement();
        miniStatementPage.generateMiniStatement(accountId);
        String miniStmtHeader = miniStatementPage.getMiniStatementHeader();
        Assert.assertTrue(miniStmtHeader.contains("Last Five Transaction Details for Account No"));

        // 3. Customised Statement (Optional/Skipped for simplicity as it requires
        // specific transaction history)
    }
}
