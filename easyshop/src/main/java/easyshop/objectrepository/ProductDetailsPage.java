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
 * Description: ProductDetailsPage POM that contains all the elements along with their getter and setter and also action methods for the elements  
 * This page displays the details of a particular product that has been clicked
 */

@Getter
@Setter
public class ProductDetailsPage {
	
	private WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "description")
	private WebElement descriptiontab;
	
	public boolean isDescriptionEnabled() {
		
		return descriptiontab.isEnabled();
	}

}
