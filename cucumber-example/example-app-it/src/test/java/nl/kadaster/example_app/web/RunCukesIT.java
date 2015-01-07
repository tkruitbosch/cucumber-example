package nl.kadaster.example_app.web;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Binds the JUnit test runner to execute all Cucumber tests (that is, all features defined in
 * {@code src/test/resources}).
 * <p/>
 * Note that we also generate an HTML report in the {@code target} directory.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = {
        "pretty", "html:target/cucumber-htmlreport", "json:target/cucumber-report.json"
}, dotcucumber = ".cucumber")
public class RunCukesIT {
    // nothing
}