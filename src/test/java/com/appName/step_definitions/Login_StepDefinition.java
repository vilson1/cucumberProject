package com.appName.step_definitions;

import com.appName.pages.HomePage;
import com.appName.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class Login_StepDefinition {

    LoginPage loginPage=new LoginPage();

    @When("The user cliks login button")
    public void the_user_cliks_login_button() {
        HomePage homePage=new HomePage();
        homePage.logInButton.click();
    }

    @When("The user enter {string} in login button")
    public void theUserEnterInLoginButton(String email) {
        loginPage.usernameInputField.sendKeys(email);
    }

    @And("The user enter password {string}")
    public void theUserEnterPassword(String password) {
        loginPage.passwordInputField.sendKeys(password);
    }

    @And("The user clik signin button")
    public void theUserClikSigninButton() {
        loginPage.loginButton.click();
    }
}
