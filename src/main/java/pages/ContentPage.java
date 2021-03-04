package pages;

import org.junit.Assert;
import freemarker.core._ArrayEnumeration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtil;

import java.util.ArrayList;
import java.util.List;

public class ContentPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ElementUtil elementUtil;

    public ContentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

/*
    Scenario Outline: User verify My Links and Shared Links then add a new link or links
    Given user click on Links tab and verify
    When click on first link in My Links and verify page title "Global Link"
    Then go to shared link and verify first link's page title "Global Link"
    And user add new link using Add icon with "<link name>" and "<url>" and "<description>" and "<tag>"
    And go to edit link to make the status of the newly created link as "public"
    Then verify the new added link in shared link tab
      Then I click on logout link


      Examples:
    |link name   |url                    |description         |tag       |
    |amazon      |https://www.amazon.com |testing purpose     |UsefulLink|


  Scenario Outline: User verify My Notes and Shared Notes then add a simple note and a note with link
    Given user click on Notes tab and verify
    Then add a new Note using Add icon with title "Test Note" and description "Test Content" and tag "testTag"
    And go to shared Note to verify newly added note
    Then add a new Note with Link using Add icon with "<title>" and "<url>" and "<tag>"
    Then go to shared Note to verify newly added note with its link
    Then I click on logout link

    Examples:
      |title               |url                    |tag           |
      |Test Note with Link |https://www.amazon.com |NoteWithLink  |

    Scenario: user delete all three newly added links and notes
      Given user click on Links tab and select edit icon to edit the newly created link
      Then user delete this newly created link and validate if the link is not deleted
      And user click on Notes tab and select edit note icon to edit the newly created simple note
      Then user delete this newly created simple note and validate if the note is not deleted
      And user click on shared Notes tab and select edit note icon to edit the newly created note with link
      Then user delete this newly created note with link and validate if the note is not deleted
      Then I click on logout link
 */
@FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'Links')]")
public WebElement linksLink;

    @FindBy(xpath = "//p[@class='ng-star-inserted'][contains(.,'Notes')]")
    public WebElement notesLink;

@FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Links')]")
public WebElement linksNavBarTitle;

    @FindBy(xpath = "//a[@class='navbar-brand'][contains(.,'Notes')]")
    public WebElement notesNavBarTitle;

    //@FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[1]/h5/a")
    @FindBy(xpath = "(//a[@href='https://globallink.com/'])[1]")
    public WebElement globalLink;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/mat-tab-header/div[2]/div/div/div[2]")
    public WebElement sharedTab;

    //a[href='https://globallink.com']")
    //@FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[2]/div/app-mycontent-item/div/div/div[2]/div[2]/div/div[1]/div[1]/div/span[2]/a")
    //@FindBy(xpath = "//i[contains(@class,'fa fa-external-link')]")
    @FindBy(xpath = "//a[contains(@href,'https://globallink.com/')]")
    public WebElement sharedGlobalLink;

    @FindBy(xpath = "//div[@class='mat-tab-label-content'][contains(.,'My Links')]")    public WebElement myLinksTab;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/mat-tab-header/div[2]/div/div/div[1]")
    public WebElement myNotesTab;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/mat-tab-header/div[2]/div/div/div[2]")
    public  WebElement sharedNoteTab;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[1]/div/a")
    public WebElement firstNoteTag;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[1]/h5/a")
    public WebElement firstNoteTitle;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[2]/div/app-mycontent-item[1]/div/div/div[1]/div[1]")
    public WebElement likeBtnInSharedNote;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[2]/div/app-mycontent-item[1]/div/div/div[1]/div[2]")
    public WebElement likeCounter;

    @FindBy(xpath = "//i[@class='material-icons'][contains(.,'add')]")    public WebElement addIcon;

    @FindBy(xpath = "//button[@data-toggle='modal'][contains(.,'Link')]")    public WebElement addLinkIcon;

    @FindBy (xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/div/button[3]")
    public WebElement addNoteIcon;

    @FindBy(xpath = "//button[contains(@id,'closeModalBtn')]")    public WebElement closeAddLinkIcon;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[2]/div/div/form/div[1]/div/div[1]/mat-form-field/div/div[1]/div/input")
    public WebElement addLinkNameInput;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[2]/div/div/form/div[1]/div/div[2]/mat-form-field/div/div[1]/div/input")
    public WebElement addLinkUrlInput;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[2]/div/div/form/div[1]/div/div[3]/mat-form-field/div/div[1]/div/textarea")
    public WebElement addLinkDescriptionInput;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[2]/div/div/form/div[1]/div/div[4]/tag-input/div/div/tag-input-form/form/input")
    public WebElement addLinkTagInput;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Save changes')]")    public WebElement addLinkSaveBtn;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/mat-form-field/div/div[1]/div/input")
    public WebElement addNoteTitleInput;

    @FindBy (xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[1]/div[1]/div[1]/input")
    public WebElement noteWithLinkYesOption;
    //following one element only for note with link once yes is chosen
    //1. url
    @FindBy (xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[2]/div/mat-form-field/div/div[1]/div/input")
    public WebElement notewithLinkUrlInput;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[1]/div[1]/div[2]/input")
    public WebElement noteWithLinkNoOption;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[1]/div[2]/div[2]/input")
    public WebElement publicStatusOption;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[1]/div[2]/div[1]/input")
    public WebElement privateStatusOption;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[2]/div/quill-editor/div[2]/div[1]")
    public WebElement addNoteDescriptionInput;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[3]/div/tag-input/div/div/tag-input-form/form/input")
    public WebElement addNoteTagInput;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[4]/div[2]/button[1]")
    public WebElement addNoteSaveBtn;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[4]/div[2]/button[2]")
    public WebElement addNoteBackBtn;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[1]/h5/a")
    public WebElement newAddedLinkTitle;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/div/div/div/div/div[2]/div")
    public WebElement newAddedLinkDescription;

    @FindBy(css="a[href='https://www.amazon.com']")
    public WebElement newAddedLinkUrl;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[2]/div/app-mycontent-item[1]/div/div/div[2]/div[2]/div/div[1]/div[1]/div")
    public WebElement sharedFirstNoteTitleAndTag;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/div/div/div/div/div[1]/div[2]/i")
    public WebElement editLink;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[5]/div[1]/i")
    public WebElement deleteLink;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/i")
    public WebElement editNote;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[4]/div[1]/i")
    public WebElement deleteNote;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[1]/div/a")
    public WebElement noteWithLinkTag;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-content/div[1]/div/mat-tab-group/div/mat-tab-body[1]/div/div/div[1]/div[2]/div/div/div/div/div/div[1]/h5/a")
    public WebElement noteWithLinkTitle;

    @FindBy(xpath="/html/body/app-root/app-admin-layout/div/div[2]/app-login/section/div[2]/div/div[1]/div/form/div[3]/div/tag-input/div/div/tag-input-form/form/input")
    public WebElement noteWithlinkTagInput;

    @FindBy(xpath = "//input[contains(@id,'inlineRadio4')]")
    public WebElement linkPublicRadioBtn;

    @FindBy(xpath = "//input[contains(@id,'inlineRadio3')]")
    public WebElement linkPrivateRadioBtn;

    @FindBy(xpath = "(//i[@class='material-icons pointer'][contains(.,'edit')])[1]")
    public WebElement editFirstLink;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    public WebElement saveBtnInEditFirstLink;

    @FindBy(xpath = "//span[contains(.,'amazon')]")
    public WebElement newSharedLink;

    @FindBy(xpath = "//a[@href='https://www.amazon.com']")
    public WebElement newAddedLink;
    @FindBy(xpath = "(//div[contains(.,'testing purpose')])[10]")    public WebElement newSharedLinkDescription;
    //2. test methods
    public String getContentPageTitle(){
        String contentPageTitle = driver.getTitle();
        System.out.println("page tile of content page is : "+contentPageTitle);
        return contentPageTitle;

    }

    public void clickLinksPage()throws Exception{
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",linksLink);
        Thread.sleep(2000);
        //myLinksTab.click();
        js.executeScript("arguments[0].click()",linksLink);

        //linksPage.click();
        Thread.sleep(3000);
    }

    public void clickMyLinksTab() throws Exception{
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",myLinksTab);
        //myLinksTab.click();
        js.executeScript("arguments[0].click()",myLinksTab);
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
    }

    public String clickOnFirstMyLink() throws Exception{
        String parentPageHandle= driver.getWindowHandle();
        System.out.println("title before clicking shared link: "+driver.getTitle());
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",globalLink);
        Thread.sleep(3000);
        for(String winHandle: driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        String newLinkPageTitle = driver.getTitle();
        System.out.println("opened link title is: "+newLinkPageTitle);
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(parentPageHandle);
        Thread.sleep(3000);
        return newLinkPageTitle;
    }

    public void clickSharedTab()throws Exception{
        js=(JavascriptExecutor)driver;
        //js.executeScript("arguments[0].rollIntoView",sharedTab);
        js.executeScript("arguments[0].click()",sharedTab);
        Thread.sleep(3000);
    }

    public String clickSharedLinkAndReturn(WebElement element)throws Exception{
        String parentPageHandle= driver.getWindowHandle();
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",element);//sharedGlobalLink
        Thread.sleep(3000);
        for(String winHandle: driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        String sharedLinkTitle = driver.getTitle();
        System.out.println("opened link title is: "+sharedLinkTitle);
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(parentPageHandle);
        Thread.sleep(3000);
        //js=(JavascriptExecutor)driver;
       // js.executeScript("arguments[0].click()",sharedGlobalLink);
        //Thread.sleep(2000);
        return sharedLinkTitle;
    }

    public void clickNotesLink()throws Exception{
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",notesLink);
        Thread.sleep(2000);
    }

    public void clickMyNotesTab() throws Exception{
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",myNotesTab);
        Thread.sleep(3000);
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }
    public String firstNoteVerification()throws Exception{
        String tagAndContent =firstNoteTag.getText()+" and "+firstNoteTitle.getText();
        return tagAndContent;
    }

    public void clickSharedNotesTab() throws Exception{
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",sharedNoteTab);
        Thread.sleep(3000);
    }

    public boolean verifyLikeCounter() throws Exception{
        likeBtnInSharedNote.click();
        Thread.sleep(2000);
        String firstLikeClick = likeCounter.getText();;
        Thread.sleep(2000);
        likeBtnInSharedNote.click();
        String secondLikeClick = likeCounter.getText();
        Thread.sleep(2000);
        Assert.assertEquals(secondLikeClick,firstLikeClick);
        return true;
    }

    public void clickAddIcon() throws Exception {
        Thread.sleep(3000);
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",addIcon);
    }

    public void clickAddLinkIcon() throws Exception {
        Thread.sleep(3000);
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",addLinkIcon);
        Thread.sleep(3000);
    }
    public void closeAddLinkAndOpenAgain()  throws Exception{
        Thread.sleep(3000);
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",closeAddLinkIcon);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",addLinkIcon);
        Thread.sleep(2000);

    }

    public void addALink(String linkName, String url, String description, String tag) throws Exception{
        addLinkNameInput.sendKeys(linkName);
        Thread.sleep(1000);
        addLinkUrlInput.sendKeys(url);
        Thread.sleep(1000);
        addLinkDescriptionInput.sendKeys(description);
        Thread.sleep(1000);
        addLinkTagInput.sendKeys(tag);
        Thread.sleep(2000);
        addLinkSaveBtn.click();
        Thread.sleep(2000);
        addLinkSaveBtn.click();
        Thread.sleep(3000);

    }

    public String verifyAddedLinkTitleAndTag() throws Exception{
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",linksLink);
        js.executeScript("arguments[0].click()",sharedTab);

        String parentPageHandle= driver.getWindowHandle();
        System.out.println("title before clicking shared link: "+driver.getTitle());
        js.executeScript("arguments[0].click()",newAddedLinkUrl);
        Thread.sleep(3000);
        for(String winHandle: driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        String newLinkPageTitle = driver.getTitle();
        System.out.println("opened link title is: "+newLinkPageTitle);
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(parentPageHandle);
        Thread.sleep(3000);
        String linkName = newAddedLinkTitle.getText();
        String description = newAddedLinkDescription.getText();
        Thread.sleep(2000);
        String linkNameAndDescription = linkName + " and "+description;
        System.out.println("actual title and description for new added link is: "+linkNameAndDescription);
        return linkNameAndDescription;
    }


    public void clickAddNoteIcon() throws Exception {
        addNoteIcon.click();
        Thread.sleep(3000);
    }

    public void backToNotesPage() throws Exception {
        js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",addNoteBackBtn);
        //addNoteBackBtn.click();
        Thread.sleep(2000);
    }

    public void addNote(String title, String description, String tag) throws Exception{
        js=(JavascriptExecutor)driver;
        addNoteTitleInput.sendKeys(title);
        publicStatusOption.click();
        Thread.sleep(2000);
        addNoteDescriptionInput.sendKeys(description);
        js.executeScript("arguments[0].scrollIntoView();",addNoteTagInput);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",addNoteTagInput);
        addNoteTagInput.sendKeys(tag);
        Thread.sleep(2000);
        addNoteSaveBtn.click();
        Thread.sleep(2000);
        addNoteSaveBtn.click();
        Thread.sleep(3000);
    }

    public String verifyAddedNoteTitleAndTag() throws Exception{
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",notesLink);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",sharedNoteTab);
        Thread.sleep(2000);
        String titleAndTag = sharedFirstNoteTitleAndTag.getText();
        Thread.sleep(2000);
        System.out.println("actual title and tag for new added note is: "+titleAndTag);
        return titleAndTag;
    }

    public void addNoteWithLink(String title, String url, String tag) throws Exception{
        js=(JavascriptExecutor)driver;
        addNoteTitleInput.sendKeys(title);
        noteWithLinkYesOption.click();
        Thread.sleep(1000);
        publicStatusOption.click();
        Thread.sleep(1000);
        privateStatusOption.click();
        notewithLinkUrlInput.sendKeys(url);
        js.executeScript("arguments[0].scrollIntoView();",noteWithlinkTagInput);
        //js.executeScript("arguments[0].click()",noteWithlinkTagInput);
        noteWithlinkTagInput.sendKeys(tag);
        addNoteSaveBtn.click();
        Thread.sleep(2000);
        addNoteSaveBtn.click();
        Thread.sleep(3000);
    }

    public String verifyNewAddedNoteWithLink() throws Exception{
        js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",notesLink);
        Thread.sleep(3000);
        js.executeScript("arguments[0].click()",firstNoteTitle);
        Thread.sleep(3000);
        System.out.println("page title for this shared link is: "+driver.getTitle());
        driver.navigate().back();
        Thread.sleep(5000);
        js.executeScript("arguments[0].click()",notesLink);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click()",myNotesTab);
        Thread.sleep(2000);
        String firstNoteTagAndTitle = firstNoteTag.getText() +" and "+firstNoteTitle.getText();
        System.out.println("tag and content of this link is: "+firstNoteTagAndTitle);
        return firstNoteTagAndTitle;
    }
    public void deleteSharedLink()throws Exception{
        js=(JavascriptExecutor)driver;
        editLink.click();
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();",deleteLink);
        js.executeScript("arguments[0].click();",deleteLink);
        //deleteLink.click();
        Thread.sleep(3000);
    }
    public void deleteSharedNote()throws Exception{
        js=(JavascriptExecutor)driver;
        editNote.click();
        js.executeScript("arguments[0].scrollIntoView();",deleteNote);
        js.executeScript("arguments[0].click();",deleteNote);
        Thread.sleep(3000);
        deleteNote.click();
        Thread.sleep(3000);

    }


    public String getPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public String getActualText(WebElement element) {
        String actualText = element.getText();
        return actualText;

    }


    public void clickOnElement(WebElement element) throws Exception {
        element.click();
        Thread.sleep(3000);
    }

    public boolean isElementVisible(WebElement element) {
        boolean isVisible = element.isDisplayed();
        return isVisible;
    }


    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }


    public boolean waitForElementTobeVisible(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
        boolean elementIsVisible = element.isDisplayed();
        return elementIsVisible;
}
    }