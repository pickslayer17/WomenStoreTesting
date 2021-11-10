import data.User;
import org.junit.Assert;
import org.junit.Test;


public class RegisterPositive extends AbstractBaseTest {


    @Test
    public void registerUser() throws InterruptedException {
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        App().Pages().AuthenticationPage().fillEmailCreateAddress(user.getUserData("E-mail"));
        App().Pages().AuthenticationPage().clickCreateAnAccountButton();

        App().Pages().CreateAnAccountPage().waitUntilGenderMaleRadioIsDisplayed();
        App().Pages().CreateAnAccountPage().fillGender(user.getUserData("Gender"));
        App().Pages().CreateAnAccountPage().fillCustomerFirstName(user.getUserData("First Name"));
        App().Pages().CreateAnAccountPage().fillCustomerLastName(user.getUserData("Last Name"));
        App().Pages().CreateAnAccountPage().fillPassword(user.getUserData("Password"));
        App().Pages().CreateAnAccountPage().fillDateOfBirth(user.getUserData("Date of Birth"));
        App().Pages().CreateAnAccountPage().fillCompany(user.getUserData("Company"));
        App().Pages().CreateAnAccountPage().fillAddress(user.getUserData("Address"));
        App().Pages().CreateAnAccountPage().fillCity(user.getUserData("City"));
        App().Pages().CreateAnAccountPage().fillState(user.getUserData("State"));
        App().Pages().CreateAnAccountPage().fillZip(user.getUserData("Zip"));
        App().Pages().CreateAnAccountPage().fillHomePhone(user.getUserData("Home Phone"));

        App().Pages().CreateAnAccountPage().register();

        Assert.assertEquals(App().Pages().MyAccountPage().getPAGE_URL(), App().Flow().getCurrentUrl());


    }

}
