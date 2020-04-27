package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.ui_object_pages.JdiElementsPage;
import hw7.ui_object_pages.JdiHomePage;

@JSite("http://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html") @Title("Home Page")
    public static JdiHomePage jdiHomePage;

    @Url("/metals-colors.html") @Title("Metal and Colors")
    public static JdiElementsPage jdiElementsPage;

    public static void open(){
        jdiHomePage.open();
    }
}

