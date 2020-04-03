package hw3.compositepages;

import org.openqa.selenium.WebDriver;

public class ElementsPageComp extends AbstractPage {

    private ElementMetalColorComposite elementMetalColorComposite;
    private LogComposite logComposite;

    public ElementMetalColorComposite getElementMetalColorComposite() {
        return elementMetalColorComposite;
    }

    public LogComposite getLogComposite() {
        return logComposite;
    }

    public ElementsPageComp(WebDriver driver){
        super(driver);
        elementMetalColorComposite = new ElementMetalColorComposite(driver);
        logComposite = new LogComposite(driver);
    }
}
