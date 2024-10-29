package com.thabangs.tests.vendorportal;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thabangs.pages.vendorPortal.VendorLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

public class VendorPortalLoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        this.driver =  new FirefoxDriver();
    }

    @Test
    public void vendorLoginTest()
    {
        VendorLoginPage vendorLoginPage = new VendorLoginPage(driver);
        vendorLoginPage.goToVendor("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        //vendorLoginPage.isAt();
        vendorLoginPage.enterVendorLoginDetails("sam", "sam");
        vendorLoginPage.clickVendorLogin();
        Assert.assertTrue(vendorLoginPage.isAt());

//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileHandler.copy(screenshot, new File("root/screenshot/vendorLoginTest.png"));
//            System.out.println("Screenshot taken: vendorLoginTest.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        

    }

    @AfterTest
    public void closeDriver()
    {
        this.driver.quit();
    }

}
