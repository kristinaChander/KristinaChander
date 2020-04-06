package hw4.ex2;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw4.ex2.SelectUtils.chooseItemFromList;

public class ElementsComposite extends AbstractPageComposite {

    @FindBy(css = "#elements-checklist label")
    private List<WebElement> elementsList;

    public ElementsComposite(WebDriver driver) {
        super(driver);
    }

    public void chooseElements(List <String> elements){
        if(elements.isEmpty()) {
            return;
        }
        chooseItemFromList(elements,elementsList);
    }
}
