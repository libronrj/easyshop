package easyshop;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import easyshop.baseclass.BaseClass;
import easyshop.fileutility.ExcelUtility;
import easyshop.fileutility.PropertiesUtility;
import easyshop.genericutility.ThreadLocalManager;
import easyshop.genericutility.WebDriverUtility;
import easyshop.objectrepository.AdminLoginPage;
import easyshop.objectrepository.HomePage;
import easyshop.objectrepository.InsertProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Author: Libron John
 * Created On: 2024 November 11
 * 
 * Description: This test is end-to-end and verifies that the admin can add a product to the web app, 
 * and then login as a user and verify whether the product is available after searching for the specific product.  
 * 
 */

public class AdminAddAProductE2ETest {

	private WebDriver driver;
	private PropertiesUtility propertiesUtility = PropertiesUtility.getInstance();
	private WebDriverUtility webdriverUtility = WebDriverUtility.getInstance();
	private ExcelUtility excelUtility = ExcelUtility.getInstance();

	@BeforeClass
	@Parameters("browser")
	public void setupTest(@Optional String browser) {

		String browserInstance = !(browser == null) ? browser : propertiesUtility.getBrowser();

		switch (browserInstance) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless"); // Enable headless mode
			driver = new ChromeDriver(chromeOptions);
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--headless"); // Enable headless mode
			driver = new EdgeDriver(edgeOptions);
			break;
		default:
			System.err.println("Invalid browser");
			return;
		}

		ThreadLocalManager.setDriver(driver);

		Reporter.log("===============Initiating  The Browser===============");
	}

	@Test(dataProvider = "excelData")
	public void adminAddAProductE2ETest(String category, String subcategory, String productName, String productCompany,
			String productPriceBeforeDiscount, String productPrice, String textArea, String productShippingCharge,
			String productAvailability, String image1, String image2, String image3) {

		driver = ThreadLocalManager.getDriver();
		webdriverUtility.waitForPageToLoad(driver);

		driver.get(propertiesUtility.getUrl());

		HomePage homepage = new HomePage(driver);
		homepage.getAdminLoginButton().click();

		AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
		adminLoginPage.loginToAdminPage("admin", "Test@123");
		adminLoginPage.getInsertProductButton().click();

		InsertProductPage insertProduct = new InsertProductPage(driver);
		webdriverUtility.select(insertProduct.getCategoryDropdown(), category);
		webdriverUtility.select(insertProduct.getSubCategoryDropdown(), subcategory);
		webdriverUtility.select(insertProduct.getProductAvailabilityDropdown(), productAvailability);
		insertProduct.productDetails(productName, productCompany, productPriceBeforeDiscount, productPrice, textArea,
				productShippingCharge, image1, image2, image3);

		webdriverUtility.javascriptExecutorClick(driver, insertProduct.getInsertButton());

		adminLoginPage.getLogoutDropdown().click();
		webdriverUtility.mouseMoveOnElement(driver, adminLoginPage.getLogout());
		adminLoginPage.getBackToPortalButton().click();

		// This is an object of the inner class
		SearchForInsertedProduct searchProduct = new SearchForInsertedProduct();
		searchProduct.searchForInsertedProduct();

		Reporter.log("===============Validated Admin Add A Product And Availability For User===============");
		driver.quit();
	}

	@DataProvider(name = "excelData")
	public Object[][] dataProvider() {

		Object[][] data = new Object[1][12];

		for (int i = 0; i < 12; i++) {
			data[0][i] = excelUtility.getCellData("search", 1, i + 3);
		}
		return data;
	}

	private class SearchForInsertedProduct extends BaseClass {

		@Test
		public void searchForInsertedProduct() {

			HomePage hp = new HomePage(AdminAddAProductE2ETest.this.driver);
			String data = AdminAddAProductE2ETest.this.excelUtility.getCellData("search", 1, 5);

			hp.searchField(data);
			hp.clickSearchButton();

			try {
				WebElement noProductFound = AdminAddAProductE2ETest.this.driver
						.findElement(By.xpath("//*[text()= 'No Product Found']"));
				AdminAddAProductE2ETest.this.webdriverUtility
						.waitForElementToBePresent(AdminAddAProductE2ETest.this.driver, noProductFound);
				Assert.fail("Expected NoSuchElementException was not thrown.");
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException was thrown as expected.");
				Assert.assertTrue(true);
			}
		}
	}

}
