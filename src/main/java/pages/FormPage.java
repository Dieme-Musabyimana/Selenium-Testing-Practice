package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By submitButton = By.id("submit");

    public void fillForm(String name, String email) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}
