package com.fdmgroup.stepdefinitions;


import static org.junit.Assert.assertTrue;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MortageCalculatorTest_StepDef {
	
	@Given("the user navigated to the mortage payment  calculator.")
	public void the_user_navigated_to_the_mortage_payment_calculator() {
	    Hooks.driver.navigate().to(DataFile.mortageCalculatorPageURL);
	}

	@When("the user scrolls to and clicks the buy a home button")
	public void the_user_scrolls_to_and_clicks_the_button() {
	    Hooks.mortgageCalculatorPage.clickBuyHomeButton();
	}

	@When("the user clicks on the Skip to calculator link")
	public void the_user_clicks_on_the_link() throws InterruptedException {
		Thread.sleep(1000);
		Hooks.mortgageCalculatorPage.clickSkipCalculatorLink();
	}

	@Then("the user should be able to see the Mortgage Payment Calculator form")
	public void the_user_should_see_the_mortgage_payment_calculator_form() {
	    assertTrue(Hooks.mortgageCalculatorPage.checkMortageCalculatorFormisDisplayed());
	}

	@When("the user enters a purchase price of {int}")
	public void the_user_enters_a_purchase_price_of(int price) {
	    Hooks.mortgageCalculatorPage.enterPurchasePrice(price);
	}

	@When("the user enters a down payment of {int}")
	public void the_user_enters_a_down_payment_of(int price) {
	   Hooks.mortgageCalculatorPage.enterDownPayment(price);
	}

	@When("the user enters an interest rate of {double}")
	public void the_user_enters_an_interest_rate_of(double rate) {
		Hooks.mortgageCalculatorPage.enterInterestRate(rate);
	}

	@When("the user selects {string} as the term")
	public void the_user_selects_as_the_term(String text) {
	    Hooks.mortgageCalculatorPage.selectMortgageaTerm(text);
	}

	@When("the user selects {string} as the payment frequency")
	public void the_user_selects_as_the_payment_frequency(String text) {
		Hooks.mortgageCalculatorPage.selectPaymentFrequency(text);
	}

	@When("the user clicks the Calculate button")
	public void the_user_clicks_the_button() {
	    Hooks.mortgageCalculatorPage.clickCalculate();
	}

	@Then("the user should be able to scroll down and see the results section")
	public void the_user_should_be_able_to_scroll_down_and_see_the_results_section() throws InterruptedException {
	    assertTrue(Hooks.mortgageCalculatorPage.checkgraphResultVisibility());
	    Thread.sleep(1000);
	}


}
