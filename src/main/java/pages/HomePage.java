package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By joinUs = By.partialLinkText("JOIN US");

    public AccountLoginPage clickJoinUs() {
        driver.findElement(joinUs).click();
        return new AccountLoginPage(driver);
    }
}
