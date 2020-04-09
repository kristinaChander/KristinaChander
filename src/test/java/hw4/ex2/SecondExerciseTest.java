package hw4.ex2;

import hw4.AbstractBaseTestHw4;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static hw4.ex2.VegetablesComposite.*;
import static org.testng.Assert.assertEquals;

public class SecondExerciseTest extends AbstractBaseTestHw4 {

    private static final String BLUE = "Blue";
    private static final String YELLOW = "Yellow";
    private static final String GREEN = "Green";
    private static final String LIST_SEPARATOR = ", ";
    private static final String FIRE = "Fire";
    private static final String WATER = "Water";
    private static final String WIND = "Wind";
    private static final String EARTH = "Earth";
    private static final String BRONZE = "Bronze";
    private static final String GOLD = "Gold";
    private static final String SELEN = "Selen";


    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {
                    new TestCaseData.Builder()
                        .addElement(EARTH)
                        .addColor(YELLOW)
                        .addMetal(GOLD)
                            .build(),
                    new ExpectedTestCaseData.Builder()
                        .setExpectedElements(EARTH)
                        .setExpectedColor(YELLOW)
                        .setExpectedMetal(GOLD)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addSummary("3")
                        .addSummary("8")
                        .addVegetable(CUCUMBER)
                        .addVegetable(TOMATO)
                            .build(),
                    new ExpectedTestCaseData.Builder()
                        .setExpectedSummary("11")
                        .setExpectedVegetables(CUCUMBER + LIST_SEPARATOR + TOMATO)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addSummary("3")
                        .addSummary("2")
                        .addElement(WIND)
                        .addElement(FIRE)
                        .addElement(WATER)
                        .addMetal(BRONZE)
                        .addVegetable(ONION)
                            .build(),
                    new ExpectedTestCaseData.Builder()
                        .setExpectedSummary("5")
                        .setExpectedElements(WATER + LIST_SEPARATOR + WIND + LIST_SEPARATOR + FIRE)
                        .setExpectedMetal(BRONZE)
                        .setExpectedVegetables(ONION)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addSummary("6")
                        .addSummary("5")
                        .addElement(WATER)
                        .addColor(GREEN)
                        .addMetal(SELEN)
                        .addVegetable(VEGETABLES)
                        .addVegetable(CUCUMBER)
                        .addVegetable(TOMATO)
                        .addVegetable(ONION)
                        .build(),
                    new ExpectedTestCaseData.Builder()
                        .setExpectedSummary("11")
                        .setExpectedElements(WATER)
                        .setExpectedColor(GREEN)
                        .setExpectedMetal(SELEN)
                        .setExpectedVegetables(CUCUMBER + LIST_SEPARATOR + TOMATO + LIST_SEPARATOR + VEGETABLES + LIST_SEPARATOR + ONION)
                        .build()
                },
                {
                    new TestCaseData.Builder()
                        .addElement(FIRE)
                        .addColor(BLUE)
                        .addVegetable(CUCUMBER)
                        .addVegetable(TOMATO)
                        .addVegetable(VEGETABLES)
                            .build(),
                    new ExpectedTestCaseData.Builder()
                        .setExpectedColor(BLUE)
                        .setExpectedElements(FIRE)
                        .setExpectedVegetables(CUCUMBER + LIST_SEPARATOR+ TOMATO + LIST_SEPARATOR + VEGETABLES)
                        .build()
                }
        };
    }

    @Test(dataProvider = "testData")
    public void logInAndFillFormTest(TestCaseData testCaseData, ExpectedTestCaseData expectedTestCaseData) {
        //3. Click on the link Metal & Colors on the Header section
        homePage.getHeaderMenuComposite().clickOnMetalsAndColors();

        MetalsAndColorsPage metalsAndColorsPage = new MetalsAndColorsPage(driver);

        //4. Fill form on the page
        metalsAndColorsPage.getSummaryComposite().chooseNumbers(testCaseData.getSummary());
        metalsAndColorsPage.getColorsComposite().chooseColor(testCaseData.getColors());
        metalsAndColorsPage.getMetalsComposite().chooseMetal(testCaseData.getMetals());
        metalsAndColorsPage.getElementsComposite().chooseElements(testCaseData.getElements());
        metalsAndColorsPage.getVegetablesComposite().chooseVegetables(testCaseData.getVegetables());

        //5. Click “Submit” button
        metalsAndColorsPage.clickSubmitBtn();

        //6. Check Results block output on the right-side
        if (expectedTestCaseData.getExpectedSummary() != null) {
            assertEquals(metalsAndColorsPage.getResultsComposite().getSummaryResult(), "Summary: " + expectedTestCaseData.getExpectedSummary());
        }

        if (expectedTestCaseData.getExpectedColor() != null) {
            assertEquals(metalsAndColorsPage.getResultsComposite().getColorResult(), "Color: " + expectedTestCaseData.getExpectedColor());
        }

        if (expectedTestCaseData.getExpectedMetal() != null) {
            assertEquals(metalsAndColorsPage.getResultsComposite().getMetalResult(), "Metal: " + expectedTestCaseData.getExpectedMetal());
        }

        if (expectedTestCaseData.getExpectedElements() != null) {
            assertEquals(metalsAndColorsPage.getResultsComposite().getElementResult(), "Elements: " + expectedTestCaseData.getExpectedElements());
        }

        if (expectedTestCaseData.getExpectedVegetables() != null) {
            assertEquals(metalsAndColorsPage.getResultsComposite().getVegetableResult(), "Vegetables: " + expectedTestCaseData.getExpectedVegetables());
        }
    }
}
