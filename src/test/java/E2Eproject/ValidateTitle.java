package E2Eproject;

import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Repeatable;

public class ValidateTitle extends Repeatable {

    @Test
    public void validateTitle() {
        //validating Landing Page title
        Assert.assertEquals("" +
                "QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy", driver.getTitle());
    }
}