package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TableGetter {


    public static List<WebElement> get_tr(WebElement element) {
        return element.findElements(By.xpath("//tr"));
    }

    public static List<WebElement> get_td(WebElement element, int trNumber) {
        return element.findElements(By.xpath("//tr[" + trNumber + "]//td"));
    }
}
