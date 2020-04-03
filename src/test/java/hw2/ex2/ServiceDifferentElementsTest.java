package hw2.ex2;

import hw2.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ServiceDifferentElementsTest extends TestBase {

    @Test
    public void homePageTest() {
        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

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
        WebElement loggedInUserName = waitAndGetElement(By.id("user-name"));
        assertEquals(loggedInUserName.getText(), "ROMAN IOVLEV");

        //5.Open through the header menu Service -> Different Elements Page
        WebElement menuService = waitAndGetElement(By.linkText("SERVICE"));
        menuService.click();

        WebElement differentElements = waitAndGetElement(By.linkText("DIFFERENT ELEMENTS"));
        differentElements.click();

        //6. Select checkboxes Water, Wind
        WebElement checkBoxWater = waitAndGetElement(By.xpath("//label[normalize-space()='Water']"));
        checkBoxWater.click();

        WebElement checkBoxWind = waitAndGetElement(By.xpath("//label[normalize-space()='Wind']"));
        checkBoxWind.click();

        //7. Select radio selen
        WebElement radioSelen = waitAndGetElement(By.xpath("//label[normalize-space()='Selen']"));
        radioSelen.click();

        //8. Select in dropdown Yellow
        WebElement colorsDropDown = waitAndGetElement(By.cssSelector("div.colors .uui-form-element"));
        colorsDropDown.click();

        WebElement yellow = waitAndGetElement(By.xpath("//*[text()='Yellow']"));
        yellow.click();

        //9. Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logList = waitAndGetListOfElements(By.cssSelector(".logs>li"));
        assertEquals(logList.size(), 4);

        List<String> filteredLogs = logList.stream()
                .map(s -> s.getText().substring(9))
                .collect(Collectors.toList());

        assertTrue(filteredLogs.contains("Colors: value changed to Yellow"));
        assertTrue(filteredLogs.contains("metal: value changed to Selen"));
        assertTrue(filteredLogs.contains("Wind: condition changed to true"));
        assertTrue(filteredLogs.contains("Water: condition changed to true"));
    }
}