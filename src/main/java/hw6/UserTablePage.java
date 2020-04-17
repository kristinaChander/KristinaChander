package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends AbstractPage {

    @FindBy(css = "#user-table select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "#user-table a")
    private List<WebElement> usernames;

    @FindBy(css = ".user-descr span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(css = "tr:nth-child(2)>td:nth-child(2) option")
    private List<WebElement> dropDownValues;

    @FindBy(css = "tr:nth-child(2)>td:nth-child(2) select")
    private WebElement dropDownBtn;

    @FindBy(css = "#user-table tr")
    private List<WebElement> tableRows;

    @FindBy(id = "ivan")
    private WebElement vipForSergeyIvan;

    @FindBy(css = ".logs li")
    private List<WebElement> logs;

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public void makeSergeyIvanVip(){
        vipForSergeyIvan.click();
    }

    public List <String> getLogsText(){
        return logs.stream().map(s->getText(s).substring(9)).collect(Collectors.toList());
    }

    public int getLogEntryCount(){
        return logs.size();
    }

    public List<String> getListFromRow(WebElement row, String sel){
        List<String> list = new ArrayList<>();
        List<WebElement> elements = row.findElements(By.cssSelector(sel));
        for (int i = 0; i <elements.size() ; i++) {
            list.add(elements.get(i).getText());
        }
        return list;
    }

    public List<UserTableRow> userTableRowList(){
        List<String> headerRow = getListFromRow(tableRows.get(0), "th");
        int numberPosition = headerRow.indexOf("Number");
        int userPosition = headerRow.indexOf("User");
        int descriptionPosition = headerRow.indexOf("Description");

        List<UserTableRow> list = new ArrayList<>();
        for (int i = 1; i < tableRows.size(); i++) {
            WebElement row = tableRows.get(i);
            List<String> listFromRow = getListFromRow(row, "td");
            String number = listFromRow.get(numberPosition);
            String user = listFromRow.get(userPosition);
            String description = listFromRow.get(descriptionPosition);
            list.add(new UserTableRow(number, user, description.substring(0, description.length()-3).trim()));
        }

        return list;
    }

    public  int getNumberTypeDropdownsCount() {
        return numberTypeDropdowns.size();
    }

    public  int getUserNamesCount() {
        return usernames.size();
    }

    public  int getDescriptionTextsCount() {
        return descriptionTexts.size();
    }

    public int getCheckBoxCount(){
        return checkboxes.size();
    }

    public List<DropDownRow> getDropDownValues(){
        dropDownBtn.click();
        return dropDownValues.stream()
                .map(s -> new DropDownRow(s.getText()))
                .collect(Collectors.toList());
    }
}
