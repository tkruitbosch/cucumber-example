package nl.kadaster.example_app;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Binds the JUnit test runner to execute all Cucumber tests (that is, all features defined in
 * {@code src/test/resources}).
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = "json:target/cucumber-report.json", dotcucumber = ".cucumber")
public class RunCukesTest {
    // nothing
}