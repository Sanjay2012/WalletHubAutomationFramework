package com.wallethub.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.domain.utilityClass.BaseTestClass;

public class WallethubUserProfilePage extends BaseTestClass {
	// webElement declaration

	@FindBy(xpath = "//*[@class=\"profile-name\"]")
	private WebElement profileName;

	@FindBy(xpath = "//*[@class=\"pr-rec-title\"]")
	private WebElement recommendTxt;

	public WallethubUserProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	/* Method to get element text */
	public String getUserName() {
		waitForElementToBeVisible(driver, profileName, 20);
		return profileName.getText();

	}

	public String recommendText() {
		waitForElementToBeVisible(driver, recommendTxt, 20);
		return recommendTxt.getText();

	}
}
