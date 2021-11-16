package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends AbstractPage {
    @FindBy(xpath = "//a[@class='login']")
    WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton() {
        waitUntilElement_IsClickable(signInButton);
        signInButton.click();
    }
}
