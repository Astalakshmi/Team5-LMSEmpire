package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.WebdriverManager;

public class SearchAndSortProgramPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	ProgramModule programModule = new ProgramModule();
	List<WebElement> sortIcons = programModule.getSortIcons();

	@FindBy(xpath = "//*[@class='p-datatable-tbody']//tr/td[2]")
	private List<WebElement> programNameList;
	@FindBy(xpath = "//*[@class='p-datatable-tbody']//tr/td[3]")
	private List<WebElement> programDescriptionList;
	@FindBy(xpath = "//*[@class='p-datatable-tbody']//tr/td[4]")
	private List<WebElement> programStatusList;

	@FindBy(xpath = "//*[@psortablecolumn='programName']")
	private WebElement programNameSortIcon;
	@FindBy(xpath = "//*[@psortablecolumn='programDescription']")
	private WebElement programDescriptionSortIcon;
	@FindBy(xpath = "//*[@psortablecolumn='programStatus']")
	private WebElement programStatusSortIcon;

	public SearchAndSortProgramPage() {
		driver = WebdriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void clickPgmNameToSort() {
		try {
			programNameSortIcon.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", programNameSortIcon);
		}
	}

	public void clickPgmDescriptionToSort() {
		try {
			programNameSortIcon.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", programDescriptionSortIcon);
		}
	}

	public void clickPgmStatusToSort() {
		try {
			programNameSortIcon.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", programStatusSortIcon);
		}
	}

	public boolean isProgramNameSorted() {

		boolean isSorted = false;

		String firstName = programNameList.get(0).getText().trim().toLowerCase();
		String secondName = programNameList.get(1).getText().trim().toLowerCase();
		String thirdName = programNameList.get(2).getText().trim().toLowerCase();

		System.out.println("firstName = " + firstName);
		System.out.println("secondName = " + secondName);
		System.out.println("thirdNameName = " + thirdName);

		if (firstName.compareTo(secondName) < 0) {// list is sorted in ascending order

			if (secondName.compareTo(thirdName) < 0) {
				isSorted = true;
				System.out.println("list is sorted in ascending order");
			}
		} else if (firstName.compareTo(secondName) > 0) {
			// list sorted is in descending order
			System.out.println("list sorted is in descending order");
			if (secondName.compareTo(thirdName) > 0) {
				System.out.println("list sorted is in descending order2");
				isSorted = true;

			}

		}
		return isSorted;

	}

	public boolean isProgramDescriptionSorted() {

		boolean isSorted = false;

		String firstDescription = programDescriptionList.get(0).getText().trim().toLowerCase();
		String secondDescription = programDescriptionList.get(1).getText().trim().toLowerCase();
		String thirdDescription = programDescriptionList.get(2).getText().trim().toLowerCase();

		System.out.println("firstDescription = " + firstDescription);
		System.out.println("secondDescription = " + secondDescription);
		System.out.println("thirdDescription = " + thirdDescription);

		if (firstDescription.compareTo(secondDescription) < 0) {// list is sorted in ascending order

			if (secondDescription.compareTo(thirdDescription) < 0) {
				isSorted = true;
				System.out.println("list is sorted in ascending order");
			}
		} else if (firstDescription.compareTo(secondDescription) > 0) {
			// list sorted is in descending order
			System.out.println("list sorted is in descending order");
			if (secondDescription.compareTo(thirdDescription) > 0) {
				System.out.println("list sorted is in descending order2");
				isSorted = true;

			}

		}
		return isSorted;

	}

	public boolean isProgramStatusSorted() {

		boolean isSorted = false;

		String firstStatus = programStatusList.get(0).getText().trim().toLowerCase();
		String secondStatus = programStatusList.get(1).getText().trim().toLowerCase();
		String thirdStatus = programStatusList.get(2).getText().trim().toLowerCase();

		System.out.println("firstDescription = " + firstStatus);
		System.out.println("secondStatus = " + secondStatus);
		System.out.println("thirdStatus = " + thirdStatus);

		if (firstStatus.compareTo(secondStatus) <= 0) {// list is sorted in ascending order

			if (secondStatus.compareTo(thirdStatus) <= 0) {
				isSorted = true;
				System.out.println("list is sorted in ascending order");
			}
		} else if (firstStatus.compareTo(secondStatus) >= 0) {
			// list sorted is in descending order
			System.out.println("list sorted is in descending order");
			if (secondStatus.compareTo(thirdStatus) >= 0) {
				System.out.println("list sorted is in descending order2");
				isSorted = true;

			}

		}
		return isSorted;

	}

}
