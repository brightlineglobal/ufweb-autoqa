package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Dashboard;
import pages.LoginPage;
import utils.ElementUtil;
import webdriver.SeleniumDriver;

public class LoginPageSteps {
    private LoginPage loginPage;
    private Dashboard dashboard;


    @Given("I open the browser")
    public void i_open_the_browser() {
        loginPage = new LoginPage(SeleniumDriver.getDriver());
        dashboard = new Dashboard(SeleniumDriver.getDriver());
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() throws Exception {
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.verifyLoginPageLogo());
    }


    @Then("empty email error message {string} should be displayed")
    public void empty_email_error_message_should_be_displayed(String errorMessage) throws Exception{
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.captureLoginErrorwithemptyEmail(), errorMessage);

    }

    @Then("I enter user name {string}")
    public void i_enter_user_name(String email) {
        loginPage.setUserName(email);
    }

    @Then("click on login button")
    public void click_on_login_button() throws Exception{
        Thread.sleep(1000);
        loginPage.clickOnLoginBtn();
        Thread.sleep(1000);
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String errorMessage) throws Exception{
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.captureWrongEmailFormatError(), errorMessage);
    }

    @Then("login failure message {string} should be displayed")
    public void login_failure_message_should_be_displayed(String loginFailureMessage)throws Exception {
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.captureLoginErrorwithemptypassword(), loginFailureMessage);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.setPassword(password);

    }

    @Then("no account found {string} should be displayed")
    public void no_account_found_should_be_displayed(String noAccountMessage) throws Exception{
        Thread.sleep(1000);
        Assert.assertEquals(loginPage.captureNoAccountMessage(), noAccountMessage);
    }

    @Then("I click on logout link")
    public void i_click_on_logout_link()throws Exception {
        Thread.sleep(4000);
        dashboard.clickOnLogOutLink();
    }
}
