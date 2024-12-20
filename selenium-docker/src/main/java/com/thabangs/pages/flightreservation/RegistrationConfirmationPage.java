package com.thabangs.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thabangs.pages.AbstractPage;

public class RegistrationConfirmationPage extends AbstractPage{

    private static final Logger log = LoggerFactory.getLogger(RegistrationConfirmationPage.class);

    @FindBy(xpath =  "//h2[contains(text(),'Registration Confirmation')]")
    private WebElement registrationConfirmationText;

    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightsSearchButton;

    public RegistrationConfirmationPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.registrationConfirmationText));
        return this.registrationConfirmationText.isDisplayed();
    }

    public void clickGoToFlightsSearch() 
    {
        this.goToFlightsSearchButton.click();
    }

}
