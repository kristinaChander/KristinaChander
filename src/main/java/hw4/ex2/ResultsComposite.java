package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsComposite extends AbstractPageComposite {


    @FindBy(className = "summ-res")
    private WebElement summaryResult;

    @FindBy(className = "col-res")
    private WebElement colorsResult;

    @FindBy(className ="met-res" )
    private WebElement metalsResult;

    @FindBy(className = "sal-res")
    private WebElement vegetablesResult;

    @FindBy(className = "elem-res")
    private WebElement elementsResult;

    public ResultsComposite(WebDriver driver) {
        super(driver);
    }

    public String getSummaryResult(){
        return summaryResult.getText();
    }

    public String getColorResult(){
        return colorsResult.getText();
    }

    public String getMetalResult(){
        return metalsResult.getText();
    }

    public String getElementResult(){
        return elementsResult.getText();
    }

    public String getVegetableResult(){
        return vegetablesResult.getText();
    }
}
