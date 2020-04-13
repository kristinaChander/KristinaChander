package hw6.steps;

import hw6.ElementsPage;
import hw6.HomePage;
import hw6.UserTablePage;
import hw6.WebDriverSingleton;
import io.cucumber.java.en.When;

public class ActionSteps {

    @When("I click on Service tab on the Header menu")
    public void iClickonServiceTab(){
        HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.clickOnTheServiceTab();
    }

    @When("I click the link 'Different elements' in Service dropdown")
    public void iClickOnDifferentElements(){
        HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.clickOnTheDifferentElements();
    }

    @When("I select checkbox {word} on the Elements page")
    public void iSelectCheckBoxesWind(String word){
        ElementsPage elementsPage = new ElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        elementsPage.clickCheckButtonsFromList(word);
    }

    @When("I select radiobutton {word} on the Elements page")
    public void iSelectRadioSelen(String word){
        ElementsPage elementsPage = new ElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        elementsPage.clickRadioButtonsFromList(word);
    }

    @When("I select color {word} in colors dropdown")
    public void iSelectYellow(String word){
        ElementsPage elementsPage = new ElementsPage(WebDriverSingleton.INSTANCE.getDriver());
        elementsPage.chooseColorFromDropDown(word);
    }

    @When ("I click on 'User Table' button in Service dropdown")
    public void iClickUserTableInServiceDropDown(){
        HomePage homePage = new HomePage(WebDriverSingleton.INSTANCE.getDriver());
        homePage.clickOnUserTable();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void iSelectVipCheckboxForSergeyIvan(){
        UserTablePage userTablePage = new UserTablePage(WebDriverSingleton.INSTANCE.getDriver());
        userTablePage.makeSergeyIvanVip();
    }

}
