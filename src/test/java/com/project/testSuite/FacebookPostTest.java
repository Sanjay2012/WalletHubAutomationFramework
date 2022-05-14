package com.project.testSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.domain.baseClass.BaseClass;
import com.domain.utilityClass.Utility;
import com.facebook.pageObject.FacebookHomePage;
import com.facebook.pageObject.FacebookLoginPage;

public class FacebookPostTest extends BaseClass {
	public FacebookLoginPage loginPo;
	public FacebookHomePage homePo;

	@Test
	public void FacebookPost() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://www.facebook.com/");
		Reporter.log("=====Application Started=====", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		loginPo = new FacebookLoginPage(driver);
		loginPo.facebookLogin(Utility.getTestData(1, 1), Utility.getTestData(2, 1));
		
		homePo = new FacebookHomePage(driver);
		homePo.postStatus(Utility.getTestData(3, 1));
	}
}
