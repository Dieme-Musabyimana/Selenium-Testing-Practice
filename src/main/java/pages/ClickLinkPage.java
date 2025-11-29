package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickLinkPage {
    private WebDriver driver;

    public ClickLinkPage(WebDriver driver) {
        this.driver = driver;
    }

    private By homePageLink = By.xpath("//a[text()='Home']");
    private By joinUsLink = By.linkText("JOIN US");
    private By britishComputerLink = By.cssSelector("a[href='https://www.bcs.org/']");


    public void clickHome() {
        driver.findElement(homePageLink).click();
    }

    public void clickBritishComputer() {
        driver.findElement(britishComputerLink).click();
    }

    public void clickJoinUs() {
        driver.findElement(joinUsLink).click();
    }
}
