package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest extends BaseCalculatorTest{

    @DataProvider
    public  Object[][] divideLongArgumentsTestData() {
        return new Object[][]{
                {5, 4, 1},
                {5, 2, 2},
                {1, 1, 1}
        };
    }

    @DataProvider
    public Object[][] divideByZeroLongArgumentsTestData() {
        return new Object[][]{
                {1},
                {0}
        };
    }

    @Test(dataProvider = "divideLongArgumentsTestData")
    public void divideLongArgumentsTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "divideByZeroLongArgumentsTestData", expectedExceptions = NumberFormatException.class )
    public void divideByZeroLongArgumentsTest(long a) {
        calculator.div(a, 0);
    }

    @DataProvider
    public Object[][] divideDoubleArgumentsTestData() {
        return new Object[][]{
                {1.0, 0.5, 2.0},
                {10.0, 4.0, 2.5}
        };
    }

    @Test(dataProvider = "divideDoubleArgumentsTestData")
    public void divideDoubleArgumentsTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }
}
