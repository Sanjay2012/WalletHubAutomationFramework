package com.project.testSuite;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.domain.baseClass.BaseClass;
import com.domain.utilityClass.Log;
import com.domain.utilityClass.Utility;
import com.wallethub.pageObject.WalletTestInsurancePage;
import com.wallethub.pageObject.WallethubConfirmReviewPage;
import com.wallethub.pageObject.WallethubLoginPage;
import com.wallethub.pageObject.WallethubReviewPage;
import com.wallethub.pageObject.WallethubUserProfilePage;

public class WalletHubTest extends BaseClass {

	public WallethubLoginPage loginPo;
	public WalletTestInsurancePage insurancePo;
	public WallethubReviewPage reviewPo;
	public WallethubConfirmReviewPage confirmReviewPo;
	public WallethubUserProfilePage userPagePo;
	
	SoftAssert soft=new SoftAssert();

	@Test
	public void walletHubLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		Log.startTestCase("walletHubLogin");
		loginPo = new WallethubLoginPage(driver);
		driver.get("https://wallethub.com/join/login");
		Log.info("Application opened" + driver.getCurrentUrl());
		/* login */
		soft.assertTrue(driver.getPageSource().contains("WalletHub Login"));
		Log.info("Verifying the page title is " + driver.getTitle());
		loginPo.wallethubLogin(Utility.getTestData(1, 4), Utility.getTestData(2, 4));
		Log.info("WalletHub login sucessful");
		Log.endTestCase("walletHubLogin");

	}


	@Test(dependsOnMethods = "walletHubLogin")
	public void verifyReviewAndClickOnStars() throws InterruptedException {
		Log.startTestCase("verifyReviewAndClickOnStars");
		driver.get("https://wallethub.com/profile/13732055i");
		Log.info("Application opened" + driver.getCurrentUrl());

		// hover over reviews stars
		insurancePo = new WalletTestInsurancePage(driver);
		soft.assertTrue(driver.getPageSource().contains("test insurance company metatitle test"));
		Log.info("Verifying the page title is " + driver.getTitle());
		insurancePo.checkReviewPostedOrNot("@madeeasyctc");
		Log.info("Check already review posted or not");
		insurancePo.hoverStarAndClick("4");
		Log.info("Hover over review stars and click on 4th star");
		Log.endTestCase("verifyReviewAndClickOnStars");

	}

	@Test(dependsOnMethods = "verifyReviewAndClickOnStars")
	public void reviewWriting() {
		reviewPo = new WallethubReviewPage(driver);
		Log.startTestCase("reviewWriting");
		soft.assertTrue(driver.getPageSource().contains("Test Insurance Company"));
		Log.info("Verifying the page contents");
		reviewPo.selectValueFromDropDown("Health Insurance");
		Log.info("Select value from dropdown");
		reviewPo.writeRiview();
		Log.info("Writing review");
		Log.endTestCase("reviewWriting");
	}

	@Test(dependsOnMethods = "reviewWriting")
	public void confirmReview() {
		Log.startTestCase("confirmReview");
		confirmReviewPo = new WallethubConfirmReviewPage(driver);
		soft.assertTrue(driver.getPageSource().contains("Your review has been posted."));
		Log.info("Verifying the page contents");
		confirmReviewPo.confirmPost();
		Log.info("Confirming the review");
		Log.endTestCase("confirmReview");
	}

	@Test(dependsOnMethods = "confirmReview")
	public void verifyReviewPosted() {
		Log.startTestCase("verifyReviewPosted");
		insurancePo = new WalletTestInsurancePage(driver);
		soft.assertTrue(driver.getPageSource().contains("@madeeasyctc"));
		Log.info("Verified the user posted review present in page");
		insurancePo.clickMenuOption("Profile");
		Log.info("Click on Profile option and page navigate to user profile");
		Log.endTestCase("verifyReviewPosted");
		
	}
	
	@Test(dependsOnMethods = "verifyReviewPosted")
	public void validateUserProfilePage() {
		Log.startTestCase("validateUserProfilePage");
		userPagePo = new WallethubUserProfilePage(driver);
		String userName = userPagePo.getUserName();
		soft.assertEquals(userName,"Sanjay Waware");
		Log.info("Verified user name on profile page");
		String recommendTxt=userPagePo.recommendText();
		soft.assertEquals(recommendTxt,"Sanjay Waware's Recommendations");
		Log.info("Verified review posted shows under profile");
		Log.endTestCase("validateUserProfilePage");
	}
	
	
}
