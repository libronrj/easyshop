package easyshop.genericutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

/*
 * Author: Libron John
 * Created: 2024 November 9
 * 
 * Description: This class is used to set the driver instance and test instance to static and make it thread safe
 * 
 */

public class ThreadLocalManager {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	
	public static void setDriver(WebDriver driver) {
		 ThreadLocalManager.driver.set(driver);
	}
	
	public static void setTest(ExtentTest test) {
		ThreadLocalManager.test.set(test);
	}
	
	public static WebDriver getDriver(){
		return driver.get();
	}
	
	public static ExtentTest getTest() {
		return test.get();
	}

}
