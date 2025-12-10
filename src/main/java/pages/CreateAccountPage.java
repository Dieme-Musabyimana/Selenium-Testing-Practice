package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By firstNameInput = By.cssSelector("input[placeholder='First name']");
    private By lastNameInput = By.cssSelector("input[placeholder='Last name']");
    private By emailInput = By.cssSelector("input[placeholder='Email']");
    private By phoneInput = By.cssSelector("input[placeholder='Phone (optional)']");
    private By createAccountButton = By.cssSelector("button[data-ux-btn='primary']");
    private By successTitle = By.xpath("//h4[contains(text(),'Check your email')]");
    private By successMessage = By.cssSelector("p[data-aid='CREATE_ACCOUNT_DESCRIPTION_REND']");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFirstName(String value) {
        driver.findElement(firstNameInput).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastNameInput).sendKeys(value);
    }

    public void enterEmail(String value) {
        driver.findElement(emailInput).sendKeys(value);
    }

    public void enterPhone(String value) {
        driver.findElement(phoneInput).sendKeys(value);
    }

    public void submit() {
        driver.findElement(createAccountButton).click();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successTitle)).getText();
    }

    public String getMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public boolean isMessageVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successTitle));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
