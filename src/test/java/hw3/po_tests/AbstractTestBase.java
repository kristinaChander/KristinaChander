package hw3.po_tests;

import hw3.voidpo.ElementsPage;
import hw3.voidpo.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ElementsPage elementsPage;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
        elementsPage = PageFactory.initElements(driver, ElementsPage.class);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
