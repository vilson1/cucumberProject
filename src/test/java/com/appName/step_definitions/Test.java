package com.appName.step_definitions;

import com.appName.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Test {
    @When("The user is in google page")
    public void the_user_is_in_google_page() {
        // Write code here that turns the phrase above into concrete actions

        Driver.getDriver().get("https://www.google.com/");
        System.out.println("test start");
    }
    @When("The user search for apple")
    public void the_user_search_for_apple() {
        Driver.getDriver().findElement(By.xpath("//textarea[@name='q']")).sendKeys("apple", Keys.ENTER);
        // Write code here that turns the phrase above into concrete actions

    }
    @Then("the user verifies that apple is in page title")
    public void the_user_verifies_that_apple_is_in_page_title() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("apple"));
        // Write code here that turns the phrase above into concrete actions

        System.out.println("first test finished");
    }

    @And("The user search for phones")
    public void theUserSearchForPhones() {
        Driver.getDriver().findElement(By.xpath("//textarea[@name='q']")).sendKeys("phone", Keys.ENTER);

    }

    @Then("the user verifies that phone is in page title")
    public void theUserVerifiesThatPhoneIsInPageTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("phone"));
        System.out.println("second test finished");
    }

    @When("test background")
    public void testBackground() {
        System.out.println("test Background");
    }

}
