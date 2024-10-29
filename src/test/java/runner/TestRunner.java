package runner;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigFileReader;



@CucumberOptions(
		 features = {"./src/test/resources/features"},
    glue = {"stepdefinitions","hooks"},
    monochrome = true,

 //  tags= "@Login or @ClassPageValidation or @AddNewClass or @EditNewclass or @createProgram or @editProgram or @manageProgram or @sortProgram or @batchPage or @loginModule or @logout", 
    		
   tags="@loginModule",
  //  tags=" @createProgram or @editProgram or @manageProgram or @sortProgram",
    plugin= {"pretty","html:target/cucumber-reports/cucumber.html",
    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
    		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
    		})

 
	
public class TestRunner extends AbstractTestNGCucumberTests{
	
	@BeforeTest
	@Parameters({"browser"})
	public void defineBrowser(String browser) {
		ConfigFileReader.setBrowserType(browser);
	}
	@Override
    @DataProvider(parallel = true)//true means execute parallely 
	
    public Object[][] scenarios() {
				
		return super.scenarios();
    }	
}