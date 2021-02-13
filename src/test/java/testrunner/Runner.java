package testrunner;


import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/loginpage.feature"},
        glue= {"stepdefinitions","cucumberhooks"},
        plugin= {"pretty","cucumberhooks.customReportListener","html:test-out/cucumber-reports.html"},
        monochrome=true,
        dryRun = false
)
public class Runner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
    }


