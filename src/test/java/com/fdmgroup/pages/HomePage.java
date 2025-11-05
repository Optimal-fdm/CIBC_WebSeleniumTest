package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	private static boolean flag = true; 

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//button[contains(text(),'Accept all cookies')]")
	WebElement acceptButton;
	
	@FindBy(xpath ="//*[a[@data-di-id ='di-id-3777ac06-696ed554']]")
	WebElement locatorIcon;

	public void handleCookies() {
		if(flag)
		try {
			waitForVisibilityOf(acceptButton);
            acceptButton.click();	
            flag = false;
		} catch (Exception e) {
			System.out.println("No cookie banner appeared.");

		}
	            
	}

	public WebElement getMenuByText(String text) {
		String path = "(//nav[@id='blq-local-nav']//li[@class = 'has-dropdown not-click']/a[contains(normalize-space(text()),'" + text + "')])[1]";
		
		return waitForVisibilityOf(driver.findElement(By.xpath(path)));
	}
	
	public WebElement getMenuItemByText(String text) {
		String path = "(//nav[@id='blq-local-nav']//li[@role= 'menuitem']/a[contains(normalize-space(text()),'" + text + "')])[1]";
		
		return waitForVisibilityOf(driver.findElement(By.xpath(path)));
	}
	
	public WebElement hoverOverMenu( String text) {
		actions.moveToElement(getMenuByText(text)).perform();
		
		return waitForVisibilityOf(driver.findElement(By.xpath("//nav[@id='blq-local-nav']//li[a[contains(text(),'"+ text +"')]]//div[@class = 'dropdown-aem']")));
	}
	
	public boolean verifyHover( String text) {
		
		return waitForVisibilityOf(
				driver.findElement(
						By.xpath(
								"//nav[@id='blq-local-nav']//li[a[contains(text(),'"+ text +"')]]//div[@class = 'dropdown-aem']"
								))).isDisplayed();
	}
	
	public void selectMenuOption(String itemString) {
		getMenuItemByText(itemString).click();
	}
	
	public boolean isLocatorIconVisible() {
		return waitForVisibilityOf(locatorIcon).isDisplayed();
	}
	
	public void clickLocatorIcon() {
		
		String parent = driver.getWindowHandle();
		waitForClickableOf(locatorIcon).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() > 1);

		for (String window : driver.getWindowHandles()) {
			if (!window.equals(parent)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
}
