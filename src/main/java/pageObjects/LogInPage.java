package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

    WebDriver driver;

    //Initialise Objects
    By email = By.xpath("//input[@id='user_email']");
    By password = By.xpath("//input[@id='user_password']");
    By btnLogIn = By.xpath("//input[@value='Log In']");

    //Constructor
    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public WebElement getEmail()
    {
        return driver.findElement(email);
    }

    public WebElement getPassword()
    {
        return driver.findElement(password);
    }

    public WebElement logIn()
    {
        return driver.findElement(btnLogIn);
    }
}
