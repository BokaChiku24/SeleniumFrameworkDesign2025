package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/cucumber/ErrorValidation.feature"
        , tags = "@ErrorValidation"
        , glue = "cucumber.stepdefination", monochrome = true
        , plugin = {"html:target/cucmber.html"}, publish = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
