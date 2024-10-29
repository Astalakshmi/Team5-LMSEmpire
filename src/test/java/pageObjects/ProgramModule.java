package pageObjects;





	

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.WebdriverManager;

public class ProgramModule {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteAll;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement searchBtn;
	@FindBy(xpath = "//button[@id='program']")
	private WebElement programBtn;

	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	private WebElement managePgm;
	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	private WebElement lmsHeading;

	@FindBy(xpath = "//div[@class = 'ng-star-inserted']/button")
	private List<WebElement> moduleNames;
	@FindBy(xpath = "//button[@id='logout']")
	private WebElement logoutBtn;
	@FindBy(xpath = "//button[@role='menuitem']")
	private WebElement addNewProgram;

	@FindBy(id = "filterGlobal")
	private WebElement searchBox;

	@FindBy(xpath = "//thead[@class = 'p-datatable-thead']/tr/th")
	private List<WebElement> dataTableHeaders;
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement chkBoxHeader;
	@FindBy(xpath = "//*[@class='p-datatable-tbody']//tr/td[1]//div[@role='checkbox']")
	private List<WebElement> chkBoxList;

	@FindBy(xpath = "//*[@psortablecolumn]//i")
	private List<WebElement> headerSortIconList;

	@FindBy(xpath = "//button[@id = 'editProgram']")
	private List<WebElement> editBtnList;
	@FindBy(xpath = "//button[@id = 'deleteProgram']")
	private List<WebElement> deleteBtnList;

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	private WebElement paginationText;

	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	private WebElement totalProgramText;

	public ProgramModule() {
		driver = WebdriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}

	public void programBtn() {
		programBtn.click();
	}

	public boolean isManagePorgramDisplayed() {
		return managePgm.isDisplayed();
	}

	public String managePorgramText() {
		return managePgm.getText();
	}

	public String lmsHeading() {
		return lmsHeading.getText();

	}

	public String moduleNames() {
		String modules = "";
		for (WebElement moduleName : moduleNames) {
			modules = modules + moduleName.getText() + " ";
		}
		return modules.trim();
	}

	public boolean isLogoutBtnDisplayed() {
		return logoutBtn.isDisplayed();
	}

	public String addNewProgram() {

		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(addNewProgram));
		return subMenuItem.getText();
	}

	public void addNewProgramClick() {

		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(addNewProgram));
		// subMenuItem.click();
		subMenuItem.click();
	}

	public boolean isDeleteAllBtnEnabled() {

		return deleteAll.isEnabled();
	}

	public String searchBoxPlaceHolder() {
		return searchBox.getAttribute("placeholder");
	}

	public String dataTableHeaders() {
		String headers = "";
		for (int i = 1; i < dataTableHeaders.size(); i++) {

			headers = headers + dataTableHeaders.get(i).getText() + ", ";
		}
		return headers.trim().substring(0, headers.length() - 2); // to remove the last 2 character ", "
	}

	public boolean isChkBxHeaderSelected() {
		return chkBoxHeader.isSelected();
	}

	public boolean isChkBoxListSelected() {
		boolean state = false;
		for (WebElement box : chkBoxList) {
			state = box.isSelected();
			if (state) {
				break; // check if any of the check boxes are selected
			}
		}
		return state;
	}

	public List<WebElement> getSortIcons() {
		return headerSortIconList;
	}

	public boolean isHeaderSortIconListVisible() {
		boolean state = true;
		for (WebElement sortIcon : headerSortIconList) {
			state = sortIcon.isDisplayed();
			if (!state) {
				break; // check if any of the sort icon is not displayedS
			}
		}
		return state;
	}

	public boolean isEditAndDeleteListVisible() {
		for (int i = 0; (i < editBtnList.size() && i < deleteBtnList.size()); i++) {
			if (!editBtnList.get(i).isDisplayed() || !deleteBtnList.get(i).isDisplayed()) {
				// returns false if either edit or delete button id not displayed
				return false;
			}
		}
		return true;
	}

	public String getPaginationText() {
		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(paginationText));
		return subMenuItem.getText();
	}

	public String getTotalProgramsText() {
		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(totalProgramText));

		return subMenuItem.getText();
	}

	public int totalNoOfPrograms() {
		String totalProgramsDetails = totalProgramText.getText();
		String[] arr = totalProgramsDetails.split(" ");
		int totalPrograms = Integer.parseInt(arr[4]);
		return totalPrograms;
	}

	public List<WebElement> getEditbuttonList() {
		return editBtnList;
	}


}
