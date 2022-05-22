package com.facebook.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.domain.utilityClass.BaseTestClass;
import com.domain.utilityClass.Log;

public class FacebookHomePage extends BaseTestClass {
	// declaration
	@FindBy(xpath = "//div[@class=\"rq0escxv l9j0dhe7 du4w35lb j83agx80 cbu4d94t qowsmv63 dp1hu0rb\"]//div[@class=\"ow4ym5g4 auili1gw rq0escxv j83agx80 buofh1pr g5gj957u i1fnvgqd oygrvhab cxmmr5t8 hcukyx3x kvgmc6g5 hpfvmrgz qt6c0cv9 jb3vyjys l9j0dhe7 du4w35lb bp9cbjyn btwxx1t3 dflh9lhu scb9dxdr nnctdnn4\"]//span[@class=\"a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7\"]")
	private WebElement profile;

	@FindBy(xpath = "//*[@class=\"m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b\"]")
	private WebElement statusTxt;

	@FindBy(xpath = "//*[@class=\"_1mf _1mj\"]")
	private WebElement statusBox;

	@FindBy(xpath = "//*[@class=\"k4urcfbm discj3wi dati1w0a hv4rvrfc i1fnvgqd j83agx80 rq0escxv bp9cbjyn\"]")
	private WebElement postButton;

	@FindBy(xpath = "//span[contains(text(), 'Create post')]")
	private WebElement createPostTitle;

	@FindBy(xpath = "//div[@class=\"l9j0dhe7 du4w35lb cjfnh4rs j83agx80 cbu4d94t lzcic4wl ni8dbmo4 stjgntxs oqq733wu cwj9ozl2 io0zqebd m5lcvass fbipl8qg nwvqtn77 nwpbqux9 iy3k6uwz e9a99x49 g8p4j16d bv25afu3 d2edcug0\"]")
	private WebElement postDialog;

	
	public FacebookHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/*
	 * Method to verify profile Name
	 */
	public String verifyProfileName() {
		waitForElementToBeVisible(driver, profile, 10);
		return profile.getText();

	}

	/*
	 * Method to verify the element is present or not on webpage
	 */

	public boolean elementDisplayed() {
		waitForElementToBeVisible(driver, postDialog, 10);
		return postDialog.isDisplayed();
	}

	/*
	 * Method to Post message after land on profile page
	 */

	public void postStatus(String message) {
		waitForElementToBeVisible(driver, profile, 10);
		clickElement(profile);
		Log.info("Click on element" + profile);
		clickElement(statusTxt);
		Log.info("Click on element" + statusTxt);
		enterText(statusBox, message);
		Log.info("Entering text into text box" + statusBox);
		clickElement(postButton);
		Log.info("Click on element" + postButton);

	}


}
