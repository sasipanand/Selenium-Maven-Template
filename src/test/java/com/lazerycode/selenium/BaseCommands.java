package com.lazerycode.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lazerycode.selenium.util.Query;

public class BaseCommands {

	public static String verifyElementTitle(Query locator, String expectedTitle) {
	    String expectedTxt = expectedTitle;
	    String actualTxt = locator.findWebElement().getText();
	    if (actualTxt.equals(expectedTxt)) {
	        System.out.println("Title name present");
	    } else {
	    	System.out.println("Title mismach or not present");
	    }
	    return "";
	}
	
	
	public static void waitForElementPresent(WebElement element, WebDriver driver ) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
