package createAccountStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import basketball.CreateAccount;
import basketball.GenerateRandom;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyStepdefs {
    private CreateAccount createAccount;
    private String browser;
    private String date;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Given("I provide starting values of browser {string} date {string} firstName {string} lastName {string} email {string} and password {string}")
    public void iProvideStartingValuesOfBrowserDateFirstNameLastNameEmailAndPassword(String browser, String date, String firstName, String lastName, String email, String password) {
        this.browser = browser;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        GenerateRandom randomEmail = new GenerateRandom();
        randomEmail.generateRandomString();
        this.email = email + randomEmail.getRandomString() + "@gmail.com";
        this.password = password;
    }

    @When("I fill in the member details with valid information but without a last name")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutALastName() {
        StartBrowser();
        createAccount.fillMemberDetails(
                date,
                firstName,
                "",
                email,
                email
        );
        createAccount.registerAccount();
        System.out.println(email);
    }

    @Then("I should see an error message indicating the last name is missing")
    public void iShouldSeeAnErrorMessageIndicatingTheLastNameIsMissing() {
        WebElement lastNameError = createAccount.getElement(By.xpath("//*[@id=\"signup_form\"]/div[5]/div[2]/div/span/span"));
        String Actual = lastNameError.getText();
        String Expected = "Last Name is required";
        createAccount.quitDriver();
        System.out.println(Actual + ", " + Expected);
        Assert.assertEquals(Actual, Expected);
    }

    @When("I fill in the member details with valid information but without matching passwords")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutMatchingPasswords() {
        StartBrowser();
        createAccount.fillMemberDetails(
                date,
                firstName,
                lastName,
                email,
                email
        );
        createAccount.fillChooseYourPassword(password, password + "a");
        createAccount.registerAccount();
        System.out.println(email);
    }

    @Then("I should see an error message indicating the passwords do not match")
    public void iShouldSeeAnErrorMessageIndicatingThePasswordsDoNotMatch() {
        WebElement passwordMismatch = createAccount.getElement(By.xpath("//*[@id=\"signup_form\"]/div[8]/div/div[2]/div[2]/div/span/span"));
        String Actual = passwordMismatch.getText();
        String Expected = "Password did not match";
        createAccount.quitDriver();
        System.out.println(Actual + ", " + Expected);
        Assert.assertEquals(Actual, Expected);
    }

    @When("I fill in the member details with valid information but without accepting the terms and conditions")
    public void iFillInTheMemberDetailsWithValidInformationButWithoutAcceptingTheTermsAndConditions() {
        StartBrowser();
        createAccount.fillMemberDetails(
                date,
                firstName,
                lastName,
                email,
                email
        );
        createAccount.acceptAgeLimit();
        createAccount.acceptCodeOfEthicsAndConduct();
        createAccount.registerAccount();
        System.out.println(email);
    }

    @Then("I should see an error message prompting me to accept the terms and conditions")
    public void iShouldSeeAnErrorMessagePromptingMeToAcceptTheTermsAndConditions() {
        WebElement termsNotAccepted = createAccount.getElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/span/span"));
        String Actual = termsNotAccepted.getText();
        String Expected = "You must confirm that you have read and accepted our Terms and Conditions";
        createAccount.quitDriver();
        System.out.println(Actual + ", " + Expected);
        Assert.assertEquals(Actual, Expected);
    }

    @When("I fill in the member details with valid information")
    public void iFillInTheMemberDetailsWithValidInformation() {
        StartBrowser();
        createAccount.fillMemberDetails(
                date,
                firstName,
                lastName,
                email,
                email
        );
        createAccount.fillChooseYourPassword(password, password);
        createAccount.acceptTerms();
        createAccount.acceptAgeLimit();
        createAccount.acceptCodeOfEthicsAndConduct();
        createAccount.registerAccount();
        System.out.println(email);
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        WebElement registrationSuccess = createAccount.getElement(By.xpath("/html/body/div/div[2]/div/div/h5"));
        String Actual = registrationSuccess.getText();
        String Expected = "Your Basketball England Membership Number is:";
        createAccount.quitDriver();
        System.out.println(Actual + ", " + Expected);
        Assert.assertEquals(Actual, Expected);
    }

    public void StartBrowser() {
        createAccount = new CreateAccount("https://membership.basketballengland.co.uk/NewSupporterAccount", browser);
        createAccount.navigateToURL();
    }
}
