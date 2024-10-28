package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
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
    private By sortIcon = By.xpath("//th[normalize-space()='Batch Name']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");

    private By newBatchButton = By.xpath("//button[normalize-space()='Add New Batch']");
    private By batchDetailsPop = By.xpath("//span[@id='pr_id_2-label']");
    
    private By rowEditBtn = By.xpath("(//span[@aria-hidden='true'])[3]");
    
    private By programNameDropdown = By.xpath("//p-dropdown[@id='programName']");
    private By batchNameField = By.xpath("(//input[@id='batchName'])[2]");
    
    private By descriptionField = By.xpath("//input[@id='batchDescription']");
    private By saveButton = By.xpath("//button[@class='p-button-rounded p-button-success p-button p-component ng-star-inserted']");
    
	
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
		
	
    public boolean PaginationValidation() {
        return isElementDisplayed(pagination); 
    }

    
    private boolean isElementDisplayed(By locator) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    
 
    public boolean isEditIconPresentInEachRow() {
        List<WebElement> editIcons = driver.findElements(BatcheditIcon); 
        
        
        for (WebElement icon : editIcons) {
            if (!icon.isDisplayed()) {
                return false; 
            }
        }
        return !editIcons.isEmpty(); 
    }
    
 
    public boolean isDeleteIconPresentInEachRow() {
        List<WebElement> deleteIcons = driver.findElements(sidedeleteIcon); 
       
        
        for (WebElement icon : deleteIcons) {
            if (!icon.isDisplayed()) {
                return false; 
            }
        }
        return !deleteIcons.isEmpty(); 
    }
    
    
    public boolean isCheckboxPresentInEachRow() {
        List<WebElement> checkboxes = driver.findElements(Batchcheckbox); 
        
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isDisplayed()) {
                return false; 
            }
        }
        return !checkboxes.isEmpty(); 
    }
    
    
 
    public boolean areHeadersVisible() {
        return isElementVisible(batchName) &&
               isElementVisible(batchDescription) &&
               isElementVisible(batchStatus) &&
               isElementVisible(noOfClasses) &&
               isElementVisible(programName) &&
               isElementVisible(editDelete);
    }

    
    private boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false; 
        }
    }
    
    public boolean isHeaderCheckboxVisible() {
        return driver.findElement(headerCheckBox).isDisplayed();
    
    
        }
    
    
    public boolean areAllSortIconsVisible() {
        List<WebElement> sortIcons = driver.findElements(sortIcon);
        
        
        for (WebElement icon : sortIcons) {
            if (!icon.isDisplayed()) {
                return false; 
            }
        }
        return true; 
    }
    
    public boolean isSubmenuVisible(String submenuText) {
    	
    	try {
            return driver.findElement(newBatchButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false; 
        }
    }
    
    public void clickAddNewBatchButton() {
        driver.findElement(newBatchButton).click();
    }
    
    public void batchdetailPOP() {

    	driver.findElement(batchDetailsPop);
	
}
    
    public void editButton() {
        WebElement editButton = driver.findElement(rowEditBtn);
        try {
            editButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
        }
    }
    
    
   public boolean isProgramNameFieldDisabled() {
        WebElement dropdown = driver.findElement(programNameDropdown);
       return !dropdown.isEnabled(); 
    }
    
   public boolean isBatchNameFieldDisabled() {
	    WebElement batchNameInput = driver.findElement(batchNameField);
	    return !batchNameInput.isEnabled(); 
	}
   
   public void enterInvalidDataInDescription(String invalidData) {
	    WebElement descriptionInput = driver.findElement(descriptionField);
	    descriptionInput.clear();  // Clear any existing text
	    descriptionInput.sendKeys(invalidData); // Enter invalid data
	}

	public void clickSaveButton() {
	   
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
	    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	    saveBtn.click();
	}
   
   
    
}
    
	


	
	
	
	
	
	