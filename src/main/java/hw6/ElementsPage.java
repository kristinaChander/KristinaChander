package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static hw3.ex2.ElementSelectUtils.chooseFromList;

public class ElementsPage extends AbstractPage {

    @FindBy(css = ".label-checkbox")
    private List<WebElement> checkBoxList;

    @FindBy(css = ".label-radio")
    private List<WebElement> radioButtonList;

    @FindBy(css = "select[class='uui-form-element']")
    private WebElement colorsDropDown;

    @FindBy(css = "option")
    private List<WebElement> colorsList;

    @FindBy(css = ".logs>li")
    private List<WebElement> logList;

    public ElementsPage(WebDriver driver) {
        super(driver);
    }


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

    public int getLogEntryCount(){
        return logList.size();
    }

    public List<String> getFilteredLogsText(){
        return logList.stream()
                .map(s -> getText(s).substring(9))
                .collect(Collectors.toList());
    }

}
