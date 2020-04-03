package hw3.composite_tests;

import hw3.AbstractTestBase;
import hw3.compositepages.ElementsPage;
import hw3.compositepages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CompositeTestHomeAndElements extends AbstractTestBase {

    @Test
    public void logInGoToElementsTest() {
        ElementsPage elementsPage = new ElementsPage(driver);
        HomePage homePage = new HomePage(driver);

        driver.get(credentialsHelper.getProperty("url"));
        assertEquals(driver.getTitle(), "Home Page");

        //logInAndCheckUserName
        homePage.getHeaderMenuComposite().openLogInForm();
        homePage.getHeaderMenuComposite().enterUserName(credentialsHelper.getProperty("login"));
        homePage.getHeaderMenuComposite().enterPassword(credentialsHelper.getProperty("password"));
        homePage.getHeaderMenuComposite().clickLoginBtn();

        assertEquals(homePage.getHeaderMenuComposite().getLoggedInUserName(), "ROMAN IOVLEV");

        //getToElementsPage
        homePage.getHeaderMenuComposite().clickOnTheServiceTab();
        homePage.getHeaderMenuComposite().clickOnTheDifferentElements();

        //Select checkboxes Water, Wind
        elementsPage.getElementMetalColorComposite().clickWaterCheckBox();
        elementsPage.getElementMetalColorComposite().clickWindCheckBox();

        //Select radio selen
        elementsPage.getElementMetalColorComposite().clickSelenRadio();

        //Select in dropdown Yellow
        elementsPage.getElementMetalColorComposite().clickColorsDropDown();
        elementsPage.getElementMetalColorComposite().clickYellow();

        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertEquals(elementsPage.getLogComposite().getLogEntryCount(), 4);

        assertTrue(elementsPage.getLogComposite().getFilteredLogsText().contains("Colors: value changed to Yellow"));
        assertTrue(elementsPage.getLogComposite().getFilteredLogsText().contains("metal: value changed to Selen"));
        assertTrue(elementsPage.getLogComposite().getFilteredLogsText().contains("Wind: condition changed to true"));
        assertTrue(elementsPage.getLogComposite().getFilteredLogsText().contains("Water: condition changed to true"));
    }
}
