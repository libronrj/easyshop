package easyshop.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;

/*
 * Author: Libron John
 * Created On: 2024 November 8
 * 
 * Description: InsertProductPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page has all the major elements located on the Insert Product Page at Admin level of the web app
 */

@Getter
@Setter
public class InsertProductPage {

	private WebDriver driver;

	public InsertProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "category")
	private WebElement categoryDropdown;

	@FindBy(name = "subcategory")
	private WebElement subCategoryDropdown;

	@FindBy(name = "productName")
	private WebElement productName;

	@FindBy(name = "productCompany")
	private WebElement productCompany;

	@FindBy(name = "productpricebd")
	private WebElement productPriceBeforeDiscount;

	@FindBy(name = "productprice")
	private WebElement productPrice;

	@FindBy(css = "div > .nicEdit-main")
	private WebElement textArea;

	@FindBy(name = "productShippingcharge")
	private WebElement productShippingCharge;

	@FindAll({ @FindBy(name = "productAvailability"), @FindBy(id = "productAvailability") })
	private WebElement productAvailabilityDropdown;

	@FindAll({ @FindBy(name = "productimage1"), @FindBy(id = "productimage1"),
			@FindBy(xpath = "//input [@id = 'productimage1']") })
	private WebElement chooseImage1;

	@FindAll({ @FindBy(name = "productimage2"), @FindBy(id = "productimage2"),
			@FindBy(xpath = "//input [@id = 'productimage2']") })
	private WebElement chooseImage2;

	@FindAll({ @FindBy(name = "productimage3"), @FindBy(id = "productimage3"),
			@FindBy(xpath = "//input [@id = 'productimage3']") })
	private WebElement chooseImage3;
	
	@FindBy(name="submit")
	private WebElement insertButton;

	public void productDetails(String productName, String productCompany, String productPriceBeforeDiscount,
			String productPrice, String textArea, String productShippingCharge, String image1, String image2,
			String image3) {
		
		this.productName.sendKeys(productName);
		this.productCompany.sendKeys(productCompany);
		this.productPriceBeforeDiscount.sendKeys(productPriceBeforeDiscount);
		this.productPrice.sendKeys(productPrice);
		this.textArea.sendKeys(textArea);
		this.productShippingCharge.sendKeys(productShippingCharge);
		chooseImage1.sendKeys(image1);
		chooseImage2.sendKeys(image2);
		chooseImage3.sendKeys(image3);
	
	}

}
