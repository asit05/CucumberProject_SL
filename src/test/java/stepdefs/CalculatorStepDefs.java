package stepdefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorStepDefs {

	int num1;
	int num2;
	int actualResult;
	List<Integer> numbers;
	Map<String, Integer> cart;
	DataTable dataTable;

	@Given("I have two numbers {int} and {int}")
	public void i_have_two_numbers_and(int int1, int int2) {
		num1 = int1;
		num2 = int2;
	}

	@When("I add those two numbers")
	public void i_add_those_two_numbers() {
		actualResult = num1 + num2;
	}

	@Then("I should get the result as {int}")
	public void i_should_get_the_result_as(int expectedResult) {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(expectedResult, actualResult);
	}

	@When("I subtract two numbers")
	public void i_subtract_two_numbers() {
		actualResult = num1 - num2;
	}

	@When("I multiply two numbers")
	public void i_multiply_two_numbers() {
		// Write code here that turns the phrase above into concrete actions
		actualResult = num1 * num2;
	}

	@Given("I have below numbers")
	public void i_have_below_numbers(List<Integer> list1) {
		this.numbers = list1;
	}

	@When("i add the numbers")
	public void i_add_the_numbers() {
		for (int num : numbers) {
			actualResult = actualResult + num;
		}
	}

	@Given("Below items are added to the cart")
	public void below_items_are_added_to_the_cart(Map<String, Integer> map1) {
		this.cart = map1;
	}

	@When("I do the checkout")
	public void i_do_the_checkout() {
		for (String item : cart.keySet()) {
			actualResult = actualResult + cart.get(item);
		}
	}

	@Then("The bill amount is displayed as {int}")
	public void the_bill_amount_is_displayed_as(int expectedResult) {
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Given("Below items are added to the cart with given quantity")
	public void below_items_are_added_to_the_cart_with_given_quantity(io.cucumber.datatable.DataTable dataTable) {

		this.dataTable = dataTable;

	}

	@When("I do the checkout with given quantity")
	public void i_do_the_checkout_with_given_quantity() {
		int numberOfRows = dataTable.height();
		System.out.println("Number of rows = " + numberOfRows);
		for (int i = 0; i < numberOfRows; i++) {
				String item = dataTable.cell(i, 0);
				int qnt = Integer.parseInt(dataTable.cell(i, 1));
				int amount = Integer.parseInt(dataTable.cell(i, 2));

				actualResult = actualResult + (qnt * amount);
		}
	}
}
