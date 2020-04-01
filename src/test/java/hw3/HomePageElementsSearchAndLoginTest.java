package hw3;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class HomePageElementsSearchAndLoginTest extends AbstractTestBase {

    @Test
    public void pageTitleTest() {
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test
    public void logInAndCheckUserNameTest() {
        homePage.openLogInForm();
        homePage.enterUserName();
        homePage.enterPassword();
        homePage.clickLoginBtn();

        assertEquals(homePage.getLoggedInUserName(), "ROMAN IOVLEV");
    }

    @Test
    public void headerMenuTest() {
        assertEquals(homePage.getHeaderTabCount(), 4);
        assertTrue(homePage.getHeaderTabNamesList().contains("HOME"));
        assertTrue(homePage.getHeaderTabNamesList().contains("CONTACT FORM"));
        assertTrue(homePage.getHeaderTabNamesList().contains("SERVICE"));
        assertTrue(homePage.getHeaderTabNamesList().contains("METALS & COLORS"));
    }

    @Test
    public void fourImagesTest() {
        assertEquals(homePage.getImagesCount(), 4);
    }

    @Test
    public void benefitTextsTest() {
        assertEquals(homePage.getTextsCount(), 4);

        assertTrue(homePage.getBenefitTexts().contains("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
        assertTrue(homePage.getBenefitTexts().contains("To be flexible and\n" + "customizable"));
        assertTrue(homePage.getBenefitTexts().contains("To be multiplatform"));
        assertTrue(homePage.getBenefitTexts().contains("Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more…"));
    }

    @Test
    public void iFrameTest() {
        assertNotNull(homePage.getIframe());

        driver.switchTo().frame(homePage.getIframe());

        assertNotNull(homePage.getIframeButton());
        driver.switchTo().defaultContent();
    }

    @Test
    public void LeftSideMenuTest(){
        assertEquals(homePage.getLeftSideTabsCount(), 5);

        assertTrue(homePage.getLeftSideTabListText().contains("Home"));
        assertTrue(homePage.getLeftSideTabListText().contains("Contact form"));
        assertTrue(homePage.getLeftSideTabListText().contains("Service"));
        assertTrue(homePage.getLeftSideTabListText().contains("Metals & Colors"));
        assertTrue(homePage.getLeftSideTabListText().contains("Elements packs"));
    }





}
