import data.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


@Order(1)
public class RegisterPositiveIT extends AbstractBaseTest {

    @Epic("Smoke test")
    @Feature("Account validation")
    @Story("Create a new account")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void registerUser() {
        goToSignInPage("http://automationpractice.com/");

        User user = DataProvider.getUser();
        createNewAccount(getNewEmail(user.getEmail()));

        fillAccountData(user);

        verifyRegisterSuccess();
    }

    @Step("Go to HomePage url and click sign in button")
    private void goToSignInPage(String url) {
        App().Flow().navigateToUrl(url);
        App().Pages().HomePage().clickSignInButton();
    }

    @Step("Enter email and click on \"Create account\" button")
    private void createNewAccount(String randomGeneratedEmail) {
        App().Pages().AuthenticationPage().fillEmailCreateAddress(randomGeneratedEmail);
        App().Pages().AuthenticationPage().clickCreateAnAccountButton();
    }

    @Step("Enter necessary fields and click \"Register\" button")
    private void fillAccountData(User user) {
        App().Pages().CreateAnAccountPage().waitUntilGenderMaleRadioIsDisplayed();
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("Gender: " + user.getGender() + "\n");
            App().Pages().CreateAnAccountPage().fillGender(user.getGender());
            sb.append("First name: " + user.getFirstName() + "\n");
            App().Pages().CreateAnAccountPage().fillCustomerFirstName(user.getFirstName());
            sb.append("Last name: " + user.getLastName() + "\n");
            App().Pages().CreateAnAccountPage().fillCustomerLastName(user.getLastName());
            sb.append("Password: " + user.getPassword() + "\n");
            App().Pages().CreateAnAccountPage().fillPassword(user.getPassword());
            sb.append("Date of Birth: " + user.getDateOfBirth() + "\n");
            App().Pages().CreateAnAccountPage().fillDateOfBirth(user.getDateOfBirth());
            sb.append("Company: " + user.getCompany() + "\n");
            App().Pages().CreateAnAccountPage().fillCompany(user.getCompany());
            sb.append("Address: " + user.getAddress() + "\n");
            App().Pages().CreateAnAccountPage().fillAddress(user.getAddress());
            sb.append("City: " + user.getCity() + "\n");
            App().Pages().CreateAnAccountPage().fillCity(user.getCity());
            sb.append("State: " + user.getState() + "\n");
            App().Pages().CreateAnAccountPage().fillState(user.getState());
            sb.append("Zip: " + user.getZip() + "\n");
            App().Pages().CreateAnAccountPage().fillZip(user.getZip());
            sb.append("Home phone: " + user.getHomePhone() + "\n");
            App().Pages().CreateAnAccountPage().fillHomePhone(user.getHomePhone());
        } catch (Exception exception) {
            throw exception;
        } finally {
            Allure.addAttachment("User data", "", sb.toString());
        }

        App().Pages().CreateAnAccountPage().register();
    }


    @Step("Verify current url corresponds to expected")
    private void verifyRegisterSuccess() {
//        App().Pages().MyAccountPage().waitPageUrlEqualsToCurrent();
        String currentUrl = App().Flow().getCurrentUrl();
        String expectedUrl = App().Pages().MyAccountPage().getPAGE_URL();
        Allure.addAttachment("Current url", "text/plain", currentUrl);
        Allure.addAttachment("Expected url", "text/plain", expectedUrl);
        Assertions.assertEquals(expectedUrl,currentUrl);
    }

    private String getNewEmail(String template) {
        String uniqueInt = String.valueOf(
                LocalDateTime.now().getMonth().toString()+
                String.valueOf(LocalDateTime.now().getDayOfMonth())) +
                String.valueOf(LocalDateTime.now().getHour()) +
                String.valueOf(LocalDateTime.now().getMinute()
                );
        String result = template.replace("@", "_" + uniqueInt + "@");
        System.out.println("User email is: " + result);
        return result;
    }
}
