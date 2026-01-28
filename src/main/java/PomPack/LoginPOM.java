package PomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {

	@FindBy (xpath = "//h5[normalize-space()='Login']")
	private WebElement loginHeader;
	
	@FindBy (xpath = "//input[@name='username']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath = "//button[normalize-space()='Login']")
	private WebElement login;
	
	@FindBy (xpath = "//p[text()='Invalid credentials']")
	private WebElement invalidCredentials;
	
	public LoginPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isLoginDisplayed() {
		return loginHeader.isDisplayed();
	}
	
	public void enterUsername(String name) {
		username.sendKeys(name);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public boolean isInvalidCredlsDisplayed() {
		return invalidCredentials.isDisplayed();
	}
}
