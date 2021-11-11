package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentOrderPage extends OrderPage {
    public PaymentOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheckLink;

    public void clickPayByCheck() {
        payByCheckLink.click();
    }
}
