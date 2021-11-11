package lib;

import org.openqa.selenium.WebDriver;


public class FlowLib {
    private WebDriver driver;

    public FlowLib(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void setWindowMaximized() {
        driver.manage().window().maximize();
    }
}
