package com.lazerycode.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.page_objects.WeightWatchersPage;

public class WeightWatchersIT extends DriverBase {

	private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString) {
		return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
	}

	@Test
	public void WeightWatchersTest() throws Exception {
		// Create a new WebDriver instance
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		WebDriver driver = getDriver();

		//******* Step 1 ********************************
		// And now use this to visit weightwatchers
		driver.get("https://www.weightwatchers.com/us/");

		WeightWatchersPage weightWatchersHomePage = new WeightWatchersPage();

		//******* Step 2 ********************************
		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());
		weightWatchersHomePage.cancelPopup();
		

		//******* Step 3 ********************************
		weightWatchersHomePage.clickOnFindAMeeting();
		
		// Find A Meeting search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, 10, 100);
		wait.until(pageTitleStartsWith("Find A Meeting"));

		//******* Step 4 ********************************
		// Should see: "Find A Meeting: Get Schedules & Times Near You | Weight Watchers"
		System.out.println("Page title is: " + driver.getTitle());
		
		//******* Step 5 ********************************
		weightWatchersHomePage.enterZipCode("10011").submitSearch();
		
		//******* Step 6 ********************************
		String locationName=weightWatchersHomePage.printFirstResultLocationName();
		String locationDistance=weightWatchersHomePage.printFirstResultLocationDistance();
		
		//******* Step 7 ********************************
		weightWatchersHomePage.clickOnFirstResultLocationName().verifyFirstResultLocationName(locationName);
		
		//******* Step 8 ********************************
		weightWatchersHomePage.printTodaysHoursOfOperation();

		
		
		

	}

}