package easyshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

/*
 * Author: Libron John
 * Created On: 2024 November 10
 * 
 * Description: MyAccountPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page displays the My Profile Panel and the sidebar with other interactive links like order history, change password
 */

@Getter
@Setter
public class MyAccountPage {

	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#name")
	private WebElement fullnametextfield;

	@FindBy(css = "input#exampleInputEmail1")
	private WebElement emailtextfield;

	@FindBy(css = "input#contactno")
	private WebElement contacttextfield;

	@FindBy(name = "update")
	private WebElement updatebutton;

	public void enterFullName(String fullname) {

		fullnametextfield.clear();
		fullnametextfield.sendKeys(fullname);

	}

	public void enterEmailAddress(String emailAddress) {

		emailtextfield.clear();
		emailtextfield.sendKeys(emailAddress);

	}

	public String enterContactNo(String contactno) {

		contacttextfield.clear();
		contacttextfield.sendKeys(contactno);
		
		return contactno;

	}

	public void enterMyProfileDetails(String fullname, String emailAddress, String contactno) {

		fullnametextfield.clear();
		fullnametextfield.sendKeys(fullname);
		emailtextfield.clear();
		emailtextfield.sendKeys(emailAddress);
		contacttextfield.clear();
		contacttextfield.sendKeys(contactno);
	}

}
