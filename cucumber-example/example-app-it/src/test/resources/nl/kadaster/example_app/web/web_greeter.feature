# the implementations of the given-when-then rules live in src/test/java/nl/kadaster/example_app/web/*Stepdefs.java
Feature: Get a greeting on the index page
  As a user of the Greeter web site
  I would like to receive a nice welcome
  so that I am happy with the product and feel like exploring more

  Scenario: Do not greet unknown users
    Given An unidentified user
    When he requests the index page
    Then he should see no greeting

  Scenario: Greet a user that has just set his name
    Given An unidentified user
    When he requests the index page
    And he enters "Alexander" as his name
    And clicks the "Set" button
    Then he should see a greeting "Hello, Alexander!" on the screen

  Scenario: Greet a user that we have seen before
    Given An unidentified user
    When he requests the index page
    And he enters "Thomas" as his name
    And clicks the "Set" button
    And he requests the index page again
    Then he should see a greeting "Hello, Thomas!" on the screen
