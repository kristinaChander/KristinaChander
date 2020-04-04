package hw3.ex2;

import hw3.compositepages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends AbstractPage {

    private ElementMetalColorComposite elementMetalColorComposite;
    private LogComposite logComposite;

    public ElementMetalColorComposite getElementMetalColorComposite() {
        return elementMetalColorComposite;
    }

    public LogComposite getLogComposite() {
        return logComposite;
    }

    public ElementsPage(WebDriver driver){
        super(driver);
        elementMetalColorComposite = new ElementMetalColorComposite(driver);
        logComposite = new LogComposite(driver);
    }
}
