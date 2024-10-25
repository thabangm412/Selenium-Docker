package com.thabangs.pages.vendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thabangs.pages.AbstractPage;

public class VendorLoginPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='h4 text-gray-900 mb-4']")
    private WebElement vendorLoginPage;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passWordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    public VendorLoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.vendorLoginPage));
        return this.vendorLoginPage.isDisplayed();
    }

    private static final Logger log = LoggerFactory.getLogger(VendorLoginPage.class);

    public void goToVendor(String url)
    {
        this.driver.get(url);
        log.info("Vendor url opened");
    }

    public void  enterVendorLoginDetails(String username, String passwaord)
    {
        this.userNameInput.sendKeys(username);
        log.info("Vendor username entered: "+ username);
        this.passWordInput.sendKeys(passwaord);
        log.info("Vendor password entered: "+ passwaord);
    }

    public void clickVendorLogin()
    {
        this.loginButton.click();
        log.info("Vendor logoin button clicked");
    }


}
