package easyshop;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import easyshop.baseclass.BaseClass;
import easyshop.objectrepository.HomePage;
import easyshop.objectrepository.MyWishlistPage;
import easyshop.objectrepository.ProductCategoryPage;

/*
 * Author: Libron John
 * Created On: 2024 November 8
 * 
 * Description: This test verifies that the user can add products to their wishlist
 * It validates if the user can add a product to the wishlist.
 */


public class AddProductToWishlistTest extends BaseClass {

	@Test
	public void addProductToWishlistTest() {

		HomePage homepage = new HomePage(driver);
		homepage.searchField(excelutility.getCellData("search", 1, 0));
		homepage.getSearchbutton().click();

		ProductCategoryPage productcategorypage = new ProductCategoryPage(driver);
		webdriverutility.scrollIntoViewElement(driver, productcategorypage.getWishlistButton())
				.javascriptExecutorClick();
		
		MyWishlistPage mywishlistpage = new MyWishlistPage(driver);

		try{
			
			mywishlistpage.getWishlistTableRowData().getText();
			Assert.fail();
		
		}catch(NoSuchElementException e){
			
			Reporter.log("Element is not available, it means that the wishlist is not empty");
			Assert.assertTrue(true);
		}
		
		Reporter.log("===============Validated the Add Product To Wishlist Functionality===============");
		
	}

}
