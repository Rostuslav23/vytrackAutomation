package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordInputBox;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LoginButton;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotPasswordLink;






}
