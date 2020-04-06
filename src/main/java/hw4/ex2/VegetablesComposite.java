package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw4.ex2.SelectUtils.chooseItemFromList;

public class VegetablesComposite extends AbstractPageComposite {

    public static final String TOMATO = "Tomato";
    public static final String VEGETABLES = "Vegetables";
    public static final String ONION = "Onion";
    public static final String CUCUMBER = "Cucumber";

    @FindBy(css= "#salad-dropdown .caret")
    private WebElement vegetablesDropDown;

    @FindBy(css = "#salad-dropdown label")
    private List <WebElement> vegetablesList;

    @FindBy(xpath = "//a//label[text()='Vegetables']")
    private WebElement vegetablesInDropDown;

    public VegetablesComposite(WebDriver driver) {
        super(driver);
    }

    public void chooseVegetables(List <String> vegetables){
        if (vegetables.isEmpty()) {
            return;
        }
        vegetablesDropDown.click();
        if (!vegetables.contains("Vegetables")) {
            vegetablesInDropDown.click();
        } else {
            vegetables.remove("Vegetables");
        }
        chooseItemFromList(vegetables, vegetablesList);
    }
}
