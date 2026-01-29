package TestPack;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	WebDriverWait wait;
	Robot robot;
	
	@BeforeClass
	public void BeforeClass() throws AWTException {
		
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		menubar = new MenuBarPOM(driver);
		pim = new PIMPOM(driver);
		wait = Util.wait(driver);
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
	
//	@Test
	public void TestD() throws EncryptedDocumentException, IOException {
		System.out.println("Test D");
		System.out.println("Search employee by employee ID");
		//creating Employee
		menubar.clickOnPIM();
		pim.clickOnAdd();
		pim.enterFirstname(Util.getExcelData(4, 0));
		pim.enterLastname(Util.getExcelData(4, 1));
		WebElement empId = pim.getEmployeeId();
		//wait for loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-form-loader')]")));
		wait.until(ExpectedConditions.elementToBeClickable(empId));
		//clear id
		empId.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);
		pim.getEmployeeId().click();
		empId.sendKeys(Util.getExcelData(4, 2));
		wait.until(ExpectedConditions.elementToBeClickable(pim.getSave())).click();;
		pim.isEmployeeNameDisplayed();
		//search employee
		pim.clickOnEmployeeList();
		wait.until(ExpectedConditions.visibilityOf(pim.getSearchEmployeeId()));
		pim.searchEmployeeId(Util.getExcelData(4, 2));
		wait.until(ExpectedConditions.elementToBeClickable(pim.getSearch()));
		pim.clickOnSearch();
		Assert.assertTrue(pim.isRecordFound());
		System.out.println("Search employee by Employee Id Successful!");
		//delete record
		wait.until(ExpectedConditions.invisibilityOfElementLocated(pim.loader));
		WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(pim.deleteIcon2));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", delete);
		delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(pim.yesDelete2)).click();
		System.out.println("Record Deleted!");
	}
	
//	@Test
	public void TestE() {
		System.out.println("Test E");
		System.out.println("View employee personal details");
		menubar.clickOnPIM();
		pim.clickOnEmployeeList();
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",pim.getRecordFound());
		pim.getRecordRows().get(0).click();
		Assert.assertTrue(pim.isPersonalDetailsDisplayed());
		System.out.println("Employee Personal Details Displayed Successfully!");
	}
	
	@Test
	public void TestF() {
		System.out.println("TestF");
		System.out.println("Edit employee personal information");
		TestE();
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", pim.getDateOfBirth());
		wait.until(ExpectedConditions.invisibilityOfElementLocated(pim.loader));
		pim.clickOnDateOfBirth();
		pim.clickOnMonth();
		pim.selectMonth();
		pim.clickOnYear();
		pim.selectYear();
		pim.selectDate();
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", pim.getGender());
		pim.selectGender();
		pim.clickOndetailsSave();
		System.out.println("Details Saved Successfully");
		// rechecking
		pim.clickOnEmployeeList();
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",pim.getRecordFound());
		pim.getRecordRows().get(0).click();
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", pim.getGender());
		// assertion failed
		System.out.println("Female selected: " + pim.getFemaleSelected().isSelected());
		Assert.assertTrue(pim.isFemaleSelected());
	}
	
//	@Test
	public void TestG() {
		System.out.println("TestG");
		System.out.println("Delete employee record");
	}
	
//	@AfterMethod
	public void AfterMethod() {
		menubar.clickOnDashboardMenu();
		dashboard.clickOnUserProfile();
		dashboard.clickOnLogout();
		System.out.println("Logout Successfully!");
	}

	
}
