package hw7;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw7.entities.Data;

public class JdiElementsForm extends Form<Data> {

    @UI("[name=custom_radio_odd]")
    private RadioButtons summaryOdd;

    @UI("[name=custom_radio_even]")
    private RadioButtons summaryEven;

    @UI("#elements-checklist input")
    private Checklist elements;

    @JDropdown(list = "#colors a",
            expand = "#colors .caret")
    private Dropdown color;

    @JDropdown(list = "#metals a",
            expand = "#metals .caret")
    private Dropdown metals;

    @JDropdown(list = "#salad-dropdown label",
            expand = "#salad-dropdown .caret")
    private Dropdown vegetables;

    public void fillFormWithValues(Data data) {
        summaryOdd.select(data.getSummaryOdd());
        summaryEven.select(data.getSummaryEven());

        for (int i = 0; i < data.getElements().size(); i++) {
            String value = data.getElements().get(i);
            elements.select(value);
      }
        color.expand();
        color.select(data.getColor());

        metals.expand();
        metals.select(data.getMetals());

        vegetables.expand();
        vegetables.select("Vegetables");
        for (int i = 0; i < data.getVegetables().size(); i++) {
            vegetables.select(data.getVegetables().get(i));
        }
    }
}




