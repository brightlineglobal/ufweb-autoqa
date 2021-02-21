package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Dashboard;
import pages.LoginPage;
import webdriver.SeleniumDriver;

import java.util.List;

public class DashboardSteps {
    private LoginPage loginPage;
    private Dashboard dashboard = new Dashboard(SeleniumDriver.getDriver());
    private LoginPageSteps loginSteps = new LoginPageSteps();



    @And("I enter user name {string} and password {string}")
    public void iEnterUserNameAndPassword(String userName, String passWord) throws Exception {
    dashboard.setUserName(userName);
    Thread.sleep(2000);
    dashboard.setPassword(passWord);
    }

    @Then("I click on login")
    public void iClickOnLogin() throws Exception {
        dashboard.clickOnLoginBtn();
        Thread.sleep(5000);
    }


    @Then("verify dashboard page title as {string}")
    public void verify_dashboard_page_title_as(String expectedPageTitle) {
        String actualTitle = dashboard.getPageTitle();
        Assert.assertEquals(expectedPageTitle,actualTitle);
        System.out.println("expected page title is : "+expectedPageTitle);
        System.out.println("actual page title is : "+actualTitle);
    }


    @And("verify post button is visible at creating new post area")
    public void verifyPostButtonIsVisibleAtCreatingNewPostArea() throws Exception  {
        Thread.sleep(3000);
        boolean isVisible = dashboard.waitForElementTobeVisible(dashboard.postBtn, 15);
        Assert.assertTrue(isVisible);
        System.out.println("Post button visilibty is :"+isVisible);
    }


    @When("user verify the user name {string} and company name {string}")
    public void userVerifyTheUserNameAndCompanyName(String userName, String companyName) {
        String actualUserName = dashboard.getUserName();
        String actualCompanyName = dashboard.getCompanyName();
        Assert.assertEquals(userName,actualUserName);
        Assert.assertEquals(companyName,actualCompanyName);
        System.out.println("Expected user name and company name is : "+userName+" "+companyName);
        System.out.println("Actual user name and company name is "+actualUserName+" "+actualCompanyName);

    }

    @Then("verify the head bar title is {string}")
    public void verifyTheHeadBarTitleIs(String homeHeadTitle) {
        String actualHomeHeadTitle = dashboard.getNavBarTitle(dashboard.homeNavBarTitle);
        Assert.assertEquals(homeHeadTitle,actualHomeHeadTitle);
        System.out.println("expected text is : "+homeHeadTitle);
        System.out.println("actual text     is : "+actualHomeHeadTitle);

    }

    @And("click the upfounders logo to redirect to people page and verify {string} head title")
    public void clickTheUpfoundersLogoToRedirectToPeoplePageAndVerifyHeadTitle(String peopleNavBarTitle) throws Exception {
            dashboard.clickOnElement(dashboard.UpFoundersLogo);
            String actualNavBarTitle = dashboard.getNavBarTitle(dashboard.peopleNavBarTitle);
            Assert.assertEquals(peopleNavBarTitle,actualNavBarTitle);
        System.out.println("expected text is : "+peopleNavBarTitle);
        System.out.println("actual text     is : "+actualNavBarTitle);
    }




    @Then("verify the following links as clickable icons on the full size sidebar")
    public void verify_and_click_the_following_links_as_clickable_icons_on_the_full_size_sidebar(DataTable dataTable) {
    List<String> expectedOptions = dataTable.asList();
    List<String> actualOptions = dashboard.sideBarOptions();
        System.out.println(expectedOptions.toString());
        System.out.println(actualOptions.toString());
    Assert.assertEquals(expectedOptions.toString(),actualOptions.toString());
    }

