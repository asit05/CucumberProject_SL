package stepdefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		monochrome = true, 
		plugin={"pretty","html:target/html-cucumber","json:target/cucumber.json"},
		features = "src/test/java/features", 
		glue = "stepdefs", 
	//	tags = {"@U_1000" }//- to run single tag
		// tags = {"not @Ignore"} - to ignore a particular tag
		// tags = {"@Calculator"} //- to run the entire feature use feature level tag
		// tags = {"@Simplilearn and not @Ignore"} - will run entire feature file except ignored one
		 tags = {"@Regression"} //- Scenario can have multiple tags
		// @U_1000 and @Regression - this will run scenarios where both the tags are present 
		// @Calculator or @Simplilearn - this will run  both calculator or Simplilearn


)

public class TestRunner {

}
