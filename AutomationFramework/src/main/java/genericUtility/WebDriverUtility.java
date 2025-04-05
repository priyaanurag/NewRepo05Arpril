package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 
 */
public class WebDriverUtility {
	/* This method is to maximize the browser provide driver
	 * 
	 */
	
	public void toMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/* This method is to minimize the browser provide driver
	 * 
	 */
	
	public void toMinimize(WebDriver driver)
	
	{
		driver.manage().window().minimize();
		
	}

/* This method is to wait the element provide by driver
 * 
 */
	
	public void towait(WebDriver driver)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	


	/**
	 * This method will wait until element is visible or Clickable.
	 * @param driver
	 * @param element
	 */
	
	public void towaituntilElementClickable(WebDriver driver,WebElement element)
	
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void towaituntillElementVisiblityOfElement(WebDriver driver,WebElement element)
	
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is usede to handle dropdown by using select by value,index,Visible text
	 * @param element
	 * @param value
	 */
	
	public void toHandleDropdown(WebElement element,String value)
	{
		
		Select select =new Select(element);
		select.selectByValue(value);
		
	}
	/**
	 * This method is usede to handle dropdown by using select by index
	 * @param element
	 * @param index
	 */
	
	public void toHandleDropdown(WebElement element,int index)
	{
		
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
	/**This method is usede to handle dropdown by using select by Visible Text
	 * 
	 * @param text
	 * @param element
	 */
	
	public void toHandleDropdown(String text,WebElement element)
	{
		
		Select select =new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	/**This method is used to handle mouse actions like mouseover.
	 * 
	 * @param driver
	 * @param element
	 */
	public void toMouseOver(WebDriver driver,WebElement element)
	{
		Actions action =new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	
	/**This method is used to handle mouse actions like double click.
	 * 
	 * @param driver
	 * @param element
	 */
	public void toDoubleclick(WebDriver driver,WebElement element)
	{
		Actions action =new Actions(driver);
		action.doubleClick(element).perform();
		
	}
	
	/**This method is used to handle mouse actions like Right click.
	 * 
	 * @param driver
	 * @param element
	 */
	public void toRightclick(WebDriver driver,WebElement element)
	{
		Actions action =new Actions(driver);
		action.contextClick(element).perform();
		
	}
	/**
	 * This method is used to handle mouse actions like dragAndDrop
	 * @param driver
	 * @param scr
	 * @param target
	 */
	public void todragAnDrop(WebDriver driver ,WebElement scr,WebElement target) {
		
		
		Actions action =new Actions(driver);
		action.dragAndDrop(scr, target).perform();
	}
	
	/**
	 * This is used to handle frame by index value.
	 * @param driver
	 * @param index
	 */
	public void toHandleFrame(WebDriver driver,int index)
	
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This is used to handle frame by name_id value.
	 * @param driver
	 * @param name_id
	 */
	
	public void toHandleFrame(WebDriver driver,String name_id)
	{
		
		
		driver.switchTo().frame(name_id);
	}
	/**
	 * This is used to handle frame by element reference.
	 * @param driver
	 * @param element
	 */
	
	public void toHandleFrame(WebDriver driver ,WebElement element)
	
	{
		
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch back to parent frame.
	 * @param driver
	 */
	
	public void toSwitcbacktofarme(WebDriver driver)
	{
		driver.switchTo().defaultContent();
		
	}
	/**
	 * This method is used to handle alert pop-up by accepting it.
	 * @param driver
	 */
	public void toswitchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to handle alert pop-up by dismissing it.
	 * @param driver
	 */
	public void toSwitchToAlertandDissmiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This message is used accept and get text of pop-up message.
	 * @param driver
	 * @return
	 */
	
	public String toswitchtoAlertandCaptureMessage(WebDriver driver)
	{
	
		Alert alert = driver.switchTo().alert();
		String Popmessage = alert.getText();
		alert.accept();
		return Popmessage;
	}
	

		/**
		 * This method is to take screenshot of entire page provide by driver
		 * @param driver
		 * @throws IOException
		 */
		public String takescreenshot(WebDriver driver,String screenshotname) throws IOException
		
		{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File temp=ts.getScreenshotAs(OutputType.FILE);
			File scr=new File ("./errorShot/"+ screenshotname+ ".jpg");
			FileHandler.copy(temp, scr);
			String path =scr.getAbsolutePath();// To get the path of take screenshot.
			return path;
			
			
			
		}
		/**
		 * This method is used to switch the driver control to window
		 * @param driver
		 * @param partialTitle
		 */
		
		
		
		public void toswitchWindow(WebDriver driver,String partialTitle)
		
		{
			Set<String> allids = driver.getWindowHandles();
			
			for(String id:allids)
			{
				String title = driver.switchTo().window(id).getTitle();
				if(title.contains(partialTitle))
				{
					break;
				}
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
