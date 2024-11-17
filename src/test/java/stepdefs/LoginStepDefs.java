package stepdefs;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
	WebDriver driver = Hooks.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Hooks.test.log(LogStatus.PASS, "Application launch successful");
	}

	@Given("I click on the Login link")
	public void i_click_on_the_login_link() {
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
	//	Hooks.test.log(LogStatus.PASS, "clicked on the login link");
	    
	}

	@When("I enter the user name")
	public void i_enter_the_user_name() {
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");

	}

	@When("I enter the password")
	public void i_enter_the_password() {
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abc@1234");

	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();

	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expMsg) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Error = driver.findElement(By.className("error_msg"));
		String actMsg = Error.getText();
		Assert.assertEquals(expMsg, actMsg);

	}
	
	@When("I enter the user name as {string}")
	public void i_enter_the_user_name_as(String UserNameVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys(UserNameVal);
	//	Hooks.test.log(LogStatus.PASS, "User name entered is successful");
	}

	@When("I enter the password as {string}")
	public void i_enter_the_password_as(String PasswordVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PasswordVal);
	}
	
	@Then("I see the below login options present on the screen")
	public void i_see_the_below_login_options_present_on_the_screen(List<String> lginOptions) {
	    for(String option: lginOptions) {
	    	Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+option+"']")).isDisplayed());
	    }
	}


}
