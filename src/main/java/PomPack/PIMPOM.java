package PomPack;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPOM {

	@FindBy (xpath = "//button[normalize-space()='Add']")
	private WebElement add;
	
	@FindBy (xpath = "//input[@name='firstName']")
	private WebElement firstname;
	
	@FindBy (xpath = "//input[@name='lastName']")
	private WebElement lastname;
	
	@FindBy (xpath = "//form[@class='oxd-form']//input[@class='oxd-input oxd-input--active']")
	private WebElement employeeId;
	
	@FindBy (xpath = "//button[normalize-space()='Save']")
	private WebElement save;
	
	@FindBy (xpath = "//div[@class='orangehrm-edit-employee-name']//h6")
	private WebElement employeeName;
	
	public PIMPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdd() {
		add.click();
	}
	
	public void enterFirstname(String name) {
		firstname.sendKeys(name);
	}
	
	public void enterLastname(String name) {
		lastname.sendKeys(name);
	}
	
	public WebElement clearEmployeeId() {
		return employeeId;
	}
	
	public void enterEmployeeId(String id) {
//		employeeId.sendKeys(Keys.CONTROL + "a");
//		employeeId.sendKeys(Keys.DELETE);
		employeeId.clear();
		employeeId.sendKeys(id);
	}
	
	public void clickOnSave() {
		save.click();
	}
	
	public boolean isEmployeeNameDisplayed() {
		return employeeName.isDisplayed();
	}
}
