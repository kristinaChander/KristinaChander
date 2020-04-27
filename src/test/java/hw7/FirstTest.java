package hw7;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw7.entities.MetalsAndColorsFormData;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hw7.entities.User.ROMAN;
import static org.testng.Assert.assertEquals;

public class FirstTest {

    @BeforeSuite(alwaysRun = true)
    void setUp() {
        initElements(JdiSite.class);
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
    public Object[][] testData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = getClass().getClassLoader().getResourceAsStream("hw7/metalsColorsDataSet.json");
        Map<String, MetalsAndColorsFormData> formData = objectMapper.readValue(is,
                new TypeReference<LinkedHashMap<String, MetalsAndColorsFormData>>() {});
        Object[][] testData = new Object[formData.size()][1];
        int i = 0;
        for (MetalsAndColorsFormData value : formData.values()) {
            testData[i][0] = value;
            i++;
        }
        return testData;
    }

    @Test(dataProvider = "testData")
    public void logInTest(MetalsAndColorsFormData data) {
        JdiSite.open();
        JdiSite.jdiHomePage.login(ROMAN);

        JdiSite.jdiHomePage.getLoggedInUsername().assertThat().text(ROMAN.getFullName());

        JdiSite.jdiHomePage.goToMetalsAndColorsFromHome();
        JdiSite.jdiElementsPage.submitForm(data);

        assertEquals(JdiSite.jdiElementsPage.getResults(), data.getExpectedResult());
    }

}
