package com.fdmgroup.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LocationPage extends BasePage {
	public LocationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "tetris-search_form-address-837")
	WebElement searchBox;

	@FindBy(id = "tetris-search_form-submit-220")
	WebElement searchButton;

	public void enterLocation(String text) {
		waitForVisibilityOf(searchBox);
		waitForClickableOf(searchBox).sendKeys(text);
	}

	public void clickSearchButton() {
		waitForClickableOf(searchButton).click();
		
	}
	
	//Below is a dummy file. Didn't get time
	public boolean verifySearchResults(String text) {
		return driver.getTitle().contains(text);
		
	}
}
