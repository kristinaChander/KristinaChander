package hw3.voidpo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ElementsPage  {

    @FindBy(xpath = "//label[normalize-space()='Water']")
    private WebElement checkBoxWater;

    @FindBy(xpath = "//label[normalize-space()='Wind']")
    private WebElement checkBoxWind;

    @FindBy(xpath = "//label[normalize-space()='Selen']" )
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
