package basketball;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccount
{
    //Remember to run this program in new intelliJ CTRL + ALT + L

    //Initializing helpers
    String url;
    WebDriver driver;
    Duration duration = Duration.ofSeconds(6);

    WebDriverWait wait;


    //Is checked booleans
    boolean termsAndConditionsChecked = false;
    boolean codeOfEthicsAndConductChecked = false;
    boolean ageLimitChecked = false;

    public CreateAccount(String url, String browser)
    {
        this.url = url;

        switch (browser)
        {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }

        wait = new WebDriverWait(driver, duration);
    }
    public void navigateToURL()
    {
        //Navigate to Create account page
        driver.get(url);
    }

    //Fills out necessary Member Details fields
    public void fillMemberDetails(String dateOfBirth, String firstName, String lastName, String email, String confirmEmail)
    {
        //Fill DateOfBirth
        WebElement dopField = getElement(By.xpath("//*[@id=\"dp\"]"));
        dopField.sendKeys(dateOfBirth);

        //Fill first name
        WebElement nameField = getElement(By.id("member_firstname"));
        nameField.click(); //Click name field first and confirm that date picker disappears
        waitToDisappear(By.className("table-condensed"));
        nameField.sendKeys(firstName);

        //Fill last name
        WebElement lastNameField = getElement((By.id("member_lastname")));
        lastNameField.sendKeys(lastName);

        //Fill email
        WebElement emailField = getElement(By.id("member_emailaddress"));
        emailField.sendKeys(email);

        //Fill confirmEmail
        WebElement confirmEmailField = getElement(By.id("member_confirmemailaddress"));
        confirmEmailField.sendKeys(confirmEmail);

    }

    //Fills out necessary Password fields
    public void fillChooseYourPassword(String password, String confirmPassword)
    {
        //Fill password
        WebElement passwordField = getElement(By.id("signupunlicenced_password"));
        passwordField.sendKeys(password);

        //Fill confirmPassword
        WebElement confirmPasswordField = getElement((By.id("signupunlicenced_confirmpassword")));
        confirmPasswordField.sendKeys(confirmPassword);
    }

    //Clicks accept on necessary terms boxes
    public void acceptTerms()
    {
        WebElement termsAndConditionsBox = getElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[1]/label/span[3]"));
        termsAndConditionsBox.click();
        termsAndConditionsChecked = true;
    }

    public void acceptAgeLimit()
    {
        WebElement ageLimitBox = getElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[2]/div[2]/label/span[3]"));
        ageLimitBox.click();
        ageLimitChecked = true;
    }

    public void acceptCodeOfEthicsAndConduct()
    {
        WebElement codeOfEthicsAndConductBox = getElement(By.xpath("//*[@id=\"signup_form\"]/div[11]/div/div[7]/label/span[3]"));
        codeOfEthicsAndConductBox.click();
        codeOfEthicsAndConductChecked = true;
    }

    public void registerAccount()
    {
        WebElement registerButton = getElement(By.xpath("//*[@id=\"signup_form\"]/div[12]/input"));
        registerButton.click();
    }
    public void quitDriver()
    {
        driver.quit();
    }
    public WebElement getElement(By by)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToDisappear(By by)
    {
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(by)));
    }
}
