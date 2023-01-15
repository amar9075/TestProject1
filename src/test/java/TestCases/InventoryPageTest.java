package TestCases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.InventoryPage;
import Pages.LoginPage;

public class InventoryPageTest extends TestBase{

	LoginPage login;
	InventoryPage inventoryPage;
	
	@BeforeMethod
	public void	setup() throws Exception {
		System.out.println("Step: Get Url of swag labs");
		initalization();
		login =	new	LoginPage();
		inventoryPage = new InventoryPage();
		
//		final String username = "problem_user";
//		final String password = "secret_sauce";
		
		System.out.println("Step: Enter username");
		login.enterUserName();
		System.out.println("Step: Enter password");
		login.enterPassword();
		System.out.println("Step: Click on Login button on Login Page");
		login.clickOnLoginButton();
		Thread.sleep(3000);
	}
	
	@Test (enabled = true)
	public void verifyInventoryUrlTest() {
		System.out.println("Step: verify inventory url");
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl =  inventoryPage.verifyInventoryUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified inventory url");
		Reporter.log("Verified inventory url :- "+ actUrl);
	}
	
	@Test (enabled = true)
	public void verifyAppLogoTest() {
		System.out.println("Step: Verify app logo");
		boolean actAppLogo = inventoryPage.isAppLogoDisplayed();
		Assert.assertEquals(true, actAppLogo);
		System.out.println("Successfully verified app logo");
		Reporter.log("Verified app logo");
	}
	
	private List<String> getExpectedItemsTextTest(){
		List<String> itemsText = new ArrayList<String>();
		itemsText.add("Sauce Labs Backpack");
		itemsText.add("Sauce Labs Bike Light");
		itemsText.add("Sauce Labs Bolt T-Shirt");
		itemsText.add("Sauce Labs Fleece Jacket");
		itemsText.add("Sauce Labs Onesie");
		itemsText.add("Test.allTheThings() T-Shirt (Red)");
		
		return itemsText;
	}
	
	@Test (enabled = true)
	public void verifyAllPresentItemsTest() throws Exception {
		
		System.out.println("Step: verify all present items on inventory page");
		List<String> actItemsText = inventoryPage.getTotalItemText();
		
		List<String> expItemsText = getExpectedItemsTextTest();
		Assert.assertEquals(expItemsText, actItemsText);
		System.out.println("Successfully verified all items");
		Reporter.log("Verified all items :- "+ actItemsText);
	}
	
	@Test (enabled = true)
	public void verifyItemUrlAfterclick() throws Exception {
		System.out.println("Step: Verify item url after click");
		String expItemUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		String actItemUrl = inventoryPage.clickOnItemAndGetUrl();
		Assert.assertEquals(expItemUrl, actItemUrl);
		System.out.println("Successfully verified item url ");
		Reporter.log("verified item url :- "+ actItemUrl);
	}
	
	@Test (enabled = true)
	public void shoppingCartBadgeTest() throws Exception {
		System.out.println("Step: Verify number of items selected in Shopping Cart Badge");
		int expSelectedItems = 3;
		int actSelectedItems = inventoryPage.verifyShoppingCartBadge();
		Assert.assertEquals(expSelectedItems, actSelectedItems);
		System.out.println("Successfully verified Shopping Cart Badge");
		Reporter.log("verified selected items Shopping Cart Badge :- "+actSelectedItems);
	}
	
	private List<String> getExpectedItemsTextAfterSorting(){
		List<String> itemsText = new ArrayList<String>();
		itemsText.add("Test.allTheThings() T-Shirt (Red)");
		itemsText.add("Sauce Labs Onesie");
		itemsText.add("Sauce Labs Fleece Jacket");
		itemsText.add("Sauce Labs Bolt T-Shirt");
		itemsText.add("Sauce Labs Bike Light");
		itemsText.add("Sauce Labs Backpack");
	
	return itemsText;
}
	
	@Test (enabled = true)
	public void verifyZToASortItemsTest() throws Exception {
		System.out.println("Step: Verify sort items ");
		List<String> actItemsText = inventoryPage.getTotalItemSortText();
		List<String> expItemsText = getExpectedItemsTextAfterSorting();
		Assert.assertEquals(expItemsText, actItemsText);
		System.out.println("Successfully verified all items");
		Reporter.log("Verified all items after sorting (Z to A) :- "+actItemsText);
	}
	
	@Test (enabled = true)
	public void verifyTwitterLinkTest() throws Exception {
		System.out.println("Step: Verify twitter link");
		boolean actTwitterLink = inventoryPage.isTwitterLinkDisplayed();
		Assert.assertEquals(true, actTwitterLink);
		System.out.println("Successfully verified twitter link display");
		Reporter.log("Verified twitter link display");
	}
	
	@Test (enabled = true)
	public void verifyTwitterUrlTest() throws Exception {
		System.out.println("Step: Verify twitter Url");
		String expUrl = "https://twitter.com/saucelabs";
		String actUrl = inventoryPage.verifyTwitterUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified Url");
		Reporter.log("verified Url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyFacebookLinkTest() throws Exception {
		System.out.println("Step: Verify facebook link");
		boolean actFacebookLink = inventoryPage.isFacebookLinkDisplayed();
		Assert.assertEquals(true, actFacebookLink);
		System.out.println("Successfully verified facebook link");
		Reporter.log("Verified facebook link display");
	}
	
	@Test (enabled = true)
	public void verifyFacebookUrlTest() throws Exception {
		System.out.println("Step: Verify facebook Url");
		String expUrl = "https://www.facebook.com/saucelabs";
		String actUrl = inventoryPage.verifyFacebookUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified Url");
		Reporter.log("Verified Url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyLinkedinLinkTest() throws Exception {
		System.out.println("Step: Verify linkedin link");
		boolean actLinkedinLink = inventoryPage.isLinkedinLinkDisplayed();
		Assert.assertEquals(true, actLinkedinLink);
		System.out.println("Successfully verified linkedin link");
		Reporter.log("Verified linkedin link display");
	}
	
	@Test (enabled = true)
	public void verifyLinkedinUrlTest() throws Exception {
		System.out.println("Step: Verify linkedin Url");
		String expUrl = "https://www.linkedin.com/company/sauce-labs/?original_referer=";
		String actUrl = inventoryPage.verifyLinkedinUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified Url");
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyRobotImageTest() throws Exception {
		System.out.println("Step: Verify robot image");
		boolean actRobotImage = inventoryPage.isRobotImageDisplayed();
		Assert.assertEquals(true, actRobotImage);
		System.out.println("Successfully verified robot image display");
		Reporter.log("Verified robot image display");
	}
	
	private List<String> getExpectedMenuList(){
		List<String> itemsText = new ArrayList<String>();
		itemsText.add("ALL ITEMS");
		itemsText.add("ABOUT");
		itemsText.add("LOGOUT");
		itemsText.add("RESET APP STATE");
		
		return itemsText;
	}
	
	@Test (enabled = true)
	public void verifyMenuItemListTest() throws Exception {
		System.out.println("Step: Verify Menu item list");
		List<String> actMenuListText = inventoryPage.verifyMenuBtn();
		List<String> expMenuListText= getExpectedMenuList();
		Assert.assertEquals(actMenuListText, expMenuListText);
		System.out.println("Successfully verified menu item list");
		Reporter.log("Verified menu item list :- "+actMenuListText);
	}
	
	@AfterMethod
	public void	closeBrowser() {
		driver.quit();
	}
}
