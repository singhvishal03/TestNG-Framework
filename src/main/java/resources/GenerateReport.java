package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class GenerateReport {

    @BeforeTest
    public static ExtentReports getReportObject() {
        String destination = System.getProperty("user.dir") + "//Reports";
        //configuring the report
        ExtentSparkReporter reporter = new ExtentSparkReporter(destination);
        reporter.config().setDocumentTitle("Automated Test Case Results");
        reporter.config().setReportName("Web Automation Results");

        //creating report with configured data
        ExtentReports report = new ExtentReports();
        report.attachReporter(reporter);
        report.setSystemInfo("Tester", "Vishal Singh");

        return report;
    }

}
