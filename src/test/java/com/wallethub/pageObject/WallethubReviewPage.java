package com.wallethub.pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.domain.testClass.TestClass;
import com.domain.utilityClass.Log;

public class WallethubReviewPage extends TestClass {
	// webElement declaration

	@FindBy(xpath="//span[normalize-space()='Select...']")
	private WebElement dropdown;
	
	@FindBy(xpath="(//ul[@role='listbox' and @class='dropdown-list ng-enter-element'])[4]")
	private WebElement listOption;
	
	@FindBy(xpath="//*[@class=\"textarea wrev-user-input validate\"]")
	private WebElement reviewTxtBox;
	
	@FindBy(xpath="//div[@class=\"sbn-action semi-bold-font btn fixed-w-c tall\"]")
	private WebElement submit;
	
	
	public WallethubReviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	
/* method, to select option from dropdown */
	
	public void selectValueFromDropDown(String value) {
		mouseClickActionMoveToElement(driver, dropdown, 5);	
		Reporter.log("Move to dropdown element"+ dropdown + " and perform click operation", true);
		selectOptionFromDropdown(listOption, value);
		Reporter.log("Choose "+ value + "from dropdown", true);
	}
	
	/*Method, to generate random string of desired length*/
	
	public String generateRandomText() {
		String generatedString = RandomStringUtils.randomAlphanumeric(250, 300);
		Reporter.log("Random string generated", true);
		return generatedString;
		
	}


	/*Method to write review in review box and submit*/
	
	public void writeRiview() {
		enterText(reviewTxtBox, generateRandomText());
		Log.info("Review writing into "+ reviewTxtBox);
		clickElement(submit);
		Log.info("Click on " + submit + "button");
	}



}
