package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement YourCartTitle;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removeBtn;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement shoppingCartBadge;
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath = "//button[@name='continue-shopping']") private WebElement continueShoppBtn;
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement openMenuBtn;
	@FindBy(xpath = "//nav[@class='bm-item-list']//a") private List<WebElement> menuItem;
	@FindBy(xpath = "//button[@name='checkout']") private WebElement chekourBtn;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCartPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isAppLogoDisplayed() {
		return appLogo.isDisplayed();
	}
	
	public boolean isYourCartTitleDisplayed() {
		return YourCartTitle.isDisplayed();
	}
	
	public int verifyShoppingCartBadge() throws Exception {
		removeBtn.click();
		
		Thread.sleep(3000);
		String cartItems = shoppingCartBadge.getText();
		return Integer.parseInt(cartItems);
	}
	
	public String clickContinueShoppBtn() {
		continueShoppBtn.click();
		
		return driver.getCurrentUrl();
	}
	
	public void clickOnCheckoutBtn() {
		chekourBtn.click();
	}
	
	
	
}
