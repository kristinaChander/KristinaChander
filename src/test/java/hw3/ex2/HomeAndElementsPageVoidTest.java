package hw3.ex2;

import hw3.AbstractTestBase;
import hw3.ex1.HomePageVoid;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeAndElementsPageVoidTest extends AbstractTestBase {

    @Test
    public void logInGoToElementsTest() {
        ElementsPageVoid elementsVoidPage = PageFactory.initElements(driver, ElementsPageVoid.class);
        HomePageVoid homePageVoid = PageFactory.initElements(driver, HomePageVoid.class);
        driver.get(credentialsHelper.getProperty("url"));
        assertEquals(driver.getTitle(), "Home Page");

        //logInAndCheckUserName
        homePageVoid.openLogInForm();
        homePageVoid.enterUserName(credentialsHelper.getProperty("login"));
        homePageVoid.enterPassword(credentialsHelper.getProperty("password"));
        homePageVoid.clickLoginBtn();

        assertEquals(homePageVoid.getLoggedInUserName(), "ROMAN IOVLEV");

        //getToElementsPage
        homePageVoid.clickOnTheServiceTab();
        homePageVoid.clickOnTheDifferentElements();

        //Select checkboxes Water, Wind
        elementsVoidPage.clickWaterCheckBox();
        elementsVoidPage.clickWindCheckBox();

        //Select radio selen
        elementsVoidPage.clickSelenRadio();

        //Select in dropdown Yellow
        elementsVoidPage.clickColorsDropDown();
        elementsVoidPage.clickYellow();

        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertEquals(elementsVoidPage.getLogEntryCount(), 4);

        assertTrue(elementsVoidPage.getFilteredLogsText().contains("Colors: value changed to Yellow"));
        assertTrue(elementsVoidPage.getFilteredLogsText().contains("metal: value changed to Selen"));
        assertTrue(elementsVoidPage.getFilteredLogsText().contains("Wind: condition changed to true"));
        assertTrue(elementsVoidPage.getFilteredLogsText().contains("Water: condition changed to true"));


    }
}
