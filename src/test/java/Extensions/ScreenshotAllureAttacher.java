package Extensions;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ScreenshotAllureAttacher implements TestWatcher {

    private ScreenshotAfterTextExecution screenshotAfterTextExecution;

    public void setScreenshotAfterTextExecution(ScreenshotAfterTextExecution screenshotAfterTextExecution) {
        this.screenshotAfterTextExecution = screenshotAfterTextExecution;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        TestWatcher.super.testFailed(context, cause);
        String methodName = context.getDisplayName();
        String screenshotPathName = screenshotAfterTextExecution.getScreenshotName(methodName);
        try {
            if(screenshotPathName != null){
                getScreenshot(screenshotPathName);
            } else {
                Allure.addAttachment("Screenshot", "text/plain", "There was found no fail screenshot for this test");
            }
        } catch (IOException exception){
            System.out.println("Failed in testFailed");
            exception.printStackTrace();
        }
    }

    @Attachment
    @Description("Failed screenshot")
    public static byte[] getScreenshot(String screenshotPathName) throws IOException {
        return Files.readAllBytes(Paths.get(screenshotPathName));
    }
}
