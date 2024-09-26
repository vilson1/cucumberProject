@login
Feature: test login
  Background:
    When The user cliks login button
 @login4
    Scenario Outline: check login "<loginchechek>"
      When The user enter "<email>" in login button
      And The user enter password "<password>"
      And The user clik signin button

   Examples:
         |email        |password   |loginchechek                   |
         |test@test.com| 1234567890|correct credentioals           |
         |             |           |without credentials            |
         |             | 1234567890|without email                  |
         |testt@test.com|          |without password               |

   @login1
   Scenario: check login When The user enter "<email>" in login button
     When The user enter "<email>" in login button
     And The user enter password "<password>"
     And The user clik signin button
     Then The user verifies the following elements
     |eleminti 1|elementi 2|elementi 3|

     @login2
     Scenario: login
       When The user enter the email
       And The user enter the password
       And The user clik signin button
       Then The user verifies that is logedin

  @login3
  Scenario: login
    When The user enter the email
    And The user enter the password
    And The user clik signin button
    Then verifies the following elements in homepage
    |welcome message|search bar|





