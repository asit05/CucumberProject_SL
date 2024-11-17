package stepdefs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;
	
	public static ExtentReports report = new ExtentReports("HtmlResults.html", false);
	public static ExtentTest test;
	
	@Before
	public void setupDriver(Scenario scenario) {
		//driver = new ChromeDriver();
		test = report.startTest(scenario.getName());
		driver = new FirefoxDriver();
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
