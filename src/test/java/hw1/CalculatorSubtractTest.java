package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest {

    @DataProvider
    public static Object[][] subtractLongArgumentsTestData() {
        return new Object[][]{
                {5, 4, 1},
                {5, 2, 3}
        };
    }

    @Test(dataProvider = "subtractLongArgumentsTestData")
    public void subtractLongArgumentsTest(long a, long b, long expected) {
        long actual = a - b;
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] subtractDoubleArgumentsTestData() {
        return new Object[][]{
                {1.0, 0.5, 0.5},
                {10.0, 4.0, 6.0}
        };
    }

    @Test(dataProvider = "subtractDoubleArgumentsTestData")
    public void subtractDoubleArgumentsTest(double a, double b, double expected) {
        double actual = a - b;
        assertEquals(actual, expected);
    }
}
