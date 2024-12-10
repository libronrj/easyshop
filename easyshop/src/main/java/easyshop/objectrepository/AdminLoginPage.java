package easyshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

/*
 * Author: Libron John
 * Created On: 2024 November 8
 * 
 * Description: AdminLoginPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page has all the major elements located on the Admin Login Page of the web app
 */

@Getter
@Setter
public class AdminLoginPage {
	
	private WebDriver driver;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="inputEmail")
	private WebElement adminId;
	
	@FindBy(id="inputPassword")
	private WebElement adminPassword;
	
	@FindBy(name="submit")
	private WebElement adminLoginButton;
	
	@FindBy(xpath = "//li[contains(., 'Insert Product')]")
	private WebElement insertProductButton;
	
	@FindBy(xpath = "//*[@class = 'dropdown-toggle']")
	private WebElement logoutDropdown;
	
	@FindBy(xpath = "//*[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//*[normalize-space(text()) = 'Back to Portal']")
	private WebElement backToPortalButton;
	
	public void loginToAdminPage(String adminUserEmail, String adminPassword) {
		
		adminId.sendKeys(adminUserEmail);
		this.adminPassword.sendKeys(adminPassword);
		adminLoginButton.click();
		
	}
}
