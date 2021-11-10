package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends AbstractPage{
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement emailAddressInput;

    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    public void fillEmailAddress(String text){
        emailAddressInput.sendKeys(text);
    }

    public void clickCreateAnAccountButton(){
        createAnAccountButton.click();
    }
}
