package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Repeatable {
   public WebDriver driver;

    public WebDriver initialiseDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("D://Projects//E2Eproject//src//main//java//resources//data.properties");
        properties.load(file);
        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D://Projects//SeleniumDriver//chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("mozilla")) {
            System.setProperty("webdriver.gecko.driver", "D://Projects//SeleniumDriver//geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "D://Projects//SeleniumDriver//msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return driver;
    }
}
