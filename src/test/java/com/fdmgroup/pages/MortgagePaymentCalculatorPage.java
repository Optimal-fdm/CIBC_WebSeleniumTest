package com.fdmgroup.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MortgagePaymentCalculatorPage extends BasePage {

	public MortgagePaymentCalculatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@id='noFirst']")
	WebElement buyHomeButton;
	
	@FindBy(id ="skipToExpert")
	WebElement skipCalculatorLink;
	
	@FindBy(id ="form-expert")
	WebElement mortageCalculatorForm;
	
	@FindBy(id ="mortgageAmount-full-input")
	WebElement purchasePrice;
	
	@FindBy(id ="downPayment-full-input")
	WebElement downPayment;
	
	@FindBy(id ="interestRate-full-input")
	WebElement interestRate;
	
	@FindBy(id ="termAndType-full")
	WebElement mortgageTermDropdown;
	
	@FindBy(id ="paymentFrequency-full")
	WebElement paymentFrequencyDropdown;
	
	@FindBy(xpath = "//*[@id=\"calcBut\"]//input")
	WebElement calculateButton;
	
	@FindBy(id ="graphResults")
	WebElement graphResults;
	
	public void clickBuyHomeButton() {
		actions.moveToElement(buyHomeButton).perform();
		waitForVisibilityOf(buyHomeButton);
		waitForClickableOf(buyHomeButton).click();
	}
	
	public void clickSkipCalculatorLink() {		
		actions.moveToElement(skipCalculatorLink).perform();
		waitForVisibilityOf(skipCalculatorLink);
		waitForClickableOf(skipCalculatorLink).click();
	}
	
	public boolean checkMortageCalculatorFormisDisplayed() {
		return waitForVisibilityOf(mortageCalculatorForm).isDisplayed();
	}
	
	public void enterPurchasePrice(int price) {
		enterValue(purchasePrice, String.valueOf(price));
	}
	
	public void enterDownPayment(int price) {
		enterValue(downPayment, String.valueOf(price));
	}
	
	public void enterInterestRate(double rate) {
		enterValue(interestRate, String.valueOf(rate));
	}
	
	public void selectMortgageaTerm(String text) {
		waitForClickableOf(mortgageTermDropdown);
		Select termSelect = new Select(mortgageTermDropdown);
		termSelect.selectByContainsVisibleText(text);
	}
	
	public void selectPaymentFrequency(String text) {
		waitForClickableOf(paymentFrequencyDropdown);
		Select paymenSelect = new Select(paymentFrequencyDropdown);
		paymenSelect.selectByContainsVisibleText(text);
	}
	
	public void clickCalculate() {
		actions.moveToElement(calculateButton).perform();
		waitForClickableOf(calculateButton);
		calculateButton.submit();
	}
	
	public boolean checkgraphResultVisibility() {
		return waitForVisibilityOf(graphResults).isDisplayed();
	}
	
	private void enterValue(WebElement element, String value) {

	    actions.moveToElement(element).perform();

	    waitForVisibilityOf(element);
	    waitForClickableOf(element);

	    try {
	        element.click();
	        element.clear();
	        element.sendKeys(value);
	    } catch (ElementNotInteractableException e) {
	    }
	}
}
