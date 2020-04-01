package hw3;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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

    }

}
