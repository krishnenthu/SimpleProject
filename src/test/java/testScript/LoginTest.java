package testScript;

import automationCore.Base;
import constants.AssertErrorMessage;
import constants.ExcelSheetName;
import dataProvider.DataProviderMethod;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import retry.TestRetry;
import utilities.ExcelUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends Base {
    LoginPage login;
    HomePage home;

    @Test(retryAnalyzer = TestRetry.class, groups = "Sanity")
    public void TC01_verifyLoginPageTitle() throws IOException {
        List<ArrayList<String>> data=ExcelUtility.getDataFromExcel(ExcelSheetName.LOGIN_PAGE_SHEET);
        String expTitle= data.get(0).get(1);
        login=new LoginPage(driver);

        String actTitle=login.getLoginPageTitle();
        Assert.assertNotEquals(actTitle,expTitle, AssertErrorMessage.TITLE_MISMATCH_MESSAGE);
    }
    @Test(groups = "Sanity")
    public void TC02_verifyLoginWithValidCredentials() throws IOException {
        List<ArrayList<String>> loginData=ExcelUtility.getDataFromExcel(ExcelSheetName.LOGIN_PAGE_SHEET);
        String userName=loginData.get(1).get(1);
        String password=loginData.get(2).get(1);
        List<ArrayList<String>> homeData=ExcelUtility.getDataFromExcel(ExcelSheetName.HOME_PAGE_SHEET);
        String expTitle=homeData.get(0).get(1);
        login=new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        login.selectRememberMeCheckBox();
        home=login.clickOnLoginButton();
        String actTitle=home.getHomePageTitle();
        Assert.assertEquals(actTitle,expTitle,AssertErrorMessage.TITLE_MISMATCH_MESSAGE);
    }
    @Test (dataProvider = "InvalidCredentials", dataProviderClass = DataProviderMethod.class, groups = {"Regression", "Sanity"})
    public void TC03_verifyLoginWithInvalidData(String userName, String password) throws IOException {
        List<ArrayList<String>> data=ExcelUtility.getDataFromExcel(ExcelSheetName.LOGIN_PAGE_SHEET);
        String expMessage=data.get(3).get(1);
        login=new LoginPage(driver);
        login.enterUsername(userName);
        login.enterPassword(password);
        login.selectRememberMeCheckBox();
        login.clickOnLoginButton();
        String actMessage=login.getInvalidLoginMessage();
        Assert.assertEquals(actMessage,expMessage,AssertErrorMessage.INVALID_LOGIN_ERROR_MESSAGE);
    }





}
