package easyshop.objectrepository;

import java.util.List;

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
 * Description: ProductCategoryPage POM that contains all the elements along with their getter and setter and also action methods for the elements
 * This page displays the list of products available after searching for a particular product  
 * 
 */

@Getter
@Setter
public class ProductCategoryPage {

	private WebDriver driver;
	private WebElement element;
	
	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(), 'iPhone')]")
	private WebElement productlink;

	@FindBy(css = "a.add-to-cart")
	private WebElement wishlistButton;

	@FindBy(xpath = "//button[text()='Add to cart']")
	private List<WebElement> addToCartButtonList;

	public void clickProductLink() {
		productlink.click();
	}

	public WebElement getAddToCartButton() {
		
		for(int i = 0; i < addToCartButtonList.size(); i++) {
			element = addToCartButtonList.getLast();
		}
		return element;
	}

}
