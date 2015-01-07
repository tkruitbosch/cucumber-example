# this is a very simple example for testing a Java library
Feature: Basic greeting
  As a user of the Greeter service
  I would like to get a nice welcome message
  so that I feel happy with the product.

  Background: a greeter
    Given a greeter

  Scenario: say hello
    When Peter asks for a greeting
    Then the result should be "Hello, Peter!"

  Scenario: say hello again
    When John asks for a greeting
    And  John asks for a greeting
    Then the result should be "Hello again, John!"
