package Extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ScreenshotAfterTextExecution implements AfterTestExecutionCallback {

    private WebDriver driver;
    private String path;
    private List<String> screenshotNameList = new ArrayList<>();
    private ShootingStrategy shootingStrategy = ShootingStrategies.viewportPasting(1000);
    private String sessionUUID = UUID.randomUUID().toString();

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setShootingStrategy(ShootingStrategy shootingStrategy){
        this.shootingStrategy = shootingStrategy;
    }

    public void captureScreenshot(String methodName) {
        try {
            new File(path).mkdirs();
            String screenshotName = path + File.separator + "screenshot-" + methodName + sessionUUID + ".png" ;
            Screenshot screenshot = new AShot().shootingStrategy(shootingStrategy).takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(),"PNG",new File(screenshotName));
            screenshotNameList.add(screenshotName);
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        Method testMethod = extensionContext.getRequiredTestMethod();
        boolean testFailed = extensionContext.getExecutionException().isPresent();
        if (testFailed) {
            System.out.println("TEST FAILED ON " + testMethod.getName());
            captureScreenshot(extensionContext.getDisplayName());
        } else {
            System.out.println("TEST PASSED ON " + testMethod.getName());
        }
    }

    public String getScreenshotName(String methodName) {
        for (String scrName: screenshotNameList) {
            if(scrName.equals(path + File.separator + "screenshot-" + methodName + sessionUUID + ".png")){
                return scrName;
            }
        }
        return null;
    }
}
