package TestPack;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
	
	@BeforeClass
	public void BeforeClass() {
		
		login = new LoginPOM(driver);
		dashboard = new DashboardPOM(driver);
		menubar = new MenuBarPOM(driver);
		pim = new PIMPOM(driver);
		
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
	
	@Test
	public void TestA() throws EncryptedDocumentException, IOException {
		System.out.println("Test A");
		menubar.clickOnPIM();
		pim.clickOnAdd();
		pim.enterFirstname(UtilityClass.getExcelData(3, 0));
		pim.enterLastname(UtilityClass.getExcelData(3, 1));
		pim.enterEmployeeId(UtilityClass.getExcelData(3, 2));
		pim.clickOnSave();
		pim.isEmployeeNameDisplayed();
	}
	
//	@AfterMethod
	public void AfterMethod() {
		menubar.clickOnDashboardMenu();
		dashboard.clickOnUserProfile();
		dashboard.clickOnLogout();
		System.out.println("Logout Successfully!");
	}

	
}
