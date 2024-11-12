package easyshop;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import easyshop.baseclass.BaseClass;
import easyshop.objectrepository.HomePage;
import easyshop.objectrepository.ProductCategoryPage;
import easyshop.objectrepository.ProductDetailsPage;

/*
 * Author: Libron John
 * Created On: 2024 November 10
 * 
 * Description: This test verifies that users can view the description of their product
 * It validates that the description is displayed below the product 
 * 
 */


public class ProductDescriptionTest extends BaseClass {

	@Test
	public void productDescriptionTest() {

		HomePage homepage = new HomePage(driver);
		homepage.searchField(excelutility.getCellData("search", 1, 0));
		homepage.clickSearchButton();

		ProductCategoryPage productcategorypage = new ProductCategoryPage(driver);
		webdriverutility.javascriptExecutorClick(driver, productcategorypage.getProductlink());

		ProductDetailsPage productdetailspage = new ProductDetailsPage(driver);
		webdriverutility.scrollIntoViewElement(driver, productdetailspage.getDescriptiontab());

		Assert.assertEquals(productdetailspage.isDescriptionEnabled(), true);
		
		Reporter.log("=============== Validated Product Description Functionality===============");

	}

}
