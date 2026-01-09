package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoField;

    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    public void deleteAccount(String accountNo) {
        accountNoField.sendKeys(accountNo);
        submitButton.click();
    }
}
