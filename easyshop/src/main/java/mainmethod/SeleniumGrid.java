package mainmethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {
	
	public static void main(String[] args) throws MalformedURLException {
		
		String huburl = "http://localhost:4444/wd/hub";
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.LINUX);
		capabilities.setBrowserName("MicrosoftEdge");
		
		WebDriver driver = new RemoteWebDriver(new URL(huburl), capabilities);
		
		driver.get("https://www.selenium.dev/downloads");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
