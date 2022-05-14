package com.domain.testClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {
	WebDriver driver;
	
	/*Method to clear textbox*/
	public void clearText(WebElement element) {  
		try {
			element.clear();
		} catch (Exception e) {
		}
        
 } 
	
	/*Enter text into text box*/
	public void enterText(WebElement element,String text) {  
		try {
			element.sendKeys(text);
		} catch (Exception e) {
			System.out.println("Exception occured wile entering text");
		}
        
 } 

	/*Method to click on element*/
	public void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Exception occured while performing click operation");
		}
        
 }
	
	/*Method to get element text*/
	public String getElementText(WebElement element) {
		return element.getText();
        
    }
	
	/*Method to to check element displayed or not*/
	 public boolean isElementDisplayed(WebElement element, By by) {
		 try {
			 driver.findElement(by);
			
		} catch (Exception e) {
		}
         return element.isDisplayed();
     }
	
	/* Finding elements by using function that take argument of By class */

	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/*Method to select option from dropdown without select class*/
	
	public void selectOptionFromDropdown(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("li"));
		for (WebElement option : allOptions) {
			   System.out.println("Option value "+option.getText());
			        if (valueToSelect.equals(option.getText())) {
			            option.click();
			            break;
			        }
			    }
	}
	
	
	/*Method to select single selectable checkbox option*/
	
	public void selectOptionFromCheckbox(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			   System.out.println("Option value "+option.getText());
			        if (valueToSelect.equals(option.getText())) {
			            option.click();
			            break;
			        }
			    }
	}
	
	
	

	/*
	 * Wait for the element to be clickable ignoring the
	 * StaleElementReferenceException
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

	/* Wait for the Alert present ignoring the StaleElementReferenceException */

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

	/*
	 * Wait for the element to be visible ignoring the
	 * StaleElementReferenceException
	 */
	/**
	 * This method is used to wait for element till visibility of element.
	 * 
	 * @param driver
	 * @param attributeValue - provide locator value of element till it is visible
	 *                       on application and then click that element.
	 * @param waitTime       - provide maximum wait time in seconds for driver
	 */
	public boolean waitForElementToBeVisible(WebDriver driver, By attributeValue, int waitTime) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(attributeValue));
			flag = true;
			return flag;
		} catch (Exception Ex) {
			return flag;
		}
	}
	

	/* Move to Element and Click Action in Selenium */
	/**
	 * This method is used to Move to Element and perform Click Action.
	 * 
	 * @param driver
	 * @param attributeValue - provide locator value of element till it is visible
	 *                       on application and then click that element.
	 * @param maxTimeout     - provide maximum wait time in seconds for driver
	 */

	public void mouseClickActionMoveToElement(WebDriver driver, WebElement element, int maxTimeout) {
		try {
			if
//The below method is defined above
			(waitForElementToBeClickableBool(driver, element, maxTimeout)) {
				//WebElement element = driver.findElement(attributeValue);
				// element.click();
				Actions builder = new Actions(driver);
				builder.moveToElement(element).click().build().perform();
				System.out.println("Able to locate and click to element !");

			} else {
				System.out.println("Not able to locate the element !");
			}
		} catch (Exception Ex) {
			System.out.println("Exception occured");
		}
		
	}
	
	
	/*Select a value in dropdown by Text*/
	/**
	 * This method is for simple dropdown selection by visibleText
	 * 
	 * @param driver
	 * @param dropDownID-This
	 *            is the unique attribute to find an dropdownelement
	 * @param dropDownValue-This
	 *            is the text to search in dropdown
	 */
	public static void dropDownSelectionByText(WebDriver driver, By dropDownID, String dropDownValue) {
		try {
			WebElement element = null;
			new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(dropDownID));
			element = driver.findElement(dropDownID);
			Select dropDown = new Select(element);
			dropDown.selectByVisibleText(dropDownValue);
		}
		catch (StaleElementReferenceException ex) {
			System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
		}
	}
	
	
	
	/*Select a value in dropdown by Value*/
	
	/**
	 * This method is for simple dropdown selection by value
	 * 
	 * @param driver
	 * @param dropDownID-This
	 *            is the unique attribute to find an dropdownelement
	 * @param dropDownValue-This
	 *            is the text to search in dropdown
	 */
	public static void dropDownSelectionByValue(WebDriver driver, By dropDownID, String dropDownValue) {
		try {
			WebElement element = null;
			new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(dropDownID));
			element = driver.findElement(dropDownID);
			Select dropDown = new Select(element);
			dropDown.selectByValue(dropDownValue);
		}
		catch (StaleElementReferenceException ex) {
			System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
		}
	}
	
	
	/*Select a value in dropdown by Index*/
	
	/**
	 * This method is for simple dropdown selection by index
	 * 
	 * @param driver
	 * @param dropDownID-This
	 *            is the unique attribute to find an dropdownelement
	 * @param dropDownValue-This
	 *            is the text to search in dropdown
	 */
	public static void dropDownSelectionByIndex(WebDriver driver, By dropDownID, int dropDownValue) {
		try {
			WebElement element = null;
			new WebDriverWait(driver, 5).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(dropDownID));
			element = driver.findElement(dropDownID);
			Select dropDown = new Select(element);
			dropDown.selectByIndex(dropDownValue);
		}
		catch (StaleElementReferenceException ex) {
			System.out.println("Exception while selecting a value from dropdown" + ex.getMessage());
		}
	}
	

}
