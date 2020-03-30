package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDifferentElementsTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void homePageTest() {
        SoftAssert sa = new SoftAssert();
        //1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        sa.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        WebElement humanIcon = new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated((By.id("user-icon"))));
        humanIcon.click();

        WebElement loginField = driver.findElement(By.id("name"));
        loginField.sendKeys("Roman");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("Jdi1234");

        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        //4. Assert Username is loggined
        WebElement logginedUserName = new WebDriverWait(driver, 1).until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        sa.assertEquals(logginedUserName.getText(), "ROMAN IOVLEV");

        //5.Open through the header menu Service -> Different Elements Page

        WebElement menuService = driver.findElement(By.linkText("SERVICE"));
        menuService.click();

        WebElement differentElements = new WebDriverWait(driver,1)
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("DIFFERENT ELEMENTS")));
        differentElements.click();

        //6. Select checkboxes Water, Wind

        WebElement checkBoxWater = new WebDriverWait(driver,2)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".label-checkbox:nth-child(1)")));
        checkBoxWater.click();

        WebElement checkBoxWind = new WebDriverWait(driver,2)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".label-checkbox:nth-child(3)")));
        checkBoxWind.click();

        //7. Select radio selen
        WebElement radioSelen = driver.findElement(By.cssSelector(".label-radio:nth-child(4)"));
        radioSelen.click();

        //8. Select in dropdown Yellow
        WebElement colorsDropDown = driver.findElement(By.cssSelector("div.colors .uui-form-element"));
        colorsDropDown.click();

        WebElement yellow = driver.findElement(By.xpath("//*[text()='Yellow']"));
        yellow.click();

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.

        List<WebElement> logList = driver.findElements(By.cssSelector(".logs>li"));
        sa.assertEquals(logList.size(),4);

        List<String> filteredLogs = logList.stream()
                .map(s -> s.getText().substring(9))
                .collect(Collectors.toList());

        sa.assertTrue(filteredLogs.contains("Colors: value changed to Yellow"));
        sa.assertTrue(filteredLogs.contains("metal: value changed to Selen"));
        sa.assertTrue(filteredLogs.contains("Wind: condition changed to true"));
        sa.assertTrue(filteredLogs.contains("Water: condition changed to true"));
    }

    //Close Browser
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
