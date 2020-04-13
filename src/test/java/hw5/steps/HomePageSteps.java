package hw5.steps;

import hw5.HomePageVoid;
import hw5.WebDriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class HomePageSteps {
    private HomePageVoid homePageVoid;
    private WebDriver driver;

    public HomePageSteps(){
        driver = WebDriverSingleton.INSTANCE.getDriver();
        homePageVoid = PageFactory.initElements(driver,HomePageVoid.class);
    }

    @Step("I open '{0}' url")
    public void open(String url){
        driver.get(url);
    }

    //pageTitle
    @Step("Page title should be '{0}")
    public void pageTitleShouldBe(String expectedPageTitle) {
        assertEquals(driver.getTitle(), expectedPageTitle);
    }

    //logInAndCheckUserName
    @Step("I log in as '{0}")
    public void logInAs(String userName, String password) {
        homePageVoid.openLogInForm();
        homePageVoid.enterUserName(userName);
        homePageVoid.enterPassword(password);
        homePageVoid.clickLoginBtn();
    }

    @Step("User name should be '{0}")
    public void userNameShouldBe(String expectedUserName) {
        assertEquals (homePageVoid.getLoggedInUserName(),expectedUserName);
    }

    //headerMenuTest
    @Step("Header menu tab count should be '{0}")
    public void headerTabCountShouldBe(int expectedTabNumber) {
        assertEquals(homePageVoid.getHeaderTabCount(),expectedTabNumber);
    }

    @Step("Header menu tab names should be '{0}")
    public void headerTabNamesShouldBe(String... tabNames) {
        assertEquals(homePageVoid.getHeaderTabNamesList(),Arrays.asList(tabNames));
    }

    @Step("Image count should be '{0}")
    public void imageCountShouldBe(int expectedImageCount) {
        assertEquals(homePageVoid.getImagesCount(), expectedImageCount);
    }

    @Step("Text count should be '{0}")
    public void textCountShouldBe(int expectedTextNumber) {
        assertEquals(homePageVoid.getTextsCount(), expectedTextNumber);
    }
    @Step("Benefit texts should be '{0}")
    public void benefitTextsShouldBe(String...expectedTexts){
        assertEquals(homePageVoid.getBenefitTexts(), Arrays.asList(expectedTexts));
    }
    @Step("I search for iFrame with button")
    public void iFrameShouldExist() {
        assertNotNull(homePageVoid.getIframe());
    }
    @Step("I search for iFrame button")
    public void iFrameButonShouldExist() {
        driver.switchTo().frame(homePageVoid.getIframe());
        assertNotNull(homePageVoid.getIframeButton());
        driver.switchTo().defaultContent();
    }
    //iFrameTest
    @Step("Left side tabs count should be '{0}")
    public void leftSideTabsCountShouldBe(int expectedSideTabsCount) {
        assertEquals(homePageVoid.getLeftSideTabsCount(),expectedSideTabsCount);
    }

    @Step("Left side tabs names should be '{0}")
    public void leftSideTabsNamesShouldBe(String...tabsNames) {
        assertEquals(homePageVoid.getLeftSideTabListText(), Arrays.asList(tabsNames));
    }

    @Step("I go to Elements page")
    public void goToElementsPage() {
        homePageVoid.clickOnTheServiceTab();
        homePageVoid.clickOnTheDifferentElements();
    }

}
