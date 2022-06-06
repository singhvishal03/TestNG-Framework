package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Repeatable {
    public static WebDriver driver;
    private static Properties properties;

    public static String getConfigData() {
        return properties.getProperty("url");
    }

    public static String getScreenshot(WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }

    @BeforeMethod
    public WebDriver initialiseDriver() throws IOException {
        String configFile = System.getProperty("user.dir") + "//src//main//java//resources//data.properties";
        FileInputStream file = new FileInputStream(configFile);
        properties = new Properties();
        properties.load(file);
        //mvn test -DBrowser="browser name" (to run from maven )
        String browserName = System.getProperty("browser");
//        String browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get(getConfigData());
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeSuite
    public void setReport() throws IOException {
        GenerateReport.getReportObject();
    }

    @AfterSuite
    public void endReport() {
        GenerateReport.closeReport();
    }

}
