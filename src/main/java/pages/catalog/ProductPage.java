package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

public class ProductPage extends AbstractPage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCartButton;
    @FindBy(xpath = "//span[normalize-space()='Proceed to checkout']/..")
    WebElement proceedToCheckOutButton;
    @FindBy(xpath = "//span[@id='our_price_display']")
    WebElement priceDisplaySpan;


    public void clickAddToCardButton(){
        addToCartButton.click();
    }

    public void clickProceedToCheckOutButton(){
        waitUntilElement_IsClickable(proceedToCheckOutButton, 3);
        proceedToCheckOutButton.click();
    }
    public String getPriceDisplaySpanText(){
        return priceDisplaySpan.getText();
    }
}
