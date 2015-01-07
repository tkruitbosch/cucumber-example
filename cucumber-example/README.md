# Cucumber-example

Provides a basic _Hello World_ for testing with Gherkin specifications using Cucumber.

## Sub projects

### example-app

There is a very simple web application in `example-app`, which consists of some Java code (a `Greeter`, which isn't
actually used here), and a single web page (`index.html`). The `Greeter` "service" is tested minimally using some
[Gherkin](https://github.com/cucumber/cucumber/wiki/Gherkin) specification, and
[Cucumber JVM](https://github.com/cucumber/cucumber-jvm) is used to glue this to JUnit.

### example-app-it

The `example-app-it` project contains all integration tests for the `example-app`'s web page. This demonstrates some
Gherkin test cases, and the link to a running web site using Cucumber JVM and
[WebDriver](http://docs.seleniumhq.org/projects/webdriver/).

## Running the tests

All tests can be run from the root directory (that is, the same directory as this Readme is located in) using this
command:

    mvn -Pintegration-test integration-test

Note that for the integration tests in `example-app-it` to work, a
[ChromeDriver](http://chromedriver.storage.googleapis.com/index.html) must be installed on the system,
the `chromedriver` executable should be in the `PATH`, and Chrome should be installed.

## IDE integration

When using IntelliJ IDEA, install the "Gherkin" and "Cucumber Java" plug-ins from IntelliJ. These will not only give
syntax highlighting for specification files, but also highlight any references to steps that have not been defined.