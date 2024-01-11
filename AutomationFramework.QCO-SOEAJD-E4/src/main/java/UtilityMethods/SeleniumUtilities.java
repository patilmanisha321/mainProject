package UtilityMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class contains the generic methods in selenium 
 * @author Manisha
 *
 */
public class SeleniumUtilities {

	/**
	 * This method is used to Maximize the window
	 * @param driver
	 */
	public void MaximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This methos is used to miniize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to give Implicit wait
	 */
	public void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is used to give Explicit wait if condition is given element should to be clickable
	 * @param driver
	 * @param element
	 */
	public void ExplicitWaitClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
	}
	/**
	 * This method is used to give Explicit wait if condion is given element Should be visible
	 * @param driver
	 * @param element
	 */
	public void ExplicitWaitVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to  give explicit wait if condition is given element should be selected
	 * @param driver
	 * @param element
	 */
	public void ExplicitWaitSelected(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(0));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	/**
	 * with this method we can select from dropdown with visible text
	 * @param element
	 * @param visibleText
	 */
	public void handleDropDown(WebElement element, String visibleText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);	
	}
	/**
	 * This method is used to to select the option from dropdown using value
	 * @param value
	 * @param element
	 */
	public void handleDropDown( String value, WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);	
	}
	
	/**
	 * This method is used to select the option from dropdown using index value
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int  index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);	
	}
	/**
	 * This method is used to move the cursor to given element
	 * @param driver
	 * @param element
	 */
	public void MouseOverAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();	
	}
	/**
	 * This method is used to right click on given element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();	
	}
	/**
	 * This method is used to double click on given element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();	
	}
	/**
	 * This method is used for drag and Drop purpose
	 * @param driver
	 * @param source
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(source, dest).perform();	
	}
	/**
	 * This method is used for Scrolling down
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,500);","");
		
	}
	/**
	 * This method is used for Scrolling up
	 * @param driver
	 */
	public void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,-500);","");	
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	/**
	 * 
	 * @param driver
	 */
	public void handleAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();	
	}
	/**
	 * 
	 * @param driver
	 * @return
	 */
	public String getTextAlertPopup(WebDriver driver)
	{
		
		return driver.switchTo().alert().getText();
	}
	/**
	 * 
	 * @param driver
	 * @param frameIndex
	 */
	public void HandleFrame(WebDriver driver, int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * 
	 * @param driver
	 * @param frameName
	 */
	public void HandleFrameByName(WebDriver driver, String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	/**
	 * 
	 * @param driver
	 * @param frameElement
	 */
	public void HandleFrameByFrameElement(WebDriver driver, WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 * 
	 * @param driver
	 * @return
	 * @throws Throwable 
	 */
	public String captureScreenshot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE); 		
		File dst=new File(".\\Screenshots\\"+screenShotName+".png");
		Files.copy(src,dst);
		return dst.getAbsolutePath();
	}
	/**
	 * 
	 * @param driver
	 * @param partialTitle
	 */
	public void HandleWindows(WebDriver driver,String partialTitle)
	{
		Set<String> AllWind = driver.getWindowHandles();
		for(String winId: AllWind)
		{
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialTitle))
			{
				break;
			}
		}
	}
}
