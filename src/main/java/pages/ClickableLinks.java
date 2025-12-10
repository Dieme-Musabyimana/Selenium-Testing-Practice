package pages;

import org.openqa.selenium.*;
import java.util.*;

public class ClickableLinks {

    private WebDriver driver;

    public ClickableLinks(WebDriver driver) {
        this.driver = driver;
    }

    public LinkReport checkAllLinks() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        List<String> failed = new ArrayList<>();
        String main = driver.getWindowHandle();

        for (WebElement link : links) {
            String text = link.getText().trim();
            if (text.isEmpty()) text = link.getAttribute("href");

            String href = link.getAttribute("href");
            if (href == null || href.isEmpty()) {
                failed.add(text);
                continue;
            }

            try {
                ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", href);
                for (String w : driver.getWindowHandles()) {
                    if (!w.equals(main)) {
                        driver.switchTo().window(w);
                        driver.close();
                    }
                }
                driver.switchTo().window(main);
            } catch (Exception e) {
                failed.add(text);
            }
        }
        return new LinkReport(failed);
    }

    public static class LinkReport {
        public List<String> failed;

        public LinkReport(List<String> failed) {
            this.failed = failed;
        }
    }
}
