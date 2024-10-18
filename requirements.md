**** OBJECTIVES AND ARCHITECTURE ****
 
1. Installations
    1.1 npm i 
    1.1 npm maven install
        mvn --version // checking maven version installed
        mvn clean compile

2. Directory structure
    2.1 root/src/main/pages/

        2.1.1 pages/flightreservation/ 

            // Page objects
            pages/flightreservation/REgistrationPage/ 
            pages/flightreservation/REgistrationConfirmationPage/
            pages/flightreservation/FlightSearchPage/      
            pages/flightreservation/FlightSelectionPage/    

        2.2.1 pages/vendorPortal/

    2.2 root/src/main/AbstractPage

        **Purpose**: It's an abstract base class for all web pages. It defines common behavior and enforces the implementation of the isAt() method in any subclass that represents a specific page.

        Summary:
        Purpose: AbstractPage serves as a reusable, common base class for different page objects in your Selenium framework. It provides WebDriver and WebDriverWait initialization while requiring subclasses to implement the isAt() method to confirm that a page is loaded or displayed correctly.
    
    2.3 root/src/tests/



**************************************After project setup**************************************************

*** Flight Reservation Application Page Objects***

1.1 Create page object for registrationi page
1.2 Create a Registration page class with methods for selectors

*** Logging levels***

1.DEBUG
    -low level info you might need only for local development/testing.
    -Will NOT be included in the prod server
2.INFO
    -any useful info which shows the app progress
3.WARN
    -any info (including some exceptions in some cases) which might requre some attention.
    -Not very critical for appto work
4.Error
    -Any exception which require immediate attention 
    -App is NOT working as expected