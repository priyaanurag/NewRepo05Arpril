package Practise;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class To_create_Organization_Viger {

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

		//3 -Click on Organization look up image
		driver.findElement(By.linkText("Organizations")).click();
		
		// 4-Create Organization with maindatory fields 
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		// Use random class for creating Orginaziton wih same 
		Random r=new Random();
		int random= r.nextInt(12);
		driver.findElement(By.name("accountname")).sendKeys("ANURAG CHEMICAL INDIA PVT"+random);
		
		//5- click on save button.
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String Orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(Orgname.contains("ANURAG CHEMICAL INDIA PVT"+random))
		{
			System.out.println("-----Passed ");
			
		}
		
		else
		{
			
			System.out.println("---Fail");
		}
		
		WebElement mouseover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions action =new Actions(driver);
		
		action.moveToElement(mouseover).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		

	}

}
