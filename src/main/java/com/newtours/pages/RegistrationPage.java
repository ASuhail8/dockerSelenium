package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(id="email")
    private WebElement userName;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(id="register-btn")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String password){
        this.userName.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
    }

    public void submit(){
        submitBtn.click();
    }

}
