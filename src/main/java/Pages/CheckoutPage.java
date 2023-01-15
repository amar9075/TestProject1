package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CheckoutPage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Checkout: Your Information']") private WebElement ckoutTitle;
	@FindBy(xpath = "//button[@name='cancel']") private WebElement cancelBtn;
	@FindBy(xpath = "//input[@id='first-name']") private WebElement firstName;
	@FindBy(xpath = "//input[@name='lastName']") private WebElement lastName;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCode;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	@FindBy(xpath = "//h3[text()='Error: First Name is required']") private WebElement errorFstName;
	@FindBy(xpath = "//h3[text()='Error: Last Name is required']") private WebElement errorLstName;
	@FindBy(xpath = "//h3[text()='Error: Postal Code is required']") private WebElement errorPostCode;
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	public String getCheckoutPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public String verifyCkoutTitle() {
		return ckoutTitle.getText();
	}
	
	public String getUrlAfterClickOnCancelBtn() throws Exception {
		cancelBtn.click();
		
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	
	public void enterFirstName(String frstname) {
		firstName.sendKeys(frstname);
	}
	
	public void enterLastName(String lstname) {
		lastName.sendKeys(lstname);
	}
	
	public void enterPostalCode(String pstlCode) {
		postalCode.sendKeys(pstlCode);
	}
	
	public String clickOnContinueBtn(String str) {
		
		if(str == "FirstNameError" ) {
			continueBtn.click();
			return errorFstName.getText();
		}else if(str == "LastNameError") {
			continueBtn.click();
			return errorLstName.getText();
		}else
			continueBtn.click();
		return errorPostCode.getText();
		
		 
	}
	
	public String getUrlAfterClickOnContnBtn(String fName, String lName, String code) throws Exception {
		enterFirstName(fName);
		enterLastName(lName);
		enterPostalCode(code);
		
		Thread.sleep(3000);
		continueBtn.click();
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
}
