package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage {
    WebDriver driver;

    //Initialise Objects
    By logIn = By.xpath("//span[text()='Login']");
    By popUp = By.xpath("//button[text()='NO THANKS']");

    //constructor
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public WebElement getLogIn() {
        return driver.findElement(logIn);
    }

    public int getPopUpSize() {
        return driver.findElements(popUp).size();
    }


    public WebElement getPopUp() {
        return driver.findElement(popUp);
    }
}
