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
	
	@FindBy (xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
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
	
	@FindBy (xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	private WebElement searchinputEmployeeId;
	
	@FindBy (xpath = "//button[normalize-space()='Search']")
	private WebElement search;
	
//	@FindBy (xpath = "//span[contains(normalize-space(), 'Record Found')]")
//	private WebElement recordFound;
	
	@FindBy (xpath = "//div[@class='oxd-table-body']//div[@role='row']")
	private List<WebElement> recordRows;
	
	@FindBy (xpath = "//button[contains(@class,'oxd-icon-button')]//i[contains(@class,'bi-trash')]")
	private WebElement deleteIcon;
	
	@FindBy (xpath = "//button[normalize-space()='Yes, Delete']")
	private WebElement yesDelete;
	
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
	
	public void searchEmployeeName(String name) {
		inputEmployeeName.sendKeys(name);
	}
	
	public WebElement getSearchEmployeeId() {
		return searchinputEmployeeId;
	}
	
	public void searchEmployeeId(String id) {
		searchinputEmployeeId.sendKeys(id);
	}
	
	public WebElement getSearch() {
		return search;
	}
	
	public void clickOnSearch() {
		search.click();
	}
	
	public boolean isRecordFound() {
		if(recordRows.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public WebElement getDeleteIcon() {
		return deleteIcon;
	}
	
	public void clickOnDeleteIcon() {
		deleteIcon.click();
	}
	
	public WebElement getYesDelete() {
		return yesDelete;
	}
	
	public void clickOnYesDelete() {
		yesDelete.click();
	}
	
}
