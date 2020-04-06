package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ColorsComposite extends AbstractPageComposite {

    public static final String BLUE = "Blue";
    public static final String YELLOW = "Yellow";
    public static final String GREEN = "Green";

    @FindBy(css = "#colors .caret")
    private WebElement colorsDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Red']")
    private WebElement redInDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Green']")
    private WebElement greenInDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Blue']")
    private WebElement blueInDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Yellow']")
    private WebElement yellowInDropDown;

    public ColorsComposite(WebDriver driver) {
        super(driver);
    }

    public void clickDropDown() {
        colorsDropDown.click();
    }

    public void clickRed() {
        redInDropDown.click();
    }

    public void clickGreen() {
        greenInDropDown.click();
    }

    public void clickBlue() {
        blueInDropDown.click();
    }

    public void clickYellow() {
        yellowInDropDown.click();
    }

    public void clickOnColors(String color) {
        if (color == null){
            return;
        }
        clickDropDown();
        switch (color) {
            case YELLOW:
                clickYellow();
                break;
            case BLUE:
                clickBlue();
                break;
            case GREEN:
                clickGreen();
                break;
        }
    }
}
