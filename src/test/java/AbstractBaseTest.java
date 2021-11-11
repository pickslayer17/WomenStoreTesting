import io.github.bonigarcia.wdm.WebDriverManager;
import lib.AppLib;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public abstract class AbstractBaseTest {

    private WebDriver driver;
    private AppLib app;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().browserVersion("96.0.4664.35").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

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
