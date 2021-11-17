import data.User;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


@Order(2)
public class SignInPositiveIT extends AbstractBaseTest {

    @Epic("Smoke test")
    @Feature("Account validation")
    @Story("Login existed account")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void signInPositive() {
        goToSignInPage("http://automationpractice.com/");

        User user = DataProvider.getUser();
        singInUser(user.getEmail(), user.getPassword());

        verifySignInSuccess();
    }

    @Step("Go to HomePage url and click sign in button")
    private void goToSignInPage(String url) {
        App().Flow().navigateToUrl(url);
        App().Pages().HomePage().clickSignInButton();
    }

    @Step("Enter user email and password. And Click sign in")
    private void singInUser(String eMail, String password) {
        App().Pages().AuthenticationPage().fillEmailAddress(eMail);
        App().Pages().AuthenticationPage().fillPassword(password);
        App().Pages().AuthenticationPage().clickSignInButton();
    }

    @Step("Verify current url corresponds to expected")
    private void verifySignInSuccess() {
        App().Pages().MyAccountPage().waitPageUrlEqualsToCurrent();
        String currentUrl = App().Flow().getCurrentUrl();
        String expectedUrl = App().Pages().MyAccountPage().getPAGE_URL();
        Allure.addAttachment("Current url", "text/plain", currentUrl);
        Allure.addAttachment("Expected url", "text/plain", expectedUrl);
        Assertions.assertEquals(expectedUrl, currentUrl);
    }
}
