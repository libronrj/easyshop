package easyshop.genericutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: WebDriverUtility class that is used contains methods like -
 * 
 * 					waitForPageToLoad(WebDriver driver)
 * 					waitForElementToBePresent(WebDriver driver, WebElement element)
 * 					switchToWindow(WebDriver driver, String partialUrl)
 * 					javascriptExecutor(WebDriver driver, WebElement element)
 * 					scrollIntoViewElement(WebDriver driver, WebElement element)
 * 
 */

public class WebDriverUtility {
	
	private static WebDriverUtility instance = null;
	private WebElement element = null;
	private WebDriver driver = null;
	
	private WebDriverUtility() {
		
	}
	
	public static WebDriverUtility getInstance() {
		
		if(instance == null) {
			synchronized(WebDriverUtility.class) {
				if(instance == null)
					instance = new WebDriverUtility();
			}
		}
		return instance;
	}
	
	public void waitForPageToLoad(WebDriver driver) {

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForElementToBePresent(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void switchToWindow(WebDriver driver, String partialUrl) {

		Set<String> windows = driver.getWindowHandles();

		for (String windowID : windows) {
			driver.switchTo().window(windowID);
			if (driver.getCurrentUrl().contains(partialUrl))
				break;
		}
	}

	public void switchToFrame(WebDriver driver, int index) {

		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {

		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);
	}

	public void switchToAlertAndAccept(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	public void select(WebElement element, String text) {

		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void mouseMoveOnElement(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {

		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void javascriptExecutorClick() {	
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);
	}
	
	public void javascriptExecutorClick(WebDriver driver, WebElement element) {	
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);
	}
	
	public WebDriverUtility scrollIntoViewElement(WebDriver driver, WebElement element) {
		
		this.driver = driver;
		this.element = element;
		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
		
		return this;
	}
}
