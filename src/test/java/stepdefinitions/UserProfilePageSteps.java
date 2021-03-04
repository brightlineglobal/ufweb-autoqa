package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.UserProfilePage;
import webdriver.SeleniumDriver;

public class UserProfilePageSteps {



    UserProfilePage userPage = new UserProfilePage(SeleniumDriver.getDriver());



    LoginPage loginPage;



    @Given("User is on login page and get the title of the login page")
    public void user_is_on_login_page_and_get_the_title_of_the_login_page() throws Exception {
        Thread.sleep(1000);
        loginPage = new LoginPage(SeleniumDriver.getDriver());

        String actualLoginPageTitle = userPage.getPageLoginTitle();

        System.out.println("The title of the Login page is:  " + actualLoginPageTitle);
    }


    @When("User inters username {string} and password {string}")
    public void user_inters_username_and_password(String email, String password) throws Exception {
        userPage.setUserName(email);
        userPage.setUserPassword(password);
        Thread.sleep(1000);

    }

    @And("User clicks login button")
    public void user_click_login_button() throws Exception {
        userPage.clickOnLoginBtn();
        Thread.sleep(3000);
    }


    @Then("User get home page title")
    public void user_get_home_page_title() throws Exception {

        String actualHomePageTitle = userPage.getHomePageTitle();
        System.out.println("The title of the home page is: " + actualHomePageTitle);
        System.out.println("  ");


        Thread.sleep(1000);
    }

    @Given("User is on home page and veridy the title of the Home page")
    public void user_is_on_home_page_and_verify_the_title_of_the_home_page() throws Exception {
        String actualHomePageTitle = userPage.getHomePageTitle();
        System.out.println("The title of the home page is: " + actualHomePageTitle);
        Thread.sleep(3000);
    }



    @When("User clicks user profile icon")
    public void user_clicks_user_profile_icon() throws Exception {
        userPage.userProfileIcon();




    }



    @Then("Validate drop down options when apppears")
    public void validate_drop_down_options_when_apppears() throws Exception {

        userPage.userProfileDropdown();


    }


    @Then("User verify {string} {string} {string} {string} and {string} options")
    public void user_verify_and_options(String message1, String message2, String message3, String message4, String message5) throws Exception {

        Assert.assertTrue(userPage.userProfileMessage1(), true);
        System.out.println("The message in the First dropdown is: " + userPage.userProfileMessage1());
        Assert.assertTrue(userPage.userProfileMessage2(), true);
        System.out.println("The message in the Second dropdown is: " + userPage.userProfileMessage2());
        Assert.assertTrue(userPage.userProfileMessage3(), true);
        System.out.println("The message in the Third dropdown is: " + userPage.userProfileMessage3());
        Assert.assertTrue(userPage.userProfileMessage4(), true);
        System.out.println("The message in the Fourth dropdown is: " + userPage.userProfileMessage4());
        Assert.assertTrue(userPage.userProfileMessage5(), true);
        System.out.println("The message in the Fifth dropdown is: " + userPage.userProfileMessage5());



    }



    @Then("User clicks logout")
    public void user_clicks_logout() throws Exception {
        userPage.clickLogOut();
    }



    @Then("Return to login page and verify login button is displayed")
    public void return_to_login_page_and_verify_login_button_is_displayed() throws Exception {
        userPage.verifyLoginBtn();
        Thread.sleep(3000);
    }

    @Given("Click on user icon after landing to the home page")
    public void click_on_user_icon_after_landing_to_the_home_page() throws Exception {
        Thread.sleep(3000);
        userPage.userProfileIcon();
        Thread.sleep(2000);

    }

    @When("Select the Profile from dropdwon")
    public void select_the_profile_from_dropdwon() throws Exception {

        userPage.clickProfileDropdown();
        Thread.sleep(3000);


    }


    @When("Enter texts to the fields")
    public void enter_texts_to_the_fields() throws Exception {

        userPage.inputFieldsUpdate();

    }



    @Then("Click on Save and Update button")
    public void click_on_save_and_update_button() throws Exception {

        userPage.saveAndUpdate();

    }



