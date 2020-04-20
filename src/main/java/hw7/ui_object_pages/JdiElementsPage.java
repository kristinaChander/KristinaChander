package hw7.ui_object_pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.JdiElementsForm;
import hw7.entities.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JdiElementsPage extends WebPage {

    private JdiElementsForm jdiElementsForm;

    @Css(".logs>li")
    private List<WebElement> logList;

    @Css("#submit-button")
    private Button submitBtn;

    @Css(".summ-res")
    private Text summaryResult;

    @Css(".col-res")
    private Text colorsResult;

    @Css(".met-res" )
    private Text metalsResult;

    @Css( ".sal-res")
    private Text vegetablesResult;

    @FindBy(className = "elem-res")
    private Text elementsResult;

    public void selectElements(Data data){
        jdiElementsForm.fillFormWithValues(data);
    }
     public void clickSubmit(){
        submitBtn.click();
     }

     public Text getSummmaryResult(){
        return summaryResult;
     }

     public Text getElemResult(){
        return elementsResult;
     }

     public Text getColorsResult(){
        return colorsResult;
     }

     public Text getMetalsResult(){
        return metalsResult;
     }

     public Text getVegetablesResult(){
        return vegetablesResult;
     }


}
