package lib;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;


public class FlowLib {
    private WebDriver driver;

    public FlowLib(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void setWindowMaximized() {
        driver.manage().window().maximize();
    }
}
