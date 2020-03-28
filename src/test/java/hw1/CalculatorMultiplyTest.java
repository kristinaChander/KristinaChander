package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultiplyTest {

    private Calculator calculator;

    @BeforeMethod
    public void setCalculator() {
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] multiplyLongArgumentsTestData() {
        return new Object[][]{
                {5, 4, 20},
                {5, 2, 10}
        };
    }

    @Test(dataProvider = "multiplyLongArgumentsTestData")
    public void multiplyLongArgumentsTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] multiplyDoubleArgumentsTestData() {
        return new Object[][]{
                {1.0, 0.5, 0.0},
                {10.0, 4.38, 43.0}
        };
    }

    @Test(dataProvider = "multiplyDoubleArgumentsTestData")
    public void multiplyDoubleArgumentsTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
