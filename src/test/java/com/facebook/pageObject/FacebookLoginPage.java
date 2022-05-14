package com.facebook.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.domain.testClass.TestClass;

public class FacebookLoginPage extends TestClass{

	WebDriver driver;

	// webElement declaration

	@FindBy(id = "email")
	private WebElement emailField;
	@FindBy(id = "pass")
	private WebElement passwordField;
	@FindBy(xpath="//*[text()='Log In' and @name='login']")
	private WebElement loginButton;
	
	
	public FacebookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	/*Method to login facebook- Login page
	 * */
	public void facebookLogin(String emailAddress, String password) {	
		clearText(emailField);   
		enterText(emailField, emailAddress);
		clearText(passwordField);
		enterText(passwordField, password);
		clickElement(loginButton);
	}
	
}
