package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ShippingOrderPage extends OrderPage {
    @FindBy(xpath = "//input[@id='cgv']")
    WebElement agreeTermsCheckbox;
    @FindBy(xpath = "//div[@class='fancybox-skin']")
    WebElement youMustAgreePopupDiv;
    @FindBy(xpath = "//div[@class='fancybox-skin']/a")
    WebElement youMustAgreePopupDivCloseButton;

    public ShippingOrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isYouMustAgreePopupDivDisplayed() {
        return youMustAgreePopupDiv.isDisplayed();
    }

    public void clickYouMustAgreePopupDivCloseButton() {
        waitUntilElement_IsClickable(youMustAgreePopupDivCloseButton, 2);
        youMustAgreePopupDivCloseButton.click();
    }

    public void clickAgreeTermsCheckbox() {
        agreeTermsCheckbox.click();
    }
}
