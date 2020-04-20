package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import hw7.entities.Data;
import hw7.entities.ExpectedData;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hw7.entities.Data.*;
import static hw7.entities.ExpectedData.*;
import static hw7.entities.User.ROMAN;
import static org.testng.Assert.assertTrue;

public class FirstTest {
    
    private JdiSite jdiSite;

    @BeforeSuite(alwaysRun = true)
    void setUp() {
        jdiSite = new JdiSite();
        initElements(jdiSite);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverFactory.reopenDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {DATA_1, EXPECTED_DATA_1},
                {DATA_2, EXPECTED_DATA_2},
                {DATA_3, EXPECTED_DATA_3},
                {DATA_4, EXPECTED_DATA_4},
                {DATA_5, EXPECTED_DATA_5}
        };
    }

    @Test(dataProvider = "testData")
    public void logInTest(Data data, ExpectedData expectedData){
        jdiSite.open();
        jdiSite.jdiHomePage.login(ROMAN);

        Assert.assertEquals(jdiSite.jdiHomePage.getUserName(),ROMAN.getFullName());

        jdiSite.jdiHomePage.goToMetalsAndColorsFromHome();
        jdiSite.jdiElementsPage.selectElements(data);
        jdiSite.jdiElementsPage.clickSubmit();

        assertTrue(jdiSite.jdiElementsPage.getSummmaryResult().getValue().contains(expectedData.getExpectedSummary()));
        assertTrue(jdiSite.jdiElementsPage.getMetalsResult().getValue().contains(expectedData.getExpectedMetals()));
        assertTrue(jdiSite.jdiElementsPage.getElemResult().getValue().contains(expectedData.getExpectedElements()));
        assertTrue(jdiSite.jdiElementsPage.getColorsResult().getValue().contains(expectedData.getExpectedColor()));
        assertTrue(jdiSite.jdiElementsPage.getVegetablesResult().getValue().contains(expectedData.getExpectedVegetables()));
    }

}
