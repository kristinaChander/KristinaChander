package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageComposite extends AbstractPage{
    private HomePageMainContentComposite homePageMainContentComposite;
    private LeftHandMenu leftHandMenu;

    public HomePageComposite(WebDriver driver){
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
