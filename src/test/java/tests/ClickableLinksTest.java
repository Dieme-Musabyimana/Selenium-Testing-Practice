package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ClickableLinks;

public class ClickableLinksTest extends BaseTest {

    @Test
    public void testAllLinks() {
        ClickableLinks checker = new ClickableLinks(driver);
        ClickableLinks.LinkReport report = checker.checkAllLinks();

        Assert.assertTrue(
                report.failed.isEmpty(),
                "Failed links: " + report.failed
        );
    }
}
