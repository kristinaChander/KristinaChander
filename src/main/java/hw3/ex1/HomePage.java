package hw3.ex1;

import hw3.compositepages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
    private HomePageMainContentComposite homePageMainContentComposite;
    private LeftHandMenu leftHandMenu;

    public HomePage(WebDriver driver){
        super(driver);
        homePageMainContentComposite = new HomePageMainContentComposite(driver);
        leftHandMenu = new LeftHandMenu(driver);
    }

    public HomePageMainContentComposite getHomePageMainContentComposite() {
        return homePageMainContentComposite;
    }

    public LeftHandMenu getLeftHandMenu() {
        return leftHandMenu;
    }
}
