package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.nio.file.WatchEvent;
import java.util.List;
import java.util.Set;

public class PageUtility  {

    public String getPageTitle(WebDriver driver){
        String title=driver.getTitle();
        return title;
    }
    public String getUrl(WebDriver driver){
        String url=driver.getCurrentUrl();
        return url;
    }
    public String getPageSource(WebDriver driver){
        String pageSource=driver.getPageSource();
        return pageSource;
    }

    public String getWindowHandle(WebDriver driver){
        String handleid=driver.getWindowHandle();
        return handleid;
    }
    public Set<String> getWindowHandles(WebDriver driver){
        Set<String> handleIds=driver.getWindowHandles();
        return handleIds;
    }
    public void pageRefresh(WebDriver driver){
        driver.navigate().refresh();
    }
    public  void pageForward(WebDriver driver){
        driver.navigate().forward();
    }
    public void pageBackward(WebDriver driver){
        driver.navigate().back();
    }
    public void clickOnElement(WebElement element){
        element. click();
    }
    public void enterText(WebElement element, String text){
        element.sendKeys(text);
    }
    public void clearText(WebElement element){
        element.clear();
    }
    public void submitForm(WebElement element){
        element.submit();
    }
    public String getTagName(WebElement element){
        String tagName=element.getTagName();
        return tagName;
    }
    public String getTextValue(WebElement element){
        String text=element.getText();
        return text;
    }
    public String getAttributeValue(WebElement element, String attribute){
       String attributeValue= element.getAttribute(attribute);
       return attributeValue;
    }
    public String getCSSValue(WebElement element, String property){
        String cssValue=element.getCssValue(property);
        return cssValue;
    }
    public Point getLocation(WebElement element){
        Point location=element.getLocation();
        return location;
    }
    public Dimension getSize(WebElement element){
        Dimension size=element.getSize();
        return size;
    }
    public boolean displayedStatus(WebElement element){
        Boolean status=element.isDisplayed();
        return status;
    }
    public boolean enabledStatus(WebElement element){
        Boolean status=element.isDisplayed();
        return status;
    }

    public boolean selectedStatus(WebElement element){
        Boolean status=element.isDisplayed();
        return status;
    }

    public void alertAccept(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void alertDismiss(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }

    public String getAlertText(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        String text=alert.getText();
       return text;
    }

    public void enterTextInAlert(WebDriver driver, String text){
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(text);
    }
    public void doubleClick(WebDriver driver, WebElement element){
        Actions action=new Actions(driver);
        action.doubleClick(element).build().perform();

    }
    public void moveToElement(WebDriver driver, WebElement target){
        Actions action=new Actions(driver);
        action.moveToElement(target).build().perform();

    }
    public void moveToElementWithOffset(WebDriver driver, WebElement target, int x, int y){
        Actions action=new Actions(driver);
        action.moveToElement(target,x,y).build().perform();

    }
    public void moveByOffset(WebDriver driver, int x, int y){
        Actions action=new Actions(driver);
        action.moveByOffset(x,y).build().perform();
    }
    public void dragAndDrop(WebDriver driver, WebElement source, WebElement target){
        Actions action=new Actions(driver);
        action.dragAndDrop(source,target).build().perform();
    }
    public void dragAndDropByOffset(WebDriver driver, WebElement source, int x, int y){
        Actions action=new Actions(driver);
        action.dragAndDropBy(source,x,y).build().perform();
    }
    public void dropDownSelectByValue(WebElement element, String value){
        Select select=new Select(element);
        select.selectByValue(value);
    }
    public void dropDownSelectByIndex(WebElement element, int index){
        Select select=new Select(element);
        select.selectByIndex(index);
    }
    public void dropDownSelectByVisibleText(WebElement element, String text){
        Select select=new Select(element);
        select.selectByVisibleText(text);
    }
    public void dropDownDeSelectByValue(WebElement element, String value){
        Select select=new Select(element);
        select.deselectByValue(value);
    }
    public void dropDownDeSelectByIndex(WebElement element, int index){
        Select select=new Select(element);
        select.deselectByIndex(index);
    }
    public void dropDownDeSelectByVisibleText(WebElement element, String text){
        Select select=new Select(element);
        select.deselectByVisibleText(text);
    }
    public List<WebElement> dropDownGetOptions(WebElement element){
        Select select=new Select(element);
        List<WebElement> data=select.getOptions();
        return data;

    }
    public List<WebElement> dropDownGetAllSelectedOptions(WebElement element){
        Select select=new Select(element);
        List<WebElement> data=select.getAllSelectedOptions();
        return data;

    }
    public WebElement dropDownGetFirstSelectedOption(WebElement element){
        Select select=new Select(element);
        WebElement firstOption=select.getFirstSelectedOption();
        return firstOption;
    }
    public void dropDownDeSelectAll(WebElement element){
        Select select=new Select(element);
        select.deselectAll();
    }
    public boolean dropDownIsMultiple(WebElement element){
        Select select=new Select(element);
        boolean status=select.isMultiple();
        return status;
    }
    public void scrollVertical(WebDriver driver, int x){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, x)");
    }
    public void scrollVerticallyToEnd(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    public void scrollToAnElement(WebDriver driver, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


}
