import lib.AppLib;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseTest {

    private WebDriver driver;
    private AppLib app;

    @Before
    public void setUp() {
        System.out.println("start test method");
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();



        app = new AppLib(driver);
    }



    @After
    public void tearDown() throws InterruptedException {
        driver.close();
    }

    public AppLib App() {
        return app;
    }
}
