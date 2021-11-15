import data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


@Order(1)
public class RegisterPositiveIT extends AbstractBaseTest {

    @Test
    public void registerUser() {
        App().Flow().navigateToUrl("http://automationpractice.com/");
        App().Pages().HomePage().clickSignInButton();

        User user = DataProvider.getUser();

        App().Pages().AuthenticationPage().fillEmailCreateAddress(getNewEmail(user.getEmail()));
        App().Pages().AuthenticationPage().clickCreateAnAccountButton();

        App().Pages().CreateAnAccountPage().waitUntilGenderMaleRadioIsDisplayed();
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

        App().Pages().MyAccountPage().waitPageUrlEqualsToCurrent();
        Assertions.assertEquals(
                App().Pages().MyAccountPage().getPAGE_URL(),
                App().Flow().getCurrentUrl(),
                "Url of MyAccount Page doesn't corresponds"
        );
    }

    private String getNewEmail(String template) {
        String uniqueInt = String.valueOf(
                LocalDateTime.now().getDayOfMonth()) +
                String.valueOf(LocalDateTime.now().getHour()) +
                String.valueOf(LocalDateTime.now().getMinute()
                );
        String result = template.replace("@", "_" + uniqueInt + "@");
        System.out.println("User email is: " + result);
        return result;
    }
}
