package hw4.ex1;

import hw4.AbstractBaseTestHw4;
import hw4.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FirstExerciseTest extends AbstractBaseTestHw4 {

    @Test
    public void logInEntryDropdownTest(){
        HomePage homePage = new HomePage(driver);
        TableWithPages tableWithPages = new TableWithPages(driver);
        //1.open site by url
        driver.get(credentialsHelper.getProperty("url"));

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        homePage.getHeaderMenuComposite().openLogInForm();
        homePage.getHeaderMenuComposite().enterUserName(credentialsHelper.getProperty("login"));
        homePage.getHeaderMenuComposite().enterPassword(credentialsHelper.getProperty("password"));
        homePage.getHeaderMenuComposite().clickLoginBtn();

        //4. Assert Username is logged in
        assertEquals(homePage.getHeaderMenuComposite().getLoggedInUserName(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Table with pages
        homePage.getHeaderMenuComposite().clickOnTheServiceTab();
        homePage.getHeaderMenuComposite().clickOnTableWithPagesLink();

        //6. Check that default value for “Show entries” dropdown is 5
        assertEquals(tableWithPages.getTableLenghtChoiceComposite().getDefaultTableLength(),5);

        //7. Select new value for the entries in the dropdown list
        // Selected value should be 10
        tableWithPages.getTableLenghtChoiceComposite().changeTableLengthToTen();

        //8. Assert that in the table displayed corrected amount of entries
        assertEquals(tableWithPages.getTableComposite().getTableRowsCount(),10);

        //9. Type in “Search” text field "junit"
        tableWithPages.getSearchComposite().enterSearchedText("junit");

        //10. Assert the table contains only records with Search field value
        for (String entry: tableWithPages.getTableComposite().getTableTexts()) {
            assertTrue(entry.contains(tableWithPages.getSearchComposite().getSearchedText()));
        }
    }
}
