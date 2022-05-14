package com.domain.baseClass;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.domain.utilityClass.Utility;

public class BaseClass {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setupApplication(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers/chromedriver.exe");
			Reporter.log("=====Chrome Browser Session Started=====", true);
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers/geckodriver.exe");
			Reporter.log("=====Firefox Browser Session Started=====", true);
			driver = new FirefoxDriver();
		}

	}

	@AfterClass
	public void closeApplication() {
		//driver.quit();
		Reporter.log("=====Browser Session End=====", true);
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			Utility.captureScreenshot(driver, testResult.getName());

		}

	}
}
