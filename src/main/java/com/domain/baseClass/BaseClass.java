package com.domain.baseClass;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.domain.utilityClass.Log;
import com.domain.utilityClass.Utility;

public class BaseClass {
	public WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	@Parameters("browser")
	@BeforeClass
	public void setupApplication(String browser) throws InterruptedException {

		BasicConfigurator.configure();
		// configure log4j xml file
		DOMConfigurator.configure("./src/main/resources/log4j2.xml");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			//options.addArguments("--headless");
			//options.addArguments("--disable-gpu");
			//options.addArguments("--no-sandbox");
			driver = new ChromeDriver(options);
			Log.info("Chrome Browser Session Started");
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers/geckodriver.exe");
			FirefoxOptions options=new FirefoxOptions();
			options.setAcceptInsecureCerts(false);
			//options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			Log.info("Firefox Browser Session Started");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
		Log.info("Browser Session terminated");
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			Utility.captureScreenshot(driver, testResult.getName());
			Log.info("The screenshot of failed test  " + testResult.getName() + " captured");

		}

	}

	public static String getDateTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
}
