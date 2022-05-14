package com.project.testSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.domain.baseClass.BaseClass;
import com.domain.utilityClass.Utility;
import com.wallethub.pageObject.WalletTestInsurancePage;
import com.wallethub.pageObject.WallethubLoginPage;

public class WalletHubTest extends BaseClass {

	public WallethubLoginPage loginPo;
	public WalletTestInsurancePage insurancePo;

	@Test
	public void walletHubLogin() throws EncryptedDocumentException, IOException, InterruptedException {
		driver.get("https://wallethub.com/join/login");
		Reporter.log("=====Application Started=====", true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		/* login */
		loginPo = new WallethubLoginPage(driver);
		loginPo.wallethubLogin(Utility.getTestData(1, 4), Utility.getTestData(2, 4));

		// open test insurance url
		driver.get("https://wallethub.com/profile/13732055i");

		// hover over reviews stars
		insurancePo = new WalletTestInsurancePage(driver);
		insurancePo.hoverStarAndClick("4");
		insurancePo.selectValueFromDropDown("Health Insurance");
		insurancePo.writeRiview();
		

	}
}
