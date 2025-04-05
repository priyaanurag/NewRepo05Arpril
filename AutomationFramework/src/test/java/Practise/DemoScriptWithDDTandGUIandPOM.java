package Practise;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyfileUtlity;
import genericUtility.WebDriverUtility;

public class DemoScriptWithDDTandGUIandPOM {

	public static void main(String[] args) throws IOException {
		
		PropertyfileUtlity putil =new PropertyfileUtlity();
		WebDriverUtility wutil =new WebDriverUtility();
		ExcelFileUtility eutil =new ExcelFileUtility();
		
		// Read data from property file
		 String URL = putil.toreaddatafromproperyfile("url");
		 String BROWSER = putil.toreaddatafromproperyfile("browser");
		String USERNAME = putil.toreaddatafromproperyfile("username");
		String PASSWORD = putil.toreaddatafromproperyfile("password");
		
		// Read data from excel file
		
		String lastname=eutil.toReadDatafromExcelFile("Contacts", 1, 2);
		
		
		// Step1 Launch browser
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
		
		// Step 2-Login with valid credentials
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameTextfields().sendKeys(USERNAME);
		lp.getPasswordTextfields().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		
		
		//step 3-Click on contact link
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		
		// step 4 To create contact
		ContactsPage cps=new ContactsPage(driver);
		cps.getCreatecontactlookupimage().click();
		
		//Step 5- click on create contact link
		CreateContactPage cp =new CreateContactPage(driver);
		cp.getLastname().sendKeys(lastname);
		
		
		// Step 6 save and verify
		cp.getSavebutton().click();
		ContactsInfoPage ccp= new ContactsInfoPage(driver);
		String name = ccp.getContactTitlename().getText();
		if (name.contains(lastname))
		{
			System.out.println(name+"======pass");
		}
		
		else
		{
			
			
			System.out.println(name+"====Fail");
		}
		
		
		
		//Step 7 logout
		wutil.toMouseOver(driver, hp.getContactlink());
		hp.getSignout();
		
		// Step 8 Close
		driver.quit();
		
		
		
		
		
		
		
		

	}

}
