package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class To_CreateContact_On_Vtiger {
	

	public static void main(String[] args) {
		
// 1-Launch Browser
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
// 2-Login to application
		driver.get("http://localhost:8888/index.php?module=Users&action=Logout");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
//3 -Navigate to contact link
		
		driver.findElement(By.linkText("Contacts")).click();
		
//4-Click on create a contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
//5- Create a contact with mandatory fields.
		
		driver.findElement(By.name("lastname")).sendKeys("Anurag Priyadarshi");
		
// 6-Save and verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @name='button']")).click();
		String lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(lastname.contains("Anurag Priyadarshi"))
		{
			
			System.out.println("----Passed");
		}
		
		else {
			
			System.out.println("----Failed");
		}
		
		
		Actions action= new Actions (driver);
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		action.moveToElement(mouseover).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 driver.close();
		
		
	}

}
