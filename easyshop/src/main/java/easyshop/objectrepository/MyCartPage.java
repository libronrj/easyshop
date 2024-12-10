package easyshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

/*
 * Author: Libron John
 * Created On: 2024 November 11
 * 
 * Description: MyCartPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This My Cart Page has all the elements used to process an order or update details like shipping or billing
 */

@Getter
@Setter
public class MyCartPage {

	private WebDriver driver;

	public MyCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "billingaddress")
	private WebElement billingAddressTextArea;

	@FindBy(id = "bilingstate")
	private WebElement billingStateTextField;

	@FindBy(id = "billingcity")
	private WebElement billingCityTextField;

	@FindBy(id = "billingpincode")
	private WebElement billingPincodeTextField;

	@FindBy(name = "update")
	private WebElement updateButton;

	@FindBy(name = "shippingaddress")
	private WebElement shippingAddressTextArea;

	@FindBy(id = "shippingstate")
	private WebElement shippingStateTextField;

	@FindBy(id = "shippingcity")
	private WebElement shippingCityTextField;

	@FindBy(id = "shippingpincode")
	private WebElement shippingPincodeTextField;

	@FindBy(name = "shipupdate")
	private WebElement shipUpdateButton;

	@FindBy(name = "ordersubmit")
	private WebElement proceedToCheckoutButton;
	
	@FindBy(xpath = "//*[text() = 'Shipping Address' and @class='estimate-title']")
	private WebElement billingAddressPanel;

	@FindBy(xpath = "//*[text() = 'Billing Address' and @class='estimate-title']")
	private WebElement shippingAddressPanel;
	
	public void enterBillingDetails(String billingaddress, String billingstate, String billingcity,
			String billingpincode) {

		billingAddressTextArea.clear();
		billingAddressTextArea.sendKeys(billingaddress);
		billingStateTextField.clear();
		billingStateTextField.sendKeys(billingstate);
		billingCityTextField.clear();
		billingCityTextField.sendKeys(billingcity);
		billingPincodeTextField.clear();
		billingPincodeTextField.sendKeys(billingpincode);
		updateButton.click();
	}

	public void enterShippingDetails(String shippingaddress, String shippingstate, String shippingcity,
			String shippingpincode) {

		shippingAddressTextArea.clear();
		shippingAddressTextArea.sendKeys(shippingaddress);
		shippingStateTextField.clear();
		shippingStateTextField.sendKeys(shippingstate);
		shippingCityTextField.clear();
		shippingCityTextField.sendKeys(shippingcity);
		shippingPincodeTextField.clear();
		shippingPincodeTextField.sendKeys(shippingpincode);
		shipUpdateButton.click();
	}

}
