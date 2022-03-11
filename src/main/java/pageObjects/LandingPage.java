package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;

    //Initialise Objects
    By logIn = By.xpath("//span[text()='Login']");

    //constructor
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public WebElement getLogIn()
    {
        return driver.findElement(logIn);
    }
}
