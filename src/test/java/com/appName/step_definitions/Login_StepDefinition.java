package com.appName.step_definitions;

import com.appName.pages.HomePage;
import com.appName.pages.LoginPage;
import com.appName.utilities.BrowserUtils;
import com.appName.utilities.ConfigurationReader;
import com.appName.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    @Then("The user verifies the following elements")
    public void the_user_verifies_the_following_elements(DataTable dataTable) {
       List<String> list= dataTable.asList(String.class);
        for (String eachElement : list) {
            switch (eachElement){
                case "elemeti 1":
                    Assert.assertTrue(eachElement+" is not displayed",true);
                    break;
                case "elemeti 2":
                    Assert.assertTrue(eachElement+" is not displayed",true);
                    break;
                case "elemeti 3":
                    Assert.assertTrue(eachElement+" is not displayed",true);
                    break;

            }
        }

    }

    @When("The user enter the email")
    public void theUserEnterTheEmail() {
        loginPage.usernameInputField.sendKeys(ConfigurationReader.getProperty("email"));
    }

    @And("The user enter the password")
    public void theUserEnterThePassword() {
        loginPage.passwordInputField.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @Then("The user verifies that is logedin")
    public void theUserVerifiesThatIsLogedin() {
        HomePage homePage=new HomePage();
        BrowserUtils.pause(5);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath(String.format(homePage.welcomeMessageXpath,ConfigurationReader.getProperty("name"),ConfigurationReader.getProperty("lastName")))).isDisplayed());
    }

    @Then("verifies the following elements in homepage")
    public void verifiesTheFollowingElementsInHomepage(DataTable table) {
        HomePage homePage=new HomePage();
        List<String> elementsNameList= table.transpose().asList(String.class);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        for (String eachElement : elementsNameList) {
            switch (eachElement){
                case "welcome message":
                    wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath(String.format(homePage.welcomeMessageXpath,ConfigurationReader.getProperty("name"),ConfigurationReader.getProperty("lastName"))))));
                    Assert.assertTrue(eachElement+" is not displayed",Driver.getDriver().findElement(By.xpath(String.format(homePage.welcomeMessageXpath,ConfigurationReader.getProperty("name"),ConfigurationReader.getProperty("lastName")))).isDisplayed());
                    break;
                case "search bar":
                    Assert.assertTrue(eachElement+" is not displayd",homePage.searBar.isDisplayed());
                    break;
            }
        }
    }
}
