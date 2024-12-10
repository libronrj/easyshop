package mainmethod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrokenLinks {
	
	static AtomicInteger count = new AtomicInteger(0);
	
	
	public static void main(String[] args) {

		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--headless");

		WebDriver driver = new EdgeDriver(edgeOptions);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println(listOfLinks.size());
		
		BrokenLinks brokenLinksInstance = new BrokenLinks();
		listOfLinks.parallelStream().forEach(brokenLinksInstance::brokenLinks);

		System.out.println("Number of broken links are " + count);

		driver.quit();

	}

	public void brokenLinks(WebElement link) {

		String urlName = link.getAttribute("href");

		try {
			URL url = new URL(urlName);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.connect();

			if (httpUrlConnection.getResponseCode() >= 400) {
				System.out.println(urlName + " ============> is broken");
				count.incrementAndGet();
			} else {
				System.out.println(urlName + " ============> is working");
			}
			httpUrlConnection.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
