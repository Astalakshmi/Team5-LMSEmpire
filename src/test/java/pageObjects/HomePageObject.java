package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.WebdriverManager;



public class HomePageObject {
	
     WebDriver driver;
     WebDriverWait wait;
   
   
	
	//constructor
	public HomePageObject() {
		
		driver = WebdriverManager.getDriver();		

	}
	
	public String getPageURL() {

		return driver.getCurrentUrl();
	}
	
}