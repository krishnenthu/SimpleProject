package utilities;

import constants.FilePath;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelUtility {
    public static FileInputStream fs;
    public static XSSFWorkbook book;
    public static XSSFSheet sheet;
    public static XSSFRow row;

    public static List<ArrayList<String>> getDataFromExcel(String sheetName) throws IOException {
        DataFormatter formatter = new DataFormatter();
        fs = new FileInputStream(FilePath.EXCEL_DATA_PATH);
        book = new XSSFWorkbook(fs);
        sheet = book.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() + 1;
        List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < rowCount; i++) {
            int x = 0;
            row = sheet.getRow(i);
            int columnCount = row.getLastCellNum();
            String rowItem[] = new String[columnCount];
            for (int j = 0; j < columnCount; j++) {
                rowItem[j] = formatter.formatCellValue(row.getCell(x));
                x++;
            }
            data.add(new ArrayList<String>(Arrays.asList(rowItem)));
        }

        return data;
    }

    public  static Object[][] getExcelDataOfDataProvider(String sheetName) throws IOException {
        DataFormatter formatter=new DataFormatter();
        fs=new FileInputStream(FilePath.EXCEL_DATA_PROVIDER_PATH);
        book=new XSSFWorkbook(fs);
        sheet=book.getSheet(sheetName);
        int rowCount=sheet.getLastRowNum()+1;
        int columnCount=sheet.getRow(1).getLastCellNum();
        Object[][] data=new Object[rowCount][columnCount];
        for (int i=0;i<rowCount;i++){
            int x=0;
            row=sheet.getRow(i);
            int cellCount=row.getLastCellNum();
            for(int j=0;j<cellCount;j++){
                data[i][j]=formatter.formatCellValue(row.getCell(x));
                x++;
            }
        }
        return data;

    }


}
