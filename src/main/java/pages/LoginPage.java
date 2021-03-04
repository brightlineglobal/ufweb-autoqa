package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;

public class LoginPage {
    public WebDriver driver;
    private JavascriptExecutor js;
    public ElementUtil elementUtil;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='navbar-main']/div/div[1]/a")
    public WebElement upFoundersLogo;

    @FindBy(xpath = "//input[contains(@name,'username')]")
    public WebElement email;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement password;

    @FindBy(xpath = "//button[contains(@id,'submit')]")
    WebElement loginBtn;

    @FindBy(xpath = "//form/div[1]/p")
    WebElement emptyEmailErrorMessage;

    @FindBy(xpath = "/html/body/app-root/app-login/main/section/div[2]/div/div/div[1]/div[2]/form/div[1]/p")    // problem
    WebElement wrongEmailFormatErrorMessage;

    @FindBy(xpath = "//form/div[2]/p")
    WebElement wrongPasswordErrorMessage;

    @FindBy(xpath = "//form/div[2]/p")
    WebElement emptypassword;

    @FindBy(xpath = "//form/div[2]/p")
    WebElement notFound;

    @FindBy(xpath = "//a[@href='/resetpw']")
    public WebElement resetPasswordLink;

    @FindBy(xpath = "//small[contains(.,'Reset Password')]")
    public WebElement resetPasswordTitle;

    @FindBy(xpath = "//input[contains(@formcontrolname,'email')]")
    public WebElement emailInput;

    @FindBy(xpath = "/html/body/app-root/app-resetpw/main/section/div[2]/div/div/div[1]/div/form/div[1]/p")
    public WebElement emailRequireWarning;

    @FindBy(xpath = "//small[contains(.,'Invalid email')]")
    public WebElement invalidEmailWarning;


    @FindBy(xpath = "//button[contains(@id,'submit')]")
    public WebElement submitBtn;

    @FindBy(xpath = "//a[@class='whitelink'][contains(.,'Back to Login?')]")
    public WebElement backToLoginLink;

    @FindBy(xpath = "//small[contains(.,'A Temporary password will be sent this email if a matching user record is found')]")
    public WebElement confirmationMsg;


    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public String captureLoginErrorwithemptyEmail() throws Exception {
        Thread.sleep(3000);
        return emptyEmailErrorMessage.getText();
    }

    public void setUserName(String userEmail) {
        email.sendKeys(userEmail);
    }

    public String captureWrongEmailFormatError() throws Exception {
        Thread.sleep(5000);
        return wrongEmailFormatErrorMessage.getText();
    }

    public String captureLoginErrorwithemptypassword() throws Exception{
        Thread.sleep(5000);
        return emptypassword.getText();
    }

    public void setPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    public String captureNoAccountMessage() throws Exception{
        Thread.sleep(3000);
        return notFound.getText();
    }

    public boolean verifyLoginPageLogo() {
        return upFoundersLogo.isDisplayed();
    }


    public String getElementText(WebElement element){
        return element.getText();
    }

    public void clickOnElement(WebElement element) throws Exception{
        element.click();
        Thread.sleep(2000);
    }

    public void sendKeys(WebElement element, String input) throws Exception {
        element.sendKeys(input);
        Thread.sleep(2000);
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public boolean verifyElementIsDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void clearElement(WebElement element){
        element.clear();
    }
}