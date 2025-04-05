package Practise;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class To_create_contact_with_org {

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
		
// 3-Nivagte to contact link
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

// 4- create contacts 
		driver.findElement(By.name("lastname")).sendKeys("Anuragone");
		
		// Storing parent window id 
		String parentwindow = driver.getWindowHandle();
		System.out.println("Parent window id"+parentwindow);
		
		driver.findElement(By.xpath("//img[@onclick='return window.open(\"index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=\",\"test\",\"width=640,height=602,resizable=0,scrollbars=0\");']")).click();

		// Storing parent+Child window's ids
		Set<String> allwindows = driver.getWindowHandles();
		
		System.out.println("The allwindow id are :-"+ allwindows);
		//Removing Parent window id
		allwindows.remove(parentwindow);
		
		for(String onlychild:allwindows)
		{
			// Tranfering the control to child window.
			driver.switchTo().window(onlychild);
			driver.manage().window().maximize();
			driver.findElement(By.linkText("ENERGY ONE INDIA PVT")).click();
			
			
		}
		// Back to parent window.
		driver.switchTo().window(parentwindow);
		
		//5 save with mandatory value.
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String Contactinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Contactinfo.contains("Anuragone"))
		{
			System.out.println("-----Passed ");
			
		}
		
		else
		{
			
			System.out.println("---Fail");
		}
		// Mouse over to singout 
     WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions action =new Actions(driver);
		
		action.moveToElement(mouseover).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

		
		
	}

}
