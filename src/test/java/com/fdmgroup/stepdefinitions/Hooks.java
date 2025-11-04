package com.fdmgroup.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.LocationPage;
import com.fdmgroup.pages.MortgagePaymentCalculatorPage;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hooks {
	static DriverUtilities driverUtilities;
	static WebDriver driver;
	static HomePage homePage;
	static MortgagePaymentCalculatorPage mortgageCalculatorPage;
	static LocationPage locationPage;

	@BeforeAll
	public static void init() {
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		//Page Initialization
		homePage = new HomePage(driver);
		mortgageCalculatorPage = new MortgagePaymentCalculatorPage(driver);
		locationPage = new LocationPage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
	}
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
		// driver.close();
	}
}
