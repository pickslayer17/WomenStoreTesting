package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SummaryOrderPage extends OrderPage {
    @FindBy(id = "cart_summary")
    WebElement orderTable;
    @FindBy(xpath = "//td/span[starts-with(@id ,'product_price')]")
    WebElement productPriceSpan;
    @FindBy(xpath = "//input[starts-with(@name ,'quantity') and @type = 'text']")
    WebElement quantitySpan;
    @FindBy(xpath = "//td/span[starts-with(@id ,'total_product_price')]")
    WebElement totalProductPriceSpan;
    @FindBy(xpath = "//td[starts-with(@id ,'total_shipping')]")
    WebElement totalShippingTd;

    public SummaryOrderPage(WebDriver driver) {
        super(driver);
    }

    public String getProductPrice_tdText() {
        return productPriceSpan.getText();
    }

    public String getQuantity_tdText() {
        return quantitySpan.getAttribute("value");
    }

    public String getTotalProductPrice_tdText() {
        return totalProductPriceSpan.getText();
    }


    public String getTotalShippingPriceText() {
        return totalShippingTd.getText();
    }
}



