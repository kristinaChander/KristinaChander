package hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComposite extends AbstractPageComposite {
    @FindBy(linkText = "SERVICE")
    private WebElement menuService;

    @FindBy(linkText = "TABLE WITH PAGES")
    private WebElement tableWithPagesLink;

    @FindBy(id = "user-icon" )
    private WebElement humanIcon;

    @FindBy(id ="name")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    @FindBy(id = "user-name")
    private WebElement loggedInUsername;

    @FindBy(linkText = "METALS & COLORS")
    private WebElement metalsColorLink;

    public HeaderMenuComposite(WebDriver driver) {
        super(driver);
    }

    public void clickOnMetalsAndColors(){
        metalsColorLink.click();
    }

    public void openLogInForm(){
        humanIcon.click();
    }

    public void enterUserName(String username){
        loginField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public String getLoggedInUserName(){
        return loggedInUsername.getText();
    }

    public void clickOnTheServiceTab(){
        menuService.click();
    }

    public void clickOnTableWithPagesLink(){
        tableWithPagesLink.click();
    }
}

