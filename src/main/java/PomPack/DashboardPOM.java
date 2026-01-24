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
	
	@FindBy (xpath = "//button[@title='Leave List']//*[name()='svg']")
	private WebElement leaveList;
	
	@FindBy (xpath = "//button[@title='Timesheets']")
	private WebElement timesheets;
	
	@FindBy (xpath = "//div[@title='Apply Leave']/preceding-sibling::button")
	private WebElement applyLeave;
	
	@FindBy(xpath = "//button[@title='My Leave']")
	private WebElement myLeave;
	
	@FindBy (xpath = "//button[@title='My Timesheet']")
	private WebElement myTimesheet;
	
	@FindBy (xpath = "//p[text()='Time at Work']")
	private WebElement timeAtWork;
	
	@FindBy (xpath = "//p[text()='My Actions']")
	private WebElement myActions;
	
	@FindBy (xpath = "//p[text()='Quick Launch']")
	private WebElement quickLaunch;
	
	@FindBy (xpath = "//p[text()='Buzz Latest Posts']")
	private WebElement buzzPosts;
	
	@FindBy (xpath = "//p[text()='Employee Distribution by Sub Unit']")
	private WebElement distributionByUnit;
	
	@FindBy (xpath = "//p[text()='Employee Distribution by Location']")
	private WebElement distributionByLocation;
	
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
	
	public void clickOnLeaveList() {
		leaveList.click();
	}
	
	public void clickOnTimesheets() {
		timesheets.click();
	}
	
	public void clickOnApplyLeave() {
		applyLeave.click();
	}
	
	public void clickOnMyLeave() {
		myLeave.click();
	}
	
	public void clickOnMyTimesheet() {
		myTimesheet.click();
	}
	
	public boolean isTimeAtWorkDisplayed() {
		return timeAtWork.isDisplayed();
	}
	
	public boolean isMyActionsDisplayed() {
		return myActions.isDisplayed();
	}
	
	public boolean isQuickLaunchDisplayed() {
		return quickLaunch.isDisplayed();
	}
	
	public boolean isBuzzPostsDisplayed() {
		return buzzPosts.isDisplayed();
	}

	public boolean isDistributionByUnitDisplayed() {
		return distributionByUnit.isDisplayed();
	}
	
	public boolean isDistributionByLocationDisplayed() {
		return distributionByLocation.isDisplayed();
	}
}
