package createAccountStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import basketball.CreateAccount;
import basketball.GenerateRandom;

public class MyStepdefs
{
    private CreateAccount createAccount;
    private String browser;
    private String date;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Given("I provide starting values of browser {string} date {string} firstName {string} lastName {string} email {string} and password {string}")
    public void iProvideStartingValuesOfBrowserDateFirstNameLastNameEmailAndPassword(String browser, String date, String firstName, String lastName, String email, String password)
    {
        this.browser = browser;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @And("I navigate to the account creation page using browser")
    public void iNavigateToTheAccountCreationPageUsingBrowser()
    {
        createAccount = new CreateAccount("https://membership.basketballengland.co.uk/NewSupporterAccount", browser);
        createAccount.navigateToURL();
    }

    @When("I fill in the member details with valid information but without a last name")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutALastName()
    {
        GenerateRandom randomEmail = new GenerateRandom();
        createAccount.fillMemberDetails(date, firstName, "", email + randomEmail.getRandomString() + "@gmail.com", email + randomEmail.getRandomString() + "@gmail.com");
    }

    @Then("I should see an error message indicating the last name is missing")
    public void iShouldSeeAnErrorMessageIndicatingTheLastNameIsMissing()
    {
    }

    @When("I fill in the member details with valid information but without matching passwords")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutMatchingPasswords()
    {
    }

    @Then("I should see an error message indicating the passwords do not match")
    public void iShouldSeeAnErrorMessageIndicatingThePasswordsDoNotMatch()
    {
    }

    @When("I fill in the member details with valid information but without accepting the terms and conditions")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutAcceptingTheTermsAndConditions()
    {
    }

    @Then("I should see an error message prompting me to accept the terms and conditions")
    public void iShouldSeeAnErrorMessagePromptingMeToAcceptTheTermsAndConditions()
    {
    }

    @When("I fill in the member details with valid information")
    public void iFillInTheMemberDetailsWithValidInformation()
    {
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage()
    {
    }


}
