package com.thabangs.tests.flightreservation;


 

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thabangs.pages.flightreservation.FlightSearchPage;
import com.thabangs.pages.flightreservation.FlightSelectionPage;
import com.thabangs.pages.flightreservation.FlightsConfirmationPage;
import com.thabangs.pages.flightreservation.RegistraionPage;
import com.thabangs.pages.flightreservation.RegistrationConfirmationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FlightReservationTest {

    private static final Logger log = LoggerFactory.getLogger(RegistraionPage.class);


    private WebDriver driver;
    private String noOfPassengers;
    private String expectedPrice;
   
    @Parameters({"noOfPassengers","expectedPrice"})
    @BeforeTest

    public void setDriver(String noOfPassengers, String expectedPrice)
    {

        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;

        // driver setup
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
 
    }

    @Test
    public void userRegistrationTest()
    {
        RegistraionPage registraionPage = new RegistraionPage(driver);
        registraionPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registraionPage.isAt());

        registraionPage.enterUserDetains("Test", "Test");
        registraionPage.enterUserCredentials("Test@seleniumDocker", "Test1234");
        registraionPage.enterAdressDetails("67 Mozart", "Johannesburg", "Alaska", "1686");
        registraionPage.register();

    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConfirmationPageTest()
    {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());
        registrationConfirmationPage.clickGoToFlightsSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationPageTest")
    public void flightSearchPageTest()
    {
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        Assert.assertTrue(flightSearchPage.isAt());

        // Using dynamic option
        flightSearchPage.chooseTrip("oneway");
        flightSearchPage.selectPasseners(noOfPassengers);
        flightSearchPage.enterFlightDetails("Acapulco","Frankfurt");
        //flightSearchPage.enterRandomFlightDetails();
        flightSearchPage.chooseServiceClass("first");
        flightSearchPage.clickSearchFlightsButton();
    }

    @Test(dependsOnMethods = "flightSearchPageTest")
    public void selectFlightPageTest()
    {
        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
        Assert.assertTrue(flightSelectionPage.isAt());

        flightSelectionPage.chooseQatarDepatureClass("first");
        flightSelectionPage.chooseQatarArrivingClass("economy");
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // wait.until(ExpectedConditions.elementToBeClickable(flightSelectionPage.clickConfirmFlights()));
        flightSelectionPage.clickConfirmFlightsButton();
    }

    
    @Test(dependsOnMethods = "selectFlightPageTest")
    public void flightConfirmationPageTest() {
        //FlightSearchPage flightSelectionPage = new FlightSearchPage(driver);
        FlightsConfirmationPage flightsConfirmationPage = new FlightsConfirmationPage(driver);
        
        //Assert the confirmation page is displayed
        Assert.assertTrue(flightsConfirmationPage.isAt());
        log.info("Confirmation Page displayed");
        Assert.assertEquals(flightsConfirmationPage.getFlightsTotalPrice(), expectedPrice);
        log.info("Returned price matches expected price:"+expectedPrice );
    }
    

    @AfterTest
    public void closeDriver()
    {
        this.driver.quit();
    }

}
