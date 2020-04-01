package hw3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {

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

    private List<WebElement> headerMenuElements;

    public void openLogInForm(){
        humanIcon.click();
    }

    public void enterUserName(){
        loginField.sendKeys("Roman");
    }

    public void enterPassword(){
        passwordField.sendKeys("Jdi1234");
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public String getLoggedInUserName(){
        return loggedInUsername.getText();
    }






}
