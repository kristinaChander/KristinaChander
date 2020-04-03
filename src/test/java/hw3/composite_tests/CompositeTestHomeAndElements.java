package hw3.composite_tests;

import hw3.AbstractTestBase;
import hw3.compositepages.ElementsPageComp;
import hw3.compositepages.HomePageComp;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CompositeTestHomeAndElements extends AbstractTestBase {

    @Test
    public void logInGoToElementsTest() {

        ElementsPageComp elementsPage = PageFactory.initElements(driver, ElementsPageComp.class);
        HomePageComp homePage = PageFactory.initElements(driver, HomePageComp.class);

        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        assertEquals(driver.getTitle(), "Home Page");

        //logInAndCheckUserName
        homePage.getHeaderMenuComposite().openLogInForm();
        homePage.getHeaderMenuComposite().enterUserName();
        homePage.getHeaderMenuComposite().enterPassword();
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
