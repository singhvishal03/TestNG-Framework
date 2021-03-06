package E2Eproject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.Repeatable;

import java.io.IOException;

public class HomePage extends Repeatable {
    @Test(dataProvider = "getData")
    public void homePageNavigation(String userName, String password) throws IOException {

        LandingPage landingPage = new LandingPage(driver);
        if (landingPage.getPopUpSize() > 0) {
            landingPage.getPopUp().click();
        }
        landingPage.getLogIn().click();

        //invoking Login Page Methods/Objects
        LogInPage logInPage = new LogInPage(driver);
        logInPage.getEmail().sendKeys(userName);
        logInPage.getPassword().sendKeys(password);
        logInPage.logIn().click();
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
