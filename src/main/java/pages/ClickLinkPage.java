package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ClickLinkPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ClickLinkPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By homePageLink = By.linkText("Home");
    private By joinUsLink = By.linkText("JOIN US");
    private By britishComputerLink = By.linkText("British Computer Society");

    private void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void clickHome() {
        safeClick(homePageLink);
    }

    public void clickBritishComputer() {
        safeClick(britishComputerLink);
    }

    public void clickJoinUs() {
        safeClick(joinUsLink);
    }
}
