package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//td[contains(text(),'Manger Id')]")
    private WebElement managerIdText;

    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    @FindBy(linkText = "New Customer")
    private WebElement newCustomerLink;

    @FindBy(linkText = "Edit Customer")
    private WebElement editCustomerLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getManagerIdText() {
        return managerIdText.getText();
    }

    public void clickLogout() {
        logoutLink.click();
    }

    public NewCustomerPage clickNewCustomer() {
        newCustomerLink.click();
        return new NewCustomerPage(driver);
    }

    public EditCustomerPage clickEditCustomer() {
        editCustomerLink.click();
        return new EditCustomerPage(driver);
    }

    @FindBy(linkText = "Delete Customer")
    private WebElement deleteCustomerLink;

    public DeleteCustomerPage clickDeleteCustomer() {
        deleteCustomerLink.click();
        return new DeleteCustomerPage(driver);
    }

    @FindBy(linkText = "New Account")
    private WebElement newAccountLink;

    public NewAccountPage clickNewAccount() {
        newAccountLink.click();
        return new NewAccountPage(driver);
    }

    @FindBy(linkText = "Edit Account")
    private WebElement editAccountLink;

    public EditAccountPage clickEditAccount() {
        editAccountLink.click();
        return new EditAccountPage(driver);
    }

    @FindBy(linkText = "Delete Account")
    private WebElement deleteAccountLink;

    public DeleteAccountPage clickDeleteAccount() {
        deleteAccountLink.click();
        return new DeleteAccountPage(driver);
    }

    @FindBy(linkText = "Deposit")
    private WebElement depositLink;

    public DepositPage clickDeposit() {
        depositLink.click();
        return new DepositPage(driver);
    }

    @FindBy(linkText = "Withdrawal")
    private WebElement withdrawalLink;

    public WithdrawalPage clickWithdrawal() {
        withdrawalLink.click();
        return new WithdrawalPage(driver);
    }

    @FindBy(linkText = "Balance Enquiry")
    private WebElement balanceEnquiryLink;

    public BalanceEnquiryPage clickBalanceEnquiry() {
        balanceEnquiryLink.click();
        return new BalanceEnquiryPage(driver);
    }

    @FindBy(linkText = "Mini Statement")
    private WebElement miniStatementLink;

    public MiniStatementPage clickMiniStatement() {
        miniStatementLink.click();
        return new MiniStatementPage(driver);
    }

    @FindBy(linkText = "Customised Statement")
    private WebElement customisedStatementLink;

    public CustomisedStatementPage clickCustomisedStatement() {
        customisedStatementLink.click();
        return new CustomisedStatementPage(driver);
    }
}
