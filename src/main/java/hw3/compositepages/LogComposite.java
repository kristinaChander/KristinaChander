package hw3.compositepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LogComposite extends AbstractPageComposite {
    @FindBy(css = ".logs>li")
    private List<WebElement> logList;

    public LogComposite(WebDriver driver) {
        super(driver);
    }

    public int getLogEntryCount(){
        return logList.size();
    }

    public List<String> getFilteredLogsText(){
        return logList.stream()
                .map(s -> s.getText().substring(9))
                .collect(Collectors.toList());
    }

}
