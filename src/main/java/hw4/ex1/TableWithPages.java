package hw4.ex1;

import hw4.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TableWithPages extends AbstractPage {

    private TableLenghtChoiceComposite tableLenghtChoiceComposite;
    private TableComposite tableComposite;
    private SearchComposite searchComposite;

    public TableWithPages(WebDriver driver) {
        super(driver);
        tableLenghtChoiceComposite = new TableLenghtChoiceComposite(driver);
        tableComposite = new TableComposite(driver);
        searchComposite = new SearchComposite(driver);
    }

    public TableLenghtChoiceComposite getTableLenghtChoiceComposite() {
        return tableLenghtChoiceComposite;
    }

    public TableComposite getTableComposite() {
        return tableComposite;
    }

    public SearchComposite getSearchComposite() {
        return searchComposite;
    }
}
