package com.appName.pages;

import com.appName.utilities.BrowserUtils;
import com.appName.utilities.ConfigurationReader;
import com.appName.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
    public CreateAccountPage(){
        super();
    }

    @FindBy(id = "firstname")
    public WebElement firstNameInputField;
    @FindBy(id = "lastname")
    public WebElement lastNameInputField;
    @FindBy(id = "email_address")
    public WebElement emailAdressInputField;
    @FindBy(css = "input[id='password']")
    public WebElement passwordInputField;
    @FindBy(css = "input[id='password-confirmation']")
    public WebElement passwordConformationInputField;
    @FindBy(css = "button[title='Create an Account']")
    public WebElement createAccountSubmitButton;
    @FindBy(xpath = "//*[@data-ui-id='message-success']/div")
    public WebElement accountSuccessullyCreatedMessage;



    public void checkTitle(){
        String expectedTitle="Create New Customer Account";
        String actualTitle=getTitle();
        Assert.assertEquals("The title of the page is not as expexted!",expectedTitle,actualTitle);
    }

    public void fillCreateAccountForm(){
        String firstName= BrowserUtils.getStringFromFaker("firstName");
        String lastName=BrowserUtils.getStringFromFaker("lastName");
        String emailAddress=BrowserUtils.getStringFromFaker("email");
        String password="1qaz2wsX.";
        String passworConfirmation="1qaz2wsX.";
        ConfigurationReader.writeToPropertiesFile("firstName",firstName);
        ConfigurationReader.writeToPropertiesFile("lastName",lastName);
        ConfigurationReader.writeToPropertiesFile("emailAddress",emailAddress);
        ConfigurationReader.writeToPropertiesFile("password",password);
        sendKeys(firstNameInputField,firstName);
        sendKeys(lastNameInputField,lastName);
        sendKeys(emailAdressInputField,emailAddress);
        sendKeys(passwordInputField,password);
        sendKeys(passwordConformationInputField,passworConfirmation);
    }
    public void clickCriateAccountSubmitButton(){
        clickElement(createAccountSubmitButton);
    }

    public void verifyAccountCreation(){
        String expectedAccountSuccessullyCreatedMessage="Thank you for registering with Main Website Store.";
        Assert.assertTrue(accountSuccessullyCreatedMessage.isDisplayed());
        BrowserUtils.verifyElementDisplayed(accountSuccessullyCreatedMessage);
        String actualAccountSuccessullyCreatedMessage= BrowserUtils.getElementProperties(accountSuccessullyCreatedMessage,"outerText");
        Assert.assertEquals(expectedAccountSuccessullyCreatedMessage,actualAccountSuccessullyCreatedMessage);
        JavascriptExecutor js=  ((JavascriptExecutor) Driver.getDriver());
        //String script="return window.getComputedStyle(document.querySelector('//div[@role='alert']/div/div'),':before').getPropertyValue('content')";
        //js.executeScript(script);
        //System.out.println(js.executeScript(script));

    }
}
