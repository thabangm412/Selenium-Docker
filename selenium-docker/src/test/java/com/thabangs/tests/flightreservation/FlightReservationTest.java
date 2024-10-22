package com.thabangs.tests.flightreservation;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

public class FlightReservationTest {

    private WebDriver driver;
    private List<String> expectedPrices;

    @BeforeTest
    @Parameters({"expectedPrice1","expectedPrice2","expectedPrice3","expectedPrice4"})
    public void setDriver(@Optional String expectedPrice1, @Optional String expectedPrice2, @Optional String expectedPrice3, @Optional String expectedPrice4 )
    {
         this.expectedPrices = Arrays.asList(expectedPrice1, expectedPrice2, expectedPrice3, expectedPrice4);

        //this.expectedPrices = expectedPrice;

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
        flightSearchPage.enterRandomFlightDetails();
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
        
        // Assert the confirmation page is displayed
        Assert.assertTrue(flightsConfirmationPage.isAt());
        flightsConfirmationPage.getFlightsTotalPrice();

        //flightSelectionPage.enterFlightDetails("Two", "Frankfurt", "Acapulco");

        
        
    
        // Call enterRandomFlightDetails once and store the result
        //String selectedFlightDetails = flightSelectionPage.enterRandomFlightDetails();
    
        // Compare the result and validate prices accordingly
        // if (selectedFlightDetails.equals("One")) {
        //     Assert.assertEquals(flightsConfirmationPage.getFlightsTotalPrice(), expectedPrices.get(0));
    
        // } else if (selectedFlightDetails.equals("Two")) {
        //     Assert.assertEquals(flightsConfirmationPage.getFlightsTotalPrice(), expectedPrices.get(1));
    
        // } else if (selectedFlightDetails.equals("Three")) {
        //     Assert.assertEquals(flightsConfirmationPage.getFlightsTotalPrice(), expectedPrices.get(2));
    
        // } else if (selectedFlightDetails.equals("Four")) {  // Corrected the condition for "Four"
        //     Assert.assertEquals(flightsConfirmationPage.getFlightsTotalPrice(), expectedPrices.get(3));
        // }
    }
    

    @AfterTest
    public void closeDriver()
    {
        this.driver.quit();
    }

}
