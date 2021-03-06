package hw3.compositepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageComposite {

    protected WebDriver driver;

    public AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
