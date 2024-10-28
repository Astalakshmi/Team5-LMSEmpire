package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.WebdriverManager;

public class LoginValidPage {
	
	WebDriver driver;
    WebDriverWait wait;
     
    @FindBy(xpath=("//form/p"))
    WebElement loginPageHeaderText;
    
    @FindBy(id="errormessage")
    WebElement invalidCredentialErrMsg;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submitBtn;
	
	@FindBy(id="mat-error-0")
	WebElement nullEmailIdErrMsg;
	
	@FindBy(id="mat-error-1")
	WebElement nullPasswordErrMsg;
	
	@FindBy(xpath=("//span[text()=' LMS - Learning Management System ']"))
	WebElement LMSHeading;
		
	private By textFields = By.className("cdk-text-field-autofill-monitored"); 
     
     
     public LoginValidPage() {
 		
 		driver = WebdriverManager.getDriver();		
 		PageFactory.initElements( driver, this);
 	}
    
	public void LoginValid(String Usename,String Password) { 

		username.sendKeys(Usename);
		password.sendKeys(Password);
		submitBtn.click();
		System.out.println("Admin is logged into LMS Application");
		
	}

	public String GetText() {
		
		return LMSHeading.getText();
		
		
	}
	
	
	
}