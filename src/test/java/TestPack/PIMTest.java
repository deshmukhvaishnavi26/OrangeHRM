package TestPack;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import BasePack.BaseClass;
import PomPack.DashboardPOM;
import PomPack.LoginPOM;
import PomPack.MenuBarPOM;
import PomPack.PIMPOM;
import UtilityPack.Util;
import junit.framework.Assert;

public class PIMTest extends BaseClass {

	LoginPOM login;
	DashboardPOM dashboard;
	MenuBarPOM menubar;
	PIMPOM pim;
	Actions actions;
	JavascriptExecutor js;
	
	Robot robot;
	
	@BeforeClass
	public void BeforeClass() throws AWTException {
		
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		menubar = new MenuBarPOM(driver);
		pim = new PIMPOM(driver);
		robot = new Robot();
		actions = new Actions(driver);
		js = (JavascriptExecutor) driver;
		String loginUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(loginUrl, driver.getCurrentUrl());
		System.out.println("Correct URL");
		
	}
	
	@BeforeMethod
	public void Login() throws EncryptedDocumentException, IOException {
		login.enterUsername(Util.getExcelData(0, 0));
		login.enterPassword(Util.getExcelData(0, 1));
		login.clickOnLogin();
		System.out.println("Login successfully");
	}
	
//	@Test
	public void TestA() throws EncryptedDocumentException, IOException {
		System.out.println("Test A");
		System.out.println("Add new employee with valid details");
		menubar.clickOnPIM();
		pim.clickOnAdd();
		pim.enterFirstname(Util.getExcelData(3, 0));
		pim.enterLastname(Util.getExcelData(3, 1));
		Util.wait(driver).until(ExpectedConditions.elementToBeClickable(pim.getSave())).click();;
//		pim.clickOnSave();
		pim.isEmployeeNameDisplayed();
	}
	
//	@Test
	public void TestB() throws InterruptedException {
		System.out.println("Test B");
		System.out.println("Validate mandatory fields while adding employee");
		menubar.clickOnPIM();
		pim.clickOnAdd();
		Assert.assertTrue(pim.isAddEmployeeHeaderDisplayed());
		//leaving mandatory fields empty
		Util.wait(driver).until(ExpectedConditions.elementToBeClickable(pim.getSave()));
		pim.clickOnSave();
		Assert.assertTrue(pim.isRequiredMessageDisplayed());
		System.out.println("Required Message Displayed Successfully!");
	}
	
//	@Test
	public void TestC() throws EncryptedDocumentException, IOException {
		System.out.println("Test C");
		System.out.println("Search employee by employee Name");
		TestA();
		System.out.println("Test A called and completed : Create Employee");
		pim.clickOnEmployeeList();
		pim.searchEmployeeName(Util.getExcelData(3, 0));
		pim.clickOnSearch();
		Assert.assertTrue(pim.isRecordFound());
		System.out.println("After Search, Name Displayed Successfully!");
	}
	
	@Test
	public void TestD() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("Test D");
		System.out.println("Search employee by employee ID");
		//creating Employee
		menubar.clickOnPIM();
		pim.clickOnAdd();
		pim.enterFirstname(Util.getExcelData(4, 0));
		pim.enterLastname(Util.getExcelData(4, 1));
		WebElement empId = pim.getEmployeeId();
		Util.wait(driver).until(ExpectedConditions.visibilityOf(empId));
		Util.wait(driver).until(ExpectedConditions.elementToBeClickable(empId));
		//clear id
		empId.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		pim.getEmployeeId().click();
		empId.sendKeys("2610");
		Util.wait(driver).until(ExpectedConditions.elementToBeClickable(pim.getSave())).click();;
		pim.isEmployeeNameDisplayed();
		//search employee
		pim.clickOnEmployeeList();
		Util.wait(driver).until(ExpectedConditions.visibilityOf(pim.getSearchEmployeeId()));
		pim.searchEmployeeId("2610");
		Util.wait(driver).until(ExpectedConditions.elementToBeClickable(pim.getSearch()));
		pim.clickOnSearch();
		Assert.assertTrue(pim.isRecordFound());
		System.out.println("Search employee by Employee Id Successful!");
		js.executeScript("arguments[0].scrollIntoView(true);", pim.getDeleteIcon());
		Util.wait(driver).until(ExpectedConditions.elementToBeClickable(pim.getDeleteIcon())).click();
		pim.clickOnDeleteIcon();
		Util.wait(driver).until(ExpectedConditions.elementToBeClickable(pim.getYesDelete()));
		pim.clickOnYesDelete();
		System.out.println("Record Deleted!");
	}
	
//	@Test
	public void TestE() throws EncryptedDocumentException, IOException {
		System.out.println("Test E");
		System.out.println("View employee personal details");
		
	}
	
//	@AfterMethod
	public void AfterMethod() {
		menubar.clickOnDashboardMenu();
		dashboard.clickOnUserProfile();
		dashboard.clickOnLogout();
		System.out.println("Logout Successfully!");
	}

	
}
