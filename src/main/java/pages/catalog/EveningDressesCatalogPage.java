package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class EveningDressesCatalogPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='center_column']/ul/li/div/div[1]/div/a[1]")
    WebElement printedDress;

    public EveningDressesCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void clickPrintedDress() {
        printedDress.click();
    }
}
