package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class GenerateReport {
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReport;

    public static ExtentTest test;
    public static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static String destination;

    public static void getReportObject() throws IOException {
        String reportName = getReportName();
        destination = System.getProperty("user.dir") + "//reports//" + reportName;

        //configuring the report and load reporter through XML or JSON
        sparkReporter = new ExtentSparkReporter(destination);
        File file = new File(System.getProperty("user.dir") + "//src//main//java//resources//extent_report_config.json");
        sparkReporter.loadJSONConfig(file);
//        reporter.loadXMLConfig(file);

        //creating report with configured data
        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);
        extentReport.setSystemInfo("Tester", "Vishal Singh");
        extentReport.setSystemInfo("OS", System.getProperty("os.name"));
        extentReport.setSystemInfo("JAVA version", System.getProperty("java.version"));

    }

    public static String getReportName() {
        Date date = new Date();
        return "AutomationReport" + date.toString().replaceAll(":", "_").replaceAll(" ", "_") + ".html";
    }

    public static void closeReport() {
        extentReport.flush();
    }
}
