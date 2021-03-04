package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;
import org.openqa.selenium.WebElement;
import webdriver.SeleniumDriver;

public class MessagingTab {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;

    public MessagingTab(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[@class='mb-0 fw-500 ng-star-inserted'][contains(.,'Kadir Akti')]")
    public WebElement popUpMsgNotifier;
    @FindBy(xpath = "//h5[@class='mb-0 fw-500 ng-star-inserted'][contains(.,'kadir gilman junior')]")
    public WebElement popUpMsgNotifierGilman;
    @FindBy(xpath = "(//div[@class='sideNavUserName'][contains(.,'Kadir Akti')])[2]")
    public WebElement msgSender;
    @FindBy(xpath = "(//input[contains(@id,'sendInput')])[1]")
    public WebElement msgInput;
    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-main-chat/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div/div/ul/li[last()]/div/div/div/p")
    public WebElement msgVerified;
    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-main-chat/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div/div/ul/li[last()]/div/div/div/p")
    public WebElement receiveMsg;
    @FindBy(xpath = "//img[@src='./../../../assets/sendIcon.png']")
    public WebElement sendTab;
    @FindBy(xpath = "(//div[@class='sideNavUserName'][contains(.,'kadir gilman juniors')])[2]")
    public WebElement sender2;

    public void clickOnElement(WebElement element) throws Exception {
        element.click();
        Thread.sleep(2000);
    }

    public void sendKeys(WebElement element, String input) throws Exception {
        element.sendKeys(input);
        Thread.sleep(2000);

    }
    public String getPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }
    public String getActualText(WebElement element) throws Exception {
        String actualText = element.getText();
        Thread.sleep(2000);
        return actualText;

    }
    public MessagingTab gotoMesagingPage() throws InterruptedException {
        popUpMsgNotifier.click();
        Thread.sleep(2000);
        return new MessagingTab(SeleniumDriver.getDriver());
    }

    public String getCurrentUrl(){
       return driver.getCurrentUrl();
    }

}