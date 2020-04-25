package hw7.ui_object_pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import hw7.JdiElementsForm;
import hw7.entities.MetalsAndColorsFormData;

import java.util.List;
import java.util.stream.Collectors;

public class JdiElementsPage extends WebPage {

    private JdiElementsForm jdiElementsForm;

    @Css("#fillFormWithValues-button")
    private Button submitBtn;

    @Css(".results li")
    private List<Label> results;

    public void submitForm(MetalsAndColorsFormData data){
        jdiElementsForm.fillFormWithValues(data);
        submitBtn.click();
    }

    public List<String> getResults() {
        return results.stream()
                .map(s -> s.getText())
                .collect(Collectors.toList());
    }
}
