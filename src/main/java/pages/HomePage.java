package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {

    public WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private  final String _loggedInUsername="//a[@class='dropdown-toggle']/child::span";
    @FindBy(xpath = _loggedInUsername) private WebElement loggedInUsername;

    public String getHomePageTitle(){
        String title= pageUtility.getPageTitle(driver);
        return title;
    }
    public String getLoggedInUsername(){
       String username=  pageUtility.getTextValue(loggedInUsername);
       return username;
    }

}
