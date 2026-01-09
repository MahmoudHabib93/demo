package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiniStatementPage extends BasePage {

    @FindBy(name = "accountno")
    private WebElement accountNoField;

    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    @FindBy(xpath = "//p[@class='heading3']")
    private WebElement miniStatementHeader;

    public MiniStatementPage(WebDriver driver) {
        super(driver);
    }

    public void generateMiniStatement(String accountNo) {
        accountNoField.sendKeys(accountNo);
        submitButton.click();
    }

    public String getMiniStatementHeader() {
        return miniStatementHeader.getText();
    }
}
