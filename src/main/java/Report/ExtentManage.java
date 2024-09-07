package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentManage implements ITestListener {

    public ExtentSparkReporter extentSpark ;
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Started");
        extentSpark=new ExtentSparkReporter(System.getProperty("user.dir")+"./Reports"+"ExtentReport.html");
        extentSpark.config().setDocumentTitle("Test Execution Result");
        extentSpark.config().setReportName("Regression Result");
        extentSpark.config().setTheme(Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSpark);
        extentReports.setSystemInfo("Computer Name" ,"Localhost");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Tester", "Krishnenthu");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Finished");
        extentReports.flush();
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Passed");
        extentTest= extentReports.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
       // extentTest.log(Status.PASS,"The Test passed is " +result.getName());
        extentTest.log(Status.PASS,MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Failed");
        extentTest=extentReports.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.FAIL,"The Test failed is"+result.getName());
      //  extentTest.log(Status.FAIL,"The Reason for failure is "+result.getThrowable());
        extentTest.log(Status.PASS,MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Skipped");
        extentTest=extentReports.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.log(Status.SKIP,"The test skipped is"+result.getName());
    }

}
