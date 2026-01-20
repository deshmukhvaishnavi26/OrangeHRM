package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeSheetPOM {

	@FindBy (xpath = "//h6[text()='Time']")
	private WebElement timesheetHeader;
	
	public TimeSheetPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isTimeHeaderDisplayed() {
		return timesheetHeader.isDisplayed();
	}
	
}
