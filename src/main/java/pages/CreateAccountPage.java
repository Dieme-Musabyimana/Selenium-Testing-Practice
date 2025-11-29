package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage {

    private WebDriver driver;

    private By firstNameInput = By.cssSelector("input[data-aid='CREATE_ACCOUNT_NAME_FIRST']");
    private By lastNameInput  = By.cssSelector("input[data-aid='CREATE_ACCOUNT_NAME_LAST']");
    private By emailInput     = By.cssSelector("input[data-aid='CREATE_ACCOUNT_EMAIL']");
    private By phoneInput     = By.cssSelector("input[data-aid='CREATE_ACCOUNT_PHONE']");
    private By createAccountButton = By.cssSelector("button[data-ux-btn='primary']");
    private By successMessage = By.xpath("//h4[text()='Check your email']");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public boolean isAccountCreatedMessageDisplayed() {
        try {
            return driver.findElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
