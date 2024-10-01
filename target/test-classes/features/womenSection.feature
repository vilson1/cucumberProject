Feature: women section
  Background: the user is logedIn
    When The user cliks login button
    And The user enter the email
    And The user enter the password
    And The user clik signin button

    @color_filter
    Scenario: check color filter
      When The user goes to women tops jacket page
      And The user filters the color
      Then The user verifies the color filter

  @add_to_items_cart
  Scenario: add an item in cart
    When The user goes to women tops jacket page
    And The user filters the color
    And The user add an item in cart