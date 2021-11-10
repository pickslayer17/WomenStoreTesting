import data.User;
import org.junit.Assert;
import org.junit.Test;


public class RegisterPositive extends AbstractBaseTest {


    @Test
    public void testJunit() throws InterruptedException {
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        App().Pages().AuthenticationPage().fillEmailCreateAddress(user.getUserData().get("E-mail"));
        App().Pages().AuthenticationPage().clickCreateAnAccountButton();

        App().Pages().CreateAnAccountPage().waitUntilGenderMaleRadioIsDisplayed();
        App().Pages().CreateAnAccountPage().fillGender(user.getUserData().get("Gender"));
        App().Pages().CreateAnAccountPage().fillCustomerFirstName(user.getUserData().get("First Name"));
        App().Pages().CreateAnAccountPage().fillCustomerLastName(user.getUserData().get("Last Name"));
        App().Pages().CreateAnAccountPage().fillPassword(user.getUserData().get("Password"));
        App().Pages().CreateAnAccountPage().fillDateOfBirth(user.getUserData().get("Date of Birth"));
        App().Pages().CreateAnAccountPage().fillCompany(user.getUserData().get("Company"));
        App().Pages().CreateAnAccountPage().fillAddress(user.getUserData().get("Address"));
        App().Pages().CreateAnAccountPage().fillCity(user.getUserData().get("City"));
        App().Pages().CreateAnAccountPage().fillState(user.getUserData().get("State"));
        App().Pages().CreateAnAccountPage().fillZip(user.getUserData().get("Zip"));
        App().Pages().CreateAnAccountPage().fillHomePhone(user.getUserData().get("Home Phone"));

        App().Pages().CreateAnAccountPage().register();

        Assert.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl());


    }

}
