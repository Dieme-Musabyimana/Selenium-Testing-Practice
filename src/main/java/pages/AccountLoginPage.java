package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountLoginPage {
    private WebDriver driver;

    public AccountLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By emailField = By.cssSelector("input[placeholder='Email']");
    private By passwordField = By.cssSelector("input[placeholder='Password']");
    private By signInButton = By.cssSelector("button[data-aid='MEMBERSHIP_SSO_SUBMIT']");
    private By createAccountLink = By.partialLinkText("Create account");
    private By loginErrorMessage = By.xpath(
            "//*[contains(text(),'password/email address combo is incorrect')]"
    );

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage login(){
        driver.findElement(signInButton).click();
        return new SecureAreaPage(driver);
    }

    public CreateAccountPage clickCreateAccount(){
        driver.findElement(createAccountLink).click();
        return new CreateAccountPage(driver);
    }
    public String getLoginErrorMessage(){
        return driver.findElement(loginErrorMessage).getText();
    }

    public boolean isLoginErrorDisplayed(){
        return driver.findElement(loginErrorMessage).isDisplayed();
    }
}
