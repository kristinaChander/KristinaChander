package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest {

    @DataProvider
    public static Object[][] sumLongArgumentsTestData() {
        return new Object[][]{
                {1, 2, 3},
                {1, 5, 6},
                {7, 8, 15}
        };
    }

    @Test(dataProvider = "sumLongArgumentsTestData")
    public void sumLongArgumentsTest(long a, long b, long expected) {
        long actual = a + b;
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] sumDoubleArgumentsTestData() {
        return new Object[][]{
                {1.0, 5.8, 6.8},
                {4.0, 0.1, 4.1}
        };
    }

    @Test(dataProvider = "sumDoubleArgumentsTestData")
    public void sumDoubleArgumentsTest(double a, double b, double expected) {
        double actual = a + b;
        assertEquals(actual, expected);
    }
}
