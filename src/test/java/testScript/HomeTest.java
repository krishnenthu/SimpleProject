package testScript;

import automationCore.Base;
import constants.AssertErrorMessage;
import constants.ExcelSheetName;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeTest extends Base {
    LoginPage login;
    HomePage home;

    @Test (groups = "Regression")
    public void TC01_verifyLoggedInUsername() throws IOException {
        List<ArrayList<String>> loginData=ExcelUtility.getDataFromExcel(ExcelSheetName.LOGIN_PAGE_SHEET);
        String username=loginData.get(1).get(1);
        String password=loginData.get(2).get(1);
        List<ArrayList<String>> homeData= ExcelUtility.getDataFromExcel(ExcelSheetName.HOME_PAGE_SHEET);
        String expUserName=homeData.get(1).get(1);
        login=new LoginPage(driver);
        login.enterUsername(username);
        login.enterPassword(password);
        login.selectRememberMeCheckBox();
        home= login.clickOnLoginButton();
        String actUserName= home.getLoggedInUsername();
        Assert.assertEquals(actUserName,expUserName, AssertErrorMessage.HOME_USERNAME_MISMATCH);

    }
}
