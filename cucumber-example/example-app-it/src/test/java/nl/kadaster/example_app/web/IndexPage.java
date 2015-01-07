package nl.kadaster.example_app.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

/**
 * A helper class for the index page ({@code src/main/webapp/index.html} in {@code example-app}). Using this class
 * requires less coding than doing all the element look-ups in the step definitions, and more importantly keeps
 * all used elements of that page neatly grouped together here; if ever an element lookup should be changed, this will
 * only have to be done here.
 */
public class IndexPage {
    @FindBy(id = "name")
    @CacheLookup
    public WebElement name;

    @FindBy(id = "greeting")
    @CacheLookup
    public WebElement greeting;

    public IndexPage(WebDriver driver) {
        // make sure we are on the correct page
        assertEquals("Cucumber example app", driver.getTitle());

        // fill all fields (instance variables) defined above
        PageFactory.initElements(driver, this);
    }
}
