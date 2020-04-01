package hw3;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageElementsSearchAndLoginTest extends AbstractTestBase{

    @Test
    public void pageTitleTest(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        assertEquals(driver.getTitle(), "Home Page");
    }

    @Test
    public void logInAndCheckUserNameTest(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        HomePage homePage = new HomePage();
        homePage.openLogInForm();
        homePage.enterUserName();
        homePage.enterPassword();
        homePage.clickLoginBtn();
        assertEquals(homePage.getLoggedInUserName(),"ROMAN IOVLEV");
    }

    @Test
    public void headerMenuTest(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        HomePage homePage = new HomePage();
        assertEquals(homePage.getHeaderTabCount(),4);
        assertTrue(homePage.getHeaderTabNamesList().contains("HOME"));
        assertTrue(homePage.getHeaderTabNamesList().contains("CONTACT FORM"));
        assertTrue(homePage.getHeaderTabNamesList().contains("SERVICE"));
        assertTrue(homePage.getHeaderTabNamesList().contains("METALS & COLORS"));

    }

    @Test
    public void fourImagesTest(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        HomePage homePage = new HomePage();
        assertEquals(homePage.getImagesCount(),4);
    }

    @Test
    public void benefitTextsTest(){
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        HomePage homePage = new HomePage();
        assertEquals(homePage.getTextsCount(),4);

        assertTrue(homePage.getBenefitTexts().contains("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
        assertTrue(homePage.getBenefitTexts().contains("To be flexible and\n" + "customizable"));
        assertTrue(homePage.getBenefitTexts().contains("To be multiplatform"));
        assertTrue(homePage.getBenefitTexts().contains("Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more…"));
    }

}
