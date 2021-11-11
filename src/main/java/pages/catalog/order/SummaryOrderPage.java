package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SummaryOrderPage extends OrderPage {
    @FindBy(id = "cart_summary")
    WebElement orderTable;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tbody/tr/td[4]/span")
    WebElement productPriceSpan;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tbody/tr/td[5]/input[2]")
    WebElement quantityInput;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tbody/tr/td[6]/span")
    WebElement totalSpan;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tfoot/tr[3]/td[2]")
    WebElement totalShippingTd;

    public SummaryOrderPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPriceSpanText() {
        return productPriceSpan.getText();
    }

    public String getQuantityInputText() {
        return quantityInput.getAttribute("value");
    }

    public String getTotalSpanText() {
        return totalSpan.getText();
    }

    public String getTotalShippingText() {
        return totalShippingTd.getText();
    }
}



