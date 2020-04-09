package hw4.ex2;


import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static hw4.ex2.SelectUtils.chooseItemFromList;

public class MetalsComposite extends AbstractPageComposite {

    @FindBy(css = "#metals .caret")
    private WebElement metalsDropDown;

    @FindBy(css = "#metals a")
    private List<WebElement> metalsList;

    public MetalsComposite(WebDriver driver) {
        super(driver);
    }

    public void chooseMetal(List <String> metals){
        if(metals.isEmpty()) {
            return;
        }
        metalsDropDown.click();
       chooseItemFromList(metals,metalsList);
    }
}
