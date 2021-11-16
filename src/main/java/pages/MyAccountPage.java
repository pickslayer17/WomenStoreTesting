package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends AbstractPage {
    private final String PAGE_URL = "http://automationpractice.com/index.php?controller=my-account";

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a[@class='sf-with-ul']")
    WebElement womenLink;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a[@class='sf-with-ul']")
    WebElement dressesLink;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a[@class='sf-with-ul']")
    WebElement t_shirtsLink;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public void clickDressesLink() {
        dressesLink.click();
    }

    public void waitPageUrlEqualsToCurrent() {
        waitUntilUrlToBe(PAGE_URL);
    }
}
