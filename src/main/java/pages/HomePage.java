package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class HomePage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
