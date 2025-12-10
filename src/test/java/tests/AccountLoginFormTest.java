package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountLoginPage;

public class AccountLoginFormTest extends BaseTest {


    @Test
    public void UnsuccessfulLoginTest() {

        AccountLoginPage loginPage = homePage.clickJoinUs();

        loginPage.enterEmail("didy@gmail.com");
        loginPage.enterPassword("!");
        loginPage.login();

        Assert.assertTrue(
                loginPage.isLoginErrorDisplayed(),
                "Login should fail but error message was not displayed"
        );
    }
}
