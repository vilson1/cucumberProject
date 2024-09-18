@sign_up
Feature: create new account

  Background:
    Given The user clicks create Account button

    Scenario: Checks if a new account ca be created
      When The user enter first name
      And The user enter last name

