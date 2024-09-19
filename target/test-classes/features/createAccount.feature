 @create_account
  Feature: Create account tests

    Background:
      Given The user clicks create account button

      Scenario: check if an account can be created
        Given verify that user is in create account page

        When The user enter first name "Sandri"
        And The user enter last name "shehu"
        And The user enter email
        And the user enter password
        And The user enter comfirm password
        And The user cliks create account button
        Then The user verifies the success message