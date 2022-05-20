package com.facebook.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.domain.testClass.TestClass;
import com.domain.utilityClass.Log;

public class FacebookHomePage extends TestClass {
	// declaration
	@FindBy(xpath = "//a[@href=\"/me/\" and @role='link']")
	private WebElement profile;

	@FindBy(xpath = "//*[@class=\"m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b\"]")
	private WebElement statusTxt;

	@FindBy(xpath = "//*[@class=\"_1mf _1mj\"]")
	private WebElement statusBox;

	@FindBy(xpath = "//*[@class=\"k4urcfbm discj3wi dati1w0a hv4rvrfc i1fnvgqd j83agx80 rq0escxv bp9cbjyn\"]")
	private WebElement postButton;

	public FacebookHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyProfileName() {
		String profileName = profile.getText();
		return profileName;

	}

	public void postStatus(String message) {
		clickElement(profile);
		Log.info("Click on element"+ profile);
		clickElement(statusTxt);
		Log.info("Click on element"+ statusTxt);
		enterText(statusBox, message);
		Log.info("Entering text into text box"+ statusBox);
		clickElement(postButton);
		Log.info("Click on element"+ postButton);

	}
}
