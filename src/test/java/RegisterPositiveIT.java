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
        userData(user);
        App().Pages().CreateAnAccountPage().fillGender(user.getGender());
        App().Pages().CreateAnAccountPage().fillCustomerFirstName(user.getFirstName());
        App().Pages().CreateAnAccountPage().fillCustomerLastName(user.getLastName());
        App().Pages().CreateAnAccountPage().fillPassword(user.getPassword());
        App().Pages().CreateAnAccountPage().fillDateOfBirth(user.getDateOfBirth());
        App().Pages().CreateAnAccountPage().fillCompany(user.getCompany());
        App().Pages().CreateAnAccountPage().fillAddress(user.getAddress());
        App().Pages().CreateAnAccountPage().fillCity(user.getCity());
        App().Pages().CreateAnAccountPage().fillState(user.getState());
        App().Pages().CreateAnAccountPage().fillZip(user.getZip());
        App().Pages().CreateAnAccountPage().fillHomePhone(user.getHomePhone());
        App().Pages().CreateAnAccountPage().register();
    }

    @Attachment
    private String userData(User user){
        StringBuilder sb = new StringBuilder();
        sb.append("Gender: " + user.getGender() + "\n");
        sb.append("First name: " + user.getFirstName() + "\n");
        sb.append("Last name: " + user.getLastName() + "\n");
        sb.append("Password: " + user.getPassword() + "\n");
        sb.append("Date of Birth: " + user.getCompany() + "\n");
        sb.append("Address: " + user.getAddress() + "\n");
        sb.append("City: " + user.getCity() + "\n");
        sb.append("State: " + user.getState() + "\n");
        sb.append("Zip: " + user.getZip() + "\n");
        sb.append("Home phone: " + user.getHomePhone() + "\n");
        return sb.toString();
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
