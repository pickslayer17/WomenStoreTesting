package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//p[@id='add_to_cart']/button[@name='Submit']")
    WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    WebElement proceedToCheckOutButton;
    @FindBy(xpath = "//span[@id='our_price_display']")
    WebElement priceDisplaySpan;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement quantityInput;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCardButton() {
        addToCartButton.click();
    }

    public void clickProceedToCheckOutButton() {
        waitUntilElement_IsClickable(proceedToCheckOutButton);
        proceedToCheckOutButton.click();
    }

    public String getPriceDisplaySpanText() {
        return priceDisplaySpan.getText().trim();
    }

    public void setQuantityInput(int count) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(count));
    }
}
