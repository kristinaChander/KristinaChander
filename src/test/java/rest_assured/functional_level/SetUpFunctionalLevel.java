package rest_assured.functional_level;

import org.testng.annotations.BeforeMethod;
import rest_assured.SpellerService;

public class SetUpFunctionalLevel {
    protected SpellerService spellerService;

    @BeforeMethod
    public void setUp() {
        spellerService = new SpellerService();
    }
}
