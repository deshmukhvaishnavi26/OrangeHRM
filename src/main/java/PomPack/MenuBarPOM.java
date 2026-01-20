package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuBarPOM {

	@FindBy (xpath = "//span[text()='Dashboard']")
	private WebElement dashboardMenu;
	
	public MenuBarPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDashboardMenu() {
		dashboardMenu.click();
	}
	
}
