package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.TestHelperUtility;
import utilities.WaitUtility;

public class LoginPage extends TestHelperUtility {
  public WebDriver driver;
// test
  public LoginPage(WebDriver driver){
    this.driver=driver;
    PageFactory.initElements(driver, this);
  }

    private  final String _usernameField="//input[@id='username']";
    @FindBy(xpath =_usernameField ) private WebElement usernameField;

    private final String _passwordField="//input[@id='password']";
    @FindBy(xpath = _passwordField) private WebElement passwordField;
    private final String _rememberMeCheckBox="//input[@name='remember']";
    @FindBy(xpath=_rememberMeCheckBox) private WebElement rememberMeCheckBox;

    private final String _loginButton="//button[@class='btn btn-primary']";
    @FindBy(xpath =_loginButton )private WebElement loginButton;

    private final String _forgotPasswordLink="//a[@class='btn btn-link']";
    @FindBy(xpath = _forgotPasswordLink)private WebElement forgotPasswordLink;

    private final String _invalidLoginMessage="//span[@class='help-block']/child::strong";
    @FindBy(xpath = _invalidLoginMessage) private WebElement invalidLoginMessage;

    public String getLoginPageTitle(){

      String title=pageUtility.getPageTitle(driver);
      return  title;

    }


    public void enterUsername(String username){
      pageUtility.enterText(usernameField,username);


    }
    public void enterPassword(String password){
      pageUtility.enterText(passwordField, password);

    }
    public void selectRememberMeCheckBox(){
      pageUtility.clickOnElement(rememberMeCheckBox);

    }
    public boolean getStatusOfRememberMeCheckbox(){
      boolean status=pageUtility.selectedStatus(rememberMeCheckBox);
      return status;

    }
    public HomePage clickOnLoginButton(){
      pageUtility.clickOnElement(loginButton);
      return new HomePage(driver);

    }
    public ResetPage clickOnForgotPasswordLink(){
      pageUtility.clickOnElement(forgotPasswordLink);
      return new ResetPage(driver);

    }
    public String getInvalidLoginMessage(){
      String message=pageUtility.getTextValue(invalidLoginMessage);
      return message;

    }




}
