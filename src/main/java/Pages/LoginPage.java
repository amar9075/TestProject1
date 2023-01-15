package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//div[@class='login_logo']") private WebElement loginLogo;
	@FindBy(xpath = "//div[@class='bot_column']") private WebElement botLogo;
	@FindBy(xpath = "//input[@id='user-name']" ) private WebElement userName;
	@FindBy(xpath = "//input[@id='password']") private WebElement passWord;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement loginButton;
	@FindBy(xpath = "//span[text()='Products']") private WebElement productTitle;
	@FindBy(xpath = "//div[@class='peek']") private WebElement peek;
	@FindBy(xpath = "//h3[text()='Epic sadface: Password is required']") private WebElement errorMessage;
	@FindBy(xpath = "//h3[text()='Epic sadface: Username is required']") private WebElement errorMessage1;
	@FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']") private WebElement errorMessage2;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyTitle()	throws Exception{
		Thread.sleep(2000);
		return driver.getTitle();
	}
	
	public String verifyCurrentUrl() throws	Exception{
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}
	
	public boolean isLoginLogo() {
		return loginLogo.isDisplayed();
	}
	
	public boolean isBotLogo() {
		return botLogo.isDisplayed();
	}
	
	public void enterUserName() throws Exception {
		userName.sendKeys(ReadData.readPropertyFile("username"));
//		username.sendKeys(ReadData.readExcelFile(0, 0));
	}
	
	public void enterPassword() throws Exception {
		passWord.sendKeys(ReadData.readPropertyFile("password"));
//		passWord.sendKeys(ReadData.readExcelFile(0, 1));
	}
	
	public void enterUserName(String username) throws Exception {
		userName.sendKeys(username);
//		username.sendKeys(ReadData.readExcelFile(0, 0));
	}
	
	public void enterPassword(String password) throws Exception {
		passWord.sendKeys(password);
//		passWord.sendKeys(ReadData.readExcelFile(0, 1));
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public boolean isProductsTitleDisplayedAfterLogin() {
		return productTitle.isDisplayed();
	}
	
	public boolean isPeekDisplayedAfterLogin() {
		return peek.isDisplayed();
	}
	
	public String getForPasswordErrorMessage() throws Exception {
		Thread.sleep(3000);
		return errorMessage.getText();
	}
	
	public String getForUsernameErrorMessage() throws Exception {
		Thread.sleep(3000);
		return errorMessage1.getText();
	}
	
	public String getErrorMessage() throws Exception {
		Thread.sleep(3000);
		return errorMessage2.getText();
	}
}
