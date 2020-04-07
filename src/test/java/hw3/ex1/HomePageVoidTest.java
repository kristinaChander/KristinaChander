package hw3.ex1;

import hw3.AbstractTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

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

        sa.assertEquals(homePageVoid.getHeaderTabNamesList(),
                Arrays.asList(
                        "HOME", "CONTACT FORM", "SERVICE" , "METALS & COLORS")
        );

        // fourImagesTest
        sa.assertEquals(homePageVoid.getImagesCount(), 4);

        //benefitTextsTest
        sa.assertEquals(homePageVoid.getTextsCount(), 4);

        sa.assertEquals(homePageVoid.getBenefitTexts(),
                Arrays.asList(
                        "To include good practices\n" + "and ideas from successful\n" + "EPAM project", "To be flexible and\n" + "customizable",
                        "To be multiplatform",
                        "Already have good base\n" + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more\u2026"
                )
        );

        //iFrameTest
        sa.assertNotNull(homePageVoid.getIframe());
        driver.switchTo().frame(homePageVoid.getIframe());
        sa.assertNotNull(homePageVoid.getIframeButton());
        driver.switchTo().defaultContent();

        //LeftSideMenuTest
        sa.assertEquals(homePageVoid.getLeftSideTabsCount(), 5);

        sa.assertEquals(homePageVoid.getLeftSideTabListText(),
                Arrays.asList(
                        "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"
                )
        );

        sa.assertAll();
    }

}
