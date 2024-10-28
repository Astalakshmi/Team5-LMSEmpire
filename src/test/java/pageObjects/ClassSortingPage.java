package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.WebdriverManager;

public class ClassSortingPage {
	
	
	WebDriver driver;
    WebDriverWait wait;
	
	
  public ClassSortingPage() {
 		
 		driver = WebdriverManager.getDriver();		
 		PageFactory.initElements( driver, this);
 	}
  
  
@FindBy(xpath=("//thead/tr/th[2]//i"))  
WebElement BatchNameSortBtn;

//or  //table[@role='grid']/thead/tr/th[2]//i\" or  
//thead/tr/th[2]//i


  

//  @FindBy(xpath=("//thead/tr/th[2]"))
//  WebElement BatchNameSorting; 
  
  //private By BatchNameSorting=By.xpath("//tr/th[2]");   //In gherkin they mension batch name
  
//  @FindBy(xpath=("//thead/tr/td[2]"))
//  WebElement ListOfBatchNames; 
  
  //--------------------pagination---------------
  
   
  
  public void BatchNameSorting() {
 
	  List<WebElement> colname = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[2]")); //read all 5 elements in column batch name
			  //("//thead/tr/th[2]"));  ////table[@role='grid']/tbody/tr/td[2]
	  
	  String[] beforeSort_Name = new String[colname.size()];
	  
	  //get text to the array
	  for(int i=0;i<colname.size();i++) {
		  
		  beforeSort_Name[i]  =colname.get(i).getText().trim();
		  
		  System.out.print(beforeSort_Name[i]);
	  }
	  
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
			  wait.until(ExpectedConditions.invisibilityOf(BatchNameSortBtn));
			  BatchNameSortBtn.click();
		  
	  List<WebElement> colname2 = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr/td[2]"));
	  String[] afterSort_Name = new String[colname2.size()];
       for(int i=0;i<colname2.size();i++) {
		  
		  beforeSort_Name[i]  =colname2.get(i).getText().trim();
		  
		  System.out.print(afterSort_Name[i]);
	  }
	  
	  
	  
	  
	  
  }  
	  
//	// click on column perticular column 
//	  
//	   ((WebElement) BatchNameSorting).click();
//	  
//	  //Capture all webelements into list
// 	 List<WebElement> elementsList=driver.findElements(By.xpath("//tr/td[2]")); 	
// 	 
// 	 //capture text of all webelements into new(original) list
// 	List<String> originalList= elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
// 	 
// 	//sort on the original list of above step which will be sorted list
// 	List<String> SortedList= originalList.stream().sorted().collect(Collectors.toList());
// 	 
// 	Assert.assertTrue(originalList.equals(SortedList));
// }


	  
	  
	  
 
  
  

}
