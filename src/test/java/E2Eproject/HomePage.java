package E2Eproject;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Repeatable;

import java.io.IOException;

public class HomePage extends Repeatable {

    @BeforeTest
    public void initialise() throws IOException {
        driver = initialiseDriver();
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "getData")
    public void homePageNavigation(String userName, String password) throws IOException {

        driver.get(getURL());
        //invoking Landing Page Methods/Objects
        new LandingPage(driver).getLogIn().click();

        //invoking Login Page Methods/Objects
        new LogInPage(driver).getEmail().sendKeys(userName);
        new LogInPage(driver).getPassword().sendKeys(password);
        new LogInPage(driver).logIn().click();
    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];
        //rows are for number of different data types test should run
        //column is for how many values for each test
        data[0][0] = "demo@gmail.com";
        data[0][1] = "demo";

        data[1][0] = "demo2@gmail.com";
        data[1][1] = "demo2";

        return data;
    }

}
