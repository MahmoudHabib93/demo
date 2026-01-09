package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithdrawalPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoField;

    @FindBy(name = "ammount")
    private WebElement amountField;

    @FindBy(name = "desc")
    private WebElement descriptionField;

    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@class='heading3']")
    private WebElement successMessage;

    public WithdrawalPage(WebDriver driver) {
        super(driver);
    }

    public void withdrawMethod(String accountNo, String amount, String description) {
        accountNoField.sendKeys(accountNo);
        amountField.sendKeys(amount);
        descriptionField.sendKeys(description);
        submitButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
