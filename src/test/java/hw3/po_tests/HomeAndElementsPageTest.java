package hw3.po_tests;

import hw3.AbstractTestBase;
import hw3.voidpo.ElementsPage;
import hw3.voidpo.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeAndElementsPageTest extends AbstractTestBase {

    @Test
    public void logInGoToElementsTest() {
        ElementsPage elementsPage = PageFactory.initElements(driver, ElementsPage.class);
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        driver.get(credentialsHelper.getProperty("url"));
        assertEquals(driver.getTitle(), "Home Page");

        //logInAndCheckUserName
        homePage.openLogInForm();
        homePage.enterUserName(credentialsHelper.getProperty("login"));
        homePage.enterPassword(credentialsHelper.getProperty("password"));
        homePage.clickLoginBtn();

        assertEquals(homePage.getLoggedInUserName(), "ROMAN IOVLEV");

        //getToElementsPage
        homePage.clickOnTheServiceTab();
        homePage.clickOnTheDifferentElements();

        //Select checkboxes Water, Wind
        elementsPage.clickWaterCheckBox();
        elementsPage.clickWindCheckBox();

        //Select radio selen
        elementsPage.clickSelenRadio();

        //Select in dropdown Yellow
        elementsPage.clickColorsDropDown();
        elementsPage.clickYellow();

        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertEquals(elementsPage.getLogEntryCount(), 4);

        assertTrue(elementsPage.getFilteredLogsText().contains("Colors: value changed to Yellow"));
        assertTrue(elementsPage.getFilteredLogsText().contains("metal: value changed to Selen"));
        assertTrue(elementsPage.getFilteredLogsText().contains("Wind: condition changed to true"));
        assertTrue(elementsPage.getFilteredLogsText().contains("Water: condition changed to true"));


    }
}
