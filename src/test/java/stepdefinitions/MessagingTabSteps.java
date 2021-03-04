package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.ContentPage;
import pages.Dashboard;
import pages.LoginPage;
import pages.MessagingTab;
import webdriver.SeleniumDriver;

public class MessagingTabSteps {

    private Dashboard dashboard = new Dashboard(SeleniumDriver.getDriver());
    private MessagingTab messagingTab = new MessagingTab(SeleniumDriver.getDriver());


    @Then("i click on mesage button")
    public void i_click_on_mesage_button() throws Exception {
        dashboard.clickOnElement(dashboard.UpFoundersLogo);
        Thread.sleep(3000);
        dashboard.clickOnElement(dashboard.messageIcon);
        Thread.sleep(3000);

    }
    @Then("I click on popup mesage")
    public void i_click_on_popup_mesage() throws Exception{
        messagingTab.gotoMesagingPage();
    }

    @Then("I verify i am on meseging page")
    public void i_verify_i_am_on_meseging_page() {
        System.out.println("current page is: "+messagingTab.getCurrentUrl());

    }


    @Then("I type {string} on text field and click send then verify")
    public void i_type_on_text_field(String msg) throws Exception{
        messagingTab.sendKeys(messagingTab.msgInput, msg);
        messagingTab.clickOnElement(messagingTab.sendTab);
        Thread.sleep(3000);
        String actualtext= messagingTab.getActualText(messagingTab.msgVerified);
        Assert.assertEquals(msg,actualtext);
        System.out.println("expected sent message is :"+msg);
        System.out.println("actual sent message is :"+actualtext);
    }


    @Then("I verify {string} message from sender {string}")
    public void i_verify_message_from_sender(String msg, String sender) throws Exception {
        String actualtext= messagingTab.getActualText(messagingTab.receiveMsg);
        Assert.assertEquals(msg,actualtext);
        System.out.println("expected last received message is :"+msg);
        System.out.println("actual last received message is :"+actualtext);
        Thread.sleep(2000);
        String actualSender = messagingTab.getActualText(messagingTab.msgSender);
        Assert.assertEquals(sender,actualSender);
        System.out.println("expected sender is :"+sender);
        System.out.println("actual sender is :"+actualSender);

    }

    @Then("I verify {string} message from other sender {string}")
    public void i_verify_message_from_other_sender(String msg, String sender) throws Exception {
        String actualtext= messagingTab.getActualText(messagingTab.receiveMsg);
        Assert.assertEquals(msg,actualtext);
        System.out.println("expected last received message is :"+msg);
        System.out.println("actual last received message is :"+actualtext);
        Thread.sleep(2000);
        String actualSender = messagingTab.getActualText(messagingTab.sender2);
        Assert.assertEquals(sender,actualSender);
        System.out.println("expected sender is :"+sender);
        System.out.println("expected sender is :"+actualSender);

    }
    @And("I click on popup mesage from {string}")
    public void iClickOnPopupMesageFrom(String popupMsgFromGilman) throws Exception {
        messagingTab.clickOnElement(messagingTab.popUpMsgNotifierGilman);
        System.out.println("message sender is :"+popupMsgFromGilman);
    }

}
