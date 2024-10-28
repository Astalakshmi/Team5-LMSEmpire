package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.WebdriverManager;

public class ClassModuleNavObject {
	WebDriver driver;
    WebDriverWait wait;
	
  
    @FindBy(xpath=("//span[normalize-space()='Class']"))
    WebElement ClassBtn;  
    
    @FindBy(xpath=("//div[normalize-space()='Manage Class']"))
    WebElement ManageClassHeading;
   	
    @FindBy(xpath=("//button[@id='logout']"))
    WebElement logout;  //
    
    @FindBy(xpath=("//form/p"))
    WebElement loginPageHeaderText;
    
    @FindBy(xpath=("//span[normalize-space()='Batch']"))
    WebElement BatchBtn;
    
    @FindBy(xpath=("//span[normalize-space()='Program']"))
    WebElement ProgramBtn;
    
    @FindBy(xpath=("//*[text()=' Manage Program']"))
    WebElement ManageProgramHeading;
    
    @FindBy(xpath=("//div[text()=' Manage Batch']"))
    WebElement ManageBatchHeading;
    
    @FindBy(xpath=("//button[normalize-space()='Add New Class']"))
    WebElement NewAddClass;
    
    @FindBy(xpath=("//button[@tabindex='-1']"))
    WebElement ClossBtnClass;
    
    @FindBy(xpath=("//span[text()='Cancel']"))
    WebElement Cancel;
    
    @FindBy(xpath=("//span[text()='Save']"))
    WebElement Save;
    
    @FindBy(xpath=("//label[normalize-space()='Batch Name']"))
    WebElement ClassName;
    
    @FindBy(id=("batchName"))
    WebElement Classfield;
    
    @FindBy(id=("classTopic"))
    WebElement ClassTopicField;
    
   

    public ClassModuleNavObject() {
 		
 		driver = WebdriverManager.getDriver();		
 		PageFactory.initElements( driver, this);
 	}

    public String GetTextClassName() {
    	
    	if(ClassName.getText().contains(" Class Name"))
    	{
    		System.out.println("Class Name is present");
    		
    	}
    	
    	else {
    		
    		System.out.println("Class Name is not present");
    	}
		return null;
    
    	
    }
    public void ValidateClassTopic() {
    	
    	boolean b=ClassTopicField.isEnabled();
    	System.out.println(b);
    }
    
    
    public void ValidateBatchName() {
    	
    	boolean b=ClassName.isDisplayed();
    	System.out.println(b);
    }
    
    
    public void ValidateCloseBtn() {
    	boolean b1 = ClossBtnClass.isDisplayed();
    	System.out.println(b1);
     
    }
    
     public void ValidateCancelBtn(){
    	boolean b2= Cancel.isDisplayed();
    	System.out.println(b2);
    	
     }
    	
     public void ValidateSaveBtn(){
      boolean b3= Save.isDisplayed();
      System.out.println(b3);	
    	
    	
    }
    public void ClickNewClass() {
    	NewAddClass.click(); 	
    	
    }
    
    
	
	 public void ClickClassBtn() {
	
		 ClassBtn.click();;
	 } 
	 
	 public String GetManageClassHeading() {
		 
		 return ManageClassHeading.getText();
		 
	 }
	 
	 public LoginValidPage ClickLogout() {
		 
		 
//		 WebElement logout=driver.findElement(By.xpath("//span[text()='Logout']"));
//		 JavascriptExecutor executor=(JavascriptExecutor)driver;
//		 executor.executeScript("argument[0].click()",logout);
		
	WebElement logout=driver.findElement(By.id("logout"));	 
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(logout));
     	logout.click();	
//	
//		 Actions action = new Actions(driver);
//		 action.doubleClick(logout);
	return new LoginValidPage();
		 
	 }

    public String GetTextLogin() {
    	
    	return loginPageHeaderText.getText();
    	
    }
	 
	 public ProgramModule ClickProgram() {
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
         wait.until(ExpectedConditions.elementToBeClickable(ProgramBtn));
		 return new ProgramModule();
		 
	 }
	
	 public BatchModule ClickBatch() {
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
         wait.until(ExpectedConditions.elementToBeClickable(BatchBtn));
		 return new BatchModule();
	 }	 
		 
	 public String GetProgramHeading() {
		 
		return ManageProgramHeading.getText();
			 
		 }
		 
     public String GetBatchHeading() {
		 
		return ManageBatchHeading.getText();
		 
			 
		 }
     
 
     
     
     
     
     
     
}
