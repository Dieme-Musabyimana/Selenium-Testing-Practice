package tests;

import base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.ClickLinkPage;

public class ClickLinkTest extends BaseTest {

    @Test
    public void testLink() {

        ClickLinkPage clickLink = new ClickLinkPage(driver);
        clickLink.clickHome();
        clickLink.clickBritishComputer();
        clickLink.clickJoinUs();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
