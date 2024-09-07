package automationCore;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class browserFactory {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver initBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            tlDriver.set(new EdgeDriver());
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else {
            throw new RuntimeException("Invalid Browser");
        }

        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
