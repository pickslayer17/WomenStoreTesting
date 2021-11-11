import lib.AppLib;
import lib.ReadExcelLib;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public abstract class AbstractBaseTest {

    private WebDriver driver;
    private AppLib app;

    @BeforeEach
    public void setUp() {
        System.out.println("start test method");
        System.setProperty("webdriver.chrome.driver", AbstractBaseTest.class.getClassLoader().getResource("chromedriver.exe").getFile());
        driver = new ChromeDriver();

        app = new AppLib(driver);
    }


    @AfterEach
    public void tearDown() throws InterruptedException {
        driver.close();
    }

    public AppLib App() {
        return app;
    }
}
