package pages.catalog.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingOrderPage extends OrderPage {
    public ShippingOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='cgv']")
    WebElement agreeTermsCheckbox;
    @FindBy(xpath = "//div[@class='fancybox-skin']")
    WebElement youMustAgreePopupDiv;
    @FindBy(xpath = "//a[@title='Close']")
    WebElement youMustAgreePopupDivCloseButton;

    public boolean isYouMustAgreePopupDivDisplayed() {
        return youMustAgreePopupDiv.isDisplayed();
    }

    public void clickYouMustAgreePopupDivCloseButton(){
        waitUntilElement_IsClickable(youMustAgreePopupDivCloseButton, 2);
        youMustAgreePopupDivCloseButton.click();
    }

    public void clickAgreeTermsCheckbox(){
        agreeTermsCheckbox.click();
    }

}
