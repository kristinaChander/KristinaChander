package hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ElementsPage  {

    @FindBy(css = ".label-checkbox:nth-child(1)")
    private WebElement checkBoxWater;

    @FindBy(css = ".label-checkbox:nth-child(3)")
    private WebElement checkBoxWind;

    @FindBy(css = ".label-radio:nth-child(4)" )
    private WebElement radioSelen;

    @FindBy(css = "div.colors .uui-form-element")
    private WebElement colorsDropDown;

    @FindBy(xpath = "//*[text()='Yellow']")
    private WebElement yellow;

    @FindBy(css = ".logs>li")
    private List<WebElement> logList;


    public void clickWaterCheckBox(){
        checkBoxWater.click();
    }

    public void clickWindCheckBox(){
        checkBoxWind.click();
    }

    public void clickSelenRadio(){
        radioSelen.click();
    }

    public void clickColorsDropDown(){
        colorsDropDown.click();
    }

    public void clickYellow(){
        yellow.click();
    }

    public int getLogEntryCount(){
        return logList.size();
    }

    public List<String> getFilteredLogsText(){
        return logList.stream()
                .map(s -> s.getText().substring(9))
                .collect(Collectors.toList());

    }

}
