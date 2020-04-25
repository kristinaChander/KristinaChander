package hw4.ex2;

import hw4.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MetalsAndColorsPage extends AbstractPage {
    private SummaryComposite summaryComposite;
    private ElementsComposite elementsComposite;
    private ColorsComposite colorsComposite;
    private MetalsComposite metalsComposite;
    private VegetablesComposite vegetablesComposite;
    private ResultsComposite resultsComposite;

    @FindBy(id = "submit-button")
    private WebElement submitBtn;

    public ResultsComposite getResultsComposite() {
        return resultsComposite;
    }

    protected MetalsAndColorsPage(WebDriver driver) {
        super(driver);
        summaryComposite = new SummaryComposite(driver);
        elementsComposite = new ElementsComposite(driver);
        colorsComposite = new ColorsComposite(driver);
        metalsComposite = new MetalsComposite(driver);
        vegetablesComposite = new VegetablesComposite(driver);
        resultsComposite = new ResultsComposite(driver);
    }

    public SummaryComposite getSummaryComposite() {
        return summaryComposite;
    }

    public ElementsComposite getElementsComposite() {
        return elementsComposite;
    }

    public ColorsComposite getColorsComposite() {
        return colorsComposite;
    }

    public MetalsComposite getMetalsComposite() {
        return metalsComposite;
    }

    public VegetablesComposite getVegetablesComposite() {
        return vegetablesComposite;
    }

    public void clickSubmitBtn(){
        submitBtn.click();
    }
}
