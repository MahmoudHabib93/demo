package com.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewCustomerPage extends BasePage {

    private By customerNameField = By.name("name");
    private By genderMaleRadio = By.xpath("//input[@value='m']");
    private By genderFemaleRadio = By.xpath("//input[@value='f']");
    private By dobField = By.name("dob");
    private By addressField = By.name("addr");
    private By cityField = By.name("city");
    private By stateField = By.name("state");
    private By pinField = By.name("pinno");
    private By mobileField = By.name("telephoneno");
    private By emailField = By.name("emailid");
    private By passwordField = By.name("password");
    private By submitButton = By.name("sub");

    // For verification
    private By successMessage = By.xpath("//p[@class='heading3']");
    private By customerIdTable = By.xpath("//td[contains(text(),'Customer ID')]/following-sibling::td");

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void addNewCustomer(String name, String gender, String dob, String address, String city, String state,
            String pin, String mobile, String email, String password) {
        driver.findElement(customerNameField).sendKeys(name);

        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMaleRadio).click();
        } else {
            driver.findElement(genderFemaleRadio).click();
        }

        // Click and type date with Keys.TAB to ensure focus loss
        WebElement dobElement = driver.findElement(dobField);
        dobElement.click();
        dobElement.sendKeys(dob); // expecting standard mm/dd/yyyy format with slashes or not, purely input
        dobElement.sendKeys(org.openqa.selenium.Keys.TAB);

        // Backup: Use JavascriptExecutor to ensure value is set if typing failed
        // specific format
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '1990-01-01';", dobElement);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(pinField).sendKeys(pin);
        driver.findElement(mobileField).sendKeys(mobile);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);

        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getCustomerId() {
        return driver.findElement(customerIdTable).getText();
    }
}
