package hw4.ex1;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TableComposite extends AbstractPageComposite {

    @FindBy(css = "tbody>tr")
    private List<WebElement> tableRows;

    public TableComposite(WebDriver driver) {
        super(driver);
    }

    public int getTableRowsCount(){
        return tableRows.size();
    }

    public List<String> getTableTexts(){
        List<String> tableTexts = tableRows.stream()
                .map(s->s.getText().toLowerCase())
                .collect(Collectors.toList());
        return tableTexts;
    }


}
