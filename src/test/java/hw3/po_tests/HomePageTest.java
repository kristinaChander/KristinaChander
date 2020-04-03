package hw3.po_tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends AbstractTestBase {

    @Test
    public void logInAndFindTabsAndFrameTest() {
        SoftAssert sa = new SoftAssert();
        //pageTitle
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        sa.assertEquals(driver.getTitle(), "Home Page");

        //logInAndCheckUserName
        homePage.openLogInForm();
        homePage.enterUserName();
        homePage.enterPassword();
        homePage.clickLoginBtn();

        sa.assertEquals(homePage.getLoggedInUserName(), "ROMAN IOVLEV");


        //headerMenuTest
        sa.assertEquals(homePage.getHeaderTabCount(), 4);
        sa.assertTrue(homePage.getHeaderTabNamesList().contains("HOME"));
        sa.assertTrue(homePage.getHeaderTabNamesList().contains("CONTACT FORM"));
        sa.assertTrue(homePage.getHeaderTabNamesList().contains("SERVICE"));
        sa.assertTrue(homePage.getHeaderTabNamesList().contains("METALS & COLORS"));

        // fourImagesTest
        sa.assertEquals(homePage.getImagesCount(), 4);

        //benefitTextsTest
        sa.assertEquals(homePage.getTextsCount(), 4);

        sa.assertTrue(homePage.getBenefitTexts().contains("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
        sa.assertTrue(homePage.getBenefitTexts().contains("To be flexible and\n" + "customizable"));
        sa.assertTrue(homePage.getBenefitTexts().contains("To be multiplatform"));
        sa.assertTrue(homePage.getBenefitTexts().contains("Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more\u2026"));


        //iFrameTest
        sa.assertNotNull(homePage.getIframe());
        driver.switchTo().frame(homePage.getIframe());
        sa.assertNotNull(homePage.getIframeButton());
        driver.switchTo().defaultContent();


        //LeftSideMenuTest

        sa.assertEquals(homePage.getLeftSideTabsCount(), 5);

        sa.assertTrue(homePage.getLeftSideTabListText().contains("Home"));
        sa.assertTrue(homePage.getLeftSideTabListText().contains("Contact form"));
        sa.assertTrue(homePage.getLeftSideTabListText().contains("Service"));
        sa.assertTrue(homePage.getLeftSideTabListText().contains("Metals & Colors"));
        sa.assertTrue(homePage.getLeftSideTabListText().contains("Elements packs"));

        sa.assertAll();
    }

}
