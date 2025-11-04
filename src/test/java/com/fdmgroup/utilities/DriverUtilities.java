package com.fdmgroup.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtilities {
	private static DriverUtilities driverUtilities;
	private WebDriver driver;
	private Properties config;

	private DriverUtilities() {
		config = new Properties();

		try {
			config.load(new FileInputStream("src/test/resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static DriverUtilities getInstance() {
		if (driverUtilities == null)
			driverUtilities = new DriverUtilities();
		return driverUtilities;
	}

	public WebDriver getDriver() {
		if (driver == null)
			createDriver();
		return driver;
	}

	private void createDriver() {
		String driverName = getDriverName();

		switch (driverName) {
		case "Chrome":
			this.driver = new ChromeDriver(addChromeOptions());
			break;
		case "Firefox":
			this.driver = new FirefoxDriver();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + driverName);
		}
	}

	private String getDriverName() {
		return config.getProperty("browser");
	}

	private ChromeOptions addChromeOptions() {
		ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false);
	    
	    options.setExperimentalOption("prefs", prefs);
		return options;

	}
}
