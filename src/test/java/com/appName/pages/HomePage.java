package com.appName.pages;

import com.appName.utilities.BrowserUtils;
import com.appName.utilities.ConfigurationReader;
import com.appName.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage  {
    public HomePage() {
        super();
    }
    public String welcomeMessageXpath="(//span[.='Welcome, %s %s!'])[1]";


    @FindBy(xpath = "//header//a[.='Create an Account']")
    public WebElement criateAccountButton;
    @FindBy(xpath = "//a[@class='action skip contentarea']/..//button[@data-action='customer-menu-toggle']")
    public static WebElement accountButton;
    @FindBy(xpath = "//a[@class='action skip contentarea']/..//div[@class='customer-menu']//a[contains(.,'Sign Out')]")
    private WebElement signOutButton;
    @FindBy(xpath = "//ul[@class='header links' and preceding-sibling::a[@class='action skip contentarea']]//a[contains(.,'Sign In')]")
    public static WebElement logInButton;
    @FindBy(xpath = "//ul[@class='header links' and preceding-sibling::a]//span[@class='logged-in']")
    private WebElement username;
    @FindBy(xpath = "//span[.='Women']/../../a")
    public static WebElement womenSectionButton;
    @FindBy(xpath = "//a[@class='action skip contentarea']/..//span[@class='counter qty']")
    public static WebElement wish_list_Button;
    @FindBy(id = "search")
    public WebElement searBar;

    @FindBy(xpath = "//span[.='Women']/..")
    public WebElement womenDropdown;
    @FindBy(xpath = "//span[.='Tops']/..")
    public WebElement womenTopsDropdown;
    @FindBy(xpath = "//span[.='Jackets']/..")
    public WebElement womenTopsJacketSection;
   // public WebElement welcomeMessage=Driver.getDriver().findElement(By.xpath(String.format(welcomeMessageXpath,ConfigurationReader.getProperty("name"),ConfigurationReader.getProperty("lastName"))));

    public void clickJacketSectionInWomenTops(){
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(womenDropdown)
                .moveToElement(womenTopsDropdown)
                .click(womenTopsJacketSection)
                .build()
                .perform();
    }

    public void clickCreateAccountButton(){
        clickElement(criateAccountButton);
    }

    public void clicksUserAccountButton(){
        clickElement(accountButton);
    }

    public void clickSignOutButton(){
        clickElement(signOutButton);
    }

    public void checkPresenceOfSignInButton(){
        BrowserUtils.verifyElementDisplayed(logInButton);
    }

    public void clickLoginButon(){
        clickElement(logInButton);
    }
    public void login(){
        LoginPage loginPage=new LoginPage();
        try {
            clickElement(logInButton);
            loginPage.writeUsername();
            loginPage.writePassword();
            loginPage.clickLogInButton();
        }catch (Exception e){
            if (!username.isDisplayed()){
                Assert.fail("There is a problem with login");
            }
        }
    }

    public void checkUserNameAndPosition(){
        String expectedUsername= ConfigurationReader.getProperty("firstName")+" "+ConfigurationReader.getProperty("lastName");
        String actualUserName=username.getText().split(",")[1].replace("!","").trim();
        Assert.assertEquals(expectedUsername,actualUserName);
        Assert.assertTrue(BrowserUtils.isElementInUpperRightQuadrant(username));
    }

    public void clickWomenDropdown(){
        clickElement(womenSectionButton);
    }

    public void checkTheNumberOfItemsInWishListFromProfile(){
        int productNumberInWishList=Integer.parseInt(BrowserUtils.getElementProperties(wish_list_Button,"textContent").split(" ")[0]);
        Assert.assertEquals(WomenPage.PRODUCT_NUMBER_ADDED_IN_WISH_LIST,productNumberInWishList);
    }

}
