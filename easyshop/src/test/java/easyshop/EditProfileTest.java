package easyshop;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import easyshop.baseclass.BaseClass;
import easyshop.objectrepository.HomePage;
import easyshop.objectrepository.MyAccountPage;

/*
 * Author: Libron John
 * Created On: 2024 November 10
 * 
 * Description: This test verifies that users can update their account information  
 * It validates if users can edit their information in the My Profile Panel 
 * 
 */

public class EditProfileTest extends BaseClass {

	@Test
	public void editProfileTest() throws InterruptedException {

		HomePage homepage = new HomePage(driver);
		homepage.getMyaccountlink().click();

		MyAccountPage myaccountpage = new MyAccountPage(driver);
		webdriverutility.scrollIntoViewElement(driver, myaccountpage.getContacttextfield()).javascriptExecutorClick();

		String newContactNumber = myaccountpage.enterContactNo(javautility.getRandomMobileNumber());

		myaccountpage.getUpdatebutton().click();
		webdriverutility.switchToAlertAndAccept(driver);
		String valueOfContactNumber = myaccountpage.getContacttextfield().getDomProperty("value");
		System.out.println(valueOfContactNumber);
		Assert.assertEquals(newContactNumber, valueOfContactNumber);

		Reporter.log("=============== Validated Edit Profile Functionality===============");

	}

}
