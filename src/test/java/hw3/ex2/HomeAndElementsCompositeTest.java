package hw3.ex2;

import hw3.AbstractTestBase;
import hw3.ex1.HomePage;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class HomeAndElementsCompositeTest extends AbstractTestBase {

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
        elementsPage.getElementMetalColorComposite().clickCheckButtonsFromList("Water");
        elementsPage.getElementMetalColorComposite().clickCheckButtonsFromList("Wind");

        //Select radio selen
        elementsPage.getElementMetalColorComposite().clickRadioButtonsFromList("Selen");

        //Select in dropdown Yellow
        elementsPage.getElementMetalColorComposite().chooseColorFromDropDown("Yellow");

        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        assertEquals(elementsPage.getLogComposite().getLogEntryCount(), 4);

        assertEquals(elementsPage.getLogComposite().getFilteredLogsText(),
                Arrays.asList(
                        "Colors: value changed to Yellow",  "metal: value changed to Selen",
                        "Wind: condition changed to true", "Water: condition changed to true")
        );
    }
}
