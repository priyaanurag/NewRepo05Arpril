package ObjectRepository;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrginizationPage {
	
	public OrginizationPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrganizationlokkupimage;

	public WebElement getCreateOrganizationlokkupimage() {
		return CreateOrganizationlokkupimage;
	}

	
	

}



	
	
	





