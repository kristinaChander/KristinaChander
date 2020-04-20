package hw7;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw7.entities.Data;

import java.util.HashMap;
import java.util.Map;

public class JdiElementsForm extends Form<Data> {

    private static Map<String, Integer> ODD_INDEX_MAP;
    private static Map<String, Integer> EVEN_INDEX_MAP;
    private static Map<String, Integer> ELEMENTS_INDEX_MAP;

    static {
        ODD_INDEX_MAP = new HashMap<>();
        ODD_INDEX_MAP.put("1", 1);
        ODD_INDEX_MAP.put("3", 2);
        ODD_INDEX_MAP.put("5", 3);
        ODD_INDEX_MAP.put("7", 4);

        EVEN_INDEX_MAP = new HashMap<>();
        EVEN_INDEX_MAP.put("2", 1);
        EVEN_INDEX_MAP.put("4", 2);
        EVEN_INDEX_MAP.put("6", 3);
        EVEN_INDEX_MAP.put("8", 4);

        ELEMENTS_INDEX_MAP = new HashMap<>();
        ELEMENTS_INDEX_MAP.put("Water", 1);
        ELEMENTS_INDEX_MAP.put("Earth", 2);
        ELEMENTS_INDEX_MAP.put("Wind", 3);
        ELEMENTS_INDEX_MAP.put("Fire", 4);

    }

    @Css("[name='custom_radio_odd'] +label")
    private RadioButtons summaryOdd;

    @Css("[name='custom_radio_even'] +label")
    private RadioButtons summaryEven;

    @Css("#elements-checklist label")
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
        summaryOdd.get(ODD_INDEX_MAP.get(data.getSummaryOdd())).click();
        summaryEven.get(EVEN_INDEX_MAP.get(data.getSummaryEven())).click();

        for (int i = 0; i < data.getElements().size(); i++) {
            String value = data.getElements().get(i);
            elements.get(ELEMENTS_INDEX_MAP.get(value)).click();
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




