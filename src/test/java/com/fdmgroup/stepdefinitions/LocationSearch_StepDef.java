package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationSearch_StepDef {
	
	@Given("the user should be able to see location icon on the homepage")
	public void the_user_should_be_able_to_see_location_icon_on_the_homepage() {
		Hooks.homePage.isLocatorIconVisible();
	}

	@When("the user clicks on the location icon")
	public void the_user_clicks_on_the_location_icon() {
		Hooks.homePage.clickLocatorIcon();
	}

	@When("the user enters {string} in the location search box")
	public void the_user_enters_in_the_location_search_box(String string) {
		Hooks.locationPage.enterLocation(string);
	}

	@When("the user clicks the Search button")
	public void the_user_clicks_the_search_button() {
		Hooks.locationPage.clickSearchButton();
	}

	@Then("A list of nearby branches or ATMs should be displayed for city name {string}")
	public void a_list_of_nearby_branches_or_at_ms_should_be_displayed(String text) {
		assertTrue(Hooks.locationPage.verifySearchResults(text));
	}
}
