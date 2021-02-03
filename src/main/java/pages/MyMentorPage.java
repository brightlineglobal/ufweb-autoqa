package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class MyMentorPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;

    public MyMentorPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }
}
