package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameter(String noOfPassengers, String expectedPrice){
        this.noOfPassengers = noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.goTo();
        regPage.enterUserDetails("selenium", "docker");
        regPage.enterUserCredentials("selenium","docker");
        regPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmation(){
        RegistrationConfirmationPage regConPage = new RegistrationConfirmationPage(driver);
        regConPage.goToFlightsDetailPage();
    }

    @Test(dependsOnMethods = "registrationConfirmation")
    public void flightDetailsPage(){
        FlightsDetailsPage flightDetails = new FlightsDetailsPage(driver);
        flightDetails.selectPassengers(noOfPassengers);
        flightDetails.clickContinueToGoFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlight = new FindFlightPage(driver);
        findFlight.submitFindFlightPage();
        findFlight.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmPage = new FlightConfirmationPage(driver);
       String actualPrice = flightConfirmPage.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }
}
