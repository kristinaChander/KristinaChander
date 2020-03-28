package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest {

    private Calculator calculator;

    @BeforeMethod
    public void setCalculator() {
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] subtractLongArgumentsTestData() {
        return new Object[][]{
                {5, 4, 1},
                {5, 2, 3}
        };
    }

    @Test(dataProvider = "subtractLongArgumentsTestData")
    public void subtractLongArgumentsTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] subtractDoubleArgumentsTestData() {
        return new Object[][]{
                {1.0, 0.5, 0.5},
                {10.0, 4.0, 6.0}
        };
    }

    @Test(dataProvider = "subtractDoubleArgumentsTestData", groups = {"subtract"})
    public void subtractDoubleArgumentsTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
