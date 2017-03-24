package at.vaadin.test;

import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.MenuBarElement;
import com.vaadin.testbench.parallel.Browser;
import com.vaadin.testbench.parallel.setup.SetupDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** @author Karl Grosse */
public class MenuItemTestbenchcaseIT extends TestBenchTestCase {

    @BeforeMethod
    public void setUp() {
        SetupDriver driverConfiguration = new SetupDriver();
        WebDriver driver = driverConfiguration.setupLocalDriver(
                Browser.FIREFOX, "");
        setDriver(driver);
    }


    @Test
    public void testMenuBarIT() {
        getDriver().get("http://localhost:8080/myapp");
        MenuBarElement menubar = $(MenuBarElement.class).id("MyUI_menubar");
        menubar.click();    // opens the menu
        menubar.clickItem("Item 1"); // leads to org.openqa.selenium.StaleElementReferenceException: Element is no longer attached to the DOM
        Assert.assertTrue(true);  // won't be reached
    }

    @AfterMethod
    public void tearDown() throws Exception {
        //getDriver().quit();
    }
}