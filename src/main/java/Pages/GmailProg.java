package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.ReadData;

public class GmailProg extends TestBase{
	
	@FindBy(xpath = "//a[@href='https://mail.google.com/mail/&ogbl']") private WebElement gmailLink;
	@FindBy(xpath = "(//div//a//span[text()='Create an account'])[1]") private WebElement createAccount;
	@FindBy(xpath = "//input[@name='firstName']") private WebElement firstName;
	@FindBy(xpath = "//input[@name='lastName']") private WebElement lastName;
	@FindBy(xpath = "//input[@name='Username']") private WebElement userName;
	@FindBy(xpath = "//input[@name='Passwd']") private WebElement password;
	@FindBy(xpath = "//input[@name='ConfirmPasswd']") private WebElement cnfmPassword;
	@FindBy(xpath = "//span[text()='Next']") private WebElement nextBtn;
	
	public GmailProg() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnGmailLink(int row) throws Exception {
		gmailLink.click();
		createAccount.click();
		
		firstName.sendKeys(ReadData.readExcelFile(row, 0, "Sheet1"));
		lastName.sendKeys(ReadData.readExcelFile(row, 1, "Sheet1"));
		userName.sendKeys(ReadData.readExcelFile(row, 2, "Sheet1"));
		password.sendKeys(ReadData.readExcelFile(row, 3, "Sheet1"));
		cnfmPassword.sendKeys(ReadData.readExcelFile(row, 4, "Sheet1"));
		nextBtn.click();
	}

}
