package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeMenuTest_StepDef {
	@Given("the user has launched the application")
	public void the_user_has_launched_the_application() {
		Hooks.driver.navigate().to(DataFile.homePageURL);
		Hooks.homePage.handleCookies();
	}

	@Then("the user should be able to see the page title {string}")
	public void the_user_should_see_the_page_title(String pageTitle) {
		assertEquals(Hooks.driver.getTitle(), pageTitle);
	}
	
	@Given("the user can view the {string} menu")
	public void the_user_can_view_the_menu(String string) {
		assertEquals(string, Hooks.homePage.getMenuByText(string).getText());
	}
	
	@When("the user hovers over the {string} menu")
	public void the_user_hovers_over_the_menu(String menuString) {
		Hooks.homePage.hoverOverMenu(menuString);
	}
	

	@Then("the user should see the dropdown for {string}")
	public void the_user_should_see_the_dropdown(String menuString){
		assertTrue(Hooks.homePage.verifyHover(menuString));
	}
	

	@When("the user clicks on {string} option")
	public void the_user_clicks_on_option(String itemString) {
	    Hooks.homePage.selectMenuOption(itemString);
	}
}
