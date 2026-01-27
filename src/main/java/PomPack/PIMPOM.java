package PomPack;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPOM {

	@FindBy (xpath = "//button[normalize-space()='Add']")
	private WebElement add;
	
	@FindBy (xpath = "//h6[text()='Add Employee']")
	private WebElement addEmployeeHeader;
	
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
	
	@FindBy (xpath = "//span[text()='Required']")
	private List<WebElement> requiredMessage;
	
	//Employee List
	
	@FindBy (xpath = "//a[text()='Employee List']")
	private WebElement employeeListHeader;
	
	@FindBy (xpath = "//label[normalize-space()='Employee Name'] /ancestor::div[contains(@class,'oxd-input-group')]//input")
	private WebElement inputEmployeeName;
	
	@FindBy (xpath = "//button[normalize-space()='Search']")
	private WebElement search;
	
//	@FindBy (xpath = "//span[contains(normalize-space(), 'Record Found')]")
//	private WebElement recordFound;
	
	@FindBy (xpath = "//div[@class='oxd-table-card']")
	private List<WebElement> record;
	
	public PIMPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdd() {
		add.click();
	}
	
	public boolean isAddEmployeeHeaderDisplayed() {
		return addEmployeeHeader.isDisplayed();
	}
	
	public void enterFirstname(String name) {
		firstname.sendKeys(name);
	}
	
	public void enterLastname(String name) {
		lastname.sendKeys(name);
	}
	
	public WebElement getEmployeeId() {
		return employeeId;
	}
	
	public void clickOnEmployeeId() {
		employeeId.click();
	}
	
	public void enterEmployeeId(String id) {
//		employeeId.sendKeys(Keys.CONTROL + "a");
//		employeeId.sendKeys(Keys.DELETE);
		employeeId.clear();
		employeeId.sendKeys(id);
	}
	
	public WebElement getSave() {
		return save;
	}
	
	public void clickOnSave() {
		save.click();
	}
	
	public boolean isEmployeeNameDisplayed() {
		return employeeName.isDisplayed();
	}
	
	public boolean isRequiredMessageDisplayed() {
		if(requiredMessage.size() == 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickOnEmployeeList() {
		employeeListHeader.click();
	}
	
	public void enterEmployeeName(String name) {
		inputEmployeeName.sendKeys(name);
	}
	
	public void clickOnSearch() {
		search.click();
	}
	
	public boolean isRecordFound() {
		if(record.size() >= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
