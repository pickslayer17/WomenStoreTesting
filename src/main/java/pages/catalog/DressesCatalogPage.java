package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;


public class DressesCatalogPage extends AbstractPage {
    @FindBy(xpath = "//div[@id='subcategories']/ul/li[2]/div[1]/a")
    WebElement eveningDressesImgLink;

    public DressesCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void clickEveningDressesImgLink() {
        eveningDressesImgLink.click();
    }
}
