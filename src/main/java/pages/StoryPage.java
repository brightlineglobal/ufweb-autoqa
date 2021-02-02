package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class StoryPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;

    public StoryPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
}
