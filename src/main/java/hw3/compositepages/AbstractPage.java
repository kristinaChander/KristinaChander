package hw3.compositepages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractPageComposite {
    protected HeaderMenuComposite headerMenuComposite;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        headerMenuComposite = new HeaderMenuComposite(driver);
    }

    public HeaderMenuComposite getHeaderMenuComposite() {
        return headerMenuComposite;
    }
}
