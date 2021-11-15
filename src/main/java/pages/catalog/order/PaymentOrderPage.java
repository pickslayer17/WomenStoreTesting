package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PaymentOrderPage extends OrderPage {
    @FindBy(xpath = "//div[@id='HOOK_PAYMENT']/div[2]/div/p/a[@class='cheque']")
    WebElement payByCheckLink;

    public PaymentOrderPage(WebDriver driver) {
        super(driver);
    }

    public void clickPayByCheck() {
        payByCheckLink.click();
    }
}
