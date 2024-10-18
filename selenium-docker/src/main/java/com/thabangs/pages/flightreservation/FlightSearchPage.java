package com.thabangs.pages.flightreservation;

import java.util.List;
import java.util.Random;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thabangs.pages.AbstractPage;

public class FlightSearchPage extends AbstractPage{

    private static final Logger log = LoggerFactory.getLogger(FlightSearchPage.class);

    @FindBy(xpath = "//h2[contains(text(),'Flight Search')]")
    private WebElement flightSearchText;
    
    @FindBy(id = "oneway")
    private WebElement oneWayCheckBox;

    @FindBy(id = "twoway")
    private WebElement roundTripCheckBox;

    @FindBy(id = "passengers")
    private WebElement passangersInput;

    @FindBy(id = "depart-from")
    private WebElement departingFromInput;

    @FindBy(id = "arrive-in")
    private WebElement arrivingInInput;

    @FindBy(id = "service-class1")
    private WebElement economyClassInput;

    @FindBy(id = "service-class2")
    private WebElement firstClassInput;

    @FindBy(id = "service-class3")
    private WebElement businessClassInput;

    @FindBy(id = "search-flights")
    private WebElement searchFllightButton;

    public FlightSearchPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightSearchText));
        return this.flightSearchText.isDisplayed();
    }

    public void chooseOneWayTrip()
    {
        this.oneWayCheckBox.click();
    }

    public void chooseRoundTrip()
    {
        this.oneWayCheckBox.click();
    }
    
    public void enterFlightDetails(String passengers, String departing, String arriving)
    {
        Select passengerSelect = new Select(this.passangersInput);
        Select departingFromSelect = new Select(this.departingFromInput);
        Select arringInSelect = new Select(this.arrivingInInput);

        passengerSelect.selectByValue(passengers);
        departingFromSelect.selectByValue(departing);
        arringInSelect.selectByValue(arriving);
    }

    public void chooseEconomyServiceClass()
    {
        this.economyClassInput.click();
    }

    public void chooseFirstServiceClass()
    {
        this.firstClassInput.click();
    }
    public void chooseBusinessServiceClass()
    {
        this.businessClassInput.click();
    }
 
    // Dynamic code for all form check options on this page object

    public void chooseServiceClass(String serviceClass) {
        switch (serviceClass.toLowerCase()) {
            case "economy":
                this.economyClassInput.click();
                break;
            case "first":
                this.firstClassInput.click();
                break;
            case "business":
                this.businessClassInput.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid service class: " + serviceClass);
        }
    }

    public void chooseTrip(String flightTrip) 
    {
        switch (flightTrip.toLowerCase()) {
            case "oneway":
                this.oneWayCheckBox.click();
                break;
            case "roundtrip":
                this.roundTripCheckBox.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid flight trip: " + flightTrip);
        }
    }
    
    // Random flight details selection
    public void enterRandomFlightDetails() {
        // Initialize Select objects for each dropdown
        Select passengerSelect = new Select(this.passangersInput);
        Select departingFromSelect = new Select(this.departingFromInput);
        Select arrivingInSelect = new Select(this.arrivingInInput);

        // Select random options from each dropdown
        selectRandomOption(passengerSelect);
        selectRandomOption(departingFromSelect);
        selectRandomOption(arrivingInSelect);
    }

    private void selectRandomOption(Select dropdown) {
        // Get all available options from the dropdown
        List<WebElement> options = dropdown.getOptions();
        
        // Generate a random index within the options list
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        
        // Select the random option
        dropdown.selectByIndex(randomIndex);
    }

    public void clickSearchFlightsButton(){
        this.searchFllightButton.click();
    }

    
}
