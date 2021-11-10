package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends AbstractPage{
    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement emailCreateAddressInput;
    @FindBy(id = "SubmitCreate")
    WebElement createAnAccountButton;

    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "passwd")
    WebElement passInput;
    @FindBy(id = "SubmitLogin")
    WebElement signInButton;


    public void fillEmailCreateAddress(String text){
        emailCreateAddressInput.sendKeys(text);
    }

    public void clickCreateAnAccountButton(){
        createAnAccountButton.click();
    }

    public void fillEmailAddress(String text){
        emailInput.sendKeys(text);
    }
    public void fillPassword(String text){
        passInput.sendKeys(text);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
}
