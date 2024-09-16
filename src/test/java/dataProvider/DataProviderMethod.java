package dataProvider;

import constants.ExcelSheetName;
import org.testng.annotations.DataProvider;
import utilities.ExcelUtility;

import java.io.IOException;

public class DataProviderMethod {
    @DataProvider(name="InvalidCredentials")
    public Object[][] getInValidCredentials(){
        Object[][] data=ExcelUtility.getExcelDataOfDataProvider(ExcelSheetName.INVALID_DATA_PROVIDER_SHEET);
        return data;
    }


}


