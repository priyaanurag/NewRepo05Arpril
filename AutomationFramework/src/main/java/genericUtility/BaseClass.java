package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;

public class BaseClass {

	public static WebDriver sdriver;
	public  WebDriver driver =null ;
	
	
	PropertyfileUtlity putil = new PropertyfileUtlity();
	WebDriverUtility wutil = new WebDriverUtility();

	//public WebDriver driver;

	@BeforeSuite(groups={"Smoke","Regression"})

	public void beforesuiteConfiguration() {

		Reporter.log("=======DataBase connection est===", true);
	}
     //@Parameters("browser")// Cross Browser testing
     ///@BeforeTest
	@BeforeClass(groups={"Smoke","Regression"})
	public void beforeClassConfiguration(/*String BROWSER*/) throws IOException {

		String BROWSER = putil.toreaddatafromproperyfile("browser");
		System.out.println(BROWSER);
		String URL = putil.toreaddatafromproperyfile("url");
		System.out.println(URL);

		if (BROWSER.contains("chrome")) {
			driver = new ChromeDriver();

		}

		else if (BROWSER.contains("edge")) {
			driver = new EdgeDriver();

		} else if (BROWSER.contains("firefox")) {
			driver = new FirefoxDriver();

		}

		Reporter.log("Browser got Launched", true);
        sdriver=driver;
		wutil.toMaximize(driver);
		wutil.towait(driver);
		driver.get(URL);

	}

	@BeforeMethod(groups={"Smoke","Regression"})
	public void beforeMethodConfiguration() throws IOException

	{

		String USERNAME = putil.toreaddatafromproperyfile("username");
		String PASSWORD = putil.toreaddatafromproperyfile("password");
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameTextfields().sendKeys(USERNAME);
		lp.getPasswordTextfields().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		Reporter.log("Logged In successfully", false);

	}

	@AfterMethod(groups={"Smoke","Regression"})

	public void afterMethodConfiguration() {

		HomePage hp = new HomePage(driver);
		wutil.toMouseOver(driver, hp.getAdminicon());
		hp.getSignout().click();
		Reporter.log("Logged out successfully", false);

	}

	@AfterClass(groups={"Smoke","Regression"})
	public void afterClassConfiguration() {
		
		Reporter.log("Browser got closed ", true);

		driver.quit();
	}

	@AfterSuite(groups="Smoke")
	public void afterSuitConfiguration() {
		Reporter.log("Database connection dissconect ", true);
	}

}
