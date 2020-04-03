package hw3.compositepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderMenuComposite extends AbstractPageComposite  {

    @FindBy(css = "header .m-l8>li>a")
    private List<WebElement> headerMenuElements;

    @FindBy(linkText = "SERVICE")
    private WebElement menuService;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

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

    public HeaderMenuComposite(WebDriver driver) {
        super(driver);
    }

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

    public int getHeaderTabCount(){
        return headerMenuElements.size();
    }

    public List<String> getHeaderTabNamesList() {
        return headerMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnTheServiceTab(){
        menuService.click();
    }

    public void clickOnTheDifferentElements(){
        differentElements.click();
    }
}

