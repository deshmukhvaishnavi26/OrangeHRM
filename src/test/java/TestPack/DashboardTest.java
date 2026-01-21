package TestPack;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.*;

import BasePack.BaseClass;
import PomPack.DashboardPOM;
import PomPack.LeavePOM;
import PomPack.LoginPOM;
import PomPack.MenuBarPOM;
import PomPack.TimePOM;
import UtilityPack.UtilityClass;
import junit.framework.Assert;

public class DashboardTest extends BaseClass {

	LoginPOM login;
	DashboardPOM dashboard;
	TimePOM time;
	MenuBarPOM menubar;
	LeavePOM leave;
	
	@BeforeClass
	public void beforeClass() {
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		time = new TimePOM(driver);
		menubar = new MenuBarPOM(driver);
		leave = new LeavePOM(driver);
		
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
		Assert.assertTrue(leave.isAssignLeaveDisplayed());
		System.out.println("Navigated to Assign Leave Successfully!");
	}
	
	@Test
	public void TestC() {
		System.out.println("TestC");
		System.out.println("Verify Leave List Quick Launch navigation");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnLeaveList();
		Assert.assertTrue(leave.isLeaveListDisplayed());
		System.out.println("Navigated to Leave List Successfully!");
	}
	
	@Test
	public void TestD() throws InterruptedException {
		System.out.println("TestD");
		System.out.println("Verify Timesheets Quick Launch navigation");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnTimesheets();
		Assert.assertTrue(time.isTimeHeaderDisplayed());
		System.out.println("Navigated to Timesheets Successfully!");
	}
	
	@Test
	public void TestE(){
		System.out.println("TestE");
		System.out.println("Verify Apply Leave Quick Launch navigation");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnApplyLeave();
		Assert.assertTrue(leave.isApplyLeaveDisplayed());
		System.out.println("Navigated to Apply Leave Successfully!");
	}
	
	@Test
	public void TestF() {
		System.out.println("TestF");
		System.out.println("Verify My Leave Quick Launch navigation");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnMyLeave();
		Assert.assertTrue(leave.isMyLeaveDisplayed());
		System.out.println("Navigated to My Leave Successfully!");
	}
	
	@Test
	public void TestG() {
		System.out.println("TestG");
		System.out.println("Verify My Timesheet Quick Launch navigation");
		menubar.clickOnDashboardMenu();
		dashboard.clickOnMyTimesheet();
		Assert.assertTrue(time.isMyTimesheetDisplayed());
		System.out.println("Navigated to My Leave Successfully!");
	}
	
	//verify all widgets are displayed 
	
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
