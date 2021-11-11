package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public abstract class OrderPage extends AbstractPage {
    @FindBy(xpath = "(//span[normalize-space()='Proceed to checkout'])[2]")
    WebElement proceedToCheckOutButton;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceed() {
        proceedToCheckOutButton.click();
    }
}
