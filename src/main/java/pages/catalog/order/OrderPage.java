package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public abstract class OrderPage extends AbstractPage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//span[normalize-space()='Proceed to checkout'])[2]")
    WebElement proceedToCheckOutButton;

    public void clickProceed(){
        proceedToCheckOutButton.click();
    }


}
