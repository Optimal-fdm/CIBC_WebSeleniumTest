package com.fdmgroup.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
    }

    protected WebElement waitForVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    protected List<WebElement> waitForVisibilityOfAll(List<WebElement> elements) {
        return wait.until(ExpectedConditions.refreshed(
        		ExpectedConditions.visibilityOfAllElements(elements)
        		));
    }

    
    protected WebElement waitForClickableOf(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}

