package easyshop;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import easyshop.baseclass.BaseClass;
import easyshop.objectrepository.HomePage;
/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: This test verifies the login functionality of the website.
 * It validates if the user can log in using valid credentials and verify the landing page. 
 * 
 */


public class LoginTest extends BaseClass{

	@Test
	public void loginTest() {
		
		HomePage hp = new HomePage(driver);
		boolean flagLogoutLink = hp.getLogoutLink().isDisplayed();
		
		Assert.assertEquals(flagLogoutLink, true);
		
		Reporter.log("=============== Validated Login Functionality===============");
	}

}
