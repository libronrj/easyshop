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
 * Description: MyWishlistPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page displays the elements that are available in the My Wishlist Page
 */


@Getter
@Setter
public class MyWishlistPage {
	
	private WebDriver driver;
	
	public MyWishlistPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tbody/tr/td[contains(text(), 'Your Wishlist is Empty')]")
	private WebElement wishlistTableRowData;
}
