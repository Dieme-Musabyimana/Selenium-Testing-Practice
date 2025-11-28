package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLoginPage {
    private WebDriver driver;

    public AccountLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By locateEmailField = By.cssSelector("input[data-aid='MEMBERSHIP_SSO_LOGIN_EMAIL']");
    private By locatePasswordField = By.cssSelector("input[data-aid='MEMBERSHIP_SSO_LOGIN_PASSWORD']");
    private By locateSignInButton = By.cssSelector("button[data-aid='MEMBERSHIP_SSO_SUBMIT']");

    public void enterEmail(String email){
        driver.findElement(locateEmailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(locatePasswordField).sendKeys(password);
    }

    public SecureAreaPage login(){
        driver.findElement(locateSignInButton).click();
        return new SecureAreaPage(driver);
    }
}
