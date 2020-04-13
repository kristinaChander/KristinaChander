package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(id = "user-icon")
    private WebElement humanIcon;

    @FindBy(id = "name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(id = "user-name")
    private WebElement loggedInUsername;

    @FindBy(linkText = "SERVICE")
    private WebElement menuService;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    @FindBy(linkText = "USER TABLE")
    private WebElement userTable;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openLogInForm() {
        humanIcon.click();
    }

    public void enterUserName(String userName) {
        loginField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public String getLoggedInUserName() {
        return loggedInUsername.getText();
    }

    public void clickOnTheServiceTab() {
        menuService.click();
    }

    public void clickOnTheDifferentElements() {
        differentElements.click();
    }

    public void clickOnUserTable() {
        userTable.click();
    }



}
