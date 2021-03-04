package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {

    private WebDriver driver;
    public ElementUtil elementUtil;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[contains(@name,'username')]")
    WebElement email;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement password;

    @FindBy(xpath = "//button[contains(@id,'submit')]")
    WebElement loginBtn;
    //@FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[1]/app-sidebar/div[2]/ul/li/p[2]")
    //@FindBy(xpath = "//i[@class='material-icons notif'][contains(.,'keyboard_arrow_down')]")
    @FindBy(xpath = "//i[@class='material-icons notif'][contains(.,'account_circle')]")
    WebElement userAccount;

    @FindBy(xpath = "//div[@class='dropdown-menu-item p-3 pointer'][contains(.,'Logout')]")
    WebElement logout;


    //@FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-main-posts/div/mat-card/mat-card-content/div/form/div[1]/div/quill-editor/div/div[1]")
    @FindBy(xpath = "//*[contains(@data-placeholder,'Post something')]")
    WebElement placeHolder;

    @FindBy(xpath = "//h4[@class='card-title ft-14 bold mb-0'][contains(.,'kadir gilman juniors')]")
    WebElement userNameTitle;

    @FindBy(xpath = "//div[@class='ft-14 dashboard-title'][contains(.,'Global Inc')]")
    WebElement userCompanyName;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Home')]")
    public WebElement homeNavBarTitle;

    @FindBy(xpath = "//a[@href='/']")
    public WebElement UpFoundersLogo;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'People')]")
    public WebElement peopleNavBarTitle;

    @FindBy(xpath = "//button[contains(.,'Post')]")
    public WebElement postBtn;

    //unused elements
    @FindBy(xpath = "//div[@class='sidebar-profile ng-star-inserted']/following-sibling::span")
    public List<WebElement> sideBarOptions;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'Home')]")
    public WebElement homeLink;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'My Mentor')]")
    public WebElement mentorLink;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'Story')]")
    public WebElement storyLink;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'People')]")
    public WebElement peopleLink;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'Content')]")
    public WebElement contentLink;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'Links')]")
    public WebElement linksLink;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'Notes')]")
    public WebElement notesLink;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'keyboard_arrow_left')]")
    public WebElement minimizeArrow;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'home')]")
    public WebElement homeLinkMiniBar;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'supervised_user_circle')]")
    public WebElement mentorLinkMiniBar;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'web')]")
    public WebElement storyLinkMinibar;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'people')]")
    public WebElement peopleLinkMiniBar;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'collections_bookmark')]")
    public WebElement contentLinkMiniBar;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'link')]")
    public WebElement linksLinkMiniBar;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'note')]")
    public WebElement notesLinkMinibar;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'keyboard_arrow_right')]")
    public WebElement maximizeSideBarBtn;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'My Mentor')]")
    public WebElement mentorNavBarTitle;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Story')]")
    public WebElement storyNavBarTitle;

    @FindBy(xpath = "//button[@class='joyride-button'][contains(.,'done')]")
    public WebElement closePopupWindowBtn;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Content')]")
    public WebElement contentNavBarTitle;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Links')]")
    public WebElement linksNavBarTitle;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Notes')]")
    public WebElement notesNavBarTitle;

    @FindBy(xpath = "//div[@class='userImg ng-star-inserted']")
    public WebElement userIcon;

    @FindBy(xpath = "//div[@class='mat-tab-label-content'][contains(.,'Change password')]")
    public WebElement changePasswordLink;


    //@FindBy(xpath = "//i[contains(.,'message')]")
    @FindBy(xpath = "//i[@class='material-icons notif'][contains(.,'message')]")    public WebElement messageIcon;

    @FindBy(xpath = "//i[@class='material-icons notif'][contains(.,'notifications')]")    public WebElement notificationIcon;

    //@FindBy(xpath = "/html/body/div/div/div[2]/span[1]")
    @FindBy(xpath = "/html/body/div/div/div[2]/span[2]")
    public WebElement virtualAssistantIcon;

    @FindBy(xpath = "//button[contains(@id,'formSubmit')]")
    public WebElement virtualAsstSubmitBtn;

    //@FindBy(xpath = "//span[contains(@id,'minimizeChatMinifiedBtn')]")
    //public WebElement closeVirtualAssistanceBtn;

    public void setUserName(String userEmail) {
        email.sendKeys(userEmail);
    }

    public void setPassword(String userPassword) {
        password.sendKeys(userPassword);
    }

    public void clickOnLoginBtn() throws Exception {
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(2000);
    }


    public void clickOnUserAccountIcon() throws Exception {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();",userAccount);
        js.executeScript("arguments[0].click()", userIcon);
        Thread.sleep(2000);
        //if(userPagePopupWindow.isDisplayed()){
        //  userPagePopupWindow.click();
        //Thread.sleep(3000);
        //  System.out.println("popup window is closed");
        //} else
        System.out.println("popup window did not show up");

    }

    public void clickOnLogOutLink() throws Exception {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", userAccount);
        js.executeScript("arguments[0].click()", userAccount);
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", logout);
        js.executeScript("arguments[0].click()", logout);

    }

    public String getPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String getActualText() {
        String actualText = placeHolder.getText();
        return actualText;

    }

    public String getUserName() {
        String userName = userNameTitle.getText();
        return userName;
    }

    public String getCompanyName() {
        String companyName = userCompanyName.getText();
        return companyName;
    }

    public String getNavBarTitle(WebElement element) {
        String actualNavBarTitle = element.getText();
        return actualNavBarTitle;
    }

    public void clickOnElement(WebElement element) throws Exception {
        element.click();
        Thread.sleep(3000);
    }

    public boolean isElementVisible(WebElement element) {
        boolean isVisible = element.isDisplayed();
        return isVisible;
    }

    //unused method
    public List<String> getSideBarOptions() {
        List<String> optionsList = new ArrayList<String>();
        for (WebElement e : sideBarOptions) {
            optionsList.add(e.getText());
            System.out.println(e.getText());
            System.out.println(sideBarOptions.toString());
        }
        System.out.println(optionsList);
        return optionsList;

    }

    public List<String> sideBarOptions() {
        List<String> sideBarLinks = new ArrayList<>();
        sideBarLinks.add(homeLink.getText());
        sideBarLinks.add(mentorLink.getText());
        sideBarLinks.add(storyLink.getText());
        sideBarLinks.add(peopleLink.getText());
        sideBarLinks.add(contentLink.getText());
        sideBarLinks.add(linksLink.getText());
        sideBarLinks.add(notesLink.getText());
        return sideBarLinks;
    }

    public boolean waitForElementTobeVisible(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        boolean elementIsVisible = element.isDisplayed();
        return elementIsVisible;
    }

    public List<String> miniSideBarOptions() {
        List<String> miniSideBarLinks = new ArrayList<>();
        miniSideBarLinks.add(homeLinkMiniBar.getText());
        miniSideBarLinks.add(mentorLinkMiniBar.getText());
        miniSideBarLinks.add(storyLinkMinibar.getText());
        miniSideBarLinks.add(peopleLinkMiniBar.getText());
        miniSideBarLinks.add(contentLinkMiniBar.getText());
        miniSideBarLinks.add(linksLinkMiniBar.getText());
        miniSideBarLinks.add(notesLinkMinibar.getText());

        return miniSideBarLinks;
    }

    public List<String> headBarOptions() {
        List<String> headBarOptions = new ArrayList<>();
        headBarOptions.add(messageIcon.getText());
        headBarOptions.add(notificationIcon.getText());
        headBarOptions.add(userAccount.getText());
        return headBarOptions;
    }

    public void switchToIframeVirtualAssistance()throws Exception{
        int iframeInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("total iframe in this page is: "+iframeInPage);
        driver.switchTo().frame(2);
        Thread.sleep(3000);
    }
    public String virtualAssitanceSubmitBtn() {
        String submitBtnText = virtualAsstSubmitBtn.getText();
        return submitBtnText;
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();

    }

    public void switchToInsideVirtualAssistantFrame() throws Exception{
        driver.switchTo().frame(1);
        Thread.sleep(3000);
    }
    public void clickOnMessageIcon() throws Exception {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", messageIcon);
        js.executeScript("arguments[0].click()", messageIcon);
        Thread.sleep(2000);
        System.out.println("message icon is clicked");
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()", messageIcon);        Thread.sleep(3000);

    }

    public void clickOnNotificationIcon() throws Exception{
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", notificationIcon);
        js.executeScript("arguments[0].click()", notificationIcon);
        Thread.sleep(2000);

        System.out.println("notification icon is clicked");
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()", notificationIcon);        Thread.sleep(3000);

    }

    public void clickOnVirtualAssistant() throws Exception{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",virtualAssistantIcon);
        js.executeScript("arguments[0].click()", virtualAssistantIcon);
        Thread.sleep(2000);
    }



}