package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountLoginPage;

public class AccountLoginFormTest extends BaseTest {

    @Test
    public void loginTest() {
        AccountLoginPage loginPage = homePage.clickJoinUs();

        loginPage.enterEmail("didy@gmail.com");
        loginPage.enterPassword("John12!");
        loginPage.login();
    }
}
