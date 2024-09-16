package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManage {

    public static ExtentReports getReport(){

        ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+"index.html");
        sparkReporter.config().setDocumentTitle("Simple Project Report");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setTheme(Theme.DARK);

        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Krishnenthu");
        extentReports.setSystemInfo("OS", "Windows");
        return extentReports;

    }



}
