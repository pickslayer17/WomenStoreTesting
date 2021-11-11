package pages.catalog.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckPaymentPage extends OrderPage {
    public CheckPaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'button-medium')]")
    WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@class='box cheque-box']")
    WebElement paymentDescriptionDiv;

    @FindBy(xpath = "//span[@id='amount']")
    WebElement priceSpan;


    @Override
    public void clickProceed(){
        confirmOrderButton.click();
    }

    public String getPriceSpanText() {
        return priceSpan.getText();
    }
}
