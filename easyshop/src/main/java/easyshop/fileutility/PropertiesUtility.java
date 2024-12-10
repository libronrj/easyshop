package easyshop.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * Author: Libron John
 * Created: 2024 November 8
 * 
 * Description: PropertiesUtility class used to retrieve a value from a property file that basically stores common data 
 * 
 */

public class PropertiesUtility {

	
	private static PropertiesUtility instance = null; // Created a static variable of this class to create a singleton class
	private static Properties property; // Created a static variable of Properties class to share the same data across the class and instances 

	// Private constructor
	private PropertiesUtility() {

		//try-with-resources to automatically close connections and avoid data leak
		try (FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties")) {
			property = new Properties();
			property.load(fis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// getInstance() to create a single instance of the singleton class with double-checked locking
	public static PropertiesUtility getInstance() {
		
		if(instance == null) { // First check (without synchronization)
			synchronized (PropertiesUtility.class) { // Locking
				if(instance == null) { // Second check (with synchronization)
					instance = new PropertiesUtility(); // Created instance of the singleton class
				}
			}
		}
		return instance;
	}
	
	// Method to receive the browser
	public String getBrowser() {
		return property.getProperty("browser");
	}

	// Method to receive the value of the url
	public String getUrl() {
		return property.getProperty("url");

	}

	// Method to receive the value of the username
	public String getUsername() {
		return property.getProperty("username");

	}

	// Method to receive the value of the password
	public String getPassword() {
		return property.getProperty("password");
	}

}
