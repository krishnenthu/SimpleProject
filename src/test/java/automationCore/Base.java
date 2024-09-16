package automationCore;

import constants.FilePath;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public FileInputStream fs;
    public Properties prop;

    public Base()  {
        prop = new Properties();
        try {
            fs = new FileInputStream(FilePath.CONFIG_FILE_PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

  /*  @BeforeMethod
    public void setUp() {
        String browserName = prop.getProperty("browser");
       // String browserName=browser;
        String url = prop.getProperty("url");
        driver = browserFactory.initBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }*/

    // Parameterized for cross browser testing
   @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) {
         String browserName=browser;
        String url = prop.getProperty("url");
        driver = browserFactory.initBrowser(browserName);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    public  String getScreenShot(String TestCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        String path=System.getProperty("user.dir")+"//Screenshot//"+TestCaseName+".png";
        FileUtils.copyFile(screenshotFile, new File(path));
        return path;

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws IOException {

        driver.close();

    }




}
