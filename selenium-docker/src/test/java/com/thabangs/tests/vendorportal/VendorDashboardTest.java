package com.thabangs.tests.vendorportal;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thabangs.pages.vendorPortal.DashboardPage;
import com.thabangs.pages.vendorPortal.VendorLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VendorDashboardTest {

    private FirefoxDriver driver;

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

    }

    @Test(dependsOnMethods = "vendorLoginTest")
    public void monthlyEarningsTest()
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.getMonthlyEarnings(), "$40,000");

    }

    @Test(dependsOnMethods = "vendorLoginTest")
    public void annualEarningsTest()
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.getAnnuallyEarnings(), "$215,000");

    }

    @Test(dependsOnMethods = "vendorLoginTest")
    public void  profitMarginTest()
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.getProfitMargin(), "50%");

    }

    @Test(dependsOnMethods = "vendorLoginTest")
    public void availableInventoryTest()
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.getAvailableInventory(), "18");

    }

    @AfterTest
    public void closeDriver()
    {
        this.driver.quit();
    }


    
    



}
