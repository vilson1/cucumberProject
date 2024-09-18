package com.appName.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"html:target/reports.html"},
        features = "src/test/resources/features",
        glue = "com/appName/step_definitions",
        dryRun = true,
        tags = "@sign_up"
)

public class Runner {
}
