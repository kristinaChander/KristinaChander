package hw3.ex1;

import hw3.AbstractTestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class HomeCompositeTest extends AbstractTestBase {

    @Test
    public void HomePageLogInAndElementsTest() {
        SoftAssert sa = new SoftAssert();

        //go to page
        driver.get(credentialsHelper.getProperty("url"));
        HomePage homePage = new HomePage(driver);

        //assert title
        sa.assertEquals(driver.getTitle(), "Home Page");

        //log in
        homePage.getHeaderMenuComposite().openLogInForm();
        homePage.getHeaderMenuComposite().enterUserName(credentialsHelper.getProperty("login"));
        homePage.getHeaderMenuComposite().enterPassword(credentialsHelper.getProperty("password"));
        homePage.getHeaderMenuComposite().clickLoginBtn();

        //assert logged in user name
        sa.assertEquals(homePage.getHeaderMenuComposite().getLoggedInUserName(), "ROMAN IOVLEV");

        //header menu test
        sa.assertEquals(homePage.getHeaderMenuComposite().getHeaderTabCount(), 4);

        sa.assertEquals(homePage.getHeaderMenuComposite().getHeaderTabNamesList(),
                Arrays.asList(
                        "HOME", "CONTACT FORM", "SERVICE" , "METALS & COLORS")
        );

        // fourImagesTest
        sa.assertEquals(homePage.getHomePageMainContentComposite().getImagesCount(), 4);

        //benefitTextsTest
        sa.assertEquals(homePage.getHomePageMainContentComposite().getTextsCount(), 4);

        sa.assertEquals(homePage.getHomePageMainContentComposite().getBenefitTexts(),
                Arrays.asList(
                        "To include good practices\n" + "and ideas from successful\n" + "EPAM project", "To be flexible and\n" + "customizable",
                        "To be multiplatform",
                        "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more\u2026"
                )
        );

        //iFrameTest
        sa.assertNotNull(homePage.getHomePageMainContentComposite().getIframe());
        driver.switchTo().frame(homePage.getHomePageMainContentComposite().getIframe());
        sa.assertNotNull(homePage.getHomePageMainContentComposite().getIframeButton());
        driver.switchTo().defaultContent();

        //LeftSideMenuTest
        sa.assertEquals(homePage.getLeftHandMenu().getLeftSideTabsCount(), 5);

        sa.assertEquals(homePage.getLeftHandMenu().getLeftSideTabListText(),
                Arrays.asList(
                        "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"
                )
        );

        sa.assertAll();
    }
}
