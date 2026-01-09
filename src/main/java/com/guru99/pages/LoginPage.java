package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "uid")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "btnLogin")
    private WebElement loginButton;

    @FindBy(className = "barone")
    private WebElement titleText;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUserName(String strUserName) {
        userName.clear();
        userName.sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        password.clear();
        password.sendKeys(strPassword);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public HomePage login(String strUserName, String strPassword) {
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
        return new HomePage(driver);
    }

    public String getTitleText() {
        return titleText.getText();
    }
}