    @And("click each links and verify each page's head title")
    public void clickEachLinksAndVerifyEachPageSHeadTitle() throws Exception {
        dashboard.clickOnElement(dashboard.homeLink);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.homeNavBarTitle,15));
        dashboard.clickOnElement(dashboard.mentorLink);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.mentorNavBarTitle,15));
        dashboard.clickOnElement(dashboard.storyLink);
        dashboard.clickOnElement(dashboard.closePopupWindowBtn);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.storyNavBarTitle,15));
        dashboard.clickOnElement(dashboard.peopleLink);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.peopleNavBarTitle,15));
        Thread.sleep(5000);
        dashboard.clickOnElement(dashboard.contentLink);
        Thread.sleep(5000);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.contentNavBarTitle,15));
        dashboard.clickOnElement(dashboard.linksLink);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.linksNavBarTitle,15));
        dashboard.clickOnElement(dashboard.notesLink);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.notesNavBarTitle,15));
    }

    @When("user click the arrow icon to minimize the sidebar")
    public void user_click_the_arrow_icon_to_minimize_the_sidebar() throws Exception{
        dashboard.clickOnElement(dashboard.minimizeArrow);
        System.out.println("side bar is minimized");
    }


    @Then("verify and click the following links as clickable icons on the minimized sidebar")
    public void verify_and_click_the_following_links_as_clickable_icons_on_the_minimized_sidebar(DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();
        List<String> actualOptions = dashboard.miniSideBarOptions();
        System.out.println(expectedOptions.toString());
        System.out.println(actualOptions.toString());
        Assert.assertEquals(expectedOptions.toString(),actualOptions.toString());
    }


    @Then("click the arrow icon to maximize the side bar")
    public void click_the_arrow_icon_to_maximize_the_side_bar() throws Exception{
        dashboard.clickOnElement(dashboard.maximizeSideBarBtn);
        System.out.println("side bar has been maximized");

    }

    @And("click each links on mini side bar and verify each page's head title")
    public void clickEachLinksOnMiniSideBarAndVerifyEachPageSHeadTitle() throws Exception{
        dashboard.clickOnElement(dashboard.homeLinkMiniBar);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.homeNavBarTitle,15));
        dashboard.clickOnElement(dashboard.mentorLinkMiniBar);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.mentorNavBarTitle,15));
        dashboard.clickOnElement(dashboard.storyLinkMinibar);
        dashboard.clickOnElement(dashboard.closePopupWindowBtn);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.storyNavBarTitle,15));
        dashboard.clickOnElement(dashboard.peopleLinkMiniBar);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.peopleNavBarTitle,15));
        dashboard.clickOnElement(dashboard.contentLinkMiniBar);Thread.sleep(5000);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.contentNavBarTitle,20));
        dashboard.clickOnElement(dashboard.linksLinkMiniBar);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.linksNavBarTitle,15));
        dashboard.clickOnElement(dashboard.notesLinkMinibar);
        Assert.assertTrue(dashboard.waitForElementTobeVisible(dashboard.notesNavBarTitle,15));

    }
    @Then("click on user's avatar to go to user profile page and close popup window if show up")
    public void click_on_user_s_avatar_to_go_to_user_profile_page() throws Exception {
        dashboard.clickOnUserAccountIcon();
    }




    @Then("verify, open and close each of the following clickable function icons on head bar")
    public void open_and_close_each_of_the_following_clickable_function_icons_on_head_bar(DataTable dataTable) throws Exception{
        List<String> expectedHeadBarOptions = dataTable.asList();
        List<String> actualHeadBarOptions = dashboard.headBarOptions();
        System.out.println("expected head bar options are "+expectedHeadBarOptions);
        System.out.println("actual head bar options are "+actualHeadBarOptions);
        Assert.assertEquals(expectedHeadBarOptions,actualHeadBarOptions); dashboard.clickOnElement(dashboard.UpFoundersLogo); Thread.sleep(3000);
        dashboard.clickOnMessageIcon();
        dashboard.clickOnNotificationIcon();


    }




    @And("click to open and close virtual assistant icon and close")
    public void clickToOpenAndCloseVirtualAssistantIconAndVerifyButton() throws Exception{ dashboard.clickOnElement(dashboard.homeLink);Thread.sleep(4000);
       dashboard.switchToIframeVirtualAssistance();Thread.sleep(4000);
        dashboard.clickOnVirtualAssistant(); Thread.sleep(3000);
        System.out.println("virtual assistance is opened for user");
        dashboard.clickOnVirtualAssistant();
        Thread.sleep(3000); dashboard.switchToDefaultContent();
    }

}
