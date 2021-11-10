import data.User;
import org.junit.Assert;
import org.junit.Test;

public class SignInPositive extends AbstractBaseTest{

    @Test
    public void signInPositive(){
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        App().Pages().AuthenticationPage().fillEmailAddress(user.getUserData("E-mail"));
        App().Pages().AuthenticationPage().fillPassword(user.getUserData("Password"));
        App().Pages().AuthenticationPage().clickSignInButton();

        Assert.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl());
    }
}
