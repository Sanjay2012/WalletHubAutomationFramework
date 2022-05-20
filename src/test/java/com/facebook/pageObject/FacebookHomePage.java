package com.facebook.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.domain.testClass.TestClass;
import com.domain.utilityClass.Log;

public class FacebookHomePage extends TestClass {
	// declaration
	@FindBy(xpath = "//a[@class='oajrlxb2 qu0x051f esr5mh6w e9989ue4 r7d6kgcz rq0escxv nhd2j8a9 p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x jb3vyjys qt6c0cv9 i1ao9s8h esuyzwwr f1sip0of abiwlrkh p8dawk7l lzcic4wl bp9cbjyn e72ty7fz qlfml3jp inkptoze qmr60zad j83agx80 btwxx1t3 tv7at329 taijpn5t d1544ag0 tw6a2znq l9j0dhe7 k4urcfbm g5ia77u1']")
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
		return profile.findElement(By.xpath("//span[@class=\"a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5\"]")).getText();
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
