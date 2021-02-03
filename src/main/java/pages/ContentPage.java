package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class ContentPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;

    public ContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
