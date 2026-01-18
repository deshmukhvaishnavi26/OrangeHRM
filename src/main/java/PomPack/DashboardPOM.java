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
}
