package pages;

import Utils.SelectUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateAnAccountPage extends AbstractPage {
    @FindBy(id = "id_gender1")
    WebElement maleRadioButton;
    @FindBy(id = "id_gender1")
    WebElement femaleRadioButton;
    @FindBy(id = "customer_firstname")
    WebElement fCustomerNameInput;
    @FindBy(id = "customer_lastname")
    WebElement lCustomerNameInput;
    @FindBy(id = "passwd")
    WebElement passInput;
    @FindBy(id = "days")
    WebElement daysSelect;
    @FindBy(id = "months")
    WebElement monthsSelect;
    @FindBy(id = "years")
    WebElement yearsSelect;
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

    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
    }

    public void fillGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            maleRadioButton.click();
        } else if (gender.equalsIgnoreCase("female")) {
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

        SelectUtil.fillSelect(daysSelect, dob[0]);
        SelectUtil.fillSelectByIndex(monthsSelect, dob[1]);
        SelectUtil.fillSelect(yearsSelect, dob[2]);
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
        SelectUtil.fillSelectVisibleText(stateSelect, state);
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
        waitUntilElement_IsDisplayed(maleRadioButton, 5);
    }
}
