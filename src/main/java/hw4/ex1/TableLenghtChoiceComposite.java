package hw4.ex1;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TableLenghtChoiceComposite extends AbstractPageComposite {

    @FindBy(css = "#table-with-pages_length .uui-form-element")
    private WebElement tableWithPageLength;

    @FindBy(xpath = "//*[text()='10']")
    private WebElement lengthTen;

    public TableLenghtChoiceComposite(WebDriver driver) {
        super(driver);
    }

    public int getDefaultTableLength(){
        return Integer.valueOf(tableWithPageLength.getText().split("\n")[0]);
    }

    public void changeTableLengthToTen(){
        tableWithPageLength.click();
        lengthTen.click();
    }
}
