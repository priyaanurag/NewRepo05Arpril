package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	public ContactsInfoPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className="dvHeaderText")
	private WebElement ContactTitlename;


	public WebElement getContactTitlename() {
		return ContactTitlename;
	}


	
	

}
