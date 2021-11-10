package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends AbstractPage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private final String PAGE_URL = "http://automationpractice.com/index.php?controller=my-account";

    public String getPAGE_URL() {
        return PAGE_URL;
    }


}
