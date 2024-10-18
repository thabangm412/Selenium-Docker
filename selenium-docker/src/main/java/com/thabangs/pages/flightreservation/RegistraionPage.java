package com.thabangs.pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.thabangs.pages.AbstractPage;

public class RegistraionPage extends AbstractPage{

    @FindBy(xpath = "//h2[contains(text(),'Customer Registration')]")
    private WebElement customerRegistrationPage;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "street")
    private WebElement streetInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "zip")
    private WebElement zipInput;

    @FindBy(id = "inputState")
    private WebElement stateInput;
    //Drop down use
    //inputStateInput.selectByValue("California")

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    //Initialize a Webdriver
    public RegistraionPage(WebDriver driver)
    {
        super(driver); 
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.customerRegistrationPage));
        return this.customerRegistrationPage.isDisplayed();
    }

    public void goTo(String url)
    {
        this.driver.get(url);
    }

    public void enterUserDetains(String firstName, String lastName) 
    {
        this.firstNameInput.sendKeys(firstName);
        this.lastNameInput.sendKeys(lastName);
    }

    public void enterAdressDetails(String street, String city, String state, String zip)
    {
        this.streetInput.sendKeys(street);
        this.cityInput.sendKeys(city);
        Select select = new Select(this.stateInput); //Keep an eye on this one
        select.selectByValue(state);
        this.zipInput.sendKeys(zip);
    }

    public void register()
    {
        this.registerButton.click();
    }

}
