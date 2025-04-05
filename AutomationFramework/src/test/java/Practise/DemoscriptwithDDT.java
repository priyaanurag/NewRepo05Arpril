package Practise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyfileUtlity;

/**This is the example of DATA DRIVER TESTING USING UTILITY FILES
 * 
 */
public class DemoscriptwithDDT {
	
	
	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws IOException
	
	{
		//To read Data from properties from property file
		PropertyfileUtlity putil =new PropertyfileUtlity();
		String URL = putil.toreaddatafromproperyfile("url");
		String Browser = putil.toreaddatafromproperyfile("browser");
		String Username = putil.toreaddatafromproperyfile("username");
		String Password = putil.toreaddatafromproperyfile("password");
		
		//To read Data from properties from Execl file
		
		ExcelFileUtility eutil =new ExcelFileUtility();
		String lastname = eutil.toReadDatafromExcelFile("Contacts", 1, 2);
		
		
		// step1 Launch browser
WebDriver driver =null;
		
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		
		else if(Browser.equals("edge"))
		{
			
			driver=new EdgeDriver();
		}
		else if (Browser.equals("fireofox"))
		{
			
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		// Steps 2 Login with valid cred 
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		// Step 3 Click on contacts and enter last name
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		// Steps 4 Navigate to save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      String Orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(Orgname.contains(lastname))
		{
			System.out.println(Orgname+"-----Passed ");
			
		}
		
		else
		{
			
			System.out.println(Orgname+"---Fail");
		}
		
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		// Step 5-Logout from system and close browser
		Actions action =new Actions(driver);
		
		action.moveToElement(mouseover).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
