package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SummaryOrderPage extends OrderPage {
    @FindBy(id = "cart_summary")
    WebElement orderTable;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tbody/tr/td[4]/span[starts-with(@id,'product_price')]")
    WebElement productPriceSpan;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tbody/tr/td[5]/input[2][starts-with(@name,'quantity')]")
    WebElement quantityInput;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tbody/tr/td[6]/span[starts-with(@id,'total_product_price')]")
    WebElement totalSpan;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tfoot/tr[3]/td[2][@id='total_shipping']")
    WebElement totalShippingTd;
    @FindBy(xpath = "//div[@id='order-detail-content']/table//tfoot//span[@id='total_price']")
    WebElement totalWithShipping;

    public SummaryOrderPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPriceSpanText() {
        return productPriceSpan.getText().trim();
    }

    public String getQuantityInputText() {
        return quantityInput.getAttribute("value");
    }

    public String getTotalSpanText() {
        return totalSpan.getText().trim();
    }

    public String getTotalShippingText() {
        return totalShippingTd.getText().trim();
    }

    public String getTotalWithShippingText() {
        return totalWithShipping.getText().trim();
    }
}



