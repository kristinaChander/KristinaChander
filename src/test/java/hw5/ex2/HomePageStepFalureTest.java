package hw5.ex2;

import hw5.AbstractTestBase;
import hw5.AllureScreenshotListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureScreenshotListener.class})
public class HomePageStepFalureTest extends AbstractTestBase {


    @Feature(value = "Home page elements")
    @Story(value = "Log in and page content test")
    @Test
    public void logInAndFindTabsAndFrameErrorTest() {
        homeSteps.open(credentialsHelper.getProperty("url"));
        homeSteps.pageTitleShouldBe("Home Page");
        homeSteps.logInAs(credentialsHelper.getProperty("login"), credentialsHelper.getProperty("password"));
        homeSteps.userNameShouldBe("ROMAN iIOVLEV");
        homeSteps.headerTabCountShouldBe(4);
        homeSteps.headerTabNamesShouldBe("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORSSSS");
        homeSteps.imageCountShouldBe(4);
        homeSteps.textCountShouldBe(4);
        homeSteps.benefitTextsShouldBe("To include good practices\n" + "and ideas from successful\n" + "EPAM project", "To be flexible and\n" + "customizable",
                "To be multiplatform",
                "Already have good base\n" + "(about 200 internal and\n" + "some external projects),\n" + "wish to get more\u2026");

        homeSteps.iFrameShouldExist();
        homeSteps.iFrameButonShouldExist();
        homeSteps.leftSideTabsCountShouldBe(5);
        homeSteps.leftSideTabsNamesShouldBe("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    }

}
