package lib;

import org.openqa.selenium.WebDriver;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.AuthenticationPage;
import pages.MyAccountPage;

public class PageLib {
    private WebDriver driver;

    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private CreateAnAccountPage createAnAccountPage;
    private MyAccountPage myAccountPage;

    public PageLib(WebDriver driver) {
        this.driver = driver;
        initializePages();
    }



    private void initializePages() {
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    public HomePage HomePage() {
        return homePage;
    }

    public AuthenticationPage AuthenticationPage() {
        return authenticationPage;
    }

    public CreateAnAccountPage CreateAnAccountPage() {
        return createAnAccountPage;
    }
    public MyAccountPage MyAccountPage() {
        return myAccountPage;
    }
}
