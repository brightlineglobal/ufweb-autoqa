package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.Dashboard;
import pages.LoginPage;
import pages.ResetPWPage;
import webdriver.SeleniumDriver;

public class ResetPWPageSteps {
    private LoginPage loginPage = new LoginPage(SeleniumDriver.getDriver()) ;
    private Dashboard dashboard = new Dashboard(SeleniumDriver.getDriver());
    private ResetPWPage resetPWPage = new ResetPWPage(SeleniumDriver.getDriver());

    @And("user click on UpFounders logo to refresh the login page and verify")
    public void userClickOnUpFoundersLogoToRefreshTheLoginPageAndVerify() throws Exception{

        Assert.assertTrue(loginPage.verifyLoginPageLogo());
        loginPage.clickOnElement(loginPage.upFoundersLogo);
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.verifyLoginPageLogo());
        System.out.println("refreshing page is successful");


    }

    @And("user click on {string} to be directed to reset password page and verify {string}")
    public void userClickOnToBeDirectedToResetPasswordPage(String resetPWlink, String expectedURL) throws Exception{
        Assert.assertEquals(resetPWlink,loginPage.getElementText(loginPage.resetPasswordLink));
        loginPage.clickOnElement(loginPage.resetPasswordLink);
        String actualURL = loginPage.getCurrentURL();
        Assert.assertEquals(expectedURL,actualURL);
        System.out.println("expected url is "+ expectedURL);
        System.out.println("actual url is "+actualURL);


    }

    @Then("user click {string} to return to login page and verify logo")
    public void userClickToReturnToLoginPageAndVerifyLogo(String returnLink) throws Exception {
        Assert.assertEquals(returnLink,loginPage.getElementText(loginPage.backToLoginLink));
        loginPage.clickOnElement(loginPage.backToLoginLink);
        Assert.assertTrue(loginPage.verifyElementIsDisplayed(loginPage.upFoundersLogo));
        System.out.println("current url is "+loginPage.getCurrentURL());

    }

    @Then("user directed to reset password page and verify {string} head title")
    public void userDirectedToResetPasswordPageAndVerifyHeadTitle(String headTitle) {
        String actualTitle = loginPage.getElementText(loginPage.resetPasswordTitle);
        Assert.assertEquals(headTitle,actualTitle);
        System.out.println("expected head title is "+headTitle);
        System.out.println("actual head title is "+actualTitle);

    }

    @Then("user try to reset without entering email and get {string}")
    public void userTryToResetWithoutEnteringEmailAndGet(String requireMsg) throws Exception {
        loginPage.clickOnElement(loginPage.submitBtn);
        Thread.sleep(2000);
        String actualWarningMessage = loginPage.getElementText(loginPage.emailRequireWarning);
        Assert.assertEquals(requireMsg,actualWarningMessage);
        System.out.println("expected warning message is "+requireMsg);
        System.out.println("actual warning message is "+actualWarningMessage);
    }


    @And("user try to reset with {string} format and get {string}")
    public void userTryToResetWithFormatAndGet(String wrongEmail, String formatMsg)  throws Exception{
        loginPage.sendKeys(loginPage.emailInput,wrongEmail);
        Thread.sleep(2000);
        String actualWarningMessage = loginPage.getElementText(loginPage.invalidEmailWarning);
        Assert.assertEquals(formatMsg,actualWarningMessage);
        System.out.println("expected warning message is "+formatMsg);
        System.out.println("actual warning message is "+actualWarningMessage);
    }

    @And("user enter correct {string} and click on {string}")
    public void userEnterAndClickOn(String email, String submitBtn) throws Exception {
        loginPage.clearElement(loginPage.emailInput);
        Thread.sleep(2000);
        loginPage.sendKeys(loginPage.emailInput,email);
        Assert.assertEquals(submitBtn,loginPage.getElementText(loginPage.submitBtn));
        loginPage.clickOnElement(loginPage.submitBtn);
    }

    @And("user verify {string}")
    public void userVerify(String confirmationMessage) throws Exception {
        String actualMsg = loginPage.getElementText(loginPage.confirmationMsg);
        Assert.assertEquals(confirmationMessage,actualMsg);
        System.out.println("expected confirmation message is "+confirmationMessage);
        System.out.println("actual confirmation message is "+actualMsg);
        Thread.sleep(3000);

    }

    @Then("user will be automatically redirected to login page and verify logo")
    public void userWillBeAutomaticallyRedirectedToLoginPageAndVerifyLogo() {
        String url =loginPage.getCurrentURL();
        Assert.assertTrue(loginPage.verifyElementIsDisplayed(loginPage.upFoundersLogo));
        System.out.println("logo is displayed");
        System.out.println("back to url "+url);
    }

    @And("user navigate to his own mailbox")
    public void userNavigateToHisOwnMailbox() throws Exception{
        resetPWPage.goToUpFoundersMailBox();
    }

    @And("user input email {string} and pw {string}")
    public void userInputEmailAndPw(String email, String password) throws Exception {
        resetPWPage.sendKeys(resetPWPage.emailInput,email);
        resetPWPage.sendKeys(resetPWPage.pwInput,password);
        resetPWPage.clickOnElement(resetPWPage.signInBtn);
        Thread.sleep(3000);
    }

    @And("user click to the reset password email")
    public void userClickToTheResetPasswordEmail() throws Exception {
        resetPWPage.clickOnElement(resetPWPage.spanMail);
        Thread.sleep(3000);
        resetPWPage.clickOnElement(resetPWPage.firstEmail);
        Thread.sleep(3000);


    }



    @Then("I copy new password and navigate to UpFounders login page and input new pw for {string}")
    public void iCopyNewPasswordAndNavigateToUpFoundersLoginPageAndInputNewPwFor(String email) throws Exception{
        String newPW = resetPWPage.getActualText(resetPWPage.pwByEmail);
        Thread.sleep(3000);
        resetPWPage.clickOnElement(resetPWPage.accountDropDown);
        Thread.sleep(2000);
        resetPWPage.clickOnElement(resetPWPage.logoutBtn);
        Thread.sleep(3000);
        resetPWPage.goToUpFoundersLoginPage();
        Thread.sleep(3000);
        loginPage.setUserName(email);
        Thread.sleep(3000);
        loginPage.setPassword(newPW);
        Thread.sleep(3000);
    }
}
