package mainmethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandlingTable {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("file:///home/himanshu/Desktop/Tables/Practice%20Tables.html");

		System.out.println("\n\n\n================Table Data================");

		try {
			for (int i = 1; i < 5; i++) {

				driver.findElement(By.xpath("//*[@id='static-table']//tr[" + i + "]"));

				if (i == 1) {
					for (int j = 1; j < 4; j++) {

						String tableHeading = driver.findElement(By.xpath("//*[@id='static-table']//th[" + j + "]"))
								.getText();
						System.out.print(tableHeading + "\t");

					}
				}

				else {
					System.out.println();
					for (int k = 1; k < 4; k++) {

						String tabledata = driver
								.findElement(By.xpath("//*[@id='static-table']//tr[" + i + "]" + "//td[" + k + "]"))
								.getText();
						System.out.print(tabledata + "\t");
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			driver.quit();
		}
	}
}
