package PomPack;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy (xpath = "//span[contains(normalize-space(), 'Records Found')]")
	private WebElement recordFound;
	
	@FindBy (xpath = "//div[@class='oxd-table-body']//div[@role='row']")
	private List<WebElement> recordRows;
	
	@FindBy (xpath = "//button[contains(@class,'oxd-icon-button')]//i[contains(@class,'bi-trash')]")
	private WebElement deleteIcon;
	
	@FindBy (xpath = "//button[normalize-space()='Yes, Delete']")
	private WebElement yesDelete;
	
	public By deleteIcon2 = By.xpath("//button[contains(@class,'oxd-icon-button')]//i[contains(@class,'bi-trash')]");
	public By yesDelete2  = By.xpath("//button[normalize-space()='Yes, Delete']");
	public By loader     = By.xpath("//div[contains(@class,'oxd-form-loader')]");
	
	@FindBy (xpath = "//h6[text()='Personal Details']")
	private WebElement personalDetailsHeader;
	
	@FindBy (xpath = "//label[text()='Date of Birth']/ancestor::div[contains(@class,'oxd-grid-item')]//input")
	private WebElement dateOfBirth;
	
	@FindBy (xpath = "//li[@class='oxd-calendar-selector-month']")
	private WebElement month;
	
	@FindBy (xpath = "//ul[@class='oxd-calendar-dropdown']//li[text()='October']")
	private WebElement october;
	
	@FindBy (xpath = "//li[@class='oxd-calendar-selector-year']")
	private WebElement year;
	
	@FindBy (xpath = "//li[text()='2001']")
	private WebElement selectYear;
	
	@FindBy (xpath = "//div[text()='26']")
	private WebElement date;
	
	@FindBy (xpath = "//div[@class='oxd-radio-wrapper']//label[text()='Female']")
	private WebElement female;
	
	@FindBy (xpath = "//div[@class='oxd-radio-wrapper']//label[text()='Female']//input")
	private WebElement femaleSelected;
	
	@FindBy (xpath = "//input[@type='radio' ]")
	private WebElement female2;
	
	@FindBy (xpath = "//div[contains(@class,'orangehrm-horizontal')]//button[normalize-space()='Save']")
	private WebElement detailsSave;
	
	@FindBy (xpath = "//i[contains(@class,'bi-trash')]/parent::button")
	private List<WebElement> deleteButtons;
	
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
	
	public WebElement getRecordFound() {
		return recordFound;
	}
	
	public List<WebElement> getRecordRows() {
		return recordRows;
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
	
	public boolean isPersonalDetailsDisplayed() {
		return personalDetailsHeader.isDisplayed();
	}
	
	public  WebElement getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void clickOnDateOfBirth() {
		dateOfBirth.click();
	}
	
	public void clickOnMonth() {
		month.click();
	}
	
	public void selectMonth() {
		october.click();
	}
	
	public void clickOnYear() {
		year.click();
	}
	
	public void selectYear() {
		selectYear.click();
	}
	
	public void selectDate() {
		date.click();
	}
	
	public WebElement getGender() {
		return female;
	}
	
	public void selectGender() {
		femaleSelected.click();
	}
	
	public WebElement getFemaleSelected() {
		return femaleSelected;
	}
	
	public boolean isFemaleSelected() {
		return femaleSelected.isSelected();
	}
	
	public void clickOndetailsSave() {
		detailsSave.click();
	}
	
	public WebElement getFemale2() {
		return female2;
	}
	
	public List<WebElement> getDeleteButtons() {
		return deleteButtons;
	}
	
	
	
}
