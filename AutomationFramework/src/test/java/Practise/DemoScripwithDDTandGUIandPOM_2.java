package Practise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.CreateOrginzationpage;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrginizationPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyfileUtlity;
import genericUtility.WebDriverUtility;

public class DemoScripwithDDTandGUIandPOM_2 {
	
	
	public static void main (String[]args) throws IOException
	
	{
		// create object of all 3 utilities.
		
		ExcelFileUtility eutil =new ExcelFileUtility();
		PropertyfileUtlity putil =new PropertyfileUtlity();
		WebDriverUtility wutil =new	WebDriverUtility();
		
		// Read data from Prpertfile
		String URL = putil.toreaddatafromproperyfile("url");
		String BROWSER = putil.toreaddatafromproperyfile("browser");
		String USERNAME = putil.toreaddatafromproperyfile("username");
		String PASSWORD = putil.toreaddatafromproperyfile("password");
		
		// Read data from Excel file
		String Orgnization = eutil.toReadDatafromExcelFile("Organization", 1, 2);
		
		
		
		// Step1:- Launch browser
	       WebDriver driver = new  ChromeDriver();
			
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
			
			wutil.toMaximize(driver);
			wutil.towait(driver);
			
			//Step:-2 Login with valid credentials.
			
			driver.get(URL);
			LoginPage lp=new LoginPage(driver);
			lp.getUsernameTextfields().sendKeys(USERNAME);
			lp.getPasswordTextfields().sendKeys(PASSWORD);
			lp.getLoginButton().click();
			
			// Step 3:-Click on Orginzation link
			HomePage hp=new HomePage(driver);
			hp.getOrganizationslink().click();
			
			// step 4- Click on Organization lookup image.
			
			OrginizationPage cp=new OrginizationPage(driver);
			cp.getCreateOrganizationlokkupimage().click();
			
			//Step 5- Create Organization
			CreateOrginzationpage cps=new CreateOrginzationpage(driver);
			
			cps.getAccountname().sendKeys(Orgnization);
			
			
			
			// Steps 6 -Click on save and verify
			cps.getSavebuttonofOrg().click();
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String title = oip.getTitleofOrgpage().getText();
			
			if(title.contains(Orgnization))
			{
				System.out.println("====Passs");
				
			}
			
			else
			{
				System.out.println("====Fail");
				
			}
			
			//Step 7 logout
			wutil.toMouseOver(driver, hp.getContactlink());
			hp.getSignout();
			
			// Step 8 Close
			driver.quit();
			
			
			
			
			
		
		
	}


}
