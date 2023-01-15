package TestCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.OverViewPage;

public class OverViewPageTest extends TestBase{

	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	OverViewPage overViewPage;
	
	@BeforeMethod
	public void setup() throws Exception{
		System.out.println("Step: Get Url of swag labs");
		initalization();
		login =	new	LoginPage();
		inventoryPage = new InventoryPage();
		cartPage = new CartPage();
		checkoutPage = new CheckoutPage();
		overViewPage = new OverViewPage();
		
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
	}
	
	@Test (enabled = true)
	public void verifyCheckoutUrlTest() {
		System.out.println("Step: Verify current page url");
		String expUrl = "https://www.saucedemo.com/checkout-step-two.html";
		String actUrl = overViewPage.getCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified url");
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifycCheckoutTitleTest() {
		System.out.println("Step: Verify checkout title display");
		boolean actResult = overViewPage.ischeckoutTitleDisplayed();
		Assert.assertEquals(actResult, true);
		System.out.println("Successfully verified checkout title display");
		Reporter.log("Verified checkout title display");
	}
	
	@Test (enabled = true)
	public void verifyCartItemsListTest() {
		System.out.println("Step: Verify cart items number");
		int expNum = 3;
		int actNum = overViewPage.verifyCartItems();
		Assert.assertEquals(expNum, actNum);
		System.out.println("Successfully verified cart items number");
		Reporter.log("Verified cart items number :- "+actNum);
	}
	
	@Test (enabled = true)
	public void verifyPaymentInfoTest() {
		System.out.println("Step: Verify payment info");
		String expInfo = "SauceCard #31337";
		String actInfo = overViewPage.verifyPaymentInfo();
		Assert.assertEquals(expInfo, actInfo);
		System.out.println("Successfully verified payment info");
		Reporter.log("Verified payment info :- "+actInfo);
	}
	
	@Test (enabled = true)
	public void verifyShipInfoTest() {
		System.out.println("Step: Verify shipping info");
		String expInfo = "FREE PONY EXPRESS DELIVERY!";
		String actInfo = overViewPage.verifyShipInfo();
		Assert.assertEquals(expInfo, actInfo);
		System.out.println("Successfully verified shipping info");
		Reporter.log("Verified shipping info :- "+actInfo);
	}
	
	@Test (enabled = true)
	public void verifySummarySubtotalLabelTest() throws Exception {
		System.out.println("Step: Verify summary subtotal label");
		String expSubtotal = "$95.97";
		String actSubtotal = overViewPage.verifySubtotal();
		Assert.assertEquals(expSubtotal, actSubtotal);
		System.out.println("Successfully verified summary subtotal label");
		Reporter.log("Verified summary subtotal label :- "+actSubtotal);
	}
	
	@Test (enabled = true)
	public void verifyTaxLabelTest() throws Exception {
		System.out.println("Step: Verify tax label");
		String expTax = "$7.68";
		String actTax =overViewPage.verifyTaxLabel();
		Assert.assertEquals(expTax, actTax);
		System.out.println("Successfully verified tax label");
		Reporter.log("Verified tax label :- "+actTax);
	}
	
	@Test (enabled = true)
	public void verifySummaryTotalLabelTest() throws Exception{
		System.out.println("Step: Verify summary total label");
		double expTotal = 103.65;
		double actTotal =overViewPage.verifyTotalabel();
		Assert.assertEquals(expTotal, actTotal);
		System.out.println("Successfully verified summary total label");
		Reporter.log("Verified summary total label :- "+actTotal);
	}
	
	@Test (enabled = true)
	public void verifyUrlAftrClickOnCancelBtnTest() throws Exception{
		System.out.println("Step: Verify url after click on cancel button");
		String expUrl = "https://www.saucedemo.com/inventory.html";
		String actUrl = overViewPage.verifyUrlAftrClickOnCancel();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified url");
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyUrlAftrClickOnFinishBtnTest() throws Exception{
		System.out.println("Step: Verify url after click on finish button");
		String expUrl = "https://www.saucedemo.com/checkout-complete.html";
		String actUrl = overViewPage.verifyUrlAftrClickOnFinish();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified url");
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@AfterMethod	
	public void closeBrowser() {
		driver.close();
	}
	
}
