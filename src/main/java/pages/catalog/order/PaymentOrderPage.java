package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PaymentOrderPage extends OrderPage {
    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheckLink;

    public PaymentOrderPage(WebDriver driver) {
        super(driver);
    }

    public void clickPayByCheck() {
        payByCheckLink.click();
    }
}
