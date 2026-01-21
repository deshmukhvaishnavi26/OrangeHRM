package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimePOM {

	@FindBy (xpath = "//h6[text()='Time']")
	private WebElement timesheetHeader;
	
	@FindBy (xpath = "//h6[text()='My Timesheet']")
	private WebElement myTimesheet;
	
	public TimePOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isTimeHeaderDisplayed() {
		return timesheetHeader.isDisplayed();
	}
	
	public boolean isMyTimesheetDisplayed() {
		return myTimesheet.isDisplayed();
	}
	
}
