package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="user_name")
	private WebElement usernameTextfields;
	
	@FindBy(xpath="//input[@type='password']")
     private WebElement passwordTextfields;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getUsernameTextfields() {
		return usernameTextfields;
	}

	public WebElement getPasswordTextfields() {
		return passwordTextfields;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	
	
	

}
