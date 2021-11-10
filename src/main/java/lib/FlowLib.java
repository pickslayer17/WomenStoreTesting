package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class FlowLib {
    private WebDriver driver;

    public FlowLib(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void waitUntilElementIsDisplayed(WebElement element, int timeSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
