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

        //1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        sa.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        WebElement humanIcon = waitAndGetElement(By.id("user-icon"), 2);
        humanIcon.click();
        WebElement loginField = waitAndGetElement(By.id("name"), 1);
        loginField.sendKeys("Roman");

        WebElement passwordField = waitAndGetElement(By.id("password"), 1);
        passwordField.sendKeys("Jdi1234");

        WebElement loginBtn = waitAndGetElement(By.id("login-button"), 1);
        loginBtn.click();

        //4. Assert Username is logged in
        WebElement loggedInUsername = waitAndGetElement(By.id("user-name"), 2);
        sa.assertEquals(loggedInUsername.getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section they are displayed and have proper texts
        List<WebElement> headerMenuElements = waitAndGetListOfElements(By.cssSelector("header ul.uui-navigation.nav.navbar-nav.m-l8>li>a"), 2);


        sa.assertEquals(headerMenuElements.size(), 4);

        List<String> stringHeaderMenuElements = headerMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        sa.assertTrue(stringHeaderMenuElements.contains("HOME"));
        sa.assertTrue(stringHeaderMenuElements.contains("CONTACT FORM"));
        sa.assertTrue(stringHeaderMenuElements.contains("SERVICE"));
        sa.assertTrue(stringHeaderMenuElements.contains("METALS & COLORS"));

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> fourImages = waitAndGetListOfElements(By.className("benefit-icon"), 3);
        sa.assertEquals(fourImages.size(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> fourTextsUnderImages = waitAndGetListOfElements(By.cssSelector("span.benefit-txt"), 3);

        sa.assertEquals(fourTextsUnderImages.size(), 4);

        List<String> fourTextsUnderImagesList = fourTextsUnderImages.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        sa.assertTrue(fourTextsUnderImagesList.contains("To include good practices\n" + "and ideas from successful\n" + "EPAM project"));
        sa.assertTrue(fourTextsUnderImagesList.contains("To be flexible and\n" + "customizable"));
        sa.assertTrue(fourTextsUnderImagesList.contains("To be multiplatform"));
        sa.assertTrue(fourTextsUnderImagesList.contains("Already have good base\n" + "(about 20 internal and\n" +
                "some external projects),\n" + "wish to get more…"));

        //8. Assert that the iframe with “Frame Button” exists

        WebElement buttonFrame = waitAndGetElement(By.id("frame"), 1);
        sa.assertNotNull(buttonFrame);

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");

        WebElement iFrameElement = waitAndGetElement(By.id("frame-button"), 2);
        sa.assertNotNull(iFrameElement);

        //10. Switch to original window back
        driver.switchTo().defaultContent();

        //11. Assert that 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSideMenuElements = waitAndGetListOfElements(By.cssSelector(".sidebar-menu>li>a"), 3);

        sa.assertEquals(leftSideMenuElements.size(), 5);

        List<String> leftSideMenuElementsList = leftSideMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        sa.assertTrue(leftSideMenuElementsList.contains("Home"), "Left side menu does not contain Home");
        sa.assertTrue(leftSideMenuElementsList.contains("Contact form"), "Left side menu does not contain Contact form");
        sa.assertTrue(leftSideMenuElementsList.contains("Service"), "Left side menu does not contain Service");
        sa.assertTrue(leftSideMenuElementsList.contains("Metals & Colors"), "Left side menu does not contain Metals & Colors");
        sa.assertTrue(leftSideMenuElementsList.contains("Elements packs"), "Left side menu does not contain Elements packs");

        try {
            sa.assertAll();
        } catch (AssertionError e) {
            System.out.println(sa);
        }
    }

}
