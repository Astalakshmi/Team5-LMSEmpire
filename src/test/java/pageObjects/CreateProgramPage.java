package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverManager.WebdriverManager;

public class CreateProgramPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	ProgramModule programModule = new ProgramModule();
	public CreateProgramPage() {
		driver = WebdriverManager.getDriver();
 		PageFactory.initElements( driver, this);
	}
	
	public ProgramModule getProgramModuleObj(){
		return this.programModule;
	}
	 
	@FindBy(xpath = "//span[contains(text(),'Program Details')]")
	private WebElement programDetails;
	@FindBy(xpath = "//label[@for='programName']//span[contains(text(),'*')]")
	private WebElement mandatorySignForName;
	
	@FindBy(xpath = "//input[@id='programName']")
	private WebElement txtName;
	@FindBy(xpath = "//input[@id='programDescription']")
	private WebElement txtDescription;
	
	@FindBy(xpath = "//small[normalize-space()='Program name is required.']")
	private WebElement lblNameFieldRqed;
	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//span[text()='Cancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Active']")
	private WebElement activeBtn;
	@FindBy(xpath = "//p-radiobutton[@ng-reflect-input-id='Inactive']")
	private WebElement inActiveBtn;
	
	@FindBy(xpath = "//p-toastitem/div/div/div/div[1]")
	private WebElement successMessage;
	
	
 
	
	public boolean isProgramDetailsVisible() {
		return programDetails.isDisplayed();	
	}
	
	public String getWindowtitle() {
		return programDetails.getText();
	}
	public boolean isMandatorySignForNameVisible() {
		return mandatorySignForName.isDisplayed();
	}
	public void txtProgramName(String name) {
		txtName.clear();
		txtName.sendKeys(name);
	}
	public String readNameEntered() {
		return txtName.getAttribute("value");
	}
	public void txtDescription(String description) {
		txtDescription.clear();
		txtDescription.sendKeys(description);
	}
	public String readDescriptionEntered() {
		return txtDescription.getAttribute("value");
	}
	public boolean isLblNameFieldRqedVisible() {
		return lblNameFieldRqed.isDisplayed();
	}
	public void saveButtonClick() {
		saveBtn.click();
	}
	public WebElement saveBtn() {
		return saveBtn;
	}
	public void cancelButtonClick() {
		cancelBtn.click();
	}
	public WebElement cancelBtn() {
		return cancelBtn;
	}
	public void activeButtonClick() {
		
		activeBtn.click();
	}
	public boolean isActiveBtnClicked() {
		
		
		return activeBtn.isSelected();
	}
	public void inActiveButtonClick()  {
		
		System.out.println("clicking..");
		inActiveBtn.click();
		//Thread.sleep(3000);
		if(inActiveBtn.isEnabled())
		System.out.println("clicked");
	}
	public boolean isInActiveBtnClicked() {
		return inActiveBtn.isEnabled();	
	}
	
	public boolean isSuccessMessageVisible() {
		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(successMessage));
		//subMenuItem.click();
		// subMenuItem.click();
		return subMenuItem.isDisplayed();
	}
	public String programCreatedMessage() {
		return successMessage.getText();
		
	}
}
