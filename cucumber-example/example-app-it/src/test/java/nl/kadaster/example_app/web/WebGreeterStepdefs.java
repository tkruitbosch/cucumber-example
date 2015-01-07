package nl.kadaster.example_app.web;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Implementation of the rules in the BDD (Gherkin) specifications. Note that the actual feature descriptions are in
 * {@code src/test/resources/nl/kadaster/example_app/web}.
 */
public class WebGreeterStepdefs {
    private static final String URL_BASE = "http://localhost:8081/example-app";

    private WebDriver driver;

    private IndexPage indexPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("^An unidentified user$")
    public void anUnidentifiedUser() {
        // nothing
    }

    @When("^he enters \"(.+)\" as his name$")
    public void heEntersHisName(String name) {
        indexPage.name.sendKeys(name);
    }

    @When("^he refreshes the page$")
    public void heRefreshesThePage() {
        driver.navigate().refresh();
        waitForPageToLoad();
        indexPage = new IndexPage(driver);
    }

    /**
     * Implementation for requesting the index page. Note that the word "again" at the end is optional, and the
     * {@code ?:} ensures that the group is not captured, so no parameter in the method definition is required.
     */
    @When("^he requests the index page(?: again)?$")
    public void heRequestsTheIndexPage() {
        driver.get(URL_BASE + "/");
        //new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Cucumber example app"));
        waitForPageToLoad();
        indexPage = new IndexPage(driver);
    }

    /**
     * Finds a button with the specified text and clicks it.
     *
     * @param text    the text of the button to click (that is, the part inside the {@code <button></button>} element)
     */
    @When("^clicks the \"(.+)\" button$")
    public void clicksTheButton(String text) {
        // Here we don't use the page helper class, but as an example we find the specified button manually here.
        // We could, of course, also have placed the button as an element in the page helper class.
        driver.findElement(By.xpath("//button[contains(text(),'" + text + "')]")).click();
    }

    @Then("^he should see no greeting$")
    public void heShouldSeeNoGreeting() {
        assertEquals("", indexPage.greeting.getText());
    }

    @Then("^he should see a greeting \"(.+)\" on the screen$")
    public void heShouldSeeAGreetingOnTheScreen(String expectedGreeting) {
        assertEquals(expectedGreeting, indexPage.greeting.getText());
    }

    /**
     * Makes sure that the current page has been loaded. This can be used to prevent racing conditions, where the
     * test code may sometimes be faster than the browser it controls, which could cause some tests to fail sometimes,
     * and we want the same result always (ie the tests must be deterministic).
     */
    private void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        Wait<WebDriver> wait = new WebDriverWait(driver, 7);
        try {
            wait.until(pageLoad);
        } catch (Throwable pageLoadWaitError) {
            fail("Timeout during page load");
        }
    }
}
