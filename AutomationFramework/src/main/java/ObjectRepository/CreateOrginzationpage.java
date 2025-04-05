package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrginzationpage {
	
	
	
	public CreateOrginzationpage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement accountname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SavebuttonofOrg;
	
	@FindBy(name="industry")
	private WebElement Industryname;
	
	@FindBy(name="accounttype")
	private WebElement Type;

	public WebElement getType() {
		return Type;
	}


	public void setSavebuttonofOrg(WebElement savebuttonofOrg) {
		SavebuttonofOrg = savebuttonofOrg;
	}


	public WebElement getIndustryname() {
		return Industryname;
	}


	public WebElement getAccountname() {
		return accountname;
	}

	public WebElement getSavebuttonofOrg() {
		return SavebuttonofOrg;
	}
	
	
	
	

}
