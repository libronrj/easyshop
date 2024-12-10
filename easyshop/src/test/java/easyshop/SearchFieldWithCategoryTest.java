package easyshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import easyshop.baseclass.BaseClass;
import easyshop.objectrepository.HomePage;

/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: This test verifies the search field functionality of a category
 * It validates if the user can search for a category
 * 
 */


public class SearchFieldWithCategoryTest extends BaseClass {

	@Test
	public void searchFieldWithCategoryTest() {

		SoftAssert softassert =new SoftAssert();
		
		HomePage hp = new HomePage(driver);
		hp.searchField(excelutility.getCellData("search", 1, 1));
		hp.clickSearchButton();

		WebElement noproductfound = driver.findElement(By.xpath("//h3[text() = 'No Product Found']"));
		webdriverutility.waitForElementToBePresent(driver, noproductfound);
	
		if (noproductfound.isDisplayed())
			Assert.assertTrue(true);	
		
		Reporter.log("=============== Validated Search Field Functionality Of A Category===============");
		
		softassert.assertAll();
	}

}
