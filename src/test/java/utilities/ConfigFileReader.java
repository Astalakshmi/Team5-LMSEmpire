package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;

	private final String propertyFilePath = "src/test/resources/config/Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
				setBrowserType(properties.getProperty("browser")) ;   // added by Shruti
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}

	}

	private static String browserType = null;

	public static void setBrowserType(String browser) {
		browserType = browser;
	}

	public static String getBrowserType() {

		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the testng.xml");

	}


	public String getUser() {                 //added by shruti
		String username = properties.getProperty("username").trim();
		if (username != null)
			return username;
		else
			throw new RuntimeException("username  not specified in the Configuration.properties file.");
	}

	
	public String getPassword() {            //added by shruti
		String password = properties.getProperty("password").trim();
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
	
	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null)
			return browser;
		else
			throw new RuntimeException("browser not specified in the Configuration.properties file.");
	}
	

	public String getPageTitle(String pageName) {
		String title = properties.getProperty(pageName);
		if (title != null)
			return title;
		else
			throw new RuntimeException(pageName + " url not specified in the Configuration.properties file.");
	}

	public String getIndexUrl() {
		String indexUrl = properties.getProperty("indexUrl");
		if (indexUrl != null)
			return indexUrl;
		else
			throw new RuntimeException(" Index url not specified in the Configuration.properties file.");
	}

	public String getHomeUrl() {
		String homepageUrl = properties.getProperty("homepageUrl");
		if (homepageUrl != null)
			return homepageUrl;
		else
			throw new RuntimeException(" homepage url not specified in the Configuration.properties file.");
	}
	
	public String getAlert(String alertNames) {
		String alertName = properties.getProperty(alertNames);
		if (alertName != null)
			return alertName;
		else
			throw new RuntimeException(alertName + " alert does not match in the Configuration.properties file.");
	}

	public String getFunctionalityMessage(String functionalityName) {
		String funcName = properties.getProperty(functionalityName);
		if (funcName != null)
			return funcName;
		else
			throw new RuntimeException(funcName + " does not match in the Configuration.properties file.");
	}
							
	public String getDashboard() {          //added by asta
		String dashBoardUrl = properties.getProperty("dashBoardUrl");
		if (dashBoardUrl != null)
			return dashBoardUrl;
		else
			throw new RuntimeException(" dashBoard Url not specified in the Configuration.properties file.");
	}
	
	public String getClassModulePageUrl() {          //added by asta
		String classModulePageUrl= properties.getProperty("classModulePageUrl");
		if (classModulePageUrl != null)
			return classModulePageUrl;
		else
			throw new RuntimeException(" classModulePage Url not specified in the Configuration.properties file.");
	}
																//asta
	public String getManageHeader(String className) {
		String classheader = properties.getProperty(className);
		if (classheader != null)
			return classheader;
		else
			throw new RuntimeException(className + " url not specified in the Configuration.properties file.");
	}
	public String getsearchbar(String searchbar) { //asta
		String searchbarValue= properties.getProperty("searchbar");
		if (searchbarValue != null)
			return searchbarValue;
		else
			throw new RuntimeException("'searchbar' property not specified in the Configuration.properties file");
	}
}