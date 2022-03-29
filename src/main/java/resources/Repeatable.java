package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Repeatable {
    public WebDriver driver;
    public Properties properties;
    public FileInputStream file;

    public WebDriver initialiseDriver() throws IOException {

        file = new FileInputStream("D://Projects//E2Eproject//src//main//java//resources//data.properties");
        properties = new Properties();
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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    public String getURL() throws IOException {
        properties = new Properties();
        file = new FileInputStream("D://Projects//E2Eproject//src//main//java//resources//data.properties");
        properties.load(file);
        return properties.getProperty("url");
    }

    public void getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "//Reports//" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
    }
}
