package com.wallethub.pageObject;

import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.domain.testClass.TestClass;

public class WalletTestInsurancePage extends TestClass {
	WebDriver driver;
	private JavascriptExecutor js;
	private Actions action;

	// webElement declaration
	@FindBy(xpath = "//div[@class=\"rv review-action ng-enter-element\"]//div[@class=\"rating-box-wrapper\"]")
	private WebElement ratingBox;

	@FindBy(xpath = "//div[@class=\"rv review-action ng-enter-element\"]//div[@class=\"rating-box-wrapper\"]//*[@class=\"rvs-star-svg\"]")
	private List<WebElement> stars;
	
	@FindBy(xpath="(//ul[@role='listbox' and @class='dropdown-list ng-enter-element'])[4]//li")
	private List<WebElement> listOptions;
	
	@FindBy(xpath="(//ul[@role='listbox' and @class='dropdown-list ng-enter-element'])[4]")
	private WebElement listOption;
	
	@FindBy(xpath="//div[@class=\"dropdown second\"]")
	private WebElement dropdown;
	
	@FindBy(xpath="//*[@class=\"textarea wrev-user-input validate\"]")
	private WebElement reviewTxtBox;
	
	@FindBy(xpath="//*[@class=\"textarea wrev-user-input validate\"]")
	private WebElement submit;

	public WalletTestInsurancePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) this.driver;
		this.action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	

	/* method, to scroll down page and Hover over review stars */

	public void hoverStarAndClick(String valueToSelect) throws InterruptedException {
		// scroll down page
		js.executeScript("arguments[0].scrollIntoView();", ratingBox);

		// loop through each stars and hover over it
		for (WebElement ele : stars) {
			action.moveToElement(ele).perform();
			Thread.sleep(500);
			if (ele.getAttribute("aria-label").contains(valueToSelect)) {
				ele.click();
			}
		}
		Reporter.log("Hover over the review stars and click operation done.", true);
	}
	
	
	/* method, to select option from dropdown */
	
	public void selectValueFromDropDown(String value) {
		mouseClickActionMoveToElement(driver, dropdown, 10);		
		selectOptionFromDropdown(listOption, value);
	}
	
	/*Method, to generate random string of desired length*/
	public String generateRandomText() {
		String generatedString = RandomStringUtils.randomAlphabetic(200);
		return generatedString;
		
	}
	
	/*Method to write review in review box and submit*/
	public void writeRiview() {
		enterText(reviewTxtBox, generateRandomText());
		Assert.assertEquals(driver.getPageSource().contains("200"), true);
		clickElement(submit);
	}

}
