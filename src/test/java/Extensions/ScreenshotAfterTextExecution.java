package Extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;


public class ScreenshotAfterTextExecution implements AfterTestExecutionCallback {

    private WebDriver driver;
    private String path;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void captureScreenshot(WebDriver driver, String fileName) {

        try {
            new File(path).mkdirs();
            try (FileOutputStream out = new FileOutputStream(path + File.separator + "screenshot-" + fileName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("screenshot failed:" + e.getMessage());
        }
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext)  {
        Method testMethod = extensionContext.getRequiredTestMethod();
        boolean testFailed = extensionContext.getExecutionException().isPresent();
        if (testFailed) {
            System.out.println("TEST FAILED ON " + testMethod.getName());
            captureScreenshot(driver, extensionContext.getDisplayName());
        } else {
            System.out.println("TEST PASSED ON " + testMethod.getName());
        }
    }
}
