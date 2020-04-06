package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw4.ex2.SelectUtils.chooseItemFromList;

public class ColorsComposite extends AbstractPageComposite {

    @FindBy(css = "#colors .caret")
    private WebElement colorsDropDown;

    @FindBy(css = "#colors a")
    private List <WebElement> colorsList;

    public ColorsComposite(WebDriver driver) {
        super(driver);
    }

    public void chooseColor(List <String> colors){
        if(colors.isEmpty()) {
            return;
        }
        colorsDropDown.click();
        chooseItemFromList(colors,colorsList);
    }
}
