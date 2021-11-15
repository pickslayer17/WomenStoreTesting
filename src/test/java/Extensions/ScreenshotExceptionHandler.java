package Extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ScreenshotExceptionHandler implements TestExecutionExceptionHandler {

    private WebDriver driver;
    private String path;

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        System.out.print("An extension appears in method: ");
        System.out.println(extensionContext.getDisplayName());
        System.out.println("The MESSAGE IS:");
        System.out.println(throwable.getMessage());
        System.out.println("---------------");
        if (driver != null) {
            captureScreenshot(driver, extensionContext.getDisplayName());
        }
        throw throwable;
    }

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
}
