package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoField;

    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public EditAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterAccountNumber(String accountNo) {
        accountNoField.sendKeys(accountNo);
        submitButton.click();
    }
}
