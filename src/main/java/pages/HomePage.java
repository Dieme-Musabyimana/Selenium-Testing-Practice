package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By homeLink = By.linkText("Home");
    private By joinUsLink = By.linkText("JOIN US");
    private By signInButton = By.cssSelector("button[data-aid='MEMBERSHIP_SSO_SUBMIT']");

    // Click Actions
    public void clickHome() {
        driver.findElement(homeLink).click();
    }

    public void clickJoinUs() {
        driver.findElement(joinUsLink).click();
    }

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    // Visibility Checks
    public boolean isHomeVisible() {
        return driver.findElement(homeLink).isDisplayed();
    }

    public boolean isJoinUsVisible() {
        return driver.findElement(joinUsLink).isDisplayed();
    }

    public boolean isSignInVisible() {
        return driver.findElement(signInButton).isDisplayed();
    }
}
