package TestPack;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import BasePack.BaseClass;
import PomPack.DashboardPOM;
import PomPack.LoginPOM;
import PomPack.MenuBarPOM;
import PomPack.PIMPOM;
import UtilityPack.UtilityClass;
import junit.framework.Assert;

public class PIMTest extends BaseClass {

	LoginPOM login;
	DashboardPOM dashboard;
	MenuBarPOM menubar;
	PIMPOM pim;
	
	Robot robot;
	
	@BeforeClass
	public void BeforeClass() throws AWTException {
		
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		menubar = new MenuBarPOM(driver);
		pim = new PIMPOM(driver);
		robot = new Robot();
		
		String loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(loginUrl, driver.getCurrentUrl());
		System.out.println("Correct URL");
		
	}
	
	@BeforeMethod
	public void Login() throws EncryptedDocumentException, IOException {
		login.enterUsername(UtilityClass.getExcelData(0, 0));
		login.enterPassword(UtilityClass.getExcelData(0, 1));
		login.clickOnLogin();
		System.out.println("Login successfully");
	}
	
//	@Test
	public void TestA() throws EncryptedDocumentException, IOException {
		System.out.println("Test A");
		System.out.println("Add new employee with valid details");
		menubar.clickOnPIM();
		pim.clickOnAdd();
		pim.enterFirstname(UtilityClass.getExcelData(3, 0));
		pim.enterLastname(UtilityClass.getExcelData(3, 1));
		UtilityClass.wait(driver).until(ExpectedConditions.elementToBeClickable(pim.getEmployeeId()));
		pim.clickOnEmployeeId();
		//select all
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//delete
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		//enter new Id
		pim.enterEmployeeId(UtilityClass.getExcelData(3, 2));
		pim.clickOnSave();
		pim.isEmployeeNameDisplayed();
	}
	
	@Test
	public void TestB() throws InterruptedException {
		System.out.println("Test B");
		System.out.println("Validate mandatory fields while adding employee");
		menubar.clickOnPIM();
		pim.clickOnAdd();
		Assert.assertTrue(pim.isAddEmployeeHeaderDisplayed());
		//leaving mandatory fields empty
		UtilityClass.wait(driver).until(ExpectedConditions.visibilityOf(pim.getSave()));
		pim.clickOnSave();
		Assert.assertTrue(pim.isRequiredMessageDisplayed());
		System.out.println("Required Message Displayed Successfully!");
		
	}
	
//	@AfterMethod
	public void AfterMethod() {
		menubar.clickOnDashboardMenu();
		dashboard.clickOnUserProfile();
		dashboard.clickOnLogout();
		System.out.println("Logout Successfully!");
	}

	
}
