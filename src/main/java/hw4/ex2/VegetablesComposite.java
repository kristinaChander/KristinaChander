package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VegetablesComposite extends AbstractPageComposite {

    public static final String TOMATO = "Tomato";
    public static final String VEGETABLES = "Vegetables";
    public static final String ONION = "Onion";
    public static final String CUCUMBER = "Cucumber";

    @FindBy(css= "#salad-dropdown .caret")
    private WebElement vegetablesDropDown;

    @FindBy(xpath = "//label[text()='Cucumber']")
    private WebElement cucumberInDropDown;

    @FindBy(xpath ="//label[text()='Tomato']")
    private WebElement tomatoInDropDown;

    @FindBy(xpath = "//label[text()='Vegetables']")
    private WebElement vegetablesInDropDown;

    @FindBy(xpath = "//label[text()='Onion']")
    private WebElement onoionInDropDown;

    public VegetablesComposite(WebDriver driver) {
        super(driver);
    }

    public void clickOnVegetablesDropDown(){
        vegetablesDropDown.click();
    }

    public void clickOnTomato(){
        tomatoInDropDown.click();
    }

    public void clickOnCucumber(){
        cucumberInDropDown.click();
    }

    public void clickOnVegetables(){
        vegetablesDropDown.click();
    }

    public void clickOnOnion(){
        onoionInDropDown.click();
    }

    public void clickOnVegetable(List<String> vegetables){
        if (vegetables.isEmpty()){
            return;
        }
        clickOnVegetablesDropDown();
        clickOnVegetables();
        for (String vegetable: vegetables) {
            switch (vegetable){
                case TOMATO:
                    clickOnTomato();
                    break;
                case CUCUMBER:
                    clickOnCucumber();
                    break;
                case ONION:
                    clickOnOnion();
                    break;
                case VEGETABLES:
                    clickOnVegetables();
                    break;
            }
        }
    }
}
