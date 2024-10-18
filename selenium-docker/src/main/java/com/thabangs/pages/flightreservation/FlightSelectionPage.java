package com.thabangs.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thabangs.pages.AbstractPage;

public class FlightSelectionPage extends AbstractPage {

    @FindBy(xpath = "//h2[contains(text(),'Select Flights')]")
    private WebElement selectFightPage;

    @FindBy(id = "dep-emirates-economy")
    private WebElement emirates_D_Economy;

    @FindBy(id = "dep-emirates-first")
    private WebElement emirates_D_First;

    @FindBy(id = "dep-emirates-business")
    private WebElement emirates_D_Business;

    @FindBy(id = "dep-qatar-economy")
    private WebElement qatar_D_Economy;

    @FindBy(id = "dep-qatar-first")
    private WebElement qatar_D_First;

    @FindBy(id = "dep-qatar-business")
    private WebElement qatar_D_Business;

    @FindBy(id = "dep-ba-economy")
    private WebElement britishA_D_Economy;

    @FindBy(id = "dep-ba-first")
    private WebElement britishA_D_First;

    @FindBy(id = "dep-ba-business")
    private WebElement britishA_D_Business;

    @FindBy(id = "arr-emirates-economy")
    private WebElement emirates_A_Economy;

    @FindBy(id = "arr-emirates-first")
    private WebElement emirates_A_First;

    @FindBy(id = "arr-emirates-business")
    private WebElement emirates_A_Business;

    @FindBy(id = "arr-qatar-economy")
    private WebElement qatar_A_Economy;

    @FindBy(id = "arr-qatar-first")
    private WebElement qatar_A_First;

    @FindBy(id = "arr-qatar-business")
    private WebElement qatar_A_Business;

    @FindBy(id = "arr-ba-economy")
    private WebElement britishA_A_Economy;

    @FindBy(id = "arr-ba-first")
    private WebElement britishA_A_First;

    @FindBy(id = "arr-ba-business")
    private WebElement britishA_A_Business;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public FlightSelectionPage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.selectFightPage));
        return this.selectFightPage.isDisplayed();
    }


    public void chooseEmiratesDepatureClass(String emiratesDepartureClass)
    {
        switch (emiratesDepartureClass.toLowerCase()) {
            case "economy":
                this.emirates_D_Economy.click();
                break;
            case  "first":
                this.emirates_D_First.click();
                break;
            case "business":
                this.emirates_D_Business.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid emirates class: " + emiratesDepartureClass);
        }
    }

    public void chooseEmiratesArrivingClass(String emiratesArrivingClass)
    {
        switch (emiratesArrivingClass.toLowerCase()) {
            case "economy":
                this.emirates_A_Economy.click();
                break;
            case  "first":
                this.emirates_A_First.click();
                break;
            case "business":
                this.emirates_A_Business.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid emirates class: " + emiratesArrivingClass);
        }
    }

    public void chooseQatarDepatureClass(String qatarDepartureClass)
    {
        switch (qatarDepartureClass.toLowerCase()) {
            case "economy":
                this.qatar_D_Economy.click();
                break;
            case  "first":
                this.qatar_D_First.click();
                break;
            case "business":
                this.qatar_D_Business.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid qatar class: " + qatarDepartureClass);
        }
    }

    public void chooseQatarSrrivingClass(String qatarArrivingClass)
    {
        switch (qatarArrivingClass.toLowerCase()) {
            case "economy":
                this.qatar_A_Economy.click();
                break;
            case  "first":
                this.qatar_A_First.click();
                break;
            case "business":
                this.qatar_A_Business.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid qatar class: " + qatarArrivingClass);
        }
    }

    public void chooseBritishDepartureClass(String britishDepartureClass)
    {
        switch (britishDepartureClass.toLowerCase()) {
            case "economy":
                this.britishA_D_Economy.click();
                break;
            case  "first":
                this.britishA_D_First.click();
                break;
            case "business":
                this.britishA_D_Business.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid british class: " + britishDepartureClass);
        }
    }

    public void chooseBritishArrivingClass(String britishArrivingClass)
    {
        switch (britishArrivingClass.toLowerCase()) {
            case "economy":
                this.britishA_A_Economy.click();
                break;
            case  "first":
                this.britishA_A_First.click();
                break;
            case "business":
                this.britishA_A_Business.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid british class: " + britishArrivingClass);
        }
    }

}
