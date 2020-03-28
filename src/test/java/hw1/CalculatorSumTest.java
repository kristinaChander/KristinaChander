package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest {

    private Calculator calculator;

    @BeforeMethod
    public void setCalculator() {
        calculator = new Calculator();
    }

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
        long actual = calculator.sum(a, b);
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
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
