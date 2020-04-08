package hw3.ex2;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementSelectUtils {

    public static void chooseFromList(String text, List<WebElement> elements) {
        for (WebElement element : elements) {
            if (text.equals(element.getText())) {
                element.click();
            }
        }
    }
}