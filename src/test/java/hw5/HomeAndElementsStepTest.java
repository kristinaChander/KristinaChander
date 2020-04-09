package hw5;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureScreenshotListener.class})
public class HomeAndElementsStepTest extends AbstractTestBase {

    @Feature(value = "Home page and elements page test")
    @Story(value = "Log in and select elements and colors")

    @Test
    public void logInGoToElementsTest() {
        homeSteps.open(credentialsHelper.getProperty("url"));
        homeSteps.pageTitleShouldBe("Home Page");
        homeSteps.logInAs(credentialsHelper.getProperty("login"), credentialsHelper.getProperty("password"));
        homeSteps.userNameShouldBe("ROMAN IOVLEV");
        homeSteps.goToElementsPage();
        elementSteps.selectCheckButton("Water");
        elementSteps.selectCheckButton("Wind");
        elementSteps.selectRadioButtons("Selen");
        elementSteps.selectColor("Yellow");
        elementSteps.logEntryCountShouldBe(4);
        elementSteps.logTextsShouldBe("Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true");

    }
}
