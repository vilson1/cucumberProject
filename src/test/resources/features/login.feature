Feature: test login
  Background:
    When The user cliks login button
 @login
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



