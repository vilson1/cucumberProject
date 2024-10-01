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

    @sort_by_price
    Scenario: check sorting by price
      When The user goes to women tops jacket page
      And The user select the filter "price"
      Then The user verifies that prices are in ascending order

  @size_filter
  Scenario: check size filter
    When The user goes to women tops jacket page
    And The user select the size filter
    Then The user verifies that all items has size selected