package OrganizationTests;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import ObjectRepository.CreateOrginzationpage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationInfoPage;
import ObjectRepository.OrginizationPage;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;

public class ToCreateOrgwithChemaicalTypeTest extends BaseClass{
	
	
	@Test(groups="Regression")
	public void tocreateOrganizationwithChemial_Type() throws EncryptedDocumentException, IOException
	{
		HomePage hp= new HomePage(driver);
		hp.getOrganizationslink().click();
		
		OrginizationPage op=new OrginizationPage(driver);
		op.getCreateOrganizationlokkupimage().click();
		
		OrginizationPage or =new OrginizationPage(driver);
		or.getCreateOrganizationlokkupimage().click();
		
		CreateOrginzationpage ogp=new CreateOrginzationpage(driver);
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String Org = eutil.toReadDatafromExcelFile("Organization", 1, 2);
		
		Random r=new Random();
		int random= r.nextInt(500);
		ogp.getAccountname().sendKeys(Org+random);
		
		WebDriverUtility wutil =new WebDriverUtility();
	  wutil.toHandleDropdown(ogp.getIndustryname(),"Energy");
	  wutil.toHandleDropdown(ogp.getType(), "Customer");
	  
	  ogp.getSavebuttonofOrg().click();
		
		OrganizationInfoPage Oip= new OrganizationInfoPage(driver);
		String Header =Oip.getTitleofOrgpage().getText();
		
		if(Header.contains(Org))
		{
			
			
			System.out.println("=====Passed and Organization created with Chemical +Type-Customer ");
		}
		
		else
		{
			System.out.println("=====Failed and Organization not created ");
			
		}
		
	}

}
