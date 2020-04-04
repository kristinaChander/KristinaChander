package hw3.ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ElementsPageFluent {

    private WebDriver driver;

    public ElementsPageFluent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

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


    public ElementsPageFluent clickWaterCheckBox(){
        checkBoxWater.click();
        return this;
    }

    public ElementsPageFluent clickWindCheckBox(){
        checkBoxWind.click();
        return this;
    }

    public ElementsPageFluent clickSelenRadio(){
        radioSelen.click();
        return this;
    }

    public ElementsPageFluent clickColorsDropDown(){
        colorsDropDown.click();
        return this;
    }

    public ElementsPageFluent clickYellow(){
        yellow.click();
        return this;
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
