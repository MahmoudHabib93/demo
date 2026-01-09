package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage extends BasePage {

    @FindBy(name = "cusid")
    private WebElement customerIdField;

    @FindBy(name = "selaccount")
    private WebElement accountTypeDropdown;

    @FindBy(name = "inideposit")
    private WebElement initialDepositField;

    @FindBy(name = "button2")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@class='heading3']")
    private WebElement successMessage;

    @FindBy(xpath = "//td[contains(text(),'Account ID')]/following-sibling::td")
    private WebElement accountIdTable;

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void createNewAccount(String customerId, String accountType, String initialDeposit) {
        customerIdField.sendKeys(customerId);
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType);
        initialDepositField.sendKeys(initialDeposit);
        submitButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getAccountId() {
        return accountIdTable.getText();
    }
}
