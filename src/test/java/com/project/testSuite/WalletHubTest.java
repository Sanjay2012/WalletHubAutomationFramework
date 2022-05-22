package com.project.testSuite;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.domain.baseClass.BaseClass;
import com.domain.utilityClass.Log;
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

	SoftAssert soft = new SoftAssert();

	@Test
	public void walletHubLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		Log.startTestCase("walletHubLogin");
		loginPo = new WallethubLoginPage(driver);
		driver.get(prop.getProperty("walletHubUrl"));
		Log.info("Application opened "+ driver.getCurrentUrl());
		/* login */
		soft.assertEquals(driver.getCurrentUrl(), prop.getProperty("walletHubUrl"));
		Log.info("Verifying the current url");
		soft.assertTrue(driver.getPageSource().contains("WalletHub Login"));
		Log.info("Verifying the page title is " + driver.getTitle());
		loginPo.wallethubLogin(prop.getProperty("username1"), prop.getProperty("password1"));
		Log.info("WalletHub login sucessful");
		Log.endTestCase("walletHubLogin");
		soft.assertAll();

	}

	@Test(dependsOnMethods = "walletHubLogin")
	public void verifyReviewAndClickOnStars() throws InterruptedException {
		Log.startTestCase("verifyReviewAndClickOnStars");
		driver.get("https://wallethub.com/profile/13732055i");
		Log.info("Application opened " + driver.getCurrentUrl());
		// hover over reviews stars
		insurancePo = new WalletTestInsurancePage(driver);
		soft.assertTrue(driver.getPageSource().contains(prop.getProperty("insurancePageTitle")));
		Log.info("Verifying the page title is " + driver.getTitle());
		insurancePo.checkReviewPostedOrNot("@madeeasyctc");
		Log.info("Check already review posted or not");
		insurancePo.hoverStarAndClick("4");
		Log.info("Hover over review stars and click on 4th star");
		Log.endTestCase("verifyReviewAndClickOnStars");
		soft.assertAll();

	}

	@Test(dependsOnMethods = "verifyReviewAndClickOnStars")
	public void reviewWriting() {
		reviewPo = new WallethubReviewPage(driver);
		Log.startTestCase("reviewWriting");
		soft.assertTrue(driver.getPageSource().contains(prop.getProperty("reviewPageHeading")));
		Log.info("Verifying the page contents");
		reviewPo.selectValueFromDropDown("Health Insurance");
		Log.info("Select value from dropdown");
		reviewPo.writeRiview();
		Log.info("Writing review");
		Log.endTestCase("reviewWriting");
		soft.assertAll();
	}

	@Test(dependsOnMethods = "reviewWriting")
	public void confirmReview() {
		Log.startTestCase("confirmReview");
		confirmReviewPo = new WallethubConfirmReviewPage(driver);
		soft.assertEquals(confirmReviewPo.postSuccessText(), prop.getProperty("reviewConfirmationText"));
		Log.info("Verifying the page contents");
		confirmReviewPo.confirmPost();
		Log.info("Confirming the review");
		Log.endTestCase("confirmReview");
		soft.assertAll();
	}

	@Test(dependsOnMethods = "confirmReview")
	public void verifyReviewPosted() {
		Log.startTestCase("verifyReviewPosted");
		insurancePo = new WalletTestInsurancePage(driver);
		soft.assertTrue(driver.getPageSource().contains(prop.getProperty("reviewEmail")));
		Log.info("Verified the user posted review present in page");
		insurancePo.clickMenuOption("Profile");
		Log.info("Click on Profile option and page navigate to user profile");
		Log.endTestCase("verifyReviewPosted");
		soft.assertAll();

	}

	@Test(dependsOnMethods = "verifyReviewPosted")
	public void validateUserProfilePage() {
		Log.startTestCase("validateUserProfilePage");
		userPagePo = new WallethubUserProfilePage(driver);
		String userName = userPagePo.getUserName();
		soft.assertEquals(userName, prop.getProperty("userName"));
		Log.info("Verified user name on profile page");
		String recommendTxt = userPagePo.recommendText();
		soft.assertEquals(recommendTxt, prop.getProperty("recommendationText"));
		Log.info("Verified review posted shows under profile");
		Log.endTestCase("validateUserProfilePage");
		soft.assertAll();
	}

}
