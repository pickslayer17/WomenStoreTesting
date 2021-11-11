package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class EveningDressesCatalogPage extends AbstractPage {
    @FindBy(xpath = "//img[@alt='Printed Dress']/..")
    WebElement printedDress;
    @FindBy(xpath = "//span[text()='Add to cart']/..")
    WebElement addToCartLink;
    @FindBy(xpath = "//div[@class='layer_cart_cart col-xs-12 col-md-6']/div[4]/a")
    WebElement pressProceedToCheckoutButton;

    public EveningDressesCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void hangOverPrintedDress() {
        Actions actions = new Actions(driver);
        actions.moveToElement(printedDress);
    }

    public void clickAddToCartLink() {
        addToCartLink.click();
    }

    public void waitUntilAddToCartButton_IsClickable() {
        waitUntilElement_IsClickable(addToCartLink, 2);
    }

    public void clickPressToCheckoutButton() {
        pressProceedToCheckoutButton.click();
    }

    public void clickPrintedDress() {
        printedDress.click();
    }
}
