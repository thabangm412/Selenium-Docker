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
        log.info("One way trip option selected.");
    }

    public void chooseRoundTrip()
    {
        this.oneWayCheckBox.click();
        log.info("Two way trip option selected.");
    }
    
    public void enterFlightDetails(String passengers, String departing, String arriving)
    {
        Select passengerSelect = new Select(this.passangersInput);
        Select departingFromSelect = new Select(this.departingFromInput);
        Select arringInSelect = new Select(this.arrivingInInput);

        passengerSelect.selectByValue(passengers);
        log.info("Passenger number selected: " + passengers);
        departingFromSelect.selectByValue(departing);
        log.info("Departing class selected: " + departing);
        arringInSelect.selectByValue(arriving);
        log.info("Arriving class selected: " + arriving);
    }

    public void chooseEconomyServiceClass()
    {
        this.economyClassInput.click();
        log.info("Economy class selected.");
    }

    public void chooseFirstServiceClass()
    {
        this.firstClassInput.click();
        log.info("First class selected.");
    }
    public void chooseBusinessServiceClass()
    {
        this.businessClassInput.click();
        log.info("Business class selected.");
    }
 
    // Dynamic code for all form check options on this page object

    public void chooseServiceClass(String serviceClass) {
        switch (serviceClass.toLowerCase()) {
            case "economy":
                this.economyClassInput.click();
                log.info("Economy class selected.");
                break;
            case "first":
                this.firstClassInput.click();
                log.info("First class selected.");
                break;
            case "business":
                this.businessClassInput.click();
                log.info("Business class selected.");
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
                log.info("One way trip selected.");
                break;
            case "roundtrip":
                this.roundTripCheckBox.click();
                log.info("Two way trip selected.");
                break;
            default:
                throw new IllegalArgumentException("Invalid flight trip: " + flightTrip);
        }
    }
    
    // Random flight details selection
    public String enterRandomFlightDetails() {
        // Initialize Select objects for each dropdown
        Select passengerSelect = new Select(this.passangersInput);
        Select departingFromSelect = new Select(this.departingFromInput);
        Select arrivingInSelect = new Select(this.arrivingInInput);

        // Select random options from each dropdown
        String selectedPassenger = selectRandomOption(passengerSelect);
        log.info("Random passengers selected: " + selectedPassenger);
        String selectedRandomDeparture = selectRandomOption(departingFromSelect);
        log.info("Random depature selected: " + selectedRandomDeparture);
        String seelctedArrivingSelected = selectRandomOption(arrivingInSelect);
        log.info("Random arriving  selected: " + seelctedArrivingSelected);

        return selectedPassenger;
    }

    private String selectRandomOption(Select dropdown) {
        // Get all available options from the dropdown
        List<WebElement> options = dropdown.getOptions();
        
        // Generate a random index within the options list
        Random random = new Random();
        int randomIndex = random.nextInt(options.size());
        
        // Select the random option
        dropdown.selectByIndex(randomIndex);
        
        // Return the text of the selected option
        return options.get(randomIndex).getText();
    }
    

    public void clickSearchFlightsButton(){
        this.searchFllightButton.click();
    }

    
}
