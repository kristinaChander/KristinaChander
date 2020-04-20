package hw7.ui_object_pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import hw7.JdiLoginForm;
import hw7.entities.User;


public class JdiHomePage extends WebPage {

    @Css("#user-icon")
    private Button userIcon;


    @Css("#user-name")
    private Text loggedInUsername;

    @XPath("//a[text()='Metals & Colors']")
    private Button metalsAndColors;

    private JdiLoginForm jdiLoginForm;

    public String getUserName(){
        return loggedInUsername.getValue();
    }

    public void login(User user){
        userIcon.click();
        jdiLoginForm.login(user);
    }

    public void goToMetalsAndColorsFromHome() {
        metalsAndColors.click();
    }
}
