package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableUtility {

    public static List<ArrayList<String>> getTableDataWithoutHeader(List<WebElement> rowElement, List<WebElement> totalElement){
        int rowCount= rowElement.size();
        int totalCount=totalElement.size();
        int columnCount=totalCount/rowCount;
        String rowItems[]=new String[columnCount];
        List<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
        int x=0;
        for(int i=0;i<rowCount;i++){
            for (int j=0;j<columnCount;j++){
                rowItems[j]=totalElement.get(x).getText();
                x++;
            }
            data.add(new ArrayList<String>(Arrays.asList(rowItems)));
        }
        return data;
    }
    public static List<ArrayList<String>> getTableDataWithHeader(List<WebElement> rowElement, List<WebElement> totalElement){
        int rowCount= rowElement.size()-1;
        int totalCount=totalElement.size();
        int columnCount=totalCount/rowCount;
        String rowItems[]=new String[columnCount];
        List<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
        int x=0;
        for(int i=0;i<rowCount;i++){
            for (int j=0;j<columnCount;j++){
                rowItems[j]=totalElement.get(x).getText();
                x++;
            }
            data.add(new ArrayList<String>(Arrays.asList(rowItems)));
        }
        return data;
    }
}
