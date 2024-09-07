package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished");
    }
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" Skipped");
    }

}
