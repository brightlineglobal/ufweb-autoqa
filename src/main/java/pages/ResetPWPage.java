package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class ResetPWPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;

    public ResetPWPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@type,'email')]")
    public WebElement emailInput;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    public WebElement pwInput;

    @FindBy(xpath = "//i[contains(@class,'icon-right-middle login-submit-icon')]")
    public WebElement signInBtn;

    @FindBy(xpath = "//span[@class='name'][contains(.,'Spam')]")
    public WebElement spanMail;

    @FindBy(xpath = "(//div[contains(@class,'subjectParent actionHandle dragHandle')])[1]")
    public WebElement firstEmail;

    @FindBy(xpath="(/html/body/div[1]/div[3]/div[2]/div[3]/div[3]/div/div/div[2]/div/div[6]/div[2]/div[1]/div/div[2]/div[2]/div[1]/div/div/p/b)")
    public WebElement pwByEmail;

    @FindBy(xpath = "//a[contains(@id,'top-system-dropdown-id')]")
    public WebElement accountDropDown;

    @FindBy(xpath = "//span[contains(@data-i18n,'TOP_TOOLBAR/BUTTON_LOGOUT')]")
    public WebElement logoutBtn;


    public void goToUpFoundersMailBox() throws Exception{
        Thread.sleep(5000);
        driver.get("http://mail.upfounders.co/");
        Thread.sleep(4000);

    }

    public void clickOnElement(WebElement element) throws Exception {
        element.click();
        Thread.sleep(2000);
    }

    public void sendKeys(WebElement element, String input) throws Exception {
        element.sendKeys(input);
        Thread.sleep(2000);

    }

    public String getActualText(WebElement element) {
        String actualText = element.getText();
        return actualText;

    }
    public void goToUpFoundersLoginPage() throws Exception{
        Thread.sleep(5000);
        driver.get("https://upfounders-staging.herokuapp.com/login");
        Thread.sleep(4000);

    }
}