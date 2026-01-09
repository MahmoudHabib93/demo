package com.guru99.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guru99.utils.ExtentManager;
import org.testng.ITestResult;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupSuite() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setup(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        WebDriverManager.chromedriver().setup();
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(com.guru99.utils.ConfigReader.getUrl());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Throwable: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        }

        if (driver != null) {
            try {
                driver.switchTo().alert().accept();
            } catch (Exception e) {
                // No alert present, ignore
            }
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDownSuite() {
        if (extent != null) {
            extent.flush();
        }
    }
}
