package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePOM {
	
	@FindBy (xpath = "//h6[text()='Assign Leave']")
	private WebElement assignLeaveHeader;
	
	@FindBy (xpath = "//h5[text()='Leave List']")
	private WebElement leaveListHeader;
	
	@FindBy(xpath = "//h6[text()='Apply Leave']")
	private WebElement applyLeaveHeader;
	
	@FindBy (xpath = "//h5[text()='My Leave List']")
	private WebElement myLeaveListHeader;
	
	public LeavePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAssignLeaveDisplayed() {
		return assignLeaveHeader.isDisplayed();
	}
	
	public boolean isLeaveListDisplayed() {
		return leaveListHeader.isDisplayed();
	}
	
	public boolean isApplyLeaveDisplayed() {
		return applyLeaveHeader.isDisplayed();
	}
	
	public boolean isMyLeaveDisplayed() {
		return myLeaveListHeader.isDisplayed();
	}
	
}
