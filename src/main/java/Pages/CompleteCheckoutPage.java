package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CompleteCheckoutPage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Checkout: Complete!']") private WebElement compltTitle;
	@FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']") private WebElement compltHeader;
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement completeText;
	@FindBy(xpath = "//img[@class='pony_express']") private WebElement ponyImg;
	@FindBy(xpath = "//button[@name='back-to-products']") private WebElement backHomeBtn;
	
	public CompleteCheckoutPage() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCompleteCheckOutTitle() {
		return compltTitle.getText();
	}
	
	public String verifyCompleteCheckoutHeader() {
		return compltHeader.getText();
	}

	public String verifyCompleteCheckoutText() {
		return completeText.getText();
	}
	
	public boolean isPonyImageDisplayed() {
		return ponyImg.isDisplayed();
	}
	
	public String verifyUrlAfterClickOnBackHomeBtn() {
		backHomeBtn.click();
		return driver.getCurrentUrl();
	}
}
