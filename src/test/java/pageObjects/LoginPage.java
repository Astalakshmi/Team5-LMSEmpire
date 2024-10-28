package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import driverManager.WebdriverManager;
import utilities.ConfigFileReader;
import utilities.ExcelFileReader;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public LoginPage() {
        driver=launchBrowser(); // Launch the browser when the page object is created
        PageFactory.initElements(driver, this);
    }
    
    private final String excelCredentialFilePath = "src//test//resources//LMSCredentials.xlsx";    
    ExcelFileReader excelFileReader = new ExcelFileReader();     
	
	public List<Map<String, String>> excelLoginData = excelFileReader.getData(excelCredentialFilePath,"Credentials");
	public String validUserName = excelLoginData.get(0).get("UserName");
	public String validPassword = excelLoginData.get(0).get("Password");    
	public String invalidUserName = excelLoginData.get(1).get("UserName");
	public String invalidPassword = excelLoginData.get(1).get("Password");
	public String emptyUserName = excelLoginData.get(2).get("UserName");
	public String emptyPassword = excelLoginData.get(3).get("Password");
	
	public List<Map<String, String>> excelPortalData = excelFileReader.getData(excelCredentialFilePath,"Portal");
	public String validPortal = excelPortalData.get(0).get("PageURL");
	public String invalidPortal = excelPortalData.get(1).get("PageURL");

    public WebDriver launchBrowser() {
		String browserType = ConfigFileReader.getBrowserType();
		WebDriver driver = WebdriverManager.initializeDriver(browserType);
		return driver;
    }

    public void enterURL(String url) {
        driver.get(url);
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }

    public boolean is404ErrorDisplayed() {
        return driver.getPageSource().contains("Application Error");
    }

    public boolean is400ErrorDisplayed() {
        return driver.getPageSource().contains("Please login to LMS application");
    }
    
    public boolean verifySpelling() {
    	return driver.getPageSource().contains("Please login to LMS application");
    }

    public boolean isLogoAlignedLeft() {
    	return driver.findElement(By.cssSelector("img.images[src='assets/img/LMS-logo.jpg']")) != null;
    }
    public boolean getAppName() {
    	return driver.findElement(By.cssSelector("img.images[src='assets/img/LMS-logo.jpg']")) != null;
    }

    public boolean getCompanyName() {
    	return driver.findElement(By.cssSelector("img.images[src='assets/img/LMS-logo.jpg']")) != null;
    }

    public boolean verifyLoginMessage() {
    	return driver.getPageSource().contains("Please login to LMS application");
    }

    public boolean verifyTwoTextfieldsPresent() {
        boolean usernamePresent = driver.findElement(By.id("username")) != null;
        boolean passwordPresent = driver.findElement(By.id("password")) != null;
        return usernamePresent && passwordPresent;
    }
    
    public String verifyUserNameText() {
    	return driver.findElement(By.id("username")).getAttribute("ng-reflect-placeholder").toString();
    }
    
    public String verifyMandatorySymbol() {
    	System.out.println(driver.findElement(By.id("username")).getAttribute("aria-required").toString());
    	return driver.findElement(By.id("username")).getAttribute("aria-required").toString();
    }
    
    public String verifyPasswordText() {
    	return driver.findElement(By.id("password")).getAttribute("ng-reflect-placeholder").toString();
    }
    
    public String verifyMandatorySymbolPassword() {    	
    	return driver.findElement(By.id("password")).getAttribute("aria-required").toString();
    }
    
    public String verifyInputFieldatMiddle() {
    	String result="false";
    	result = driver.findElement(By.id("password")).getAttribute("aria-required").toString();
    	return result;
    }
    
    public boolean isLoginButtonPresent() {
    	return driver.findElement(By.id("login")).isDisplayed();
    }
    
    public boolean isUsernameFieldGray() {
        WebElement usernameField = driver.findElement(By.id("username"));        
        String color = usernameField.getCssValue("color");
        String expectedGrayColor = "rgba(128, 128, 128, 1)";
        return color.equals(expectedGrayColor);
    }
    
    public boolean isPasswordFieldGray() {
        WebElement passwordField = driver.findElement(By.id("password"));        
        String color = passwordField.getCssValue("color");
        String expectedGrayColor = "rgba(128, 128, 128, 1)";
        return color.equals(expectedGrayColor);
    }
    
    public void LoginWithValidCredentials() { 
    	driver.findElement(By.id("username")).sendKeys(validUserName);
    	driver.findElement(By.id("password")).sendKeys(validPassword);
    	driver.findElement(By.id("login")).click();	
	}	
	
	public void LoginWithInValidCredentials() { 
    	driver.findElement(By.id("username")).sendKeys(invalidUserName);
    	driver.findElement(By.id("password")).sendKeys(invalidPassword);
    	driver.findElement(By.id("login")).click();	
	}
	
	public String IsLoginErrorDisplayed() {
		 WebElement errorMessage = driver.findElement(By.id("errormessage"));
		 String errorText = errorMessage.getText();
		 return errorText;
	}
	
    public void onlyEnterPassoword() { 
    	driver.findElement(By.id("password")).sendKeys(validPassword);
    	driver.findElement(By.id("login")).click();	
	}
    
    public void onlyEnterUserName() { 
    	driver.findElement(By.id("username")).sendKeys(validUserName);
    	driver.findElement(By.id("login")).click();	
	}	
	
}
