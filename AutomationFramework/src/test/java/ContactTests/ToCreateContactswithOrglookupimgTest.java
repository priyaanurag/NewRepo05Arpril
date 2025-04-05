package ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;

public class ToCreateContactswithOrglookupimgTest extends BaseClass{

	@Test(groups="Smoke")
	public void toCreateContactwithOrganizationlokupimg() throws EncryptedDocumentException, IOException
	{
		
		
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreatecontactlookupimage().click();
		
		 CreateContactPage  ccp= new CreateContactPage(driver);
		 ExcelFileUtility eutil =new ExcelFileUtility();
		 String lastname = eutil.toReadDatafromExcelFile("Contacts", 1, 2);
		 ccp.getLastname().sendKeys(lastname);
		 
		 
		 
		 //To click on org look up img
		 
	ccp.getOrganizationicon().click();
	WebDriverUtility wutil =new WebDriverUtility();
	
	// To switch driver control to parent
	wutil.toswitchWindow(driver, "Accounts");
	
	// Click on  ANURAG
	driver.findElement(By.xpath("//a[text()='ANURAG FOODS.PVT.LIMITED']"));
	
	
	// To switch back to driver control to parent
	wutil.toswitchWindow(driver, "Contacts");
	
	// Save and verify
	
	ccp.getSavebutton().click();
	 
	 ContactsInfoPage cip =new ContactsInfoPage(driver);
	 String title = cip.getContactTitlename().getText();
	 
	 
	 //To validate the below scenario we use assert  
	 
	 
	 /*if(title.contains(lastname))
	 {
		 
		 System.out.println(title+"---passed");
	 }
	 
	 else {
		 
		 System.out.println(title+"---Failed");
	 }
	*/
	
	Assert.assertTrue(title.contains(lastname));
	
		 
		 
		 
		
	}
}
