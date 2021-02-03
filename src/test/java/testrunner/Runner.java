package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/loginpage.feature"},
        glue= {"stepdefinitions","cucumberhooks"},
        plugin= {"pretty","html:test-out/cucumber-reports.html"},
        monochrome=true,
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

}
