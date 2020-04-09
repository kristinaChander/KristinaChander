package hw5.steps;

import hw5.ElementsPageVoid;
import hw5.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ElementsPageSteps {

    private ElementsPageVoid elementsPageVoid;
    private WebDriver driver;

    public ElementsPageSteps() {
        driver = WebDriverSingleton.INSTANCE.getDriver();
        elementsPageVoid = PageFactory.initElements(driver, ElementsPageVoid.class);
    }

    @Step("I select '{0}' checkbox")
    public void selectCheckButton(String checkboxName) {
        elementsPageVoid.clickCheckButtonsFromList(checkboxName);
    }

    @Step("I select '{0}' radiobutton")
    public void selectRadioButtons(String radiobuttonName) {
        elementsPageVoid.clickRadioButtonsFromList(radiobuttonName);
    }

    @Step("I select '{0}' color")
    public void selectColor(String colorName) {
        elementsPageVoid.chooseColorFromDropDown(colorName);
    }

    @Step("Log entry count should be '{0}")
    public void logEntryCountShouldBe(int expectedLogCount) {
        assertEquals(elementsPageVoid.getLogEntryCount(), expectedLogCount);
    }

    @Step("Log texts should be '{0}")
    public void logTextsShouldBe(String... texts) {
        assertEquals(elementsPageVoid.getFilteredLogsText(),
                Arrays.asList(texts));
    }
}

