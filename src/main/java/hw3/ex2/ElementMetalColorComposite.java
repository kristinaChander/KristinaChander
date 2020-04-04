package hw3.ex2;

import hw3.compositepages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementMetalColorComposite extends AbstractPageComposite {
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

    public ElementMetalColorComposite(WebDriver driver) {
        super(driver);
    }

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

}
