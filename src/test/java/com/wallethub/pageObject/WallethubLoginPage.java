package com.wallethub.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.domain.testClass.TestClass;

public class WallethubLoginPage extends TestClass {
	WebDriver driver;

	// webElement declaration

	@FindBy(xpath = "//a[@class=\"login\"]")
	private WebElement loginLink;
	
	@FindBy(id="email")
	private WebElement emailField;
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(xpath="//button[ @class='btn blue center reg-tabs-bt touch-element-cl']")
	private WebElement loginButton;
	
	@FindBy(xpath="//button[@class=\"btn blue touch-element-cl\"]")
	private WebElement cntButton;
	
	
	public WallethubLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	/*Method to login wallethub- Login page
	 * */
	public void wallethubLogin(String emailAddress, String password) {
		clearText(emailField);   
		enterText(emailField, emailAddress);
		clearText(passwordField);
		enterText(passwordField, password);
		clickElement(loginButton);
		clickElement(cntButton);
	}
	
}
