package listeners;

import Report.ExtentManage;
import automationCore.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener extends Base implements ITestListener {

    ExtentReports extent = ExtentManage.getReport();
    ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();


    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started");
    }


    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(result.getMethod().getMethodName() + " Started");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(result.getMethod().getMethodName() + " Passed");
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String filePath=null;

        System.out.println(result.getMethod().getMethodName() + " Failed");
        test.get().fail(result.getThrowable());

        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
             filePath=getScreenShot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Skipped");
        test.get().skip(result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context) {

        System.out.println("Test Suite Finished");
        extent.flush();
    }

}
