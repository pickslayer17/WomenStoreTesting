import Extensions.ScreenshotAfterTextExecution;
import Extensions.ScreenshotAllureAttacher;
import data.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import lib.AppLib;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public abstract class AbstractBaseTest {

    @RegisterExtension
    ScreenshotAfterTextExecution screenshotAfterTextExecution = new ScreenshotAfterTextExecution();
    @RegisterExtension
    ScreenshotAllureAttacher screenshotAllureAttacher = new ScreenshotAllureAttacher();
    private WebDriver driver;
    private AppLib app;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        app = new AppLib(driver);
        screenshotAfterTextExecution.setDriver(driver);
        screenshotAfterTextExecution.setPath(Properties.getInstance().getPropertyByKey("screenshot_target"));
        screenshotAllureAttacher.setScreenshotAfterTextExecution(screenshotAfterTextExecution);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public AppLib App() {
        return app;
    }
}
