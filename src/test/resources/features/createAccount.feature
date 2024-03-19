Feature: AccountCreation
  As a new user
  I want to create a new account
  So that I can access the Basketball England membership platform

  Scenario Outline: Creating account with invalid and valid information
    Given I provide starting values of browser "<browser>" date "<date>" firstName "<firstName>" lastName "<lastName>" email "<email>" and password "<password>"
    When I fill in the member details with valid information but without a last name
    Then I should see an error message indicating the last name is missing
    When I fill in the member details with valid information but without matching passwords
    Then I should see an error message indicating the passwords do not match
    When I fill in the member details with valid information but without accepting the terms and conditions
    Then I should see an error message prompting me to accept the terms and conditions
    When I fill in the member details with valid information
    Then I should see a confirmation message


    Examples:
      | browser | date       | firstName | lastName | email     | password |
      | chrome  | 24/07/1987 | Bjorn     | Ranelid  | testEmail | hejsan   |
      | edge    | 24/07/1987 | Bjorn     | Ranelid  | testEmail | hejsan   |