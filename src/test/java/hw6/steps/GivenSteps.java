package hw6.steps;

import hw3.PropertiesHelper;
import hw6.HomePage;
import hw6.WebDriverSingleton;
import io.cucumber.java.en.Given;

public class GivenSteps {

    PropertiesHelper credentialsHelper = new PropertiesHelper("hw3/hw3credentials.properties");

    @Given("I open JDI GitHub site")
    public void iOpenJDIGitHubSite(){
        WebDriverSingleton.INSTANCE.createDriver("Chrome");
        WebDriverSingleton.INSTANCE.getDriver().get(credentialsHelper.getProperty("url"));
    }

    @Given("I log in as user Roman Iovlev on the home page")
    public void iLogInAsRomanIovlev(){
        HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.openLogInForm();
        homePage.enterUserName(credentialsHelper.getProperty("login"));
        homePage.enterPassword(credentialsHelper.getProperty("password"));
        homePage.clickLoginBtn();
    }
}
