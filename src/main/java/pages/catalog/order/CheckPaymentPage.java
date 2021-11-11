package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckPaymentPage extends OrderPage {
    @FindBy(xpath = "//div[@id='center_column']/form/p/button")
    WebElement confirmOrderButton;
    @FindBy(xpath = "//span[@id='amount']")
    WebElement priceSpan;

    public CheckPaymentPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickProceed() {
        confirmOrderButton.click();
    }

    public String getPriceSpanText() {
        return priceSpan.getText().trim();
    }
}
