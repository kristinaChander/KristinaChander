package hw4.ex2;

import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectUtils {

    public static void chooseItemFromList(List<String> texts, List <WebElement> elements) {
        for (String text : texts) {
            for (WebElement element : elements) {
                if (element.getText().equals(text)) {
                    element.click();
                }
            }
        }
    }
}
