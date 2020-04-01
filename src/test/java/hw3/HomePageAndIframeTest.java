package hw3;

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
        //sa.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
       // WebElement humanIcon = waitAndGetElement(By.id("user-icon"), 2);
       // humanIcon.click();
//        WebElement loginField = waitAndGetElement(By.id("name"),1);
//        loginField.sendKeys("Roman");
//
//        WebElement passwordField = waitAndGetElement(By.id("password"),1);
//        passwordField.sendKeys("Jdi1234");
//
//        WebElement loginBtn = waitAndGetElement(By.id("login-button"),1);
//        loginBtn.click();
//
//        //4. Assert Username is logged in
//        WebElement loggedInUsername = waitAndGetElement(By.id("user-name"), 2);
//        sa.assertEquals(loggedInUsername.getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section they are displayed and have proper texts
//        List<WebElement> headerMenuElements = waitAndGetListOfElements(By.cssSelector("header ul.uui-navigation.nav.navbar-nav.m-l8>li>a"));
//                //(By.xpath("//header/div/nav/ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"));
//
//        sa.assertEquals(headerMenuElements.size(), 4);
//
//        List<String> stringHeaderMenuElements = headerMenuElements.stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//
//        sa.assertTrue(stringHeaderMenuElements.contains("HOME"));
//        sa.assertTrue(stringHeaderMenuElements.contains("CONTACT FORM"));
//        sa.assertTrue(stringHeaderMenuElements.contains("SERVICE"));
        //sa.assertTrue(stringHeaderMenuElements.contains("METALS & COLORS"));

//        //6. Assert that there are 4 images on the Index Page and they are displayed
//        List<WebElement> fourImages = waitAndGetListOfElements(By.className("benefit-icon"));
//        sa.assertEquals(fourImages.size(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
//        List<WebElement> fourTextsUnderImages = waitAndGetListOfElements(By.cssSelector("span.benefit-txt"));
//
//        sa.assertEquals(fourTextsUnderImages.size(), 4);
//
//        List<String> fourTextsUnderImagesList = fourTextsUnderImages.stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//
//        sa.assertTrue(fourTextsUnderImagesList.contains("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
//        sa.assertTrue(fourTextsUnderImagesList.contains("To be flexible and\n" + "customizable"));
//        sa.assertTrue(fourTextsUnderImagesList.contains("To be multiplatform"));
//        sa.assertTrue(fourTextsUnderImagesList.contains("Already have good base\n" + "(about 20 internal and\n" +
//                "some external projects),\n" + "wish to get more…"));

        //8. Assert that the iframe with “Frame Button” exists
        //try {


//            driver.switchTo().frame("frame");
//            driver.switchTo().defaultContent();
//        } catch (NoSuchFrameException e) {
//            sa.fail("The frame with Frame Button doesn't exist");
//        }
//
//        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
//        driver.switchTo().frame("frame");
//
//        WebElement iFrameButton = waitAndGetElement(By.id("frame-button"), 2);
//        sa.assertNotNull(iFrameButton);

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSideMenuElements = waitAndGetListOfElements(By.cssSelector(".sidebar-menu>li>a"));

        sa.assertEquals(leftSideMenuElements.size(), 4);

        List<String> leftSideMenuElementsList = leftSideMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        sa.assertTrue(leftSideMenuElementsList.contains("Home"));
        sa.assertTrue(leftSideMenuElementsList.contains("Contact form"));
        sa.assertTrue(leftSideMenuElementsList.contains("Service"));
        sa.assertTrue(leftSideMenuElementsList.contains("Metals & Colors"));
    }

    private WebElement waitAndGetElement(By by, int i) {
        return new WebDriverWait(driver, i)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private List<WebElement> waitAndGetListOfElements(By by) {
        return new WebDriverWait(driver,3)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

//    //Close Browser
//    @AfterMethod
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
