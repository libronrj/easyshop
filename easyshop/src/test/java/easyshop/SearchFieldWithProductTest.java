package easyshop;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import easyshop.baseclass.BaseClass;
import easyshop.objectrepository.HomePage;

/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: This test verifies the search field functionality of a product
 * It validates if the user can search for a product and get a list of the product/related products
 * 
 */


public class SearchFieldWithProductTest extends BaseClass{
	
	@Test
	public void searchFieldWithProductTest()  {
		
		HomePage hp = new HomePage(driver);
		hp.searchField(excelutility.getCellData("search", 1, 0));
		hp.clickSearchButton();
		
		List<WebElement> productlist = driver.findElements(By.xpath("//div[starts-with(@id, 'rateit-')]"));
		Assert.assertEquals(true, !(productlist.isEmpty()));
		
		Reporter.log("=============== Validated Search Field Functionality Of A Product===============");
	}

}
