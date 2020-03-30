package hw2.ex1;

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

public class HomePageAndIframeTest {


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

        //5. Assert that there are 4 items on the header section they are displayed and have proper texts
        List<WebElement> headerMenuElements = driver
                .findElements(By.xpath("//header/div/nav/ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
        sa.assertEquals(headerMenuElements.size(), 4);
        sa.assertEquals(headerMenuElements.get(0).getText(), "HOME");
        sa.assertEquals(headerMenuElements.get(1).getText(), "CONTACT FORM");
        sa.assertEquals(headerMenuElements.get(2).getText(), "SERVICE");
        sa.assertEquals(headerMenuElements.get(3).getText(), "METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> fourImages = driver.findElements(By.className(".benefit-icon"));
        sa.assertEquals(fourImages.size(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> fourTextsUnderImages = driver.findElements(By.cssSelector("span.benefit-txt"));
        sa.assertEquals(fourTextsUnderImages.size(), 4);
        sa.assertEquals(fourTextsUnderImages.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" + "EPAM project");
        sa.assertEquals(fourTextsUnderImages.get(1).getText(), "To be flexible and\n" + "customizable");
        sa.assertEquals(fourTextsUnderImages.get(2).getText(), "To be multiplatform");
        sa.assertEquals(fourTextsUnderImages.get(3).getText(), "Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more…");

        //8. Assert that the iframe with “Frame Button” exists
        try {
            driver.switchTo().frame("frame");
            driver.switchTo().defaultContent();
        } catch (NoSuchFrameException e) {
            sa.fail("The frame with Frame Button doesn't exist");
        }

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");

        WebElement iFrameElement = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("frame-button")));
        sa.assertNotNull(iFrameElement);

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSideMenuElements = new WebDriverWait(driver,1)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".sidebar-menu>li>a")));

        sa.assertEquals(leftSideMenuElements.size(), 4);
        sa.assertEquals(leftSideMenuElements.get(0).getText(), "Home");
        sa.assertEquals(leftSideMenuElements.get(1).getText(), "Contact form");
        sa.assertEquals(leftSideMenuElements.get(2).getText(), "Service");
        sa.assertEquals(leftSideMenuElements.get(3).getText(), "Metals & Colors");
        sa.assertEquals(leftSideMenuElements.get(4).getText(), "Elements packs");
    }

    //Close Browser
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
