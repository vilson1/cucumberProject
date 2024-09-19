package com.appName.step_definitions;


import com.appName.utilities.ConfigurationReader;
import com.appName.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

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
    public void tearDown(){
        //System.out.println("@After Annotation");
    Driver.closeDriver();
}

}

