package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.CompleteCheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.OverViewPage;

public class CompleteCheckoutPageTest extends TestBase{

	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	OverViewPage overViewPage;
	CompleteCheckoutPage completeCheckoutPage;
	
	@BeforeMethod
	public void setup() throws Exception{
		System.out.println("Step: Get Url of swag labs");
		initalization();
		login =	new	LoginPage();
		inventoryPage = new InventoryPage();
		cartPage = new CartPage();
		checkoutPage = new CheckoutPage();
		overViewPage = new OverViewPage();
		completeCheckoutPage = new CompleteCheckoutPage();
		
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
		System.out.println("Step: Click on checkout button");
		cartPage.clickOnCheckoutBtn();
		Thread.sleep(3000);
		
		System.out.println("Step: Enter first name");
		String fName = "Amar";
		System.out.println("Step: Enter last name");
		String lName = "Kadam";
		System.out.println("Step: Enter postal code");
		String pCode = "422009";
		System.out.println("Step: Click on continue button");
		checkoutPage.getUrlAfterClickOnContnBtn(fName, lName, pCode);
		Thread.sleep(3000);
		
		overViewPage.verifyUrlAftrClickOnFinish();
	}
	
	@Test (enabled = true)
	public void verifyCompleteCheckoutTitleTest() {
		System.out.println("Step: Verify checkout complete title");
		String expTitle = "CHECKOUT: COMPLETE!";
		String actTitle = completeCheckoutPage.verifyCompleteCheckOutTitle();
		Assert.assertEquals(expTitle, actTitle);
		System.out.println("Successfully verified checkout complete title");
		Reporter.log("Verified checkout complete title :- "+actTitle);
	}
	
	@Test (enabled = true)
	public void verifyCompleteCheckoutHeaderTest() {
		System.out.println("Step: Verify checkout complete header");
		String expHeader = "THANK YOU FOR YOUR ORDER";
		String actHeader = completeCheckoutPage.verifyCompleteCheckoutHeader();
		Assert.assertEquals(expHeader, actHeader);
		System.out.println("Successfully verified checkout complete header");
		Reporter.log("Verified checkout complete header :- "+actHeader);
	}
	
	@Test (enabled = true)
	public void verifyCompleteCheckoutTextTest() {
		System.out.println("Step: Verify checkout complete text");
		String expText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actText = completeCheckoutPage.verifyCompleteCheckoutText();
		Assert.assertEquals(expText, actText);
		System.out.println("Successfully verified checkout complete text");
		Reporter.log("Verified checkout complete text :- "+actText);
	}
	
	@Test (enabled = true)
	public void verifyPonyImageTest() {
		System.out.println("Step: Verify pony image");
		boolean img = completeCheckoutPage.isPonyImageDisplayed();
		Assert.assertEquals(true, img);
		System.out.println("Successfully verified pony image");
		Reporter.log("Verified pony image ");
	}
	
	@Test (enabled = true)
	public void verifyUrlAfterClickOnBackHomeBtnTest() {
		System.out.println("Step: Verify url after click on back home button");
		String expUrl ="https://www.saucedemo.com/inventory.html";
		String actUrl = completeCheckoutPage.verifyUrlAfterClickOnBackHomeBtn();
		Assert.assertEquals(expUrl, actUrl);	
		System.out.println("Successfully verified url");
		Reporter.log("Verified url after click on back home button :- "+ actUrl);
	}
	
	@AfterMethod	
	public void closeBrowser() {
		driver.close();
	}
}
