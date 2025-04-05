package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public HomePage(WebDriver driver)
	{
		
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Contacts")
	private WebElement Contactlink;
	
	
	
@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement adminicon;

public WebElement getContactlink() {
	return Contactlink;
}


@FindBy(linkText="Organizations")
private WebElement Organizationslink;

public WebElement getOrganizationslink() {
	return Organizationslink;
}

public WebElement getAdminicon() {
	return adminicon;
}

public WebElement getSignout() {
	return Signout;
}

@FindBy(linkText="Sign Out")
private WebElement Signout;

}
