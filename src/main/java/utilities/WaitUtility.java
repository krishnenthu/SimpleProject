package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    public static final long HARD_WAIT=1000;
    public static final long PAGE_LOAD_WAIT=20;

    public static final long IMPLICIT_WAIT=20;
    public static final long EXPLICIT_WAIT=20;
    public static final long FLUENT_WAIT=20;
    public static final long FLUENT_WAIT_POLLING_TIME=1;
    public static WebDriverWait wait;

    public static void setHardWait(){
        try {
            Thread.sleep(HARD_WAIT);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
   public static void PageLoadWait(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
   }
   public static void implicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
   }

   public  enum LocatorType{
        Id, Name, ClassName, TagName, XPath, CSSSelector, LinkText, PartialLinkText;
   }
   public static void explicitWaitVisibilityOfElement(WebDriver driver, String target, Enum locatorType){

       wait=new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
       if (locatorType.equals(LocatorType.Id)){
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
       } else if (locatorType.equals(LocatorType.Name)) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(target)));
       }
       else if (locatorType.equals(LocatorType.ClassName)) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(target)));
       }
       else if (locatorType.equals(LocatorType.TagName)) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(target)));
       }
       else if (locatorType.equals(LocatorType.XPath)) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
       }
       else if (locatorType.equals(LocatorType.CSSSelector)) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(target)));
       }
       else if (locatorType.equals(LocatorType.LinkText)) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(target)));
       }
       else if (locatorType.equals(LocatorType.PartialLinkText)) {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(target)));
       }
       else {
           throw new RuntimeException("Invalid locator");
       }


   }
   public static void explicitWaitElementToBeClickable(WebDriver driver, String target, Enum locatorType){
         wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
        if(locatorType.equals(LocatorType.Id)){
            wait.until(ExpectedConditions.elementToBeClickable(By.id(target)));
        }
      else if(locatorType.equals(LocatorType.Name)){
           wait.until(ExpectedConditions.elementToBeClickable(By.name(target)));
       }
       else if(locatorType.equals(LocatorType.ClassName)){
           wait.until(ExpectedConditions.elementToBeClickable(By.className(target)));
       }
        else if(locatorType.equals(LocatorType.TagName)){
           wait.until(ExpectedConditions.elementToBeClickable(By.tagName(target)));
       }
        else if(locatorType.equals(LocatorType.XPath)){
           wait.until(ExpectedConditions.elementToBeClickable(By.xpath(target)));
       }
        else if(locatorType.equals(LocatorType.CSSSelector)){
           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(target)));
       }
        else if(locatorType.equals(LocatorType.LinkText)){
           wait.until(ExpectedConditions.elementToBeClickable(By.linkText(target)));
       }
        else  if(locatorType.equals(LocatorType.Id)){
           wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(target)));
       }
        else {
            throw new RuntimeException("Invalid selector");
        }
   }
    public static void explicitWaitElementToBeSelectable(WebDriver driver, String target, Enum locatorType){
        wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
        if(locatorType.equals(LocatorType.Id)){
            wait.until(ExpectedConditions.elementToBeSelected(By.id(target)));
        }
        else if(locatorType.equals(LocatorType.Name)){
            wait.until(ExpectedConditions.elementToBeSelected(By.name(target)));
        }
        else if(locatorType.equals(LocatorType.ClassName)){
            wait.until(ExpectedConditions.elementToBeSelected(By.className(target)));
        }
        else if(locatorType.equals(LocatorType.TagName)){
            wait.until(ExpectedConditions.elementToBeSelected(By.tagName(target)));
        }
        else if(locatorType.equals(LocatorType.XPath)){
            wait.until(ExpectedConditions.elementToBeSelected(By.xpath(target)));
        }
        else if(locatorType.equals(LocatorType.CSSSelector)){
            wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(target)));
        }
        else if(locatorType.equals(LocatorType.LinkText)){
            wait.until(ExpectedConditions.elementToBeSelected(By.linkText(target)));
        }
        else  if(locatorType.equals(LocatorType.Id)){
            wait.until(ExpectedConditions.elementToBeSelected(By.partialLinkText(target)));
        }
        else {
            throw new RuntimeException("Invalid selector");
        }
    }
    public static void explicitWaitVisibilityOfAllElements(WebDriver driver, String target, Enum locatorType){
        wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_WAIT));
        if(locatorType.equals(LocatorType.Id)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(target)));
        }
        else if(locatorType.equals(LocatorType.Name)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(target)));
        }
        else if(locatorType.equals(LocatorType.ClassName)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(target)));
        }
        else if(locatorType.equals(LocatorType.TagName)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(target)));
        }
        else if(locatorType.equals(LocatorType.XPath)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(target)));
        }
        else if(locatorType.equals(LocatorType.CSSSelector)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(target)));
        }
        else if(locatorType.equals(LocatorType.LinkText)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(target)));
        }
        else  if(locatorType.equals(LocatorType.Id)){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(target)));
        }
        else {
            throw new RuntimeException("Invalid selector");
        }
    }

    public void fluentVisibilityOfElement(WebDriver driver, String target,Enum locatorType ){
        FluentWait fluentWait=new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(FLUENT_WAIT));
        fluentWait.pollingEvery(Duration.ofSeconds(FLUENT_WAIT_POLLING_TIME));
        if (locatorType.equals(LocatorType.Id)){
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(target)));
        }
        else if (locatorType.equals(LocatorType.Name)) {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(target)));
        }
        else if (locatorType.equals(LocatorType.ClassName)) {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(target)));
        }
        else if (locatorType.equals(LocatorType.TagName)) {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(target)));
        }
        else if (locatorType.equals(LocatorType.XPath)) {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(target)));
        }
        else if (locatorType.equals(LocatorType.CSSSelector)) {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(target)));
        }
        else if (locatorType.equals(LocatorType.LinkText)) {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(target)));
        }
        else if (locatorType.equals(LocatorType.PartialLinkText)) {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(target)));
        }
        else {
            throw new RuntimeException("Invalid locator");
        }

    }
    public static void fluentWaitElementToBeClickable(WebDriver driver, String target, Enum locatorType){
        FluentWait fluentWait=new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(FLUENT_WAIT));
        fluentWait.pollingEvery(Duration.ofSeconds(FLUENT_WAIT_POLLING_TIME));
        if(locatorType.equals(LocatorType.Id)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.id(target)));
        }
        else if(locatorType.equals(LocatorType.Name)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.name(target)));
        }
        else if(locatorType.equals(LocatorType.ClassName)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.className(target)));
        }
        else if(locatorType.equals(LocatorType.TagName)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.tagName(target)));
        }
        else if(locatorType.equals(LocatorType.XPath)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath(target)));
        }
        else if(locatorType.equals(LocatorType.CSSSelector)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(target)));
        }
        else if(locatorType.equals(LocatorType.LinkText)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.linkText(target)));
        }
        else  if(locatorType.equals(LocatorType.Id)){
            fluentWait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(target)));
        }
        else {
            throw new RuntimeException("Invalid selector");
        }
    }
    public static void fluentWaitElementToBeSelectable(WebDriver driver, String target, Enum locatorType){
        FluentWait fluentWait=new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(FLUENT_WAIT));
        fluentWait.pollingEvery(Duration.ofSeconds(FLUENT_WAIT_POLLING_TIME));
        if(locatorType.equals(LocatorType.Id)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.id(target)));
        }
        else if(locatorType.equals(LocatorType.Name)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.name(target)));
        }
        else if(locatorType.equals(LocatorType.ClassName)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.className(target)));
        }
        else if(locatorType.equals(LocatorType.TagName)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.tagName(target)));
        }
        else if(locatorType.equals(LocatorType.XPath)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.xpath(target)));
        }
        else if(locatorType.equals(LocatorType.CSSSelector)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector(target)));
        }
        else if(locatorType.equals(LocatorType.LinkText)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.linkText(target)));
        }
        else  if(locatorType.equals(LocatorType.Id)){
            fluentWait.until(ExpectedConditions.elementToBeSelected(By.partialLinkText(target)));
        }
        else {
            throw new RuntimeException("Invalid selector");
        }
    }
    public static void fluentWaitVisibilityOfAllElements(WebDriver driver, String target, Enum locatorType){
        FluentWait fluentWait=new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(FLUENT_WAIT));
        fluentWait.pollingEvery(Duration.ofSeconds(FLUENT_WAIT_POLLING_TIME));
        if(locatorType.equals(LocatorType.Id)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(target)));
        }
        else if(locatorType.equals(LocatorType.Name)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(target)));
        }
        else if(locatorType.equals(LocatorType.ClassName)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(target)));
        }
        else if(locatorType.equals(LocatorType.TagName)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName(target)));
        }
        else if(locatorType.equals(LocatorType.XPath)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(target)));
        }
        else if(locatorType.equals(LocatorType.CSSSelector)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(target)));
        }
        else if(locatorType.equals(LocatorType.LinkText)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(target)));
        }
        else  if(locatorType.equals(LocatorType.Id)){
            fluentWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText(target)));
        }
        else {
            throw new RuntimeException("Invalid selector");
        }
    }






}
