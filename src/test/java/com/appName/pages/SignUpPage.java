package com.appName.pages;

import com.appName.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public SignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameInputBox;

    @FindBy(id ="lastname")
    private WebElement lastNameInputBox;

    public void inputFirstName(String firstName){
        firstNameInputBox.sendKeys(firstName);
    }

    public void inputLastName(String lastNAme){
        lastNameInputBox.sendKeys(lastNAme);
    }
}
