package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProgramModule {
	WebDriver driver;
	
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteAll;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement searchBtn;
	

}
