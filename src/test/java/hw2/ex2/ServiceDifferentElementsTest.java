package hw2.ex2;

import hw2.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDifferentElementsTest extends TestBase {

    @Test
    public void homePageTest() {
        SoftAssert sa = new SoftAssert();
        //1. Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        sa.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        WebElement humanIcon = waitAndGetElement(By.id("user-icon"),2);
        humanIcon.click();

        WebElement loginField = waitAndGetElement(By.id("name"),1);
        loginField.sendKeys("Roman");

        WebElement passwordField = waitAndGetElement(By.id("password"),1);
        passwordField.sendKeys("Jdi1234");

        WebElement loginBtn = waitAndGetElement(By.id("login-button"),1);
        loginBtn.click();

        //4. Assert Username is logged in
        WebElement loggedInUserName = waitAndGetElement(By.id("user-name"),2);
        sa.assertEquals(loggedInUserName.getText(), "ROMAN IOVLEV");

        //5.Open through the header menu Service -> Different Elements Page
        WebElement menuService = waitAndGetElement(By.linkText("SERVICE"),2);
        menuService.click();

        WebElement differentElements = waitAndGetElement(By.linkText("DIFFERENT ELEMENTS"),3);
        differentElements.click();

        //6. Select checkboxes Water, Wind
        WebElement checkBoxWater = waitAndGetElement(By.cssSelector(".label-checkbox:nth-child(1)"),3);
        checkBoxWater.click();

        WebElement checkBoxWind = waitAndGetElement(By.cssSelector(".label-checkbox:nth-child(3)"),3);
        checkBoxWind.click();

        //7. Select radio selen
        WebElement radioSelen = waitAndGetElement(By.cssSelector(".label-radio:nth-child(4)"),3);
        radioSelen.click();

        //8. Select in dropdown Yellow
        WebElement colorsDropDown = waitAndGetElement(By.cssSelector("div.colors .uui-form-element"),2);
        colorsDropDown.click();

        WebElement yellow = waitAndGetElement(By.xpath("//*[text()='Yellow']"),1);
        yellow.click();

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logList = waitAndGetListOfElements(By.cssSelector(".logs>li"),2);
        sa.assertEquals(logList.size(), 4);

        List<String> filteredLogs = logList.stream()
                .map(s -> s.getText().substring(9))
                .collect(Collectors.toList());

        sa.assertTrue(filteredLogs.contains("Colors: value changed to Yellow"));
        sa.assertTrue(filteredLogs.contains("metal: value changed to Selen"));
        sa.assertTrue(filteredLogs.contains("Wind: condition changed to true"));
        sa.assertTrue(filteredLogs.contains("Water: condition changed to true"));

        sa.assertAll();
    }

}