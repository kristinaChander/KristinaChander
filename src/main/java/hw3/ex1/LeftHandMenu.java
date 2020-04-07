package hw3.ex1;

import hw3.compositepages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LeftHandMenu extends AbstractPageComposite {
    @FindBy(css = ".sidebar-menu>li>a" )
    private List<WebElement> leftSideMenuElements;

    public LeftHandMenu(WebDriver driver) {
        super(driver);
    }
    public int getLeftSideTabsCount(){
        return leftSideMenuElements.size();
    }

    public List<String> getLeftSideTabListText(){
        return leftSideMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
