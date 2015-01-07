package nl.kadaster.example_app;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Implementation of the steps in our feature file, using Cucumber JVM and JUnit.
 */
public class GreeterStepdefs {
    private Greeter greeter;
    private String result;

    @Given("^a greeter$")
    public void aGreeter() {
        greeter = new Greeter();
    }

    @When("^(.+) asks for a greeting$")
    public void asksForAGreeting(String name) {
        result = greeter.greet(name);
    }

    @Then("^the result should be \"(.+)\"$")
    public void theResultShouldBe(String expectedResult) {
        assertEquals(expectedResult, result);
    }
}
