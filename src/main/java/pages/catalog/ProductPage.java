package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class ProductPage extends AbstractPage {
    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']/..")
    WebElement proceedToCheckOutButton;
    @FindBy(xpath = "//span[@id='our_price_display']")
    WebElement priceDisplaySpan;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCardButton() {
        addToCartButton.click();
    }

    public void clickProceedToCheckOutButton() {
        waitUntilElement_IsClickable(proceedToCheckOutButton, 3);
        proceedToCheckOutButton.click();
    }

    public String getPriceDisplaySpanText() {
        return priceDisplaySpan.getText();
    }
}
