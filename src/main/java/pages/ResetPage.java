package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.TestHelperUtility;

public class ResetPage extends TestHelperUtility {

    public WebDriver driver;

    public ResetPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
