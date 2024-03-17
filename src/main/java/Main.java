public class Main
{
    public static void main(String[] args)
    {
        //Create account creation object
        CreateAccount createAccount = new CreateAccount("https://membership.basketballengland.co.uk/NewSupporterAccount", "chrome");
        createAccount.navigateToURL();

        //Generate random strings for account re-creation
        GenerateRandom randomEmail = new GenerateRandom();
        randomEmail.generateRandomString();

        //Fill out Member Details fields
        createAccount.fillMemberDetails("24/07/1987",
                "Bjorn",
                "Ranelid",
                "testEmail" + randomEmail.getRandomString() + "@gmail.com",
                "testEmail" + randomEmail.getRandomString() + "@gmail.com");

        //Fill out password fields
        createAccount.fillChooseYourPassword("losenord", "losenord");

        //Accept Terms
        createAccount.acceptTerms();

        //Accept Age Limit
        createAccount.acceptAgeLimit();

        //Accept Code of Ethics and Conduct
        createAccount.acceptCodeOfEthicsAndConduct();

        //Register account
        //createAccount.registerAccount();

        //Close program and browser
        //createAccount.quitDriver();

    }
}
