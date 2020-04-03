package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ElementsPageComposite extends AbstractPage {

    private ElementMetalColorComposite elementMetalColorComposite;
    private LogComposite logComposite;

    public ElementMetalColorComposite getElementMetalColorComposite() {
        return elementMetalColorComposite;
    }

    public LogComposite getLogComposite() {
        return logComposite;
    }

    public ElementsPageComposite(WebDriver driver){
        super(driver);
        elementMetalColorComposite = new ElementMetalColorComposite(driver);
        logComposite = new LogComposite(driver);
    }
}
