package hw6.steps;

import hw6.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ThenSteps {

    @Then("browser title should be 'Home Page' on the home page")
    public void pageTitleShouldBe() {
        assertEquals(WebDriverSingleton.INSTANCE.getDriver().getTitle(), "Home Page");
    }

    @Then("logged in user name  should be {string} on the header")
    public void loggedInUserNameShouldBe(String name) {
        HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(homePage.getLoggedInUserName(), name);
    }

    @Then("A log row should be for each selected value on the log panel")
    public void individualLogShouldBeForEachSelection() {
        ElementsPage elementsPage = new ElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(elementsPage.getLogEntryCount(), 4);
    }

    @Then("value of chosen checkboxes, radiobuttons and dropdowns should correspond to their status on the Elements Page")
    public void logTextsShouldCorrespondToSelections() {
        ElementsPage elementsPage = new ElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(elementsPage.getFilteredLogsText(), Arrays.asList("Colors: value changed to Yellow", "metal: value changed to Selen",
                "Wind: condition changed to true", "Water: condition changed to true"));
    }

    @Then("{string} page should be opened")
    public void userTableShouldBeOpened(String string) {
        assertEquals(WebDriverSingleton.INSTANCE.getDriver().getTitle(), string);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void sixNumberTypeDropDownsShouldBe(int expectedNumber) {
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getNumberTypeDropdownsCount(), expectedNumber);
    }

    @Then("{int} User names should be displayed on Users Table on User Table Page")
    public void sixUserNamesShouldBeDisplayed(int expectedNumber) {
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getUserNamesCount(), expectedNumber);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void sixDescriptionTextShouldBeDisplayed(int expectedNumber) {
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getDescriptionTextsCount(), expectedNumber);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void sixCheckBoxesShouldBeDisplayed(int expectedNumber) {
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getCheckBoxCount(), expectedNumber);
    }


    @DataTableType
    public UserTableRow userEntry(Map<String, String> entry) {
        return new UserTableRow(
                entry.get("Number"),
                entry.get("User"),
                entry.get("Description"));
    }

    @Then("User table should contain following values:")
    public void tableShouldContain(List<UserTableRow> userTableRows) {
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.userTableRowList(), userTableRows);
    }

    @DataTableType
    public DropDownRow userType(Map<String, String> entry) {
        return new DropDownRow(entry.get("Dropdown Values"));
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistValuesShoulBe(List<DropDownRow> dropDownRows) {
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getDropDownValues(), dropDownRows);
    }

    @Then("{int} log row has {string} text in log section")
    public void oneLogVipGotTrue(int number, String text) {
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        assertEquals(userTablePage.getLogEntryCount(), number);
        assertEquals(userTablePage.getLogsText().get(0), text);
    }
}
