package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModelHandling {

    private WebDriver driver;
    private By closeModalButton = By.id("popup-widget183-close-icon");

    public ModelHandling(WebDriver driver) {
        this.driver = driver;
    }

    public void closePopupIfPresent() {
        try {
            Thread.sleep(1500);

            if (driver.findElement(closeModalButton).isDisplayed()) {
                driver.findElement(closeModalButton).click();
                Thread.sleep(1500);
                System.out.println("Popup closed successfully.");
            }

        } catch (Exception e) {
            System.out.println("No popup found. Continuing found");
        }
    }
}
