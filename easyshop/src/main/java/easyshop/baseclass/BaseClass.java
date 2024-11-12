package easyshop.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import easyshop.fileutility.ExcelUtility;
import easyshop.fileutility.PropertiesUtility;
import easyshop.genericutility.JavaUtility;
import easyshop.genericutility.ThreadLocalManager;
import easyshop.genericutility.WebDriverUtility;
import easyshop.objectrepository.HomePage;
import easyshop.objectrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: Base class that is used to setup and teardown all the configurations required before and after execution resectively. 
 * 
 */

public class BaseClass {

	public WebDriver driver = null;
	public static PropertiesUtility properties = PropertiesUtility.getInstance();
	public static JavaUtility javautility = JavaUtility.getInstance();
	public static WebDriverUtility webdriverutility = WebDriverUtility.getInstance();
	public static ExcelUtility excelutility = ExcelUtility.getInstance();

	@BeforeSuite
	public void setupSuite() {

		Reporter.log("===============Connected The Database===============");
	}

	@BeforeClass
	@Parameters("browser")
	public void setupClass(@Optional String browser) {

		String browserInstance = !(browser == null) ? browser : properties.getBrowser();

		switch (browserInstance) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless"); // Enable headless mode
			chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
			chromeOptions.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
			driver = new ChromeDriver(chromeOptions);
			break;
		case "edge":	
			EdgeOptions edgeOptions = new EdgeOptions();
	        edgeOptions.addArguments("--headless"); // Enable headless mode
	        edgeOptions.addArguments("--no-sandbox"); // Bypass OS security model
	        edgeOptions.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
			driver = new EdgeDriver(edgeOptions);
			break;
		default:
			System.err.println("Invalid browser");
			return;
		}

		ThreadLocalManager.setDriver(driver);
		
		Reporter.log("===============Initiating  The Browser===============");
	}

	@BeforeMethod
	public void setupMethod() {

		String url = properties.getUrl();
		driver.get(url);

		webdriverutility.waitForPageToLoad(driver);

		HomePage hp = new HomePage(driver);
		hp.loginLinkClick();

		String username = properties.getUsername();
		String password = properties.getPassword();

		LoginPage lp = new LoginPage(driver);
		lp.loginButtonClick(username, password);
	
		Reporter.log("===============Logged into Page===============");
	}

	@AfterMethod
	public void tearDownMethod() {

		HomePage hp = new HomePage(driver);
		hp.getLogoutLink().click();
		Reporter.log("===============Logged out of Page===============");
	}

	@AfterClass
	public void tearDownClass() {

		driver.quit();
		Reporter.log("===============Terminated The Browser===============");
	}

	@AfterSuite
	public void tearDownSuite() {

		Reporter.log("===============Disconnected The Database===============");
	}

}
