package hw3.ex2;

import hw3.AbstractTestBase;
import hw3.ex1.HomePageFluent;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeAndElementsFluentTest extends AbstractTestBase {
    @Test
    public void logInGoToElementsTest() {
        ElementsPageFluent elementsPage = new ElementsPageFluent(driver);
        HomePageFluent homePage = new HomePageFluent(driver);
        driver.get(credentialsHelper.getProperty("url"));
        assertEquals(driver.getTitle(), "Home Page");

        //logInAndCheckUserName
        homePage.openLogInForm()
                .enterUserName(credentialsHelper.getProperty("login"))
                .enterPassword(credentialsHelper.getProperty("password"))
                .clickLoginBtn();

        assertEquals(homePage.getLoggedInUserName(), "ROMAN IOVLEV");

        //getToElementsPage
        homePage.clickOnTheServiceTab()
                .clickOnTheDifferentElements()
                .clickWaterCheckBox()//Select checkboxes Water, Wind
                .clickWindCheckBox()
                .clickSelenRadio()//Select radio selen
                .clickColorsDropDown()
                .clickYellow();//Select in dropdown Yellow


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
