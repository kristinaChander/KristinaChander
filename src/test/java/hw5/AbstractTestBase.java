package hw5;

import hw3.PropertiesHelper;
import hw5.steps.ElementsPageSteps;
import hw5.steps.HomePageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {

    protected WebDriver driver;
    protected PropertiesHelper credentialsHelper;
    protected HomePageSteps homeSteps;
    protected ElementsPageSteps elementSteps;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        WebDriverSingleton.INSTANCE.createDriver("Chrome");
        driver = WebDriverSingleton.INSTANCE.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        credentialsHelper = new PropertiesHelper("hw3/hw3credentials.properties");
        homeSteps = new HomePageSteps();
        elementSteps = new ElementsPageSteps();
    }

    @AfterMethod
    public void teardown() {
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }
}
