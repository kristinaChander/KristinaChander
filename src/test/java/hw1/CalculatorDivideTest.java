package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest {

    @DataProvider
    public static Object[][] divideLongArgumentsTestData() {
        return new Object[][] {
                {5, 4, 1},
                {5, 2, 2}
        };
    }

    @Test(dataProvider = "divideLongArgumentsTestData")
    public void divideLongArgumentsTest(long a, long b, long expected) {
        long actual = a / b;
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] divideDoubleArgumentsTestData() {
        return new Object[][] {
                {1.0, 0.5, 2.0},
                {10.0, 4.0, 2.5}
        };
    }

    @Test(dataProvider = "divideDoubleArgumentsTestData")
    public void divideDoubleArgumentsTest(double a, double b, double expected) {
        double actual = a / b;
        assertEquals(actual, expected);
    }
}
