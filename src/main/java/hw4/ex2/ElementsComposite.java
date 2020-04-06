package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ElementsComposite extends AbstractPageComposite {

    public static final String FIRE = "Fire";
    public static final String WATER = "Water";
    public static final String WIND = "Wind";
    public static final String EARTH = "Earth";

    @FindBy(xpath = "//*[@id='elements-checklist']//label[text()='Water']")
    private WebElement checkBoxWater;

   @FindBy(xpath = "//*[@id='elements-checklist']//label[text()='Earth']")
    private WebElement checkBoxEarth;

   @FindBy(xpath = "//*[@id='elements-checklist']//label[text()='Wind']")
    private WebElement checkBoxWind;

   @FindBy(xpath = "//*[@id='elements-checklist']//label[text()='Fire']")
    private WebElement checkBoxFire;

    public ElementsComposite(WebDriver driver) {
        super(driver);
    }

    public void clickOnWater(){
        checkBoxWater.click();
    }

    public void clickOnEarth(){
        checkBoxEarth.click();
    }

    public void clickOnWind(){
        checkBoxWind.click();
    }

    public void clickOnFire(){
        checkBoxFire.click();
    }

    public void clickOnElement(List<String> elements){
        for (String element: elements) {
            switch (element){
                case EARTH:
                    clickOnEarth();
                    break;
                case WATER:
                    clickOnWater();
                    break;
                case WIND:
                    clickOnWind();
                    break;
                case FIRE:
                    clickOnFire();
                    break;
            }
        }
    }
}
