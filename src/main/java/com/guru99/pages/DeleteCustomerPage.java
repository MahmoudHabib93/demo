package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomerPage extends BasePage {

    @FindBy(name = "cusid")
    private WebElement customerIdField;

    @FindBy(name = "AccSubmit")
    private WebElement submitButton;

    public DeleteCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void deleteCustomer(String customerId) {
        customerIdField.sendKeys(customerId);
        submitButton.click();
    }
}
