package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ClickableLinks;

public class ClickableLinksTest extends BaseTest {
    @Test
    public void testAllLinks() {
        ClickableLinks linkChecker = new ClickableLinks(driver);
        ClickableLinks.LinkReport report = linkChecker.checkAllLinks();

        System.out.println("Clickable Links:");
        for (String text : report.clickableLinks) {
            System.out.println(text);
        }

        System.out.println("\nUnclickable Links:");
        for (String text : report.unclickableLinks) {
            System.out.println(text);
        }
    }
}
