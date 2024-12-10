package easyshop;

import org.testng.Reporter;
import org.testng.annotations.Test;

import easyshop.baseclass.BaseClass;
import easyshop.objectrepository.HomePage;
import easyshop.objectrepository.MyCartPage;
import easyshop.objectrepository.PaymentMethodPage;
import easyshop.objectrepository.ProductCategoryPage;

/*
 * Author: Libron John
 * Created On: 2024 November 11
 * 
 * Description: This test verifies that the user can login, search, add the product to cart and then checkout.  
 * 
 */

public class ProceedToCheckoutTest extends BaseClass {

	@Test
	public void proceedToCheckoutTest()  {

		HomePage homepage = new HomePage(driver);
		webdriverutility.javascriptExecutorClick(driver, homepage.getFurnitureLink());

		ProductCategoryPage productcategorypage = new ProductCategoryPage(driver);
		webdriverutility.javascriptExecutorClick(driver, productcategorypage.getAddToCartButton());
		webdriverutility.switchToAlertAndAccept(driver);

		MyCartPage mycartpage = new MyCartPage(driver);
		
		webdriverutility.scrollIntoViewElement(driver, mycartpage.getBillingAddressPanel());
		String billingaddress = excelutility.getCellData("billing", 1, 0);
		String billingstate = excelutility.getCellData("billing", 1, 1);
		String billingcity = excelutility.getCellData("billing", 1, 2);
		String billingpincode = excelutility.getCellData("billing", 1, 3);
		mycartpage.enterBillingDetails(billingaddress, billingstate, billingcity, billingpincode);
		webdriverutility.switchToAlertAndAccept(driver);

		webdriverutility.scrollIntoViewElement(driver, mycartpage.getShippingAddressPanel());
		String shippingaddress = excelutility.getCellData("shipping", 1, 0);
		String shippingstate = excelutility.getCellData("shipping", 1, 1);
		String shippingcity = excelutility.getCellData("shipping", 1, 2);
		String shippingpincode = excelutility.getCellData("shipping", 1, 3);
		mycartpage.enterShippingDetails(shippingaddress, shippingstate, shippingcity, shippingpincode);
		webdriverutility.switchToAlertAndAccept(driver);
		
		webdriverutility.scrollIntoViewElement(driver, mycartpage.getProceedToCheckoutButton());
		webdriverutility.javascriptExecutorClick(driver, mycartpage.getProceedToCheckoutButton());

		PaymentMethodPage paymentmethodpage = new PaymentMethodPage(driver);
		webdriverutility.javascriptExecutorClick(driver, paymentmethodpage.getSubmitButton());
		
		Reporter.log("===============Validated The Proceed To Checkout Functionality===============");

	}
}
