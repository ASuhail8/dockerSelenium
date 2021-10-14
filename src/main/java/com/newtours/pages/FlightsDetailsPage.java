package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passengers;

    @FindBy(id="findFlights")
    private WebElement submit;

    public FlightsDetailsPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassengers(String noOfPassengers){
        wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select sel = new Select(passengers);
        sel.selectByValue(noOfPassengers);
    }

    public void clickContinueToGoFindFlightsPage(){
        submit.click();
    }
}
