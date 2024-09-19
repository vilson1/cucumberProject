package com.appName.step_definitions;

import com.appName.pages.CreateAccountPage;
import com.appName.pages.HomePage;
import com.appName.utilities.BrowserUtils;
import com.appName.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccount_StepDefinition {
    CreateAccountPage createAccountPage=new CreateAccountPage();
    @Given("The user clicks create account button")
    public void the_user_clicks_create_account_button() {
        HomePage homePage=new HomePage();
        homePage.criateAccountButton.click();

    }
    @Given("verify that user is in create account page")
    public void verify_that_user_is_in_create_account_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Create New Customer"));
    }

    @And("The user enter email")
    public void theUserEnterEmail() {
        String email=BrowserUtils.getStringFromFaker("email");
        createAccountPage.emailAdressInputField.sendKeys(email);
        System.out.println(email);

    }

    @And("the user enter password")
    public void theUserEnterPassword() {
        createAccountPage.passwordInputField.sendKeys("1qaz2wsX!");
    }

    @And("The user enter comfirm password")
    public void theUserEnterComfirmPassword() {
        createAccountPage.passwordConformationInputField.sendKeys("1qaz2wsX!");
    }

    @And("The user cliks create account button")
    public void theUserCliksCreateAccountButton() {
        createAccountPage.createAccountSubmitButton.click();
    }

    @Then("The user verifies the success message")
    public void theUserVerifiesTheSuccessMessage() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(createAccountPage.accountSuccessullyCreatedMessage));
        Assert.assertTrue(createAccountPage.accountSuccessullyCreatedMessage.isDisplayed());
    }

    @When("The user enter first name {string}")
    public void theUserEnterFirstName(String firstName) {
        createAccountPage.firstNameInputField.sendKeys(firstName);
    }

    @And("The user enter last name {string}")
    public void theUserEnterLastName(String lastName) {
        createAccountPage.lastNameInputField.sendKeys(lastName);
    }
}
