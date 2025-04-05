package Practise;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyfileUtlity;
import genericUtility.WebDriverUtility;

public class Demoscriptwith_DDTUusingUtilityfile {

	public static void main(String[] args) throws IOException {
		
		// Create an object for all 3 utility classes

		PropertyfileUtlity putil = new PropertyfileUtlity();
		ExcelFileUtility eutil =new ExcelFileUtility();
		WebDriverUtility wutil =new WebDriverUtility();
		
		
		// 1 Read data from properties file
		
		String URL = putil.toreaddatafromproperyfile("url");
		String BROWSER = putil.toreaddatafromproperyfile("browser");
		String USERNAME = putil.toreaddatafromproperyfile("username");
		String PASSWORD=putil.toreaddatafromproperyfile("password");
		
		// Read data from Excel file
		
		String lastname=eutil.toReadDatafromExcelFile("Contacts", 1, 2);
		
		
		
		// Step 1:-Launch browser
		WebDriver driver =new  ChromeDriver();
		
		if(BROWSER.equals("Chrome"))
		{
			driver =new ChromeDriver();
		}
		
		else if (BROWSER.equals("Edge"))
			
		{
			driver =new EdgeDriver();
		}
		
		else if(BROWSER.equals("Firefox"))
		{
			driver =new FirefoxDriver();
		}
		
		// To maximize
		 wutil.toMaximize(driver);
		 wutil.towait(driver);
		 
		 // 2-Login 
		 driver.get(URL);
		 driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			// 3- click on create contact link 
			driver.findElement(By.linkText("Contacts")).click();
			
			// 4 -click on look up contact image
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			
			
			// 5- Fill the mandatory details
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			
			
			//6 -save and verify
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
				
				// 7 -Logout
				WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        wutil.toMouseOver(driver, mouseover);
		
		       // 8 -close
		       driver.findElement(By.linkText("Sign Out")).click();
		       driver.close();
		
			
			
			
	}

}
