package com.wallethub.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.domain.utilityClass.BaseTestClass;
import com.domain.utilityClass.Log;

public class WallethubLoginPage extends BaseTestClass {
	// webElement declaration

	@FindBy(xpath = "//a[@class=\"login\"]")
	private WebElement loginLink;

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[ @class='btn blue center reg-tabs-bt touch-element-cl']")
	private WebElement loginButton;

	@FindBy(xpath = "//button[@class=\"btn blue touch-element-cl\"]")
	private WebElement cntButton;

	public WallethubLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/*
	 * Method to login wallethub- Login page
	 */
	public void wallethubLogin(String emailAddress, String password) {
		clearText(emailField);
		Log.info("Clearing the text box" + emailField);
		enterText(emailField, emailAddress);
		Log.info("Entering text into text box" + emailField);
		clearText(passwordField);
		Log.info("Clearing the text box" + passwordField);
		enterText(passwordField, password);
		Log.info("Entering text into text box" + passwordField);
		clickElement(loginButton);
		Log.info("Click on element" + loginButton);
		clickElement(cntButton);
		Log.info("Click on element" + cntButton);
	}

}
