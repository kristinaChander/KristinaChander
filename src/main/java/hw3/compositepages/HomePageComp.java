package hw3.compositepages;

import org.openqa.selenium.WebDriver;

public class HomePageComp extends AbstractPage{
    private HomePageMainContentComposite homePageMainContentComposite;
    private LeftHandMenu leftHandMenu;

    public HomePageComp(WebDriver driver){
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
