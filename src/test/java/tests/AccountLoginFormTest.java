package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AccountLoginPage;
import pages.ClickLinkPage;

public class AccountLoginFormTest extends BaseTest {

    @Test
    public void loginTest() {

        ClickLinkPage clickLinks = new ClickLinkPage(driver);
        clickLinks.clickJoinUs();

        AccountLoginPage loginPage = new AccountLoginPage(driver);
        loginPage.enterEmail("didy@gmail.com");
        loginPage.enterPassword("John12!");
        loginPage.login();
    }
}
