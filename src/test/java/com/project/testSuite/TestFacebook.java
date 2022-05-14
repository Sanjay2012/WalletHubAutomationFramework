package com.project.testSuite;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestFacebook {
	String userName = "madeeasyctc@gmail.com";
	String password = "Shiv@123";
	WebDriver driver;

	@Test
	public void FacebookPost() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "//drivers/chromedriver.exe");
		Reporter.log("=====Chrome Browser Session Started=====", true);
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		Reporter.log("=====Application Started=====", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// facebook login page

		WebElement emailTxt = driver.findElement(By.id("email"));
		emailTxt.clear();
		emailTxt.sendKeys(userName);

		WebElement passwordTxt = driver.findElement(By.id("pass"));
		passwordTxt.clear();
		passwordTxt.sendKeys(password);

		driver.findElement(By.xpath("//*[text()='Log In' and @name='login']")).click();

		// Home page

		driver.findElement(By.xpath("//a[@href=\"/me/\"]")).click();

		driver.findElement(By.xpath("//*[@class=\"m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b\"]")).click();

		driver.findElement(By.xpath("//*[@class=\"_1mf _1mj\"]")).sendKeys("Hello World !!");

		driver.findElement(
				By.xpath("//*[@class=\"k4urcfbm discj3wi dati1w0a hv4rvrfc i1fnvgqd j83agx80 rq0escxv bp9cbjyn\"]"))
				.click();
		
		// tear down
		driver.quit();
	}

}
