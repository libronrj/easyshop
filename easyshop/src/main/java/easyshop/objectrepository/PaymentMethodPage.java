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
 * Description: PaymentMethodPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page contains the elements required to make different type of payments i.e COD, Internet Banking or Card Payment
 */

@Getter
@Setter
public class PaymentMethodPage {
	
	private WebDriver driver;
	
	public PaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "submit")
	private WebElement submitButton;

}
