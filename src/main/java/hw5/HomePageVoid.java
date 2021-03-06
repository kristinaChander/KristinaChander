package hw5;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageVoid {

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

    @FindBy(css = "header .m-l8>li>a")
    private List<WebElement> headerMenuElements;

    @FindBy(className = "benefit-icon")
    private List<WebElement> fourImages;

    @FindBy(css = "span.benefit-txt")
    private List<WebElement> fourTextsUnderImages;

    @FindBy(id = "frame")
    private WebElement iFrame;

    @FindBy(id = "frame-button")
    private WebElement iFrameButton;

    @FindBy(css = ".sidebar-menu>li>a")
    private List<WebElement> leftSideMenuElements;

    @FindBy(linkText = "SERVICE")
    private WebElement menuService;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

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

    public int getHeaderTabCount() {
        return headerMenuElements.size();
    }

    public List<String> getHeaderTabNamesList() {
        return headerMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public int getImagesCount() {
        return fourImages.size();
    }

    public int getTextsCount() {
        return fourTextsUnderImages.size();
    }

    public List<String> getBenefitTexts() {
        return fourTextsUnderImages.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getIframe() {
        return iFrame;
    }

    public WebElement getIframeButton() {
        return iFrameButton;
    }

    public int getLeftSideTabsCount() {
        return leftSideMenuElements.size();
    }

    public List<String> getLeftSideTabListText() {
        return leftSideMenuElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickOnTheServiceTab() {
        menuService.click();
    }

    public void clickOnTheDifferentElements() {
        differentElements.click();
    }
}
