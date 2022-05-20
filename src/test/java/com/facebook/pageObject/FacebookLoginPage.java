package com.facebook.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.domain.testClass.TestClass;
import com.domain.utilityClass.Log;

public class FacebookLoginPage extends TestClass{
	// webElement declaration

	@FindBy(id = "email")
	private WebElement emailField;
	@FindBy(id = "pass")
	private WebElement passwordField;
	@FindBy(xpath="//*[text()='Log In' and @name='login']")
	private WebElement loginButton;
	
	
	public FacebookLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/*Method to login facebook- Login page
	 * */
	public void facebookLogin(String emailAddress, String password) {
		clearText(emailField); 
		Log.info("Clearing the text box"+ emailField);
		enterText(emailField, emailAddress);
		Log.info("Entering text into text box"+ emailField);
		clearText(passwordField);
		Log.info("Clearing the text box"+ passwordField);
		enterText(passwordField, password);
		Log.info("Entering text into text box"+ passwordField);
		clickElement(loginButton);
		Log.info("Click on element"+ loginButton);
	}
	
}
