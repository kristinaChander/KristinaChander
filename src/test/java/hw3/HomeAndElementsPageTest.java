package hw3;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeAndElementsPageTest extends AbstractTestBase {

    @Test
    public void logInGoToElementsTest() {
        SoftAssert sa = new SoftAssert();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        sa.assertEquals(driver.getTitle(), "Home Page");


        //logInAndCheckUserName
        homePage.openLogInForm();
        homePage.enterUserName();
        homePage.enterPassword();
        homePage.clickLoginBtn();

        sa.assertEquals(homePage.getLoggedInUserName(), "ROMAN IOVLEV");

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
        sa.assertEquals(elementsPage.getLogEntryCount(), 4);

        sa.assertTrue(elementsPage.getFilteredLogsText().contains("Colors: value changed to Yellow"));
        sa.assertTrue(elementsPage.getFilteredLogsText().contains("metal: value changed to Selen"));
        sa.assertTrue(elementsPage.getFilteredLogsText().contains("Wind: condition changed to true"));
        sa.assertTrue(elementsPage.getFilteredLogsText().contains("Water: condition changed to true"));

        sa.assertAll();
    }
}
