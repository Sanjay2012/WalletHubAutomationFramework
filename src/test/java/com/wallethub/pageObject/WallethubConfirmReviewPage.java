package com.wallethub.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.domain.utilityClass.BaseTestClass;
import com.domain.utilityClass.Log;

public class WallethubConfirmReviewPage extends BaseTestClass {
	WebDriver driver;
	// webElement declaration

	@FindBy(xpath = "//*[text()='Your review has been posted.']")
	private WebElement postMessage;

	@FindBy(xpath = "//div[@class=\"btn rvc-continue-btn\" and text()='Continue']")
	private WebElement continueBtn;

	public WallethubConfirmReviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/* Method to validate post success message */

	public String postSuccessText() {
		waitForElementToBeVisible(driver, postMessage, 10);
		return postMessage.getText();

	}

	/* Method to post the review */

	public void confirmPost() {
		waitForElementToBeVisible(driver, continueBtn, 10);
		clickElement(continueBtn);
		Log.info("click on " + continueBtn);
	}

}
