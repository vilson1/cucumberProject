
Feature: test

  Background: test
    When test background

  @search
  Scenario: search For Apple
    When The user is in google page
    And The user search for apple
    Then the user verifies that apple is in page title

   @search2
    Scenario: search for phones
    When The user is in google page
    And The user search for phones
    Then the user verifies that phone is in page title



