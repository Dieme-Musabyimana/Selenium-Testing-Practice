package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountLoginPage;
import pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccountTest() {


        AccountLoginPage loginPage = homePage.clickJoinUs();

        CreateAccountPage create = loginPage.clickCreateAccount();


        create.enterFirstName("Dieme");
        create.enterLastName("Musabyimana");
        create.enterEmail("diy@gmail.com");
        create.enterPhone("0786706621");

        create.clickCreateAccount();

    }
}
