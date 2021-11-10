package lib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {

    public static void fillSelect(WebElement select, String selectValue){
        Select sel = new Select(select);
        sel.selectByValue(selectValue);
    }

    public static void fillSelectByIndex(WebElement select, String selectValue) {
        Select sel = new Select(select);
        sel.selectByIndex(Integer.parseInt(selectValue));
    }

    public static void fillSelectVisibleText(WebElement select, String selectValue) {
        Select sel = new Select(select);
        sel.selectByVisibleText(selectValue);
    }


}
