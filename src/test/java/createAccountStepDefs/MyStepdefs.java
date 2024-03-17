package createAccountStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs
{
    private CreateAccount createAccount;
    @Given("I am on the account creation page")
    public void iAmOnTheAccountCreationPage()
    {
    }

    @When("I fill in the member details with valid information")
    public void iFillInTheMemberDetailsWithValidInformation()
    {
    }

    @And("I choose a password")
    public void iChooseAPassword()
    {
    }

    @And("I accept the terms")
    public void iAcceptTheTerms()
    {
    }

    @And("I confirm I am of the required age")
    public void iConfirmIAmOfTheRequiredAge()
    {
    }

    @And("I agree to the code of ethics and conduct")
    public void iAgreeToTheCodeOfEthicsAndConduct()
    {
    }

    @And("I register the account")
    public void iRegisterTheAccount()
    {
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage()
    {
    }

    @When("I fill in the member details with valid information but without a last name")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutALastName()
    {
    }

    @And("I attempt to register the account")
    public void iAttemptToRegisterTheAccount()
    {
    }

    @Then("I should see an error message indicating the last name is missing")
    public void iShouldSeeAnErrorMessageIndicatingTheLastNameIsMissing()
    {
    }

    @And("I choose two different passwords")
    public void iChooseTwoDifferentPasswords()
    {
    }

    @Then("I should see an error message indicating the passwords do not match")
    public void iShouldSeeAnErrorMessageIndicatingThePasswordsDoNotMatch()
    {
    }

    @And("I do not accept the terms")
    public void iDoNotAcceptTheTerms()
    {
    }

    @Then("I should see an error message prompting me to accept the terms and conditions")
    public void iShouldSeeAnErrorMessagePromptingMeToAcceptTheTermsAndConditions()
    {
    }
}
