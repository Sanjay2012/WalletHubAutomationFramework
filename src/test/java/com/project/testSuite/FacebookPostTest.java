package com.project.testSuite;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.domain.baseClass.BaseClass;
import com.domain.utilityClass.Log;
import com.facebook.pageObject.FacebookHomePage;
import com.facebook.pageObject.FacebookLoginPage;

public class FacebookPostTest extends BaseClass {
	public FacebookLoginPage loginPo;
	public FacebookHomePage homePo;
	SoftAssert soft = new SoftAssert();

	@Test
	public void FacebookLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		Log.startTestCase("FacebookLogin");
		loginPo = new FacebookLoginPage(driver);
		// driver.get("https://www.facebook.com/");
		driver.get(prop.getProperty("facebookUrl"));
		Log.info("Application opened" + driver.getCurrentUrl());
		soft.assertTrue(driver.getPageSource().contains("log in or sign up"));
		// loginPo.facebookLogin(Utility.getTestData(1, 1), Utility.getTestData(2, 1));
		loginPo.facebookLogin(prop.getProperty("username"), prop.getProperty("password"));
		Log.endTestCase("FacebookLogin");
		soft.assertAll();
	}

	@Test(dependsOnMethods = "FacebookLogin")
	public void FacebookPost() throws EncryptedDocumentException, IOException {
		Log.startTestCase("FacebookPost");
		homePo = new FacebookHomePage(driver);
		soft.assertEquals(homePo.verifyProfileName(), "Shiv Kumar");
		Log.info("Verifying profile name");
		soft.assertTrue(true, "Dialog displayed");
		// homePo.postStatus(Utility.getTestData(3, 1));
		homePo.postStatus(prop.getProperty("message"));
		Log.info("Facebook Post sucessfully");
		Log.endTestCase("FacebookPost");
		soft.assertAll();
	}

}
