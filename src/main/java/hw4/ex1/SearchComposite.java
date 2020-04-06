package hw4.ex1;

import hw4.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComposite extends AbstractPageComposite {
    @FindBy(css ="input[type='search']")
    private WebElement searchField;

    public SearchComposite(WebDriver driver) {
        super(driver);
    }
    public void enterSearchedText(String searchedText){
        searchField.sendKeys(searchedText);
    }

    public String getSearchedText(){
        return searchField.getText().toLowerCase();
    }



}
