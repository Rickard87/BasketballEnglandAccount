package createAccountStepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import basketball.CreateAccount;
import org.junit.Assert;

public class MyStepdefs {

    private CreateAccount createAccount;

    public void setUp(String url, String browser) {
        // Initialize browser once before running any scenario

        createAccount = new CreateAccount(url, browser);
        createAccount.navigateToURL();
    }

    @Given("I am on the account creation page")
    public void iAmOnTheAccountCreationPage() {

    }

    @When("I fill in the member details with valid information")
    public void iFillInTheMemberDetailsWithValidInformation() {
        // Implement this step
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        // Implement this step
    }

    @When("I fill in the member details with valid information but without a last name")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutALastName() {
        // Implement this step
    }

    @Then("I should see an error message indicating the last name is missing")
    public void iShouldSeeAnErrorMessageIndicatingTheLastNameIsMissing() {
        // Implement this step
    }

    @Then("I should see an error message indicating the passwords do not match")
    public void iShouldSeeAnErrorMessageIndicatingThePasswordsDoNotMatch() {
        // Implement this step
    }

    @Then("I should see an error message prompting me to accept the terms and conditions")
    public void iShouldSeeAnErrorMessagePromptingMeToAcceptTheTermsAndConditions() {
        // Implement this step
    }
    @After
    public void tearDown() {
        // Close browser after all scenarios are executed
        createAccount.quitDriver();
    }
}
