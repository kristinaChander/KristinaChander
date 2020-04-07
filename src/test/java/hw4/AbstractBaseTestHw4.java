package hw4;

import hw3.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseTestHw4 {

    protected WebDriver driver;
    protected HomePage homePage;
    private PropertiesHelper credentialsHelper;


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        credentialsHelper = new PropertiesHelper("hw3/hw3credentials.properties");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        login();
    }

    private void login() {
        homePage = new HomePage(driver);
        //1.open site by url
        driver.get(credentialsHelper.getProperty("url"));

        //3. Perform login
        homePage.getHeaderMenuComposite().openLogInForm();
        homePage.getHeaderMenuComposite().enterUserName(credentialsHelper.getProperty("login"));
        homePage.getHeaderMenuComposite().enterPassword(credentialsHelper.getProperty("password"));
        homePage.getHeaderMenuComposite().clickLoginBtn();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
