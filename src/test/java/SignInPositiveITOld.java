import data.User;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


@Order(2)
public class SignInPositiveITOld extends AbstractBaseTest {

    @Test
    public void signInPositive() {
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        singInUser(user);

        App().Pages().MyAccountPage().waitPageUrlEqualsToCurrent();
        Assertions.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl());
    }
    @Step
    private void goToSignInPage(){

    }

    @Step()
    private void singInUser(User user){
        App().Pages().AuthenticationPage().fillEmailAddress(user.getEmail());
        App().Pages().AuthenticationPage().fillPassword(user.getPassword());
        App().Pages().AuthenticationPage().clickSignInButton();
    }

    @Step
    private void verifySignInSuccess(){

    }

}
