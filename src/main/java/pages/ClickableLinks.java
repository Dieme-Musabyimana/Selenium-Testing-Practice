package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ClickableLinks {
    private WebDriver driver;

    public ClickableLinks(WebDriver driver) {
        this.driver = driver;
    }

    public LinkReport checkAllLinks() {
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        List<String> clickableLinks = new ArrayList<>();
        List<String> unclickableLinks = new ArrayList<>();
        String mainWindow = driver.getWindowHandle();

        for (WebElement link : allLinks) {
            String linkText = link.getText().trim();
            if (linkText.isEmpty()) {
                linkText = link.getAttribute("href");
            }

            String href = link.getAttribute("href");
            if (href == null || href.isEmpty()) {
                unclickableLinks.add(linkText);
                continue;
            }

            try {
                ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", href);
                Set<String> windows = driver.getWindowHandles();
                for (String handle : windows) {
                    if (!handle.equals(mainWindow)) {
                        driver.switchTo().window(handle);
                        driver.close();
                    }
                }
                driver.switchTo().window(mainWindow);
                clickableLinks.add(linkText);
            } catch (Exception e) {
                unclickableLinks.add(linkText);
            }
        }

        return new LinkReport(clickableLinks, unclickableLinks);
    }

    public static class LinkReport {
        public List<String> clickableLinks;
        public List<String> unclickableLinks;

        public LinkReport(List<String> clickableLinks, List<String> unclickableLinks) {
            this.clickableLinks = clickableLinks;
            this.unclickableLinks = unclickableLinks;
        }
    }
}
