package TestPack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import BasePack.BaseClass;
import PomPack.DashboardPOM;
import PomPack.LeavePOM;
import PomPack.LoginPOM;
import PomPack.MenuBarPOM;
import PomPack.TimePOM;
import UtilityPack.Util;
import junit.framework.Assert;

public class DashboardTest extends BaseClass {

	LoginPOM login;
	DashboardPOM dashboard;
	TimePOM time;
	MenuBarPOM menubar;
	LeavePOM leave;
	
	SoftAssert soft;
	
	@BeforeClass
	public void beforeClass() {
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		time = new TimePOM(driver);
		menubar = new MenuBarPOM(driver);
		leave = new LeavePOM(driver);
		
		soft = new SoftAssert();
		
		String loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(loginUrl, driver.getCurrentUrl());
		System.out.println("Correct Url");
	}
	
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException {
		login.enterUsername(Util.getExcelData(0, 0));
		login.enterPassword(Util.getExcelData(0, 1));
		login.clickOnLogin();
		System.out.println("Login successfully");
	}
	
	@Test
	public void TestA() {
		System.out.println("TestA");
		System.out.println("Verify Dashboard header text is displayed correctly");
		Assert.assertTrue(dashboard.isDashboardDisplayed());;
		System.out.println("Dashboard is Displayed Successfully!");
	}

	
	@Test
	public void TestB() {
		System.out.println("Test B");
		System.out.println("Verify All Quick Launches");
		dashboard.clickOnAssignLeave();
		soft.assertTrue(leave.isAssignLeaveDisplayed());
		System.out.println("Navigated to Assign Leave Successfully!");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnLeaveList();
		soft.assertTrue(leave.isLeaveListDisplayed());
		System.out.println("Navigated to Leave List Successfully!");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnTimesheets();
		soft.assertTrue(time.isTimeHeaderDisplayed());
		System.out.println("Navigated to Timesheets Successfully!");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnApplyLeave();
		soft.assertTrue(leave.isApplyLeaveDisplayed());
		System.out.println("Navigated to Apply Leave Successfully!");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnMyLeave();
		soft.assertTrue(leave.isMyLeaveDisplayed());
		System.out.println("Navigated to My Leave Successfully!");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnMyTimesheet();
		soft.assertTrue(time.isMyTimesheetDisplayed());
		System.out.println("Navigated to My Timesheet Successfully!");
		soft.assertAll();
	}
	
	@Test
	public void TestC() {
		System.out.println("Test C");
		System.out.println("Verify All Widgets are Displayed");
		soft.assertTrue(dashboard.isTimeAtWorkDisplayed());
		soft.assertTrue(dashboard.isMyActionsDisplayed());
		soft.assertTrue(dashboard.isQuickLaunchDisplayed());
		soft.assertTrue(dashboard.isBuzzPostsDisplayed());
		soft.assertTrue(dashboard.isDistributionByUnitDisplayed());
		soft.assertTrue(dashboard.isDistributionByLocationDisplayed());
		System.out.println("All Widgets displayed Successfully!");
		soft.assertAll();
	}
	
	
	@AfterMethod
	public void logout() {
		menubar.clickOnDashboardMenu();
		dashboard.clickOnUserProfile();
		dashboard.clickOnLogout();
		System.out.println("Logout Successfully!");
	}
	
//	@AfterClass
//	public void AfterClass() {
//		driver.close();
//	}
}
