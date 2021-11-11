package pages.catalog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class DressesCatalogPage extends AbstractPage {
    public DressesCatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Evening Dresses' and @class='img']")
    WebElement eveningDressesImgLink;

    public void clickEveningDressesImgLink(){
        eveningDressesImgLink.click();
    }
}
