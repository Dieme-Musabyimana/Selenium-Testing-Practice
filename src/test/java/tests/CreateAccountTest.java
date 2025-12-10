package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountLoginPage;
import pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccountTest() {
        AccountLoginPage loginPage = homePage.clickJoinUs();
        CreateAccountPage page = loginPage.clickCreateAccount();

        page.enterFirstName("Dieme");
        page.enterLastName("Musabyimana");
        page.enterEmail("musabyimanadieme10@gmai.lcom");
        page.enterPhone("0786706621");
        page.submit();

        Assert.assertTrue(
                page.isMessageVisible(),
                "Success heading was not visible"
        );

        Assert.assertTrue(
                page.getMessageText().contains("email"),
                "Success message text incorrect: " + page.getMessageText()
        );
    }

}
