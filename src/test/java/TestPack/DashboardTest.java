package TestPack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;

import BasePack.BaseClass;
import PomPack.DashboardPOM;
import PomPack.LoginPOM;
import PomPack.MenuBarPOM;
import PomPack.TimeSheetPOM;
import UtilityPack.UtilityClass;
import junit.framework.Assert;

public class DashboardTest extends BaseClass {

	LoginPOM login;
	DashboardPOM dashboard;
	TimeSheetPOM timesheet;
	MenuBarPOM menubar;
	
	@BeforeClass
	public void beforeClass() {
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		timesheet = new TimeSheetPOM(driver);
		menubar = new MenuBarPOM(driver);
		
		String loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(loginUrl, driver.getCurrentUrl());
		System.out.println("Correct Url");
	}
	
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException {
		login.enterUsername(UtilityClass.getExcelData(0, 0));
		login.enterPassword(UtilityClass.getExcelData(0, 1));
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
	public void TestB()  {
		System.out.println("TestB");
		System.out.println("Verify Assign Leave Quick Launch navigation");
		dashboard.clickOnAssignLeave();
		Assert.assertTrue(dashboard.isAssignLeaveDisplayed());
		System.out.println("Navigated to Assign Leave Successfully!");
	}
	
	@Test
	public void TestC() throws InterruptedException {
		System.out.println("TestC");
		System.out.println("Verify Leave List Quick Launch navigation");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnLeaveList();
		Assert.assertTrue(dashboard.isLeaveListDisplayed());
		System.out.println("Navigated to Leave List Successfully!");
	}
	
	@Test
	public void TestD() throws InterruptedException {
		System.out.println("TestD");
		System.out.println("Verify Timesheets Quick Launch navigation");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnTimesheets();
		Assert.assertTrue(timesheet.isTimeHeaderDisplayed());
		System.out.println("TimeSheet Header is Displayed Successfully!");
	}
	
	@AfterMethod
	public void logout() {
		dashboard.clickOnUserProfile();
		dashboard.clickOnLogout();
		System.out.println("Logout Successfully!");
	}
	
//	@AfterClass
//	public void AfterClass() {
//		driver.close();
//	}
}
