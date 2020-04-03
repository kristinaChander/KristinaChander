package hw3;

import org.openqa.selenium.WebDriver;

public class AbstractPage extends AbstractPageComposite {
    protected HeaderMenuComposite headerMenuComposite;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        headerMenuComposite = new HeaderMenuComposite(driver);
    }

}
