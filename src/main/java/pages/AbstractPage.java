package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected void waitUntilElement_IsClickable(WebElement element, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElement_IsDisplayed(WebElement element, int timeSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilUrlToBe(String expectedUrl, int timeSec){
        WebDriverWait wait = new WebDriverWait(driver,timeSec);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
