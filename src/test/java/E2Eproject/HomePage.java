package E2Eproject;

import org.junit.Test;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Repeatable;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePage extends Repeatable {

    @Test
    public void homePageNavigation() throws IOException {
        driver = initialiseDriver();
        driver.get("http://www.qaclickacademy.com/");
        driver.manage().window().maximize();

        //invoking Landing Page Methods/Objects
        new LandingPage(driver).getLogIn().click();

        //invoking Login Page Methods/Objects
        new LogInPage(driver).getEmail().sendKeys("abcd@gmail.com");
        new LogInPage(driver).getPassword().sendKeys("abcd");
        new LogInPage(driver).logIn().click();
    }

}
