package com.appName.step_definitions;

import com.appName.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignUp_StepDefinition {
    @Given("The user clicks create Account button")
    public void the_user_clicks_create_account_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The user enter first name")
    public void the_user_enter_first_name() {
        SignUpPage signUpPage=new SignUpPage();
        signUpPage.inputFirstName("vilson");
    }
    @When("The user enter last name")
    public void the_user_enter_last_name() {
        SignUpPage signUpPage=new SignUpPage();
        signUpPage.inputLastName("Shehu");
    }

}
