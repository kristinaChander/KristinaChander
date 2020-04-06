package hw4.ex2;


import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MetalsComposite extends AbstractPageComposite {

    public static final String BRONZE = "Bronze";
    public static final String GOLD = "Gold";
    public static final String SELEN = "Selen";

    @FindBy(css = "#metals .caret")
    private WebElement metalsDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Gold']")
    private WebElement goldInDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Silver']")
    private WebElement silverInDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Bronze']")
    private WebElement bronzeInDropDown;

    @FindBy(xpath = "//*[@class='text'][text()='Selen']")
    private WebElement selenInDropDown;

    public MetalsComposite(WebDriver driver) {
        super(driver);
    }

    public void clickOnMetalsDropDown() {
        metalsDropDown.click();
    }

    public void clickOnGold() {
        goldInDropDown.click();
    }

    public void clickOnSilver() {
        silverInDropDown.click();
    }

    public void clickOnSelen() {
        selenInDropDown.click();
    }

    public void clickOnBronze() {
        bronzeInDropDown.click();
    }

    public void clickOnMetals(String metal) {
        if (metal == null) {
            return;
        }
        clickOnMetalsDropDown();
        switch (metal) {
            case GOLD:
                clickOnGold();
                break;
            case SELEN:
                clickOnSelen();
                break;
            case BRONZE:
                clickOnBronze();
                break;
        }
    }
}
