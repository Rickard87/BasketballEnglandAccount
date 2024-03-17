Feature: AccountCreation
  As a new user
  I want to create a new account
  So that I can access the Basketball England membership platform

  Background: I have navigated to the account creation website
    Given I am on the account creation page

  Scenario: Create user - everything goes as expected and an account is created
    Given I am on the account creation page
    When I fill in the member details with valid information
    And I choose a password
    And I accept the terms
    And I confirm I am of the required age
    And I agree to the code of ethics and conduct
    And I register the account
    Then I should see a confirmation message

  Scenario: Create user - last name is missing
    Given I am on the account creation page
    When I fill in the member details with valid information but without a last name
    And I choose a password
    And I accept the terms
    And I confirm I am of the required age
    And I agree to the code of ethics and conduct
    And I attempt to register the account
    Then I should see an error message indicating the last name is missing

  Scenario: Create user - password does not match
    Given I am on the account creation page
    When I fill in the member details with valid information
    And I choose two different passwords
    And I accept the terms
    And I confirm I am of the required age
    And I agree to the code of ethics and conduct
    And I attempt to register the account
    Then I should see an error message indicating the passwords do not match

  Scenario: Create user - terms and conditions are not accepted
    Given I am on the account creation page
    When I fill in the member details with valid information
    And I choose a password
    And I do not accept the terms
    And I confirm I am of the required age
    And I agree to the code of ethics and conduct
    And I attempt to register the account
    Then I should see an error message prompting me to accept the terms and conditions
