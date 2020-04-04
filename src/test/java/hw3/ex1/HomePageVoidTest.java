package hw3.ex1;

import hw3.AbstractTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageVoidTest extends AbstractTestBase {

    @Test
    public void logInAndFindTabsAndFrameTest() {
        HomePageVoid homePageVoid = PageFactory.initElements(driver, HomePageVoid.class);
        SoftAssert sa = new SoftAssert();
        //pageTitle
        driver.get(credentialsHelper.getProperty("url"));

        sa.assertEquals(driver.getTitle(), "Home Page");

        //logInAndCheckUserName
        homePageVoid.openLogInForm();
        homePageVoid.enterUserName(credentialsHelper.getProperty("login"));
        homePageVoid.enterPassword(credentialsHelper.getProperty("password"));
        homePageVoid.clickLoginBtn();

        sa.assertEquals(homePageVoid.getLoggedInUserName(), "ROMAN IOVLEV");

        //headerMenuTest
        sa.assertEquals(homePageVoid.getHeaderTabCount(), 4);
        sa.assertTrue(homePageVoid.getHeaderTabNamesList().contains("HOME"));
        sa.assertTrue(homePageVoid.getHeaderTabNamesList().contains("CONTACT FORM"));
        sa.assertTrue(homePageVoid.getHeaderTabNamesList().contains("SERVICE"));
        sa.assertTrue(homePageVoid.getHeaderTabNamesList().contains("METALS & COLORS"));

        // fourImagesTest
        sa.assertEquals(homePageVoid.getImagesCount(), 4);

        //benefitTextsTest
        sa.assertEquals(homePageVoid.getTextsCount(), 4);

        sa.assertTrue(homePageVoid.getBenefitTexts().contains("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
        sa.assertTrue(homePageVoid.getBenefitTexts().contains("To be flexible and\n" + "customizable"));
        sa.assertTrue(homePageVoid.getBenefitTexts().contains("To be multiplatform"));
        sa.assertTrue(homePageVoid.getBenefitTexts().contains("Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more\u2026"));


        //iFrameTest
        sa.assertNotNull(homePageVoid.getIframe());
        driver.switchTo().frame(homePageVoid.getIframe());
        sa.assertNotNull(homePageVoid.getIframeButton());
        driver.switchTo().defaultContent();


        //LeftSideMenuTest

        sa.assertEquals(homePageVoid.getLeftSideTabsCount(), 5);

        sa.assertTrue(homePageVoid.getLeftSideTabListText().contains("Home"));
        sa.assertTrue(homePageVoid.getLeftSideTabListText().contains("Contact form"));
        sa.assertTrue(homePageVoid.getLeftSideTabListText().contains("Service"));
        sa.assertTrue(homePageVoid.getLeftSideTabListText().contains("Metals & Colors"));
        sa.assertTrue(homePageVoid.getLeftSideTabListText().contains("Elements packs"));

        sa.assertAll();
    }

}
