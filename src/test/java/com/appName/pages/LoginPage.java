package com.appName.pages;

import com.appName.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(){
        super();
    }

    @FindBy(css = "input[id='email']")
    public WebElement usernameInputField;
    @FindBy (css = "input[title='Password']")
    public WebElement passwordInputField;
    @FindBy (xpath = "//button[@class='action login primary']")
    public WebElement loginButton;
    @FindBy(xpath = "//ul[@class='header links' and preceding-sibling::a[@class='action skip contentarea']]//a[contains(.,'Sign In')]")
    public static WebElement logInButton;
    @FindBy(xpath = "//a[@class='action skip contentarea']/..//div[@class='customer-menu']//a[contains(.,'Sign Out')]")
    private WebElement signOutButton;


    public void writeUsername(){
        sendKeys(usernameInputField, ConfigurationReader.getProperty("emailAddress"));
    }

    public void writePassword(){
        sendKeys(passwordInputField, ConfigurationReader.getProperty("password"));
    }

    public void clickLogInButton(){
        clickElement(loginButton);
    }

    public void checkIfIsLoggedOut() {
        try {
            logInButton.isDisplayed();
        } catch (Exception e) {
            clickElement(HomePage.accountButton);
            clickElement(signOutButton);
        }
    }
}
