package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.InventoryPage;
import Pages.LoginPage;

public class CartPageTest extends TestBase{

	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartPage;
	
	@BeforeMethod
	public void	setup() throws Exception  {
		System.out.println("Step: Get Url of swag labs");
		initalization();
		login =	new	LoginPage();
		inventoryPage = new InventoryPage();
		cartPage = new CartPage();
		
//		final String username = "problem_user";
//		final String password = "secret_sauce";
		
		System.out.println("Step: Enter username");
		login.enterUserName();
		System.out.println("Step: Enter password");
		login.enterPassword();
		System.out.println("Step: Click on Login button on Login Page");
		login.clickOnLoginButton();
		Thread.sleep(3000);
		
		System.out.println("Step: Select number of items");
		inventoryPage.verifyShoppingCartBadge();
		System.out.println("Step: Click on shopping cart badge");
		inventoryPage.clickOnShoppingCartLink();
		
		Thread.sleep(3000);
	}
	
	@Test (enabled = true)
	public void verifyCartUrlTest() {
		System.out.println("Step: verify cart page url");
		String expUrl = "https://www.saucedemo.com/cart.html";
		String actUrl = cartPage.getCartPageUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified cart page url");
		Reporter.log("Verified cart page url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyCartTitleTest() {
		System.out.println("Step: Verify cart title");
		boolean actCartTitle = cartPage.isYourCartTitleDisplayed();
		Assert.assertEquals(true, actCartTitle);
		System.out.println("Successfully verified cart title");
		Reporter.log("Verified cart title display");
	}
	
	@Test (enabled = true)
	public void verifyAppLogoTest() {
		System.out.println("Step: Verify app logo");
		boolean actAppLogo = cartPage.isAppLogoDisplayed();
		Assert.assertEquals(true, actAppLogo);
		System.out.println("Successfully verified app logo");
		Reporter.log("Verified app logo display");
	}
	
	@Test (enabled = true)
	public void verifyCartNumber() throws Exception {
		System.out.println("Step: verify cart number");
		int expCartNum = 2 ;
		int actCartNum = cartPage.verifyShoppingCartBadge();
		Assert.assertEquals(expCartNum, actCartNum);
		System.out.println("Successfully verified cart number");
		Reporter.log("Verified cart number after removing 1 item :- "+ actCartNum); 
	}
	
	@Test (enabled = true)
	public void verifyUrlAfterContinueShoppBtnClickedTest() {
		System.out.println("Step: Verify url after continue shopping button Clicked");
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = cartPage.clickContinueShoppBtn();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified url");
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@AfterMethod
	public void	closeBrowser() {
		driver.close();
	}
}
