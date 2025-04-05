package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class To_create_Contact_using_PropExeclfile {

	public static void main(String[] args) throws IOException {

		// To Read data from Propfile

		FileInputStream pfis = new FileInputStream(".\\src\\test\\resources\\common.data.properties");
		Properties prop = new Properties();
		prop.load(pfis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		
		// To Read data from Excel file
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestDataforVtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String contactlastaname = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		
		

		
		// Steps 1 Lauch Browser
		
		WebDriver driver =null;
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		
		else if(BROWSER.equals("edge"))
		{
			
			driver=new EdgeDriver();
		}
		else if (BROWSER.equals("fireofox"))
		{
			
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		// Steps 2 Login with valid cred 
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// Step 3 Click on contacts and enter last name
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactlastaname);
		
		// Steps 4 Navigate to save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
      String Orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(Orgname.contains(contactlastaname))
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
		
		// Do same for Organization
		
		
	}

}
