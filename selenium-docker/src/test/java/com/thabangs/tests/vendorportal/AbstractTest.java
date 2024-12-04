package com.thabangs.tests.vendorportal;

import com.thabangs.pages.vendorPortal.VendorLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);
    private String username;
    private String password;
    protected WebDriver driver;

    @Parameters({"username","password"})
    @BeforeTest
    public void setDriver(String username, String password) throws MalformedURLException {

        this.username = username;
        this.password = password;

        if(Boolean.getBoolean("selenium.grid.enabled"))
        {
            this.driver = getRemoteDriver();
            log.info("remote driver triggered");
        }else{
            this.driver = getLocalDriver();
            log.info("local driver triggered");
        }

    }

    private WebDriver getLocalDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities;
        if(System.getProperty("browser").equalsIgnoreCase("chrome"))
        {
            capabilities = new ChromeOptions();
            log.info("chrome option returned");
        }else{
            capabilities = new FirefoxOptions();
            log.info("firefox option returned");
        }
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

    }

    @Test
    public void vendorLoginTest() {
        VendorLoginPage vendorLoginPage = new VendorLoginPage(driver);
        vendorLoginPage.goToVendor("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        //vendorLoginPage.isAt();
        vendorLoginPage.enterVendorLoginDetails(username, password);
        vendorLoginPage.clickVendorLogin();
        Assert.assertTrue(vendorLoginPage.isAt());
    }
    @AfterTest
    public void quitDriver()
    {
        this.driver.quit();
    }
}