    @Then("validate the {string} message")
    public void validate_the_message(String updateConfirmation) throws Exception {

        Assert.assertEquals(userPage.validateUpdateSuccessMessage(), updateConfirmation);
        System.out.println("The updated confirmation message is: " + userPage.validateUpdateSuccessMessage());
        Thread.sleep(1000);
    }


    @Given("User is on home page and clicks on user icon")
    public void user_is_on_home_page_and_clicks_on_user_icon() throws Exception {
        Thread.sleep(2000);
        userPage.userProfileIcon();
    }


    @When("Navigate to user profile page")
    public void navigate_to_user_profile_page() throws Exception {
        Thread.sleep(3000);
        userPage.clickProfileDropdown();
        Thread.sleep(3000);

    }


    @Then("Select change password link")
    public void select_change_password_link() throws Exception {
        userPage.changePasswordLink();


    }


    @Then("Enter new password as {string} into the fields")
    public void enter_new_password_as_into_the_fields(String password) throws Exception {
        userPage.enterNewPassword(password);
        userPage.reEnterNewPassword(password);
    }


    @Then("Click on save and validate the {string} message")
    public void click_on_save_and_validate_the_button(String confirmPasswordUpdate) throws Exception {
        userPage.clickOnSaveBtn();
        Thread.sleep(1000);

        System.out.println("This is the updated password confirmation message: " + userPage.validatePasswordUpdatedMessage());

    }






    @Then("Click on user icon and logout")
    public void click_on_user_icon_and_logout() throws Exception {
        Thread.sleep(3000);
        userPage.userProfileIcon();
        Thread.sleep(2000);
        userPage.clickLogOut();

    }


    @When("User relogin with username {string} and new password {string}")
    public void user_relogin_with_username_and_new_password(String email, String newPassword) throws Exception {
        Thread.sleep(3000);
        userPage.setUserName(email);
        Thread.sleep(1000);
        userPage.reloginWithNewPassword(newPassword);
        Thread.sleep(1000);
        userPage.clickOnLoginBtn();


    }


    @Then("Navigate to user profile page And Select change password link")
    public void navigate_to_user_profile_page_and_select_change_password_link() throws Exception {
        Thread.sleep(3000);
        userPage.userProfileIcon();
        Thread.sleep(2000);
        userPage.clickProfileDropdown();
        Thread.sleep(3000);
        userPage.changePasswordLink();
        Thread.sleep(2000);

    }


    @And("User reverse back the old password {string} and click on Save button")
    public void user_reverse_back_the_old_password_and_click_on_save_button(String oldPassword) throws Exception {
        Thread.sleep(3000);
        userPage.reverseBackTheOldPassword(oldPassword);
        Thread.sleep(1000);


    }

    @Given("User is on login page And clicks on user Icon")
    public void user_is_on_login_page_and_clicks_on_user_icon() throws Exception {
        Thread.sleep(1000);
        userPage.userProfileIcon();



    }


    @When("User select Profile and landing to the account information page")
    public void user_select_profile_and_landing_to_the_account_information_page() throws Exception {

        userPage.clickProfileDropdown();

    }


    @Then("Update username, job title And company name")
    public void update_username_job_title_and_company_name() throws Exception {
        userPage.changeAccountInfo();


    }


    @Then("click on save and update button And refresh the page")
    public void click_on_save_and_update_button_and_refresh_the_page() throws Exception {
        userPage.refreshTheProfilePage();
        Thread.sleep(5000);

    }


    @Then("Validate the changed username jop title and company name")
    public void validate_the_changed_username_job_title_and_company_name() {
        System.out.println("The new updated name is: " + userPage.newUserInformation1());
        System.out.println("The new updated job title is: " + userPage.newUserInformation2());
        System.out.println("The new updated company name is: " + userPage.newUserInformation3());

    }


    @Then("Reverse back the original user info")
    public void reverse_back_the_original_user_info() throws Exception {
        userPage.reverseBackTheOriginalAccountInfo();

    }


    @Then("click on same and update button And validate the success message")
    public void click_on_same_and_update_button_and_validate_the_success_message() throws Exception {
        userPage.saveAndUpdate();
        Thread.sleep(2000);
        userPage.validateUpdateSuccessMessage();
    }



}