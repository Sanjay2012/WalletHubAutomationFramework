package com.project.testSuite;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.domain.baseClass.BaseClass;
import com.domain.utilityClass.Log;
import com.domain.utilityClass.Utility;
import com.facebook.pageObject.FacebookHomePage;
import com.facebook.pageObject.FacebookLoginPage;

public class FacebookPostTest extends BaseClass {
	public FacebookLoginPage loginPo;
	public FacebookHomePage homePo;

	@Test
	public void FacebookLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		Log.startTestCase("FacebookLogin");
		loginPo = new FacebookLoginPage(driver);
		driver.get("https://www.facebook.com/");
		Log.info("Application opened" + driver.getCurrentUrl());
		loginPo.facebookLogin(Utility.getTestData(1, 1), Utility.getTestData(2, 1));
		Log.endTestCase("FacebookLogin");
	}

	@Test(dependsOnMethods = "FacebookLogin")
	public void FacebookPost() throws EncryptedDocumentException, IOException {
		Log.startTestCase("FacebookPost");
		homePo = new FacebookHomePage(driver);
		Assert.assertEquals(homePo.verifyProfileName(), "Shiv");
		Log.info("Verifying profile name");
		homePo.postStatus(Utility.getTestData(3, 1));
		Log.info("Facebook Post sucessfully");
		Log.endTestCase("FacebookPost");
	}
}
