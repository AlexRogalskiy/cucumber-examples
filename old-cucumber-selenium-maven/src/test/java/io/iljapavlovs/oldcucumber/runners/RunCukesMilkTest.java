package io.iljapavlovs.oldcucumber.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber/milk", "json:target/cucumber/cucumber-milk.json"},
        features = {"src/test/resources/features"},
        tags = {"@milk"},
        glue = {"io.iljapavlovs.oldcucumber.stepdefs", "io.iljapavlovs.oldcucumber.hooks"}
)
public class RunCukesMilkTest {

}
