package com.thabangs.pages.vendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thabangs.pages.AbstractPage;

public class vendorPortalHomePage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='h3 mb-0 text-gray-800']")
    private WebElement vendorHomePage;

      public vendorPortalHomePage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.vendorHomePage));
        return this.vendorHomePage.isDisplayed();
    }

}
