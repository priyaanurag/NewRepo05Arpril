package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class To_Create_Org_with_Energy_Customer {

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
		
// 4-Create Organization with industry chemical maindatory fields 
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("ENERGY ONE1");
		
		WebElement industry = driver.findElement(By.name("industry"));
		Select select =new Select(industry) ;
		select.selectByValue("Energy");
		
		WebElement type = driver.findElement(By.name("accounttype"));
		Select selects =new Select (type);
		selects.selectByValue("Customer");
		
		driver.findElement(By.xpath("//input[@value='U' and @type='radio']"));
//5- click on save button.
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String Orgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
	 String indu=driver.findElement(By.id("dtlview_Industry")).getText();
	 String types = driver.findElement(By.id("mouseArea_Type")).getText();
		
		if(Orgname.contains("ENERGY ONE"))
			{
			
			if(indu.contains("Energy") && types.contains("ENERGY ONE1")) 
			{
			
			
		
				
					System.out.println("-----Passed ");
			
		}
		
	
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
