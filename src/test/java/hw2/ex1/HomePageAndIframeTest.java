package hw2.ex1;

import hw2.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageAndIframeTest extends TestBase {

    @Test
    public void homePageTest() {
        SoftAssert sa = new SoftAssert();

        //2. Assert Browser title
        sa.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        WebElement humanIcon = waitAndGetElement(By.id("user-icon"));
        humanIcon.click();
        WebElement loginField = waitAndGetElement(By.id("name"));
        loginField.sendKeys("Roman");

        WebElement passwordField = waitAndGetElement(By.id("password"));
        passwordField.sendKeys("Jdi1234");

        WebElement loginBtn = waitAndGetElement(By.id("login-button"));
        loginBtn.click();

        //4. Assert Username is logged in
        WebElement loggedInUsername = waitAndGetElement(By.id("user-name"));
        sa.assertEquals(loggedInUsername.getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section they are displayed and have proper texts
        List<WebElement> headerMenuElements = waitAndGetListOfElements(By.cssSelector("header .m-l8>li>a"));

        sa.assertEquals(headerMenuElements.size(), 4);

        List<String> stringHeaderMenuElements = headerMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        sa.assertTrue(stringHeaderMenuElements.contains("HOME"));
        sa.assertTrue(stringHeaderMenuElements.contains("CONTACT FORM"));
        sa.assertTrue(stringHeaderMenuElements.contains("SERVICE"));
        sa.assertTrue(stringHeaderMenuElements.contains("METALS & COLORS"));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> fourImages = waitAndGetListOfElements(By.className("benefit-icon"));
        sa.assertEquals(fourImages.size(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> fourTextsUnderImages = waitAndGetListOfElements(By.cssSelector("span.benefit-txt"));

        sa.assertEquals(fourTextsUnderImages.size(), 4);

        List<String> fourTextsUnderImagesList = fourTextsUnderImages.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        sa.assertTrue(fourTextsUnderImagesList.contains("To include good practices\n" + "and ideas from successful\n"
                + "EPAM project"));
        sa.assertTrue(fourTextsUnderImagesList.contains("To be flexible and\n" + "customizable"));
        sa.assertTrue(fourTextsUnderImagesList.contains("To be multiplatform"));
        sa.assertTrue(fourTextsUnderImagesList.contains("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more\u2026"));


        //8. Assert that the iframe with “Frame Button” exists
        WebElement buttonFrame = waitAndGetElement(By.id("frame"));
        sa.assertNotNull(buttonFrame);

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        WebElement iFrameElement = waitAndGetElement(By.id("frame-button"));
        sa.assertNotNull(iFrameElement);

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSideMenuElements = waitAndGetListOfElements(By.cssSelector(".sidebar-menu>li>a"));

        sa.assertEquals(leftSideMenuElements.size(), 5);

        List<String> leftSideMenuElementsList = leftSideMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        sa.assertTrue(leftSideMenuElementsList.contains("Home"));
        sa.assertTrue(leftSideMenuElementsList.contains("Contact form"));
        sa.assertTrue(leftSideMenuElementsList.contains("Service"));
        sa.assertTrue(leftSideMenuElementsList.contains("Metals & Colors"));
        sa.assertTrue(leftSideMenuElementsList.contains("Elements packs"));

        sa.assertAll();
    }

}
