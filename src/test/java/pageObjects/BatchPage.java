package pageObjects;

import java.time.Duration;

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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mongodb.assertions.Assertions;

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
	
	
	
	public void BatchClickMd() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(batchClick).click();
						}
	
	public void ManageBatchVerify() {
		driver.findElement(manageBatch);
	
	
}

}
	
	
	
	
	
	