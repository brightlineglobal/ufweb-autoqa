package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.ContentPage;
import pages.Dashboard;
import pages.LoginPage;
import webdriver.SeleniumDriver;

public class ContentPageSteps {

    private LoginPage loginPage = new LoginPage(SeleniumDriver.getDriver());
    private Dashboard dashboard = new Dashboard(SeleniumDriver.getDriver());
    private LoginPageSteps loginSteps = new LoginPageSteps();
    private DashboardSteps dashSteps = new DashboardSteps();
    private ContentPage contentPage = new ContentPage(SeleniumDriver.getDriver());

    @Then("user click on content page and verify head bar name {string}")
    public void click_on_content_page_and_verify_head_bar_name(String contentHeadBar) throws Exception{
        dashboard.clickOnElement(dashboard.contentLink);
        String actualHeadTitle = dashboard.contentNavBarTitle.getText();
        Assert.assertEquals(contentHeadBar,actualHeadTitle);
        System.out.println("expected head bar title is: "+contentHeadBar);
        System.out.println("actual head bar title is :"+actualHeadTitle);

    }


    @Given("user click on Links link and verify head bar name {string}")
    public void userClickOnLinksLinkAndVerifyHeadBarName(String expectedTitle)  throws Exception{
        dashboard.clickOnElement(dashboard.linksLink);
        Assert.assertEquals(expectedTitle, contentPage.getActualText(contentPage.linksNavBarTitle));
    }



    @When("click on first link in My Links and verify page title {string}")
    public void click_on_first_link_in_my_links_and_verify_page_title(String linkTitle) throws Exception{
        String verifiedLinkTitle = contentPage.clickOnFirstMyLink();
        Thread.sleep(2000);
        System.out.println("expected link title is :"+linkTitle);
        System.out.println("actual link title is :"+verifiedLinkTitle);
        Assert.assertEquals(linkTitle, verifiedLinkTitle);
    }


    @Then("go to shared link click and verify first link's page title {string}")
    public void go_to_shared_link_and_verify_first_link_s_page_title(String linksTitle) throws Exception{
        contentPage.clickSharedTab();
        String sharedLinkTitle = contentPage.clickSharedLinkAndReturn(contentPage.sharedGlobalLink);
        Assert.assertEquals(linksTitle, sharedLinkTitle);
        System.out.println("expected link title is :"+ linksTitle);
        System.out.println("actual link title is "+sharedLinkTitle);
    }


    @Then("user add new link using Add icon with {string} and {string} and {string} and {string}")
    public void user_add_new_link_using_add_icon_with_and_and_and(String linkName, String url, String description, String tag) throws Exception{
        contentPage.clickAddIcon();
        System.out.println("add icon clicked");
        contentPage.clickAddLinkIcon();
        System.out.println("add link icon clicked");
        contentPage.closeAddLinkAndOpenAgain();
        contentPage.addALink(linkName, url, description, tag);

    }


    @Then("go to edit link to make the status of the newly created link as {string}")
    public void go_to_edit_link_to_make_the_status_of_the_newly_created_link_as(String publicStatus) throws Exception {
        contentPage.clickOnElement(contentPage.myLinksTab);
        Thread.sleep(3000);
        contentPage.refreshPage();
        Thread.sleep(6000);
        contentPage.clickOnElement(contentPage.editFirstLink);
        contentPage.clickOnElement(contentPage.linkPublicRadioBtn);
        contentPage.clickOnElement(contentPage.saveBtnInEditFirstLink);
        System.out.println("status of this link is :"+publicStatus);
       // contentPage.clickOnElement(contentPage.sharedTab);

    }


    @Then("verify the new added link {string} and {string} in shared link tab")
    public void verifyTheNewAddedLinkAndInSharedLinkTab(String linkName, String description) throws Exception{
        contentPage.clickOnElement(contentPage.sharedTab);
        Thread.sleep(3000);
        String actualLinkName = contentPage.getActualText(contentPage.newSharedLink);
        String actualDescription = contentPage.getActualText(contentPage.newSharedLinkDescription);
        String actualLinkNameAndDescription = actualLinkName+" and " + actualDescription;
        String expectedLinkNameAndDescription = linkName + " and " + description;
        System.out.println("expected link name and description is: " + expectedLinkNameAndDescription);
        Assert.assertEquals(expectedLinkNameAndDescription, actualLinkNameAndDescription);
        System.out.println("actual link name and description is: "+actualLinkNameAndDescription);
    }


    @And("click the link and verify {string}")
    public void clickTheLinkAndVerify(String pageTitle) throws Exception {
        String sharedLinkTitle = contentPage.clickSharedLinkAndReturn(contentPage.newAddedLink);
        Assert.assertEquals(pageTitle, sharedLinkTitle);
        System.out.println("expected link title is :"+ pageTitle);

    }


    @Given("user click on Notes link and verify")
    public void user_click_on_notes_tab_and_verify() {

    }


