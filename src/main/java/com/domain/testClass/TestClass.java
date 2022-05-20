package com.domain.testClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions builder;

	// Constructor
	public TestClass(WebDriver driver) {
		this.driver = driver;
		this.builder = new Actions(driver);
		this.js = (JavascriptExecutor) this.driver;
		wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Method to clear textbox
	 * 
	 * @param element - provide locator value of element.
	 */
	public void clearText(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
		}

	}

	/**
	 * Method to enter text into text box
	 * 
	 * @param element - provide locator value of element.
	 * @param text    - provide the text which want to be entered.
	 */

	public void enterText(WebElement element, String text) {
		try {
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("Exception occured while entering text");
		}

	}

	/**
	 * Method to click on element
	 * 
	 * @param element - provide locator value of element.
	 */
	public void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Exception occured while performing click operation");
		}

	}

	/**
	 * Method to to check element displayed or not by using function that take
	 * argument of By class
	 * 
	 * @param driver Method return True/False If element present return==> True If
	 *               element not present ===> return False
	 */
	public boolean isElementDisplayed(WebElement element, By by) {
		try {
			driver.findElement(by);

		} catch (Exception e) {
		}
		return element.isDisplayed();
	}

	/**
	 * Method to Finding elements by using function that take argument of By class
	 * 
	 * @param driver Method return True/False If present return==> True If element
	 *               not present ===> return False
	 */

	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Wait for the element to be visible ignoring the
	 * StaleElementReferenceException
	 * 
	 * @param driver
	 * @param locator  - provide locator value of element till it is visible on
	 *                 application and then click that element.
	 * @param waitTime - provide maximum wait time in seconds for driver
	 */
	public boolean waitForElementToBeVisible(WebDriver driver, WebElement element, int waitTime) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated((By) element));
			flag = true;
			return flag;
		} catch (Exception e) {
			return flag;
		}
	}

	/**
	 * Wait for the element to be clickable ignoring the
	 * StaleElementReferenceException
	 * 
	 * @param driver
	 * @param element  - provide locator value of element till it is visible on
	 *                 application and then click that element.
	 * @param waitTime - provide maximum wait time in seconds for driver
	 */
	public boolean waitForElementToBeClickableBool(WebDriver driver, WebElement element, int waitTime) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));
			flag = true;
			return flag;

		} catch (Exception Ex) {
			return flag;
		}
	}

	/**
	 * Method to select option from dropdown without select class
	 * 
	 * @param driver
	 * @param element       - provide locator value of element.
	 * @param valueToSelect - provide the option value to be selected
	 */

	public void selectOptionFromDropdown(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("li"));
		for (WebElement option : allOptions) {
			// System.out.println("Option value "+option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	/**
	 * Method to select single selectable checkbox option
	 * 
	 * @param driver
	 * @param element       - provide locator value of element.
	 * @param valueToSelect - provide the option value to be selected
	 */

	public void selectOptionFromCheckbox(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			// System.out.println("Option value "+option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	/**
	 * Wait for the Alert present ignoring the StaleElementReferenceException
	 * 
	 * @param driver
	 * @param waitTime - provide maximum wait time in seconds for driver
	 */

	public boolean waitForAlertPresent(WebDriver driver, int waitTime) {
		boolean flag = false;
		new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.alertIsPresent());
		try {
			driver.switchTo().alert();
			return flag = true;
		} catch (Exception Ex) {
			return flag;
		}
	}

	/**
	 * This method is used to Move to Element using Actions class
	 * 
	 * @param driver
	 * @param element    - provide locator value of element till it is visible on
	 *                   application and then click that element.
	 * @param maxTimeout - provide maximum wait time in seconds for driver
	 */

	public void mouseActionMoveToElement(WebDriver driver, WebElement element, int maxTimeout) {
		try {
			if
//The below method is defined above
			(waitForElementToBeClickableBool(driver, element, maxTimeout)) {
				builder.moveToElement(element).perform();

			} else {
				System.out.println("Not able to locate the element !");
			}
		} catch (Exception e) {
			System.out.println("Exception occured");
		}

	}

	/**
	 * This method is used to Move to Element and perform Click Action.
	 * 
	 * @param driver
	 * @param element    - provide locator value of element till it is visible on
	 *                   application and then click that element.
	 * @param maxTimeout - provide maximum wait time in seconds for driver
	 */

	public void mouseClickActionMoveToElement(WebDriver driver, WebElement element, int maxTimeout) {
		try {
			if
//The below method is defined above
			(waitForElementToBeClickableBool(driver, element, maxTimeout)) {
				builder.moveToElement(element).click().build().perform();

			} else {

				System.out.println("Not able to locate the element !");
			}
		} catch (Exception e) {
			System.out.println("Exception occured");
		}

	}

	/**
	 * This method is for simple dropdown selection by visibleText using select
	 * class
	 * 
	 * @param driver
	 * @param element-provide    locator value of dropdown element
	 * @param dropDownValue-This is the text to search in dropdown
	 */
	public static void dropDownSelectionByText(WebDriver driver, WebElement element, String dropDownValue) {
		try {
			new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));
			Select select = new Select(element);
			select.selectByVisibleText(dropDownValue);
		} catch (StaleElementReferenceException ex) {
			System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
		}
	}

	/**
	 * This method is for simple dropdown selection by value using select class
	 * 
	 * @param driver
	 * @param element-provide    locator value of dropdown element
	 * @param dropDownValue-This is the text to search in dropdown
	 */
	public static void dropDownSelectionByValue(WebDriver driver, WebElement element, String dropDownValue) {
		try {
			new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));
			Select select = new Select(element);
			select.selectByValue(dropDownValue);
		} catch (StaleElementReferenceException ex) {
			System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
		}
	}

	/**
	 * This method is for simple dropdown selection by index using select class
	 * 
	 * @param driver
	 * @param element-provide    locator value of dropdown element
	 * @param dropDownValue-This is the text to search in dropdown
	 */
	public static void dropDownSelectionByIndex(WebDriver driver, WebElement element, int dropDownValue) {
		try {
			new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));
			Select select = new Select(element);
			select.selectByIndex(dropDownValue);
		} catch (StaleElementReferenceException ex) {
			System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
		}
	}

}
