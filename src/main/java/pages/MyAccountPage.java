package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends AbstractPage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private final String PAGE_URL = "http://automationpractice.com/index.php?controller=my-account";

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a") //"#block_top_menu>ul>li:nth-child(2)>a"
    WebElement womenLink;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a") //"#block_top_menu>ul>li:nth-child(2)>a"
    WebElement dressesLink;
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a") //"#block_top_menu>ul>li:nth-child(2)>a"
    WebElement t_shirtsLink;





    public void clickDressesLink() {
        dressesLink.click();

    }
}
