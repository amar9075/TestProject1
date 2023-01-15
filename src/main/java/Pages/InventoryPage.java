package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;
import Utility.UtilityMethods;

public class InventoryPage extends TestBase {

	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath = "//div[@class='inventory_item_name']") private List<WebElement> itemName;
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]") private WebElement element1;
	@FindBy(xpath = "(//button[text()='Add to cart'])[3]") private WebElement element2;
	@FindBy(xpath = "(//button[text()='Add to cart'])[4]") private WebElement element3;
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']") private WebElement item1;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement shoppingCartBadge;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productSortContainer;
	@FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']") private WebElement twitterLink;
	@FindBy(xpath = "//a[@href='https://www.facebook.com/saucelabs']") private WebElement facebookLink;
	@FindBy(xpath = "//a[@href='https://www.linkedin.com/company/sauce-labs/']") private WebElement linkedinLink;
	@FindBy(xpath = "//img[@class='footer_robot']") private WebElement robotImage;
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement openMenuBtn;
	@FindBy(xpath = "//nav[@class='bm-item-list']//a") private List<WebElement> menuItem;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement shoppingCartLink;
	//select[@class='product_sort_container']
	
	public InventoryPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyInventoryUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isAppLogoDisplayed() {
		return appLogo.isDisplayed();
	}
	
	public List<String> getTotalItemText() {
		List<WebElement> items = itemName;
		List<String> itemsText = new ArrayList<String>();
		for(WebElement item : items) {
			itemsText.add(item.getText());
		}
		return itemsText;
	}
	
	private void selectNumberOfItems() throws Exception {
		element1.click();
		Thread.sleep(3000);
		element2.click();
		Thread.sleep(3000);
		element3.click();
	}
	
	public String clickOnItemAndGetUrl() throws Exception {
		item1.click();
		 
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}
	
	public int verifyShoppingCartBadge() throws Exception {
		selectNumberOfItems();
		
		Thread.sleep(3000);
		String selectedItems = shoppingCartBadge.getText();
		return Integer.parseInt(selectedItems);
	}
	
	public List<String> getTotalItemSortText() throws Exception{
		Select select = new Select(productSortContainer);
		select.selectByVisibleText("Name (Z to A)");
		
		Thread.sleep(3000);
		List<String> itemsText = getTotalItemText();
		return itemsText;
	}
	
	public boolean isTwitterLinkDisplayed() throws Exception {
		UtilityMethods.scrollToElement(twitterLink);
		return twitterLink.isDisplayed();
	}
	
	public String verifyTwitterUrl() throws Exception {
		UtilityMethods.scrollToElement(twitterLink);
		twitterLink.click();
		
		Thread.sleep(1000);
		UtilityMethods.driverWindowFocusSwitchToAnotherWindow();
		
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
	
	public boolean isFacebookLinkDisplayed() throws Exception {
		UtilityMethods.scrollToElement(facebookLink);
		return facebookLink.isDisplayed();
	}
	
	public String verifyFacebookUrl() throws Exception {
		UtilityMethods.scrollToElement(facebookLink);
		facebookLink.click();
		
		Thread.sleep(1000);
		UtilityMethods.driverWindowFocusSwitchToAnotherWindow();
		
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
	
	public boolean isLinkedinLinkDisplayed() throws Exception {
		UtilityMethods.scrollToElement(linkedinLink);
		return linkedinLink.isDisplayed();
	}
	
	public String verifyLinkedinUrl() throws Exception {
		UtilityMethods.scrollToElement(linkedinLink);
		linkedinLink.click();
		
		Thread.sleep(1000);
		UtilityMethods.driverWindowFocusSwitchToAnotherWindow();
		
		Thread.sleep(1000);
		return driver.getCurrentUrl();
	}
	
	public boolean isRobotImageDisplayed() throws Exception {
		UtilityMethods.scrollToElement(robotImage);
		return robotImage.isDisplayed();
	}
	
	public List<String> verifyMenuBtn() throws Exception {
		openMenuBtn.click();
		Thread.sleep(3000);
		List<WebElement> menuItemList = menuItem;
		List<String> menuItemText = new ArrayList<String>();
		for(WebElement item : menuItemList) {
			menuItemText.add(item.getText());
		}
		return menuItemText;
	}
	
	public void clickOnShoppingCartLink() {
		shoppingCartLink.click();
	}
}
