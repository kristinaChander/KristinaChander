package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.List;

public  abstract class TestBase {
    protected WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    protected WebElement waitAndGetElement(By by, int i) {
        return new WebDriverWait(driver, i)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> waitAndGetListOfElements(By by, int timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    //Close Browser
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
