package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomisedStatementPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoField;

    @FindBy(name = "fdate")
    private WebElement fromDateField;

    @FindBy(name = "tdate")
    private WebElement toDateField;

    @FindBy(name = "amountlower")
    private WebElement minTransactionValueField;

    @FindBy(name = "numtransaction")
    private WebElement numTransactionField;

    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public CustomisedStatementPage(WebDriver driver) {
        super(driver);
    }

    public void getStatement(String accountNo, String fromDate, String toDate, String minVal, String numTrans) {
        accountNoField.sendKeys(accountNo);
        fromDateField.sendKeys(fromDate);
        toDateField.sendKeys(toDate);
        minTransactionValueField.sendKeys(minVal);
        numTransactionField.sendKeys(numTrans);
        submitButton.click();
    }
}
