package easyshop.genericutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: JavaUtility class that contains methods to generate a random number, system date, or a specific required date 
 * 
 */

public class JavaUtility {

	private static JavaUtility instance = null;

	private JavaUtility() {

	}

	public static JavaUtility getInstance() {
		if (instance == null) {
			synchronized (JavaUtility.class) {
				if (instance == null)
					instance = new JavaUtility();
			}
		}
		return instance;
	}

	public int getRandomNumber() {

		Random randomNumber = new Random();

		return randomNumber.nextInt(1000);
	}

	public String getRandomMobileNumber() {

		Random randomNumber = new Random();

		return "9935" + randomNumber.nextInt(100000, 1000000);
	}

	public String getSystemDate() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();

		return sdf.format(calendar.getTime());
	}

	public String getRequiredSystemDate(int days) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, days);

		return sdf.format(calendar.getTime());
	}
}
