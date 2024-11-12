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
 * Description: LoginPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page displays the elements to login to the web app and also elements used to sign up for the web app
 */

@Getter
@Setter
public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#exampleInputEmail1")
	private WebElement username;

	@FindBy(css = "input#exampleInputPassword1")
	private WebElement password;

	@FindBy(xpath = "//button[text()= 'Login']")
	private WebElement loginButton;

	public void loginButtonClick(String username, String password) {
		
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", loginButton);
		loginButton.click();
	}
	

}
