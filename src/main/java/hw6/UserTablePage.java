package hw6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return logs.stream().map(s->s.getText().substring(9)).collect(Collectors.toList());


    }
    public int getLogEntryCount(){
        return logs.size();
    }

    public List<Map<String,String>> getTableRows(){
        WebElement headerRow = tableRows.get(0);
        List<String> headerList = getList(headerRow, "th");
        return tableRows.stream()
                .skip(1)
                .map(row -> toRowMap(row, headerList))
                .collect(Collectors.toList());
    }

    private Map<String, String> toRowMap(WebElement row, List<String> headerList) {
        Map<String,String> map = new HashMap<>();
        List<String> columns = getList(row, "td");
        for (int i = 0; i < columns.size(); i++) {
            String header = headerList.get(i);
            String value = columns.get(i);
            if(!"Type".equals(header)) {
                if("Description".equals(header)){
                    map.put(header, value.substring(0, value.length()-3).trim());
                } else{
                    map.put(header, value.trim());
                }
            }
        }
        return map;
    }

    private List<String> getList(WebElement row, String selector){
        return row.findElements(By.cssSelector(selector))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
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

    public List<String> getDropDownValues(){
        dropDownBtn.click();
        return dropDownValues.stream()
                .map(s -> s.getText())
                .collect(Collectors.toList());
    }




}
