package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderConfirmedPage extends OrderPage {
    @FindBy(xpath = "//div[@id='center_column']/p[1]")
    WebElement successOrderP;
    @FindBy(xpath = "//div[@id='center_column']/div/span")
    WebElement priceSpan;

    public OrderConfirmedPage(WebDriver driver) {
        super(driver);
    }

    public String getPriceSpanText() {
        return priceSpan.getText().trim();
    }

    public String getSuccessOrderPText() {
        return successOrderP.getText().trim();
    }
}
