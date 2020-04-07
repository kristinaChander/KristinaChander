package hw3.ex2;

import hw3.compositepages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw3.ex2.ElementSelectUtils.chooseFromList;

public class ElementMetalColorComposite extends AbstractPageComposite {

    public ElementMetalColorComposite(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkBoxList;

    @FindBy(css = ".label-radio")
    private List<WebElement> radioButtonList;

    @FindBy(css = "select[class='uui-form-element']")
    private WebElement colorsDropDown;

    @FindBy(css = "option")
    private List<WebElement> colorsList;

    public void chooseColorFromDropDown(String colorName) {
        colorsDropDown.click();
        chooseFromList(colorName, colorsList);
    }

    public void clickCheckButtonsFromList(String checkBoxName){
        chooseFromList(checkBoxName, checkBoxList);
    }

    public void clickRadioButtonsFromList(String radioButtonName){
        chooseFromList(radioButtonName, radioButtonList);
    }
}
