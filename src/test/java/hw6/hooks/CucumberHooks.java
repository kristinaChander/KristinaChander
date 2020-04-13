package hw6.hooks;

import hw6.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks {

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void tearDown(){
        WebDriverSingleton.INSTANCE.getDriver().quit();
    }
}
