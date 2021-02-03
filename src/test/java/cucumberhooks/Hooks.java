package cucumberhooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import webdriver.SeleniumDriver;

import java.util.Properties;

public class Hooks {
    private SeleniumDriver slDriver;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order=0)
    public void getProperty() {
        configReader= new ConfigReader();
        prop = configReader.init_prop();
    }
    @Before(order=1)
    public void launchBrowser() {
        String browserType = prop.getProperty("browser");
        slDriver = new SeleniumDriver();
        driver=slDriver.init_driver(browserType);
        driver.get(prop.getProperty("url"));

    }

    @After(order=0)
    public void quiteBrowser() {
        driver.quit();
    }

    @After(order=1)
    public void tearDown(Scenario sc) {
        if(sc.isFailed()) {
            String screenshotName=sc.getName().replaceAll(" ","_");
            byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            sc.attach(sourcePath, "image/png", screenshotName);
        }
    }
}

