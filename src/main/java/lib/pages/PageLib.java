package lib.pages;

import org.openqa.selenium.WebDriver;
import pages.*;
import pages.catalog.DressesCatalogPage;
import pages.catalog.EveningDressesCatalogPage;
import pages.catalog.ProductPage;

public class PageLib {
    private WebDriver driver;

    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private CreateAnAccountPage createAnAccountPage;
    private MyAccountPage myAccountPage;
    private DressesCatalogPage dressesCatalogPage;
    private EveningDressesCatalogPage eveningDressesCatalogPage;
    private ProductPage productPage;

    //page libs
    private OrderPageLib orderPages;

    public PageLib(WebDriver driver) {
        this.driver = driver;
        initializePages();
        initializePageLibs();
    }

    private void initializePages() {
        homePage = new HomePage(driver);
        authenticationPage = new AuthenticationPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
        myAccountPage = new MyAccountPage(driver);
        dressesCatalogPage = new DressesCatalogPage(driver);
        eveningDressesCatalogPage = new EveningDressesCatalogPage(driver);
        productPage = new ProductPage(driver);
    }

    public void initializePageLibs(){
        orderPages = new OrderPageLib(driver);
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
    public MyAccountPage MyAccountPage() { return myAccountPage;}
    public DressesCatalogPage DressesCatalogPage() {return dressesCatalogPage;}
    public EveningDressesCatalogPage EveningDressesCatalogPage() {return eveningDressesCatalogPage;}
    public ProductPage ProductPage() {return productPage;}

    public OrderPageLib OrderPages(){
        return orderPages;
    }
}
