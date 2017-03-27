package at.vaadin.test;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();

        MenuBar menuBar = new MenuBar();
        menuBar.setId(getClass().getSimpleName() + "_menubar");
        menuBar.setCaption("Main menu");
        MenuBar.MenuItem menuItem = menuBar.addItem("Option 1", null);
        menuItem.addItem("Item 1", clickedItem());
        menuItem.addItem("Item 2", clickedItem());
        menuItem.addItem("Item 3", clickedItem());
        menuItem.addItem("Item 4", clickedItem());

        layout.addComponent(menuBar);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    private MenuBar.Command clickedItem() {
        return new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                Notification.show("Just clicked " + menuItem.getText());
            }
        };
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
