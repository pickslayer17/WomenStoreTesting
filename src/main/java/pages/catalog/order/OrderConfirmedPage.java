package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderConfirmedPage extends OrderPage {
    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement successOrderP;
    @FindBy(xpath = "//span[@class='price']")
    WebElement priceSpan;

    public OrderConfirmedPage(WebDriver driver) {
        super(driver);
    }

    public String getPriceSpanText() {
        return priceSpan.getText();
    }

    public String getSuccessOrderPText() {
        return successOrderP.getText();
    }
}
