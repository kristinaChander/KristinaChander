package hw3.composite_tests;

import hw3.AbstractTestBase;
import hw3.compositepages.HomePageComp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CompositeTestHome extends AbstractTestBase {

    @Test
    public void HomePageLogInAndElementsTest() {
        SoftAssert sa = new SoftAssert();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        HomePageComp homePage = new HomePageComp(driver);

        sa.assertEquals(driver.getTitle(), "Home Page");

        homePage.getHeaderMenuComposite().openLogInForm();
        homePage.getHeaderMenuComposite().enterUserName();
        homePage.getHeaderMenuComposite().enterPassword();
        homePage.getHeaderMenuComposite().clickLoginBtn();

        sa.assertEquals(homePage.getHeaderMenuComposite().getLoggedInUserName(), "ROMAN IOVLEV");

        sa.assertEquals(homePage.getHeaderMenuComposite().getHeaderTabCount(), 4);
        sa.assertTrue(homePage.getHeaderMenuComposite().getHeaderTabNamesList().contains("HOME"));
        sa.assertTrue(homePage.getHeaderMenuComposite().getHeaderTabNamesList().contains("CONTACT FORM"));
        sa.assertTrue(homePage.getHeaderMenuComposite().getHeaderTabNamesList().contains("SERVICE"));
        sa.assertTrue(homePage.getHeaderMenuComposite().getHeaderTabNamesList().contains("METALS & COLORS"));

        // fourImagesTest
        sa.assertEquals(homePage.getHomePageMainContentComposite().getImagesCount(), 4);

        //benefitTextsTest
        sa.assertEquals(homePage.getHomePageMainContentComposite().getTextsCount(), 4);

        sa.assertTrue(homePage.getHomePageMainContentComposite().getBenefitTexts().contains("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
        sa.assertTrue(homePage.getHomePageMainContentComposite().getBenefitTexts().contains("To be flexible and\n" + "customizable"));
        sa.assertTrue(homePage.getHomePageMainContentComposite().getBenefitTexts().contains("To be multiplatform"));
        sa.assertTrue(homePage.getHomePageMainContentComposite().getBenefitTexts().contains("Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more\u2026"));


        //iFrameTest
        sa.assertNotNull(homePage.getHomePageMainContentComposite().getIframe());
        driver.switchTo().frame(homePage.getHomePageMainContentComposite().getIframe());
        sa.assertNotNull(homePage.getHomePageMainContentComposite().getIframeButton());
        driver.switchTo().defaultContent();


        //LeftSideMenuTest

        sa.assertEquals(homePage.getLeftHandMenu().getLeftSideTabsCount(), 5);

        sa.assertTrue(homePage.getLeftHandMenu().getLeftSideTabListText().contains("Home"));
        sa.assertTrue(homePage.getLeftHandMenu().getLeftSideTabListText().contains("Contact form"));
        sa.assertTrue(homePage.getLeftHandMenu().getLeftSideTabListText().contains("Service"));
        sa.assertTrue(homePage.getLeftHandMenu().getLeftSideTabListText().contains("Metals & Colors"));
        sa.assertTrue(homePage.getLeftHandMenu().getLeftSideTabListText().contains("Elements packs"));

        sa.assertAll();
    }
}
