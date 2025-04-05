package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	
	public CreateContactPage(WebDriver driver)
	
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement Lastname;
	
	@FindBy(xpath="//img[contains(@onclick, 'window.open')]")
	private WebElement Organizationicon;
	
	public WebElement getLastname() {
		return Lastname;
	}

	public WebElement getOrganizationicon() {
		return Organizationicon;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement Savebutton;

}
