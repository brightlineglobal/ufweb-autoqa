package testrunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue= {"stepdefinitions","cucumberhooks"},
        plugin= {"pretty","html:test-out/cucumber-reports.html"},
        monochrome=true,
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

}

//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: