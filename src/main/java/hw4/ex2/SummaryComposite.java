package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw4.ex2.SelectUtils.chooseItemFromList;

public class SummaryComposite extends AbstractPageComposite {

    @FindBy(css =".radio label" )
    private List <WebElement> radioList;

    public SummaryComposite(WebDriver driver) {
        super(driver);
    }

    public void chooseNumbers(List <String> numbers){
        chooseItemFromList(numbers,radioList);
    }
}
