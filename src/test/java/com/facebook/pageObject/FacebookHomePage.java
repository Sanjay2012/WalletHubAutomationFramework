package com.facebook.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.domain.testClass.TestClass;

public class FacebookHomePage extends TestClass {

	WebDriver driver;

	// declaration
	@FindBy(xpath = "//a[@href=\"/me/\"]")
	private WebElement profile;

	@FindBy(xpath = "//*[@class=\"m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b\"]")
	private WebElement statusTxt;

	@FindBy(xpath = "//*[@class=\"_1mf _1mj\"]")
	private WebElement statusBox;

	@FindBy(xpath = "//*[@class=\"k4urcfbm discj3wi dati1w0a hv4rvrfc i1fnvgqd j83agx80 rq0escxv bp9cbjyn\"]")
	private WebElement postButton;

	public FacebookHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void postStatus(String message) {
		clickElement(profile);
		clickElement(statusTxt);
		enterText(statusBox, message);
		clickElement(postButton);

	}
}
