package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtil;
import webdriver.SeleniumDriver;

public class UserProfilePage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;


    Actions actions = new Actions(SeleniumDriver.getDriver());


    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[contains(@name,'username')]")
    WebElement email;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement password;

    @FindBy(xpath = "//button[contains(@id,'submit')]")
    WebElement loginBtn;

    @FindBy(xpath = "//i[@class='material-icons notif'][contains(.,'keyboard_arrow_down')]")
    WebElement profileIcon;

    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[3]/div/div[1]")
    WebElement userSelect;

    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[3]/div/div[2]")
    WebElement profileSelect;

    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[3]/div/div[3]")
    WebElement settingSelect;

    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[3]/div/div[4]")
    WebElement helpSelect;


    @FindBy(xpath = "//*[@id=\"navigation\"]/ul/li[3]/div/div[5]")
    WebElement logoutSelect;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[2]/div/mat-form-field/div/div[1]/div[3]/input")
    WebElement userNameField;

//    @FindBy(xpath = "(//div[contains(.,'Email')])[15]")
//    WebElement emailField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[4]/div/mat-form-field/div/div[1]/div[3]/input")
    WebElement jobTitleField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[5]/div/mat-form-field/div/div[1]/div[3]/input")
    WebElement companyNameField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[6]/div/mat-form-field/div/div[1]/div[3]/input")
    WebElement WebsiteField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[8]/div/mat-form-field/div/div[1]/div[3]/input")
    WebElement phoneField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[9]/div/mat-form-field/div/div[1]/div[3]/input")
    WebElement locationField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[11]/div/mat-form-field/div/div[1]/div[3]/textarea")
    WebElement aboutMeField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[12]/div/mat-form-field/div/div[1]/div[3]/textarea")
    WebElement aboutMyCompany;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[1]/div/form/div/div/div[13]/div/button")
    WebElement saveAndUpdateBtn;

    @FindBy(xpath = "(//div[contains(.,'profile updated successfully')])[12]")
    WebElement successMessage;

    @FindBy(xpath = "(//div[contains(.,'Change password')])[11]")
    WebElement changePassword;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/div/div/form/mat-form-field[1]/div/div[1]/div[3]/input")
    WebElement enterPasswordField;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[2]/mat-tab-group/div/mat-tab-body[2]/div/div/div/div/form/mat-form-field[2]/div/div[1]/div[3]/input")
    WebElement reEnterPasswordField;

    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(.,'save')]")
    WebElement saveBtn;

    @FindBy(xpath = "(//div[contains(.,'password updated successfully')])[13]")

    WebElement passwordUpdatedMessage;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[1]/div/div[4]/h4")
    WebElement newUserName;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[1]/div/div[4]/h5[1]")
    WebElement newJobTitle;

    @FindBy(xpath = "/html/body/app-root/app-admin-layout/div/div[2]/app-user-profile/div/div/div/div[1]/div/div[4]/h5[2]")
    WebElement newCompanyName;


    public String getPageLoginTitle() {
        return driver.getTitle();
    }


    public void setUserName(String userEmail) {
        email.sendKeys(userEmail);

    }

    public void setUserPassword(String userPassword) {
        password.sendKeys(userPassword);

    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }


    public String getHomePageTitle() {

        return driver.getTitle();
    }

    public void userProfileIcon() throws Exception {
        profileIcon.click();
        Thread.sleep(2000);


    }

    public void userProfileDropdown() throws Exception {


        actions.moveToElement(userSelect).perform();
        Thread.sleep(1000);
        actions.moveToElement(profileSelect).perform();
        Thread.sleep(1000);
        actions.moveToElement(settingSelect).perform();
        Thread.sleep(1000);
        actions.moveToElement(helpSelect).perform();
        Thread.sleep(2000);

    }

    public String userProfileMessage1() {

        return userSelect.getText();

    }

    public String userProfileMessage2() {

        return profileSelect.getText();

    }

    public String userProfileMessage3() {

        return settingSelect.getText();

    }

    public String userProfileMessage4() {

        return helpSelect.getText();

    }

    public String userProfileMessage5() {

        return logoutSelect.getText();

    }


    public void clickLogOut() throws Exception {

        actions.moveToElement(logoutSelect).click(logoutSelect).perform();
        Thread.sleep(1000);

    }

    public void verifyLoginBtn() {
        loginBtn.isDisplayed();
    }

    public void clickProfileDropdown() throws Exception {
        actions.moveToElement(userSelect).perform();
        Thread.sleep(1000);
        actions.moveToElement(profileSelect).click(profileSelect).perform();
        Thread.sleep(2000);
    }

    public void inputFieldsUpdate() throws Exception {
        Thread.sleep(3000);
        userNameField.clear();
        Thread.sleep(1000);
        userNameField.sendKeys("Abdusemet Omer");
//		Thread.sleep(1000);
//		emailField.clear();
//		emailField.sendKeys("begbolo@gmail.com");
        Thread.sleep(1000);
        jobTitleField.clear();
        jobTitleField.sendKeys("QA AUtomation");
        Thread.sleep(2000);
        companyNameField.clear();
        Thread.sleep(2000);
        companyNameField.sendKeys("N/A");
        Thread.sleep(2000);
        WebsiteField.clear();
        Thread.sleep(2000);
        WebsiteField.sendKeys("https://upfounders-staging.herokuapp.com/");
        Thread.sleep(2000);
        phoneField.clear();
        Thread.sleep(2000);
        phoneField.sendKeys("1234567890");
        Thread.sleep(2000);
        locationField.clear();
        Thread.sleep(2000);
        locationField.sendKeys("San Ramon, CA, USA");
        Thread.sleep(2000);
        aboutMeField.clear();
        Thread.sleep(2000);
        aboutMeField.sendKeys("I'm QA Automation");
        Thread.sleep(2000);
        aboutMyCompany.clear();
        Thread.sleep(2000);
        aboutMyCompany.sendKeys("This is a startUp");
        Thread.sleep(2000);


    }

    public void saveAndUpdate() throws Exception {
        saveAndUpdateBtn.click();

        Thread.sleep(1000);
    }


    public String validateUpdateSuccessMessage() throws Exception {
        return successMessage.getText();
    }

    public void changePasswordLink() throws Exception {
        Thread.sleep(3000);
        changePassword.click();
    }

    public void enterNewPassword(String newPassword) throws Exception {
        Thread.sleep(1000);
        enterPasswordField.sendKeys(newPassword);

    }

    public void reEnterNewPassword(String newPassword) throws Exception {
        Thread.sleep(2000);
        reEnterPasswordField.sendKeys(newPassword);

    }

    public void clickOnSaveBtn() throws Exception {
        Thread.sleep(2000);
        saveBtn.click();
        Thread.sleep(2000);

    }


    public String validatePasswordUpdatedMessage() {
        return passwordUpdatedMessage.getText();
    }

    public void reloginWithNewPassword(String loginWithNewPassword) {
        password.sendKeys(loginWithNewPassword);
    }


    public void reverseBackTheOldPassword(String previousPassword) throws Exception {
        Thread.sleep(3000);
        enterPasswordField.clear();
        Thread.sleep(1000);
        enterPasswordField.sendKeys(previousPassword);
        Thread.sleep(2000);


        reEnterPasswordField.clear();
        Thread.sleep(1000);
        reEnterPasswordField.sendKeys(previousPassword);
        Thread.sleep(2000);
        saveBtn.click();
    }

    public void changeAccountInfo() throws Exception {
        userNameField.clear();
        userNameField.sendKeys("Abu Oo");
        Thread.sleep(2000);
        jobTitleField.clear();
        jobTitleField.sendKeys("Superman");
        Thread.sleep(2000);
        companyNameField.clear();
        companyNameField.sendKeys("UpFounders");
        Thread.sleep(2000);

    }

    public void refreshTheProfilePage() throws Exception {
        saveAndUpdateBtn.click();
        Thread.sleep(2000);
        driver.navigate().refresh();
    }


    public String newUserInformation1() {
        return newUserName.getText();

    }

    public String newUserInformation2() {
        return newJobTitle.getText();

    }

    public String newUserInformation3() {
        return newCompanyName.getText();

    }

    public void reverseBackTheOriginalAccountInfo() throws Exception {
        Thread.sleep(3000);
        userNameField.clear();
        userNameField.sendKeys("Abdusemet Omer");
        Thread.sleep(1000);
        jobTitleField.clear();
        jobTitleField.sendKeys("QA AUtomation");
        Thread.sleep(1000);
        companyNameField.clear();
        companyNameField.sendKeys("N/A");
        Thread.sleep(3000);
    }
}