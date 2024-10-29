package pageObjects;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.math3.linear.EigenDecomposition;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.WebdriverManager;

public class EditProgramPage {
	WebDriver driver;
	ProgramModule programModule = new ProgramModule();
	CreateProgramPage createProgramPage = new CreateProgramPage();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/span[1]/button[1]")
	private WebElement editBtn;

	public EditProgramPage() {
		driver = WebdriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	public ProgramModule getProgramModuleObj() {
		return this.programModule;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public CreateProgramPage getCreateProgramObj() {
		return this.createProgramPage;
	}

	public void getProgramNameField() {
		// createProgramPage.txtProgramName("sd");
	}

	public void getRandomEditButton() {
		int number = new Random().nextInt(5);
		// System.out.println("random number = " + number);
		// clicking one random edit button from editButton list
		WebElement editBtn = programModule.getEditbuttonList().get(number);
		System.out.println("clicking the edit btn..");
		try {
			editBtn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", editBtn);
		}

	}
}
