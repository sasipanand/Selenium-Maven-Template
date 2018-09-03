package com.lazerycode.selenium.page_objects;

import com.lazerycode.selenium.BaseCommands;
import com.lazerycode.selenium.DriverBase;
import com.lazerycode.selenium.util.Query;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WeightWatchersPage extends BaseCommands {

    private final RemoteWebDriver driver = DriverBase.getDriver();

    private Query findAMeeting = new Query(By.id("ela-menu-visitor-desktop-supplementa_find-a-meeting"), driver);
    private Query meetingSearch = new Query(By.id("meetingSearch"), driver);	
    private Query searchButton = new Query(By.xpath("//button[@type='button']"), driver);
    private Query locationName = new Query(By.cssSelector("div.location__name > span"), driver);
    private Query locationDistance = new Query(By.cssSelector("div.location__distance"), driver);
    private Query firstSearchLocationTitle = new Query(By.cssSelector("location-address[location='vm.location']>div>div>div>div>span"),driver);
    private Query todaysHoursOfOperations = new Query(By.cssSelector("div.hours-list-item-wrapper.hours-list--currentday > div.hours-list-item-hours > div"),driver);
    //private Query modelpopupcancel = new Query(By.id("mf-lsw-modal"),driver);
   private Query modelpopupcancel = new Query(By.cssSelector("#mf-lsw-modal > div.modal-vert-center-wrapper > div.modal-dialog > div.modal-content > div.modal-header > button.close"),driver);
                                                          
	public void cancelPopup() {
		waitForElementPresent(modelpopupcancel.findWebElement(), driver);
		if (modelpopupcancel.findWebElement().isDisplayed()) {
			modelpopupcancel.findWebElement().click();
		}
	}
    public WeightWatchersPage() throws Exception {
    	//waitForElementPresent(findAMeeting.findWebElement(), driver);
    }

    public WeightWatchersPage clickOnFindAMeeting() {
    	//waitForElementPresent(findAMeeting.findWebElement(), driver);
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	findAMeeting.findWebElement().click();
        return this;
    }
    
    public WeightWatchersPage enterZipCode(String zipcode) {
    	waitForElementPresent(meetingSearch.findWebElement(), driver);
    	meetingSearch.findWebElement().sendKeys(zipcode);
        return this;
    }

    public WeightWatchersPage submitSearch() {
    	waitForElementPresent(searchButton.findWebElement(), driver);
    	searchButton.findWebElement().click();
        return this;
    }
    
    public WeightWatchersPage clickOnFirstResultLocationName() {
    	waitForElementPresent(locationName.findWebElement(), driver);
    	locationName.findWebElement().click();
        return this;
    }
    
    public String printFirstResultLocationName() {
    	waitForElementPresent(locationName.findWebElement(), driver);
    	String data=locationName.findWebElement().getText();
    	System.out.println(data);
        return data;
    }
    
    public String printFirstResultLocationDistance() {
    	String data=locationDistance.findWebElement().getText();
    	System.out.println(data);
        return data;
    }
    
    public void verifyFirstResultLocationName(String locationName) {
    	String ActualData= firstSearchLocationTitle.findWebElement().getText();
    	if(! (ActualData.equalsIgnoreCase(locationName))) {
    		System.out.println("[Verification Failure]- Actual <"+ ActualData+ "> doesn't match expected Vaule "+ locationName );
    	}
    	System.out.println("[Verification Success] - LocationName title matches");
    	
    }
    
    public void printTodaysHoursOfOperation() {
    	 List<WebElement> elements = todaysHoursOfOperations.findWebElements(); 
    			
    	Iterator<WebElement> it = elements.iterator();
    	while(it.hasNext()) {
    		WebElement element = (WebElement) it.next();
    		System.out.println(element.getText());
    	}
    	
    	
    }

}