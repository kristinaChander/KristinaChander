package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SummaryComposite extends AbstractPageComposite {

    @FindBy(xpath = "//label[text()='2']")
    private WebElement radioTwo;

    @FindBy(xpath = "//label[text()='3']")
    private WebElement radioThree;

    @FindBy(xpath = "//label[text()='5']")
    private WebElement radioFive;

    @FindBy(xpath = "//label[text()='6']")
    private WebElement radioSix;

    @FindBy(xpath = "//label[text()='8']")
    private WebElement radioEight;

    public SummaryComposite(WebDriver driver) {
        super(driver);
    }
    public void clickRadioTwo(){
        radioTwo.click();
    }
    public void clickRadioThree(){
        radioThree.click();
    }
    public void clickRadioFive(){
        radioFive.click();
    }
    public void clickRadioSix(){
        radioSix.click();
    }
    public void clickRadioEight(){
        radioEight.click();
    }

    public void clickOnNumbers(List<Integer> numbers){
        for (Integer number: numbers) {
            switch (number){
                case 2:
                    clickRadioTwo();
                    break;
                case 3:
                    clickRadioThree();
                    break;
                case 5:
                    clickRadioFive();
                    break;
                case 6:
                    clickRadioSix();
                    break;
                case 8:
                    clickRadioEight();
                    break;
            }

        }
    }

}
