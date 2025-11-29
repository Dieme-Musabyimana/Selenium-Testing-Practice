package tests;

import base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.ClickLinkPage;

public class HomePageTest extends BaseTest {

    @Test
    public void testLinkNavigation() throws InterruptedException {

        ClickLinkPage clickLink = new ClickLinkPage(driver);

        clickLink.clickJoinUs();
        Thread.sleep(1500);
        driver.navigate().back();
        Thread.sleep(1500);

        String homeWindow = driver.getWindowHandle();
        clickLink.clickBritishComputer();
        Thread.sleep(1500);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(homeWindow)) {
                driver.switchTo().window(handle);
                Thread.sleep(1500);
                driver.close();
                driver.switchTo().window(homeWindow);
                break;
            }
        }

        clickLink.clickHome();
        Thread.sleep(1500);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
