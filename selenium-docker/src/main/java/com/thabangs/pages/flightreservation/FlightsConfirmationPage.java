package com.thabangs.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thabangs.pages.AbstractPage;

public class FlightsConfirmationPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(FlightsConfirmationPage.class);

    @FindBy(xpath = "//h2[contains(text(),'Flights Confirmation')]")
    private WebElement flightsConfirmationPage;

    @FindBy(css = "p.fw-bold") //index 0
    private WebElement flightsConfirmationNumber;

    @FindBy(css = "p.fw-bold") //index 1
    private WebElement flightTotalTax;

    @FindBy(css = "p.fw-bold") //index 2
    private WebElement flightTotalPrice;

    public FlightsConfirmationPage (WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsConfirmationPage));
        return this.flightsConfirmationPage.isDisplayed();
    }
    public String getFlightsTotalPrice() {
        // Initialize Select objects for dropdowns
        Select selectFlightConfirmationNumber = new Select(this.flightsConfirmationNumber);
        Select selectTotalTaxApplied = new Select(this.flightTotalTax);
        Select selectFlightTotalPrice = new Select(this.flightTotalPrice);
    
        // Select options by index and get the selected values as strings
        selectFlightConfirmationNumber.selectByIndex(0);
        String flightConfirmationNumber = selectFlightConfirmationNumber.getFirstSelectedOption().getText();
    
        selectTotalTaxApplied.selectByIndex(1);
        String flightTotalTax = selectTotalTaxApplied.getFirstSelectedOption().getText();
    
        selectFlightTotalPrice.selectByIndex(2);
        String flightTotalPrice = selectFlightTotalPrice.getFirstSelectedOption().getText();
    
        // Log the details
        log.info("Flight confirmation number is: " + flightConfirmationNumber);
        log.info("Flight total tax is: " + flightTotalTax);
        log.info("Flight total price is: " + flightTotalPrice);
    
        // Return the total price as a string
        return flightTotalPrice;
    }
    
    

}
