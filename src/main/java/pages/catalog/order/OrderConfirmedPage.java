package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrderConfirmedPage extends OrderPage {
    @FindBy(xpath = "//div[@id='center_column']/p[starts-with(@class, 'alert')]")
    WebElement successOrderP;
    @FindBy(xpath = "//div[@id='center_column']/div/span[@class='price']")
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
