package E2Eproject;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.GenerateReport;
import resources.Repeatable;

import java.util.Arrays;
import static resources.Repeatable.getScreenshot;

public class Listeners extends GenerateReport implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        test = extentReport.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String logText = "<b> Test Method " + result.getMethod().getMethodName() + " passed successfully </b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.get().log(Status.PASS, markup);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        extentTest.get().fail("<details><summary><font color=red>" +
                "Exception Occurred, Click to see details:" +
                "</font></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

        try {
            extentTest.get().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot(Repeatable.driver)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String logText = "Test Method " + result.getMethod().getMethodName() + "failed";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
        extentTest.get().log(Status.FAIL, markup);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String logText = "<b> Test Method " + result.getMethod().getMethodName() + "skipped. </b>";
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.get().log(Status.SKIP, markup);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
    }

}
