package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mongodb.assertions.Assertions;
import org.openqa.selenium.support.PageFactory;

import driverManager.WebdriverManager;


public class BatchPage {

	public WebDriver driver;
	public BatchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	private By manageBatch = By.xpath("//div[normalize-space()='Manage Batch']");
	private By batchClick = By.xpath("//span[normalize-space()='Batch']");
	private By header = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	private By headerBatch = By.xpath("//div[text()=' Manage Batch']");
	private By topdeleteIcon = By.xpath("//div/button[@icon='pi pi-trash']");
	private By pagination = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']");
	private By BatcheditIcon = By.xpath("//span[@class='p-button-icon pi pi-pencil']");
	private By sidedeleteIcon = By.xpath("(//td//span[@class='p-button-icon pi pi-trash'])");
	private By Batchcheckbox = By.xpath("//td//div[@role='checkbox']");	
	
	private By batchName = By.xpath("//th[@psortablecolumn='batchName']");
	private By batchDescription = By.xpath("//th[@psortablecolumn='batchDescription']");
	private By batchStatus = By.xpath("//th[@psortablecolumn='batchStatus']");
	private By noOfClasses = By.xpath("//th[@psortablecolumn='batchNoOfClasses']");
	private By programName = By.xpath("//th[@psortablecolumn='programName']");
	private By editDelete = By.xpath("//th[text()=' Edit / Delete ']");	
	
	
	private By headerCheckBox = By.xpath("//div[@class='p-checkbox-box']");
	
	
	public void BatchClickMd() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(batchClick).click();
						}
	
	public void ManageBatchVerify() {
		driver.findElement(manageBatch);
		
	}
	
	public Boolean HeaderValidation(String string) {

		String headertext = header.toString();
		Boolean isContent = headertext.contains(string);
		return isContent;
}
		
	public Boolean HeaderValidationBatch(String string) {

		String headertext = headerBatch.toString();
		Boolean isContent = headertext.contains(string);
		return isContent;
}
	
	public Boolean DeletetopIconValidation() {
		
		Boolean isDeleteIconDisabled = driver.findElement(topdeleteIcon).isEnabled();
		return isDeleteIconDisabled; 
}
		
	// Method to validate pagination controls
    public boolean PaginationValidation() {
        return isElementDisplayed(pagination); // Directly check if pagination is displayed
    }

    // Helper method to check if an element is displayed
    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if element is not found or an exception occurs
        }
    }
    
    
 // Method to validate if edit icon is present in each row
    public boolean isEditIconPresentInEachRow() {
        List<WebElement> editIcons = driver.findElements(BatcheditIcon); // Finds all edit icons
        // Check that edit icon is present in each row (assuming one icon per row)
        for (WebElement icon : editIcons) {
            if (!icon.isDisplayed()) {
                return false; // Return false if any icon is not visible
            }
        }
        return !editIcons.isEmpty(); // Return true if all icons are visible and list is not empty
    }
    
 // Method to validate if delete icon is present in each row
    public boolean isDeleteIconPresentInEachRow() {
        List<WebElement> deleteIcons = driver.findElements(sidedeleteIcon); // Find all delete icons
        // Check that delete icon is present in each row (assuming one icon per row)
        for (WebElement icon : deleteIcons) {
            if (!icon.isDisplayed()) {
                return false; // Return false if any icon is not visible
            }
        }
        return !deleteIcons.isEmpty(); // Return true if all icons are visible and list is not empty
    }
    
    
    public boolean isCheckboxPresentInEachRow() {
        List<WebElement> checkboxes = driver.findElements(Batchcheckbox); // Find all checkboxes
        // Check that checkbox is present in each row (assuming one checkbox per row)
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isDisplayed()) {
                return false; // Return false if any checkbox is not visible
            }
        }
        return !checkboxes.isEmpty(); // Return true if all checkboxes are visible and list is not empty
    }
    
    
 // Method to validate if all headers are present
    public boolean areHeadersVisible() {
        return isElementVisible(batchName) &&
               isElementVisible(batchDescription) &&
               isElementVisible(batchStatus) &&
               isElementVisible(noOfClasses) &&
               isElementVisible(programName) &&
               isElementVisible(editDelete);
    }

    // Helper method to check visibility of an element
    private boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if the element is not found or not visible
        }
    }
    
    public boolean isHeaderCheckboxVisible() {
        return driver.findElement(headerCheckBox).isDisplayed();
    
    
    
    }
    }
	


	
	
	
	
	
	