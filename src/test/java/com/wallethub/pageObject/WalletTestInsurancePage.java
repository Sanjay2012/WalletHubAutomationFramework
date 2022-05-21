package com.wallethub.pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.domain.testClass.TestClass;
import com.domain.utilityClass.Log;

public class WalletTestInsurancePage extends TestClass {
	
	// webElement declaration
	@FindBy(xpath="//h1[@class=\"profile-name\"]")
	private WebElement profileName;
	
	@FindBy(xpath ="//div[@class=\"rv review-action ng-enter-element\"]//div[@class=\"rating-box-wrapper\"]")
	private WebElement ratingBox;

	@FindBy(xpath = "//div[@class=\"rv review-action ng-enter-element\"]//div[@class=\"rating-box-wrapper\"]//*[@class=\"rvs-star-svg\"]")
	private List<WebElement> stars;

	@FindBy(xpath = "(//ul[@role='listbox' and @class='dropdown-list ng-enter-element'])[4]//li")
	private List<WebElement> listOptions;

	@FindBy(xpath = "//button[text()='edit']")
	private WebElement editBtn;

	@FindBy(xpath = "//textarea[@placeholder=\"Write your review\"]")
	private WebElement reviewTextArea;

	@FindBy(xpath = "//*[@class=\"nav-link semi-bold-font-weight active\"]")
	private WebElement qna;

	@FindBy(xpath = "//button[@class=\"btn blue fixed-w-c with-loader\"]")
	private WebElement submitBtn;

	@FindBy(xpath = "//*[@class=\"burger-menu-right-menu\"]//div[@class=\"brgm-button brgm-user brgm-list-box\"]//span[@class=\"brgm-list-title\"]")
	private WebElement profileMenu;

	@FindBy(xpath = "//div[@class=\"brgm-list brgm-user-list ng-enter-element\"]//a")
	private List<WebElement> menuOptions;

	public WalletTestInsurancePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	/*
	 * Method to check review posted or not. If review exist then remove it before
	 * post new one
	 */

	public void checkReviewPostedOrNot(String email) throws InterruptedException {
		Log.info("Checking post is present in page ?");
		if (driver.getPageSource().contains(email)) {
			clickElement(editBtn);
			clearText(reviewTextArea);
			enterText(reviewTextArea,
					"                                                                                                                                                                                      ");
			Thread.sleep(2000);
			clickElement(submitBtn);
			Thread.sleep(5000);
			driver.navigate().refresh();
		}

	}
	

	/* method, to scroll down page and Hover over review stars */

	public void hoverStarAndClick(String valueToSelect) {
		// scroll down page
		js.executeScript("arguments[0].scrollIntoView();", ratingBox);

		// loop through each stars and hover over it
		for (WebElement ele : stars) {
			builder.moveToElement(ele).perform();
			if (ele.getAttribute("aria-label").contains(valueToSelect)) {
				ele.click();
			}

		}
		Log.info("Hover over review star and click on  " + valueToSelect + "  star done successfully");

	}

	/* Method to click on profile menu */
	public void clickMenuOption(String optionToSelect) {
		// scroll up page
		builder.sendKeys(Keys.PAGE_UP).build().perform();
		mouseActionMoveToElement(driver, profileMenu, 10);
		for (WebElement ele : menuOptions) {
			if(optionToSelect.equals(ele.getText())) {
				ele.click();
				break;
			}
			
		}
		
	}

}
