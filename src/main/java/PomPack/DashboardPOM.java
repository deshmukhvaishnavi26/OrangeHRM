package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {

	@FindBy (xpath = "//h6[normalize-space()='Dashboard']")
	private WebElement dashboardHeader;
	
	@FindBy (xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement userProfile;
	
	@FindBy (xpath = "//a[normalize-space()='Logout']")
	private WebElement logout;
	
	@FindBy (css = "button[title='Assign Leave'] svg")
	private WebElement assignLeave;
	
	@FindBy (xpath = "//h6[text()='Assign Leave']")
	private WebElement assignLeaveHeader;
	
	@FindBy (xpath = "//button[@title='Leave List']//*[name()='svg']")
	private WebElement leaveList;
	
	@FindBy (xpath = "//h5[text()='Leave List']")
	private WebElement leaveListHeader;
	
	@FindBy (xpath = "//button[@title='Timesheets']")
	private WebElement timesheets;
	
	public DashboardPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDashboardDisplayed() {
		return dashboardHeader.isDisplayed();
	}
	
	public void clickOnUserProfile() {
		userProfile.click();
	}
	
	public void clickOnLogout() {
		logout.click();
	}
	
	public void clickOnAssignLeave() {
		assignLeave.click();
	}
	
	public boolean isAssignLeaveDisplayed() {
		return assignLeaveHeader.isDisplayed();
	}
	
	public void clickOnLeaveList() {
		leaveList.click();
	}
	
	public boolean isLeaveListDisplayed() {
		return leaveListHeader.isDisplayed();
	}
	
	public void clickOnTimesheets() {
		timesheets.click();
	}
	
	String LeaveList = "https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList";
}
