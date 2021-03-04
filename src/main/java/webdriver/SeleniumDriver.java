package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver {


    public WebDriver driver;
    public static ThreadLocal <WebDriver> tlDriver = new ThreadLocal<>();


    public WebDriver init_driver(String browser) {

        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if(browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else {
            System.out.println("browser is not recognized");
        }

        getDriver().manage().window().maximize();
        return getDriver();


    }

    public static synchronized WebDriver getDriver() {


        return tlDriver.get();
    }


        }





