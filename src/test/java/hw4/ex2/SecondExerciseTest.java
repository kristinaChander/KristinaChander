package hw4.ex2;

import hw4.AbstractBaseTesthw4;
import hw4.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static hw4.ex2.ColorsComposite.*;
import static hw4.ex2.ElementsComposite.*;
import static hw4.ex2.MetalsComposite.*;
import static hw4.ex2.VegetablesComposite.*;
import static org.testng.Assert.assertEquals;

public class SecondExerciseTest extends AbstractBaseTesthw4 {



    private static final String LIST_SEPARATOR = ", ";

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {
                    new TestCaseData.Builder()
                        .addElement(EARTH)
                        .setColors(YELLOW)
                        .setMetals(GOLD)
                        .setExpectedElements(EARTH)
                        .setExpectedColor(YELLOW)
                        .setExpectedMetal(GOLD)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addSummary(3)
                        .addSummary(8)
                        .addVegetable(CUCUMBER)
                        .addVegetable(TOMATO)
                        .setExpectedSummary(11)
                        .setExpectedVegetables(CUCUMBER + LIST_SEPARATOR + TOMATO)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addSummary(3)
                        .addSummary(2)
                        .addElement(WIND)
                        .addElement(FIRE)
                        .addElement(WATER)
                        .setMetals(BRONZE)
                        .addVegetable(ONION)
                        .setExpectedSummary(5)
                        .setExpectedElements(WIND + LIST_SEPARATOR + FIRE + LIST_SEPARATOR + WATER)
                        .setExpectedMetal(BRONZE)
                        .setExpectedVegetables(ONION)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addSummary(6)
                        .addSummary(5)
                        .addElement(WATER)
                        .setColors(GREEN)
                        .setMetals(SELEN)
                        .addVegetable(VEGETABLES)
                        .addVegetable(CUCUMBER)
                        .addVegetable(TOMATO)
                        .addVegetable(ONION)
                        .setExpectedSummary(11)
                        .setExpectedElements(WATER)
                        .setExpectedColor(GREEN)
                        .setExpectedMetal(SELEN)
                        .setExpectedVegetables(VEGETABLES + LIST_SEPARATOR + CUCUMBER + LIST_SEPARATOR + TOMATO + LIST_SEPARATOR + ONION)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addElement(FIRE)
                        .setColors(BLUE)
                        .addVegetable(CUCUMBER)
                        .addVegetable(TOMATO)
                        .addVegetable(VEGETABLES)
                        .setExpectedColor(BLUE)
                        .setExpectedElements(FIRE)
                        .setExpectedVegetables(TOMATO + LIST_SEPARATOR + ONION)
                        .build()
                }
        };
    }

    @Test(dataProvider = "testData")
    public void logInAndFillFormTest(TestCaseData testCaseData) {
        HomePage homePage = new HomePage(driver);
        MetalsAndColorsPage metalsAndColorsPage= new MetalsAndColorsPage(driver);
        //1.open site by url
        driver.get(credentialsHelper.getProperty("url"));

        //2.  Perform login
        homePage.getHeaderMenuComposite().openLogInForm();
        homePage.getHeaderMenuComposite().enterUserName(credentialsHelper.getProperty("login"));
        homePage.getHeaderMenuComposite().enterPassword(credentialsHelper.getProperty("password"));
        homePage.getHeaderMenuComposite().clickLoginBtn();

        //3. Click on the link Metal & Colors on the Header section
        homePage.getHeaderMenuComposite().clickOnMetalsAndColors();

        //4. Fill form on the page
        metalsAndColorsPage.getSummaryComposite().clickOnNumbers(testCaseData.getSummary());
        metalsAndColorsPage.getColorsComposite().clickOnColors(testCaseData.getColors());
        metalsAndColorsPage.getElementsComposite().clickOnElement(testCaseData.getElements());
        metalsAndColorsPage.getVegetablesComposite().clickOnVegetable(testCaseData.getVegetables());
        metalsAndColorsPage.getMetalsComposite().clickOnMetals(testCaseData.getMetals());

        //5. Click “Submit” button
        metalsAndColorsPage.clickSubmitBtn();

        //6. Check Results block output on the right-side
        if(testCaseData.getExpectedSummary()!= null){
            assertEquals(metalsAndColorsPage.getResultsComposite().getSummaryResult(),"Summary: " + testCaseData.getExpectedSummary());
        }

        if(testCaseData.getExpectedColor()!= null){
            assertEquals(metalsAndColorsPage.getResultsComposite().getColorResult(),"Color: " + testCaseData.getExpectedColor());
        }

        if(testCaseData.getExpectedMetal()!= null){
            assertEquals(metalsAndColorsPage.getResultsComposite().getMetalResult(),"Metal: " + testCaseData.getExpectedMetal());
        }

        if(testCaseData.getExpectedElements()!= null){
            assertEquals(metalsAndColorsPage.getResultsComposite().getElementResult(),"Elements: " + testCaseData.getExpectedElements());
        }

        if(testCaseData.getExpectedVegetables()!= null){
            assertEquals(metalsAndColorsPage.getResultsComposite().getVegetableResult(),"Vegetables: " + testCaseData.getExpectedVegetables());
        }


    }
}
