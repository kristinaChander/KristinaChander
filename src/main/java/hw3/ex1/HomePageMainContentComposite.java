package hw3.ex1;

import hw3.compositepages.AbstractPageComposite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePageMainContentComposite extends AbstractPageComposite {
    @FindBy(id = "frame")
    private WebElement iFrame;

    @FindBy(id = "frame-button")
    private WebElement iFrameButton;

    @FindBy(className= "benefit-icon")
    private List<WebElement> fourImages;

    @FindBy(css = "span.benefit-txt")
    private List<WebElement> fourTextsUnderImages;

    public HomePageMainContentComposite(WebDriver driver) {
        super(driver);
    }

    public int getImagesCount(){
        return fourImages.size();
    }

    public int getTextsCount(){
        return fourTextsUnderImages.size();
    }

    public List<String> getBenefitTexts(){
        return fourTextsUnderImages.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getIframe(){
        return iFrame;
    }

    public WebElement getIframeButton(){
        return iFrameButton;
    }
}