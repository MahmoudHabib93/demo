package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerPage extends BasePage {

    private By customerIdField = By.name("cusid");
    private By submitButton = By.name("AccSubmit");

    // Edit fields (assuming similar structure after submitting ID)
    private By addressField = By.name("addr");
    private By submitEditButton = By.name("sub");

    private By successMessage = By.xpath("//p[@class='heading3']");

    public EditCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void enterCustomerId(String customerId) {
        driver.findElement(customerIdField).sendKeys(customerId);
        driver.findElement(submitButton).click();
    }

    public void updateAddress(String newAddress) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(newAddress);
        driver.findElement(submitEditButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
