package mainmethod;

import java.util.Calendar;

import easyshop.fileutility.ExcelUtility;
import easyshop.fileutility.PropertiesUtility;
import easyshop.genericutility.JavaUtility;

/*
 * This class is created to test logic and validate the data that I'm trying to retrieve from properties file, excel file, database etc.
 * There's no major use of this class
 */
public class Main {

	public static void main(String[] args) throws Exception {

		// Block to check if data is being retrieved from the commondata.properties file
		{
			PropertiesUtility properties = PropertiesUtility.getInstance();

			String browser = properties.getBrowser();
			String url = properties.getUrl();
			String username = properties.getUsername();
			String password = properties.getPassword();

			System.out.println(browser + "\n" + url + "\n" + username + "\n" + password + "\n");
		}

		// Block to check if data is being retrieved from JavaUtility class
		{
			JavaUtility javautility = JavaUtility.getInstance();

			int randomNumber = javautility.getRandomNumber();
			String currentDate = javautility.getSystemDate();
			String dateAfter_1Month = javautility.getRequiredSystemDate(30);

			System.out.println(randomNumber + "\n" + currentDate + "\n" + dateAfter_1Month + "\n");
			
			String contactNumber = javautility.getRandomMobileNumber();
			System.out.println(contactNumber+"\n");
		}

		// Block to check if data is being retrieved from excel file
		{
			ExcelUtility excelutility = ExcelUtility.getInstance();
			int count = excelutility.getRowCount("search");
			System.out.println(count);
			String data = excelutility.getCellData("search", 1, 0);
			System.out.println(data + "\n");
		}

		// Block to check if I'm retrieving the correct time
		{
			String calendarTime = Calendar.getInstance().getTime().toString().replace(" ", "_").replace(":", "_");
			System.out.println(calendarTime + "\n");
		}
	}

}
