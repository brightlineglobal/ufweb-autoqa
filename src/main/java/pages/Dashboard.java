package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class Dashboard {

    private WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //@FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[1]/app-sidebar/div[2]/ul/li/p[2]")
    @FindBy(xpath = "//p[@class='pointer nav-item'][contains(.,'Log out')]")
    WebElement logout;

    public void clickOnLogOutLink() throws Exception {
            Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();",logout);
            Thread.sleep(2000);
            js.executeScript("arguments[0].click()",logout);

            // wait = new WebDriverWait(driver,15);
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='pointer nav-item'][contains(.,'Log out')]")));
            // logout.click();
        }
    }

