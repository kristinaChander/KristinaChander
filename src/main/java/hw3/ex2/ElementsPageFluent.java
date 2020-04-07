package hw3.ex2;

import hw3.compositepages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static hw3.ex2.ElementSelectUtils.chooseFromList;

public class ElementsPageFluent extends AbstractPageComposite {

    public ElementsPageFluent(WebDriver driver) {
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

    @FindBy(css = ".logs>li")
    private List<WebElement> logList;

    public ElementsPageFluent chooseColorFromDropDown(String colorName) {
        colorsDropDown.click();
        chooseFromList(colorName, colorsList);
        return this;
    }

    public ElementsPageFluent clickCheckButtonsFromList(String checkBoxName) {
        chooseFromList(checkBoxName, checkBoxList);
        return this;
    }

    public ElementsPageFluent clickRadioButtonsFromList(String radioButtonName) {
        chooseFromList(radioButtonName, radioButtonList);
        return this;
    }

    public int getLogEntryCount() {
        return logList.size();
    }

    public List<String> getFilteredLogsText() {
        return logList.stream()
                .map(s -> s.getText().substring(9))
                .collect(Collectors.toList());
    }
}
