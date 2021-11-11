package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class DressesCatalogPage extends AbstractPage {
    @FindBy(xpath = "//a[@title='Evening Dresses' and @class='img']")
    WebElement eveningDressesImgLink;

    public DressesCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void clickEveningDressesImgLink() {
        eveningDressesImgLink.click();
    }
}
