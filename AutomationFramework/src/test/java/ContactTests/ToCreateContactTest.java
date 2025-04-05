package ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;


@Listeners(genericUtility.ListenersImplementation.class)
public class ToCreateContactTest extends BaseClass {
	
	
	
	@Test(groups="Smoke")
		
		public void toCreateContacts_001() throws EncryptedDocumentException, IOException
		
		{
			HomePage hp=new HomePage(driver);
			hp.getContactlink().click();
			
			ContactsPage cp=new ContactsPage(driver);
			cp.getCreatecontactlookupimage().click();
			
			 CreateContactPage  ccp= new CreateContactPage(driver);
			 ExcelFileUtility eutil =new ExcelFileUtility();
			 String lastname = eutil.toReadDatafromExcelFile("Contacts", 1, 2);
			 ccp.getLastname().sendKeys(lastname);
			 
			 //Assert.fail();
			 
			 ccp.getSavebutton().click();
			 
			 ContactsInfoPage cip =new ContactsInfoPage(driver);
			 String title = cip.getContactTitlename().getText();
			 
			 System.out.println("This is smoke");
			 /*if(title.contains(lastname))
			 {
				 
				 System.out.println(title+"---passed");
			 }
			 
			 else {
				 
				 System.out.println(title+"---Failed");
			 }
			 */
			 //Assert.assertTrue(title.contains(lastname));//
			// Assert.assertEquals(lastname, null);
			
		}
		


}
