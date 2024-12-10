package easyshop.objectrepository;

import org.openqa.selenium.JavascriptExecutor;
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
 * Description: HomePage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page has all the major elements located on the homepage of the web app
 */

@Getter
@Setter
public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(linkText = "Login")
	private WebElement loginLink;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	@FindBy(linkText = "My Account")
	private WebElement myaccountlink;
	
	@FindBy(css = "input.search-field")
	private WebElement searchfield;
	
	@FindBy(css = "button.search-button")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//*[text()=' Furniture']")
	private WebElement furnitureLink;
	
	@FindBy(xpath = "//*[@class = 'list-unstyled']//li[contains(., 'Admin Login')]")
	private WebElement adminLoginButton;
	
	public void loginLinkClick() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginLink);
	}
	
	public void searchField(String data) {
		searchfield.clear();
		searchfield.sendKeys(data);
	}
	
	public void clickSearchButton() {
		searchbutton.click();
	}
}