    @Then("add a new Note using Add icon with title {string} and description {string} and tag {string}")
    public void add_a_new_note_using_add_icon_with_title_and_description_and_tag(String string, String string2, String string3) {

    }


    @Then("go to shared Note to verify newly added note")
    public void go_to_shared_note_to_verify_newly_added_note() {

    }


    @Then("add a new Note with Link using Add icon with {string} and {string} and {string}")
    public void add_a_new_note_with_link_using_add_icon_with_and_and(String string, String string2, String string3) {

    }


    @Then("go to shared Note to verify newly added note with its link")
    public void go_to_shared_note_to_verify_newly_added_note_with_its_link() {

    }


    @Given("user click on Links link and select edit icon to edit the newly created link")
    public void user_click_on_links_tab_and_select_edit_icon_to_edit_the_newly_created_link() {

    }


    @Then("user delete this newly created link and validate if the link is not deleted")
    public void user_delete_this_newly_created_link_and_validate_if_the_link_is_not_deleted() {

    }

    @Then("user click on Notes link and select edit note icon to edit the newly created simple note")
    public void user_click_on_notes_tab_and_select_edit_note_icon_to_edit_the_newly_created_simple_note() {

    }


    @Then("user delete this newly created simple note and validate if the note is not deleted")
    public void user_delete_this_newly_created_simple_note_and_validate_if_the_note_is_not_deleted() {

    }

    @Then("user click on shared Notes tab and select edit note icon to edit the newly created note with link")
    public void user_click_on_shared_notes_tab_and_select_edit_note_icon_to_edit_the_newly_created_note_with_link() {

    }



    @Then("user delete this newly created note with link and validate if the note is not deleted")
    public void user_delete_this_newly_created_note_with_link_and_validate_if_the_note_is_not_deleted() {

    }


    @Given("user click on Notes link and verify head bar name {string} and tab name {string}")
    public void userClickOnNotesLinkAndVerifyHeadBarNameAndTabName(String arg0, String arg1) {

    }


    @And("make the note {string} and verify the note in {string} tab")
    public void makeTheNoteAndVerifyTheNoteInTab(String arg0, String arg1) {
        
    }

    @Then("go to edit note and make the note {string} and verify the note in {string} tab")
    public void goToEditNoteAndMakeTheNoteAndVerifyTheNoteInTab(String arg0, String arg1) {
        
    }

    @And("go to shared Note to verify newly added note's {string} {string} and {string}")
    public void goToSharedNoteToVerifyNewlyAddedNoteSAnd(String arg0, String arg1, String arg2) {
    }

    @Then("click the link at this Note with link and verify {string}")
    public void clickTheLinkAtThisNoteWithLinkAndVerify(String pageTitle) {
        
    }

    @Then("go to edit note and make the note {string} and verify the note in {string} Notes tab")
    public void goToEditNoteAndMakeTheNoteAndVerifyTheNoteInNotesTab(String arg0, String arg1) {
        
    }

    @Given("user is on the home page and verify {string} head bar title")
    public void userIsOnTheHomePageAndVerifyHeadBarTitle(String arg0) {
    }

    @And("user verify shared {string} and shared {string} and click the link and verify {string}")
    public void userVerifySharedAndSharedAndClickTheLinkAndVerify(String arg0, String arg1, String arg2) {
    }

    @Then("user verify shared {string} and shared {string}")
    public void userVerifySharedAndShared(String arg0, String arg1) {
        
    }

    @And("user verify shared {string} and click the link then verify {string}")
    public void userVerifySharedAndClickTheLinkThenVerify(String arg0, String arg1) {
    }

    @And("verify all added shared links and notes in home page")
    public void verifyAllAddedSharedLinksAndNotesInHomePage() {
    }

    @Then("user click on Links link and select edit icon to delete the newly created link and validate if the link is deleted")
    public void userClickOnLinksLinkAndSelectEditIconToDeleteTheNewlyCreatedLinkAndValidateIfTheLinkIsDeleted() {
    }

    @And("user click on Notes link and select edit note icon to delete the newly created simple note and validate if the note is deleted")
    public void userClickOnNotesLinkAndSelectEditNoteIconToDeleteTheNewlyCreatedSimpleNoteAndValidateIfTheNoteIsDeleted() {
    }

    @Then("user click Shared links tab and delete the newly created link and validate if the link is deleted")
    public void userClickSharedLinksTabAndDeleteTheNewlyCreatedLinkAndValidateIfTheLinkIsDeleted() {
    }

    @And("user click Shared Notes tab and delete the newly created simple note and validate if the note is deleted")
    public void userClickSharedNotesTabAndDeleteTheNewlyCreatedSimpleNoteAndValidateIfTheNoteIsDeleted() {
    }

    @And("user click Shared Notes tab and select edit note icon to edit the newly created note with link")
    public void userClickSharedNotesTabAndSelectEditNoteIconToEditTheNewlyCreatedNoteWithLink() {
    }
}
