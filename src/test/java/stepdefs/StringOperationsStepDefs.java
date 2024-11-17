package stepdefs;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StringOperationsStepDefs {
	
	String name1;
	String name2;
	
	String actualResult;

	@Given("The first string is {string}")
	public void the_first_string_is(String str1) {
	   this.name1 = str1;
	}

	@Given("The second string is {string}")
	public void the_second_string_is(String str2) {
	    this.name2 = str2;
	}

	@When("I compare the strings")
	public void i_compare_the_strings() {
	    if(name1.equals(name2)) {
	    	actualResult = "matching";
	    }
	    else {
	    	actualResult = "mismatching";
		}
	}

	@Then("I should get the result as {string}")
	public void i_should_get_the_result_as(String expectedResult) {
	    Assert.assertEquals(expectedResult, actualResult);
	}


}
