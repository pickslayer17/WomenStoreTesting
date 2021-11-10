package pages;

import lib.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage extends AbstractPage{
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id_gender1")
    WebElement maleRadioButton;
    @FindBy(id = "id_gender1")
    WebElement femaleRadioButton;
    @FindBy(id = "customer_firstname")
    WebElement fCustomerNameInput;
    @FindBy(id = "customer_lastname")
    WebElement lCustomerNameInput;
    @FindBy(id = "@@@")
    WebElement eMailInput;
    @FindBy(id = "passwd")
    WebElement passInput;

    @FindBy(id = "days")
    WebElement daysSelect;
    @FindBy(id = "months")
    WebElement monthsSelect;
    @FindBy(id = "years")
    WebElement yearsSelect;

    @FindBy(id = "@@@")
    WebElement newsLettersCheckbox;
    @FindBy(id = "@@@")
    WebElement specialOffersCheckbox;

    @FindBy(id = "@@@")
    WebElement fNameInput;
    @FindBy(id = "@@@")
    WebElement lNameInput;
    @FindBy(id = "company")
    WebElement companyInput;
    @FindBy(id = "address1")
    WebElement address_1_Input;
    @FindBy(id = "address2")
    WebElement address_2_Input;
    @FindBy(id = "city")
    WebElement cityInput;
    @FindBy(id = "id_state")
    WebElement stateSelect;
    @FindBy(id = "postcode")
    WebElement zipInput;
    @FindBy(id = "id_country")
    WebElement countrySelect;
    @FindBy(id = "phone")
    WebElement homePhoneInput;
    @FindBy(id = "phone_mobile")
    WebElement mobilePhoneInput;
    @FindBy(id = "alias")
    WebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    WebElement registerButton;




    public void fillGender(String gender) {
        if(gender.equalsIgnoreCase("male")){
            maleRadioButton.click();
        } else if(gender.equalsIgnoreCase("female")){
            femaleRadioButton.click();
        }
    }

    public void fillCustomerFirstName(String first_name) {
        fCustomerNameInput.sendKeys(first_name);
    }

    public void fillCustomerLastName(String last_name) {
    lCustomerNameInput.sendKeys(last_name);
    }

    public void fillPassword(String password) {
        passInput.sendKeys(password);
    }

    public void fillDateOfBirth(String date_of_birth) {
        String[] dob = date_of_birth.split("-");

        Util.fillSelect(daysSelect, dob[0]);
        Util.fillSelectByIndex(monthsSelect, dob[1]);
        Util.fillSelect(yearsSelect, dob[2]);

    }


    public void fillCompany(String company) {
        companyInput.sendKeys(company);
    }

    public void fillAddress(String address) {
        address_1_Input.sendKeys(address);
    }

    public void fillCity(String city) {
        cityInput.sendKeys(city);
    }

    public void fillState(String state) {
        Util.fillSelectVisibleText(stateSelect, state);
    }

    public void fillZip(String zip) {
        zipInput.sendKeys(zip);
    }

    public void fillHomePhone(String homePhone) {
        homePhoneInput.sendKeys(homePhone);
    }

    public void register() {
        registerButton.click();
    }

    public void waitUntilGenderMaleRadioIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(maleRadioButton));
    }
}
