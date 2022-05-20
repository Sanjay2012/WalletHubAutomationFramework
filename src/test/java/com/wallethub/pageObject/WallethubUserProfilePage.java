package com.wallethub.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.domain.testClass.TestClass;

public class WallethubUserProfilePage extends TestClass {
	// webElement declaration

	@FindBy(xpath = "//*[@class=\"profile-name\"]")
	private WebElement profileName;
	
	@FindBy(xpath = "//*[@class=\"pr-rec-subtitle\"]")
	private WebElement recommendText;


	public WallethubUserProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/*Method to get element text*/
	public String getElementText() {
		waitForElementToBeVisible(driver, profileName, 10);
		return profileName.getText();
        
    }
	
	public String recommendText() {
		waitForElementToBeVisible(driver, recommendText, 10);
		return recommendText.getText();
		
	}
}
