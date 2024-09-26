package com.appName.step_definitions;


import com.appName.utilities.ConfigurationReader;
import com.appName.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
@Before
    public void setup() {
    //System.out.println("@Before annotation");
    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
}

/*@BeforeStep
public void beforeStep(){
    System.out.println("@BeforeStep");
}
@AfterStep
public void afterStep(){
    System.out.println("@AfterStep");
}*/

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
        Driver.closeDriver();
}

}

