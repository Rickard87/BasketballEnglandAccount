Feature: AccountCreation
  As a new user
  I want to create a new account
  So that I can access the Basketball England membership platform

  Background: I have navigated to the account creation website
    Given I navigate to the account creation page with "<url>" using "<browser>"

  Scenario: Create user - everything goes as expected and an account is created
    Given I am on the account creation page
    When I fill in the member details with valid information
    Then I should see a confirmation message

  Scenario: Create user - last name is missing
    Given I am on the account creation page
    When I fill in the member details with valid information but without a last name
    Then I should see an error message indicating the last name is missing

  Scenario: Create user - password does not match
    Given I am on the account creation page
    When I fill in the member details with valid information
    Then I should see an error message indicating the passwords do not match

  Scenario: Create user - terms and conditions are not accepted
    Given I am on the account creation page
    When I fill in the member details with valid information
    Then I should see an error message prompting me to accept the terms and conditions
