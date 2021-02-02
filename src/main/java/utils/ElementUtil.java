package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.util.List;

public class ElementUtil {
    private WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElementTobeVisible(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementPresent(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean compareDropdownOptions(WebElement element, String[] expected) {
        List<WebElement> options = getAllDropDownOptions(element);
        int i = 0;
        for (WebElement opt : options) {
            if (!opt.getText().equals(expected[i])) {
                return false;
            }
            i = i + 1;
        }
        return true;
    }

    public List<WebElement> getAllDropDownOptions(WebElement element) {
        Select select = new Select(element);
        List<WebElement> op = select.getOptions();
        return op;
    }

    public String randomString(int len) {
        String abc = "0123456789abcdefghijklmnopqrstuvwxyz";
        SecureRandom sr = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(abc.charAt(sr.nextInt(abc.length())));
        }
        return sb.toString();
    }

}
