package com.thabangs.pages.vendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thabangs.pages.AbstractPage;

public class DashboardPage extends AbstractPage{

    @FindBy(id = "#userDropdown")
    private WebElement dashboardProfileElement;

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningElement;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;
    
    @FindBy(id ="available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(id = "userDropdown")
    private WebElement profileElement;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutElement;

    @FindBy(css = "div.modal-footer .btn-primary")
    private WebElement logoutButtonElement;

    @FindBy(id = "exampleModalLabel")
    private WebElement logoutPageElement;

    public DashboardPage(WebDriver driver)
    {
        super(driver);
    }
    @Override
    public boolean isAt()
    {
        this.wait.until(ExpectedConditions.visibilityOf(this.dashboardProfileElement));
        return this.dashboardProfileElement.isDisplayed();
    }

    public String getMonthlyEarnings()
    {
        return this.monthlyEarningElement.getText();

    }

    public String getAnnuallyEarnings()
    {
        return this.annualEarningElement.getText();
        
    }

    public String getProfitMargin()
    {
        return this.profitMarginElement.getText();
    }

    public String getAvailableInventory()
    {
        return this.availableInventoryElement.getText();
    }

}
