package hw3.ex2;

import hw3.AbstractTestBase;
import hw3.ex1.HomePageFluent;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

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
                .clickCheckButtonsFromList("Water")//Select checkboxes Water, Wind
                .clickCheckButtonsFromList("Wind")
                .clickRadioButtonsFromList("Selen")//Select radio selen
                .chooseColorFromDropDown("Yellow");//Select in dropdown Yellow

        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertEquals(elementsPage.getLogEntryCount(), 4);

        assertEquals(elementsPage.getFilteredLogsText(),
                Arrays.asList(
                        "Colors: value changed to Yellow",  "metal: value changed to Selen",
                        "Wind: condition changed to true", "Water: condition changed to true")
        );


    }
}
