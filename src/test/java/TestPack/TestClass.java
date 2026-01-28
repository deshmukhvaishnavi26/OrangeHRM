package TestPack;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;

import BasePack.BaseClass;
import PomPack.DashboardPOM;
import PomPack.LoginPOM;
import UtilityPack.Util;
import junit.framework.Assert;

public class TestClass extends BaseClass {

	LoginPOM login;
	DashboardPOM dashboard;
	
	@BeforeClass
	public void BeforeClass() {
		
		// all POM class initialization
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		
		String loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(loginUrl, driver.getCurrentUrl());
		System.out.println("Correct URL");
	}
	
	
	@Test
	public void TestA() throws EncryptedDocumentException, IOException {
		System.out.println("Test A");
		System.out.println("Verify Login with Valid Username and Password");
		login.enterUsername(Util.getExcelData(0,0));
		login.enterPassword(Util.getExcelData(0, 1));
		login.clickOnLogin();
		Assert.assertTrue(dashboard.isDashboardDisplayed());
		System.out.println("Test Case 1 Successfully Executed!");
	}
	
	@Test
	public void TestB() {
		System.out.println("Test B");
		System.out.println("Verify Logout Functionality");
		dashboard.clickOnUserProfile();
		dashboard.clickOnLogout();
		Assert.assertTrue(login.isLoginDisplayed());
		System.out.println("Logout Successfully!");
	}
	
	@Test
	public void TestC() throws EncryptedDocumentException, IOException {
		System.out.println("TestC");
		System.out.println("Verify login with invalid username");
		login.enterUsername(Util.getExcelData(1, 0));
		login.enterPassword(Util.getExcelData(1, 1));
		login.clickOnLogin();
		Assert.assertTrue(login.isInvalidCredlsDisplayed());
		System.out.println("Error message Displayed!");
	}
	
	@Test
	public void TestD() throws EncryptedDocumentException, IOException {
		System.out.println("TestD");
		System.out.println("Verify login with invalid password");
		login.enterUsername(Util.getExcelData(2, 0));
		login.enterPassword(Util.getExcelData(2, 1));
		login.clickOnLogin();
		Assert.assertTrue(login.isInvalidCredlsDisplayed());
		System.out.println("Error message Displayed!");
	}
	
//	@AfterClass
//	public void TearDown() {
//		driver.quit();
//	}
}
