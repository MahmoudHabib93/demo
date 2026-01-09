package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BalanceEnquiryPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoField;

    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@class='heading3']")
    private WebElement balanceDetailsHeader;

    public BalanceEnquiryPage(WebDriver driver) {
        super(driver);
    }

    public void checkBalance(String accountNo) {
        accountNoField.sendKeys(accountNo);
        submitButton.click();
    }

    public String getBalanceDetailsHeader() {
        return balanceDetailsHeader.getText();
    }
}
