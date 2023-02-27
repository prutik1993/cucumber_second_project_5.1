package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandler {
    public static void selectByVisibleText(WebElement dropdown, String text){
        new Select(dropdown).selectByVisibleText(text);
    }
}
