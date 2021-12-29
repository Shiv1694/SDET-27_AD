package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * it contain WebDriver specific reusable actions
 * @author hp
 *
 */
public class WebDriverUtility
{
/**
 * wait for page to load before identifying any synchronizedn element in DOM(HTML-Document)
 * @param driver
 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * wait for page to load before identifying any synchronized[java scripts actions] element in DOM[HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoadforJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	/**
	 *used to wait for element to be clickable in GUI, & check for specific element for every 500 milli seconds
	 *@param driver
	 * @param element
	 * @param polling Time is in the form second
	 * @throws Throwable 
	 * @throws throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws Throwable
	{
		FluentWait wait =new FluentWait(driver);
		wait.pollingEvery(pollingTime,TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to Switch to any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		
		while (it.hasNext()) {
								String wID=it.next();
								driver.switchTo().window(wID);
								String currentWindowTitle=driver.getTitle();
								if(currentWindowTitle.contains(partialWindowTitle)){
									break;
									}
							 }
		
	}
	/**
	 * used to Switch to Alert Window &click on Ok button
	 * @param
	 */
	public void switchToAlertwindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to Switch to Alert window & click on cancel Button
	 * @param driver
	 * 
	 */
	public void switchToAlertWindowAndcancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to Switch Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToframe(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * used to Switch to frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 * used to select the value from the dropdown based on index
	 * @param driver
	 * @param index
	 */
	 public void select(WebElement element, int index)
	 {
		 Select sel= new Select(element);
		 sel.selectByIndex(index);	 
	 }
	 /**
	  * used to select the value from the dropdown based on value/ option available in GUI
	  * @param element
	  * @param value
	  */
	 public void select(WebElement element,String text)
	 {
		Select Sel=new Select(element);
		Sel.selectByVisibleText(text);
	 }
	 /**
	  * used to place mouse cursor on specified element
	  * @param driver
	  * @param element
	  */
	 public void mouseOverOnElement(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	 /**
	  * used to right click on specified element
	  *  @param driver
	  *   @param element
	  * 
	  */
	 public void rightClickOnElement(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 /**
	  * @param driver
	  * @param javaScript
	  */
	 public void executeJavaScript(WebDriver driver,String javaScript)
	 {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeAsyncScript(javaScript, null);
	 }
	 
	 public void waitAndClick(WebElement element) throws InterruptedException
	 {
		 	int count=0;
		 	while(count<20) {
		 						try {
		 							element.click();
		 							break;
		 						}catch(Throwable e) {
		 									Thread.sleep(1000);
		 									}
		 	}
	 }
	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement orgEle) {
		// TODO Auto-generated method stub
		
	}

	 public void takeScreenshot(WebDriver driver,String screenshotName) throws Throwable
	 {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File sdest=new File("./screenshot/"+screenshotName+".PNG");
		 Files.copy(src, sdest);
	 }
	 /**
	  * pass enter key appearing in to browser
	  * @param driver
	  */
	 public void passEnterKey(WebDriver driver)
	 {
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.ENTER).perform();
	 }
}
