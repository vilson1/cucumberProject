package com.appName.step_definitions;

import com.appName.pages.HomePage;
import com.appName.pages.WomenPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WomenSection_StepDefinition {
    WomenPage womenPage=new WomenPage();
    @When("The user goes to women tops jacket page")
    public void the_user_goes_to_women_tops_jacket_page() {
        HomePage homePage=new HomePage();
        homePage.clickJacketSectionInWomenTops();
    }

    @And("The user filters the color")
    public void theUserFiltersTheColor() {
        womenPage.selectitemsColor();
    }

    @Then("The user verifies the color filter")
    public void theUserVerifiesTheColorFilter() {
        womenPage.checkItemsSelectedColors();
    }

    @And("The user add an item in cart")
    public void theUserAddAnItemInCart() {
        womenPage.addItemToCart();
    }
}
