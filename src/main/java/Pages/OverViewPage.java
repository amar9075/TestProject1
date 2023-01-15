package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import Utility.UtilityMethods;

public class OverViewPage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement checkoutTitle;
	@FindBy(xpath = "//div[@class='cart_item']") private List<WebElement> cartItems;
	@FindBy(xpath = "//div[text()='SauceCard #31337']") private WebElement paymInfo;
	@FindBy(xpath = "//div[text()='FREE PONY EXPRESS DELIVERY!']") private WebElement shipInfo;
	@FindBy(xpath = "//div[@class='summary_subtotal_label']") private WebElement subTotal;
	@FindBy(xpath = "//div[@class='summary_tax_label']") private WebElement taxLabel;
	@FindBy(xpath= "//div[@class='summary_total_label']") private WebElement totalLabel;
	@FindBy(xpath = "//button[@name='cancel']") private WebElement cancelBtn;
	@FindBy(xpath = "//button[@name='finish']") private WebElement finishBtn;
	
	public OverViewPage() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean ischeckoutTitleDisplayed() {
		return checkoutTitle.isDisplayed();
	}
	
	public int verifyCartItems() {
		List<WebElement> cartItemsList = cartItems ;
		return cartItemsList.size();
	}
	
	public String verifyPaymentInfo() {
		return paymInfo.getText();
	}
	
	public String verifyShipInfo() {
		return shipInfo.getText();
	}
	
	public String verifySubtotal() throws Exception {
		UtilityMethods.scrollToElement(subTotal);
		String sbTotal = subTotal.getText().split(":")[1].trim();
		return sbTotal;
	}
	
	public String verifyTaxLabel() throws Exception {
		UtilityMethods.scrollToElement(taxLabel);
		String taxLbl = taxLabel.getText().split(":")[1].trim();
		return taxLbl;
	}
	
	public double verifyTotalabel() throws Exception {
		UtilityMethods.scrollToElement(totalLabel);
		String totalLbl = totalLabel.getText().split(":")[1].trim();
		String str = "";
		for(int index = 0; index<totalLbl.length(); index++) {
			char ch = totalLbl.charAt(index);
			if(ch != '$') {
				str += ch ;
			}
		}
		return Double.parseDouble(str);
	}
	
	public String verifyUrlAftrClickOnCancel() throws Exception {
		UtilityMethods.scrollToElement(cancelBtn);
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyUrlAftrClickOnFinish() throws Exception {
		UtilityMethods.scrollToElement(finishBtn);
		finishBtn.click();
		return driver.getCurrentUrl();
	}
}
