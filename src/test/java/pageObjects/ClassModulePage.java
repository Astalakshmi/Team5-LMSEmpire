
package pageObjects;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverManager.WebdriverManager;

public class ClassModulePage {

	WebDriver driver = WebdriverManager.getDriver();
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
							//locator
				//************ClassPageValidation**************
	@FindBy(xpath="//span[normalize-space()='Class']")
	WebElement classBtn;
	@FindBy(xpath="//button[normalize-space()='Add New Class']")
	WebElement addNewClass;
	@FindBy(xpath="//div[normalize-space()='Manage Class']")
	WebElement manageClassHeader;
	@FindBy(xpath="//input[@id='filterGlobal']")
	WebElement searchBox;
	@FindBy(xpath="//div[@class='p-checkbox-box']")
	WebElement checkbox;
    @FindBy(xpath = "//thead[@class='p-datatable-thead']")
	public List<WebElement> tableHeader;
	@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
	WebElement paginationText;
    @FindBy(xpath = "//*[@psortablecolumn]//i")
	private List<WebElement> headerSortIconList;
    @FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	WebElement deleteAll; //delete icon
    @FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	public WebElement totalClass;
    			//*****************AddNewClass*****************
    @FindBy(xpath="//div[@role='dialog']")
    WebElement dailog;
    @FindBy(xpath="//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")
    WebElement dailogCancelBtn;
    @FindBy(xpath="//button[@id='saveClass']")
    WebElement dailogSaveBtn;
    @FindBy(xpath="/html/body/app-root/app-session/p-dialog/div/div/div[1]/div/button")
    WebElement dialogCloseBtn;
    @FindBy(tagName="input")
    public List<WebElement> forminputs;
    @FindBy(xpath = "//*[@type='text']")
    public List<WebElement> formTextInputs;
          //********************EditNewClass*************************
    
    @FindBy(xpath="//body[1]/app-root[1]/app-session[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/div[1]/span[1]/button[1]")
    WebElement editBtn;
    @FindBy(xpath="//p-dropdown[@id='batchName']")
    WebElement batchName;
    @FindBy(xpath="//input[@id='classTopic']")
    WebElement classTopic;
    
          //***************AddNewClassPopup*******************

	
    					//Action Methods
    
            //*************ClassPageValidation*******************
	public void clickClassBtn() 
	{
		classBtn.click();	
	}
	public String getActualTitle() {
		return driver.getTitle();
	}
	public String setManageClassHeader()
	{
		return manageClassHeader.getText();	
	}
	public boolean setSearchbar(){
		return searchBox.isDisplayed();
	}

	// Method that returns the WebElements
	public List<WebElement> tableHeaderElements() {
	    return tableHeader;
	}

	// Method that returns the text of each WebElement
	public List<String> tableHeaderTexts() {
	    return tableHeader.stream()
	                      .map(WebElement::getText)
	                      .collect(Collectors.toList());
	}
	public boolean getPaginationText() {
		
		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(paginationText));
		return subMenuItem.getText() != null;
	}
	
	public boolean isHeaderSortIconListVisible() {
		boolean state = true;
		for(WebElement sortIcon: headerSortIconList ) {
			state = sortIcon.isDisplayed();
			if (!state)
			 {
				break;  
			}
		}
		return state;
	}
	public boolean isDeleteAllBtnEnabled() {

		return deleteAll.isEnabled();
	}

	public String totalNoOfClasses() {
		return totalClass.getText().toString();
	}
	
	 //***********AddNewClass***************
	
	public void clickAddNewClassBtn() {
		addNewClass.click();
	}
	public boolean Dialogbox() {
		return dailog.isDisplayed();
	}
	public boolean cancelBtnDialogbox() {
		return dailogCancelBtn.isDisplayed();
	}
	public boolean saveBtnDialogbox() {
		return dailogSaveBtn.isDisplayed();
	}
	public boolean closeIconDialogbox() {
		return dialogCloseBtn.isDisplayed();
	}
	   //***********EditNewClass*******************
	public void clickEditButton() {
		 wait.until(ExpectedConditions.visibilityOf(editBtn));
		 WebElement editButton = editBtn;
		 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);
//		editBtn.click();
	}
	public boolean classDetailsAppear() {
		return dailog.isDisplayed();
	}
	
	public boolean disableBatchName() {
		wait.until(ExpectedConditions.visibilityOf(batchName));
	//	return !(batchName.isEnabled());
		  return batchName.getAttribute("disabled") != null; 
	}
	public boolean disableClassTopic() {
		wait.until(ExpectedConditions.visibilityOf(classTopic));
		return !(classTopic.isEnabled());
	}
	//constructor
		public ClassModulePage() 
		{ 
			PageFactory.initElements(driver, this);
		}
	
}