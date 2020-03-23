package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest {

    @DataProvider
    public static Object[][] multiplyLongArgumentsTestData() {
        return new Object[][]{
                {5, 4, 20},
                {5, 2, 10}
        };
    }

    @Test(dataProvider = "multiplyLongArgumentsTestData")
    public void multiplyLongArgumentsTest(long a, long b, long expected) {
        long actual = a * b;
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] multiplyDoubleArgumentsTestData() {
        return new Object[][]{
                {1.0, 0.5, 0.5},
                {10.0, 4.0, 40.0}
        };
    }

    @Test(dataProvider = "multiplyDoubleArgumentsTestData")
    public void multiplyDoubleArgumentsTest(double a, double b, double expected) {
        double actual = a * b;
        assertEquals(actual, expected);
    }
}
