package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPageComposite {

    protected WebDriver driver;

    public AbstractPageComposite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
