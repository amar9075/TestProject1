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

public class CheckoutPageTest extends TestBase{

	LoginPage login;
	InventoryPage inventoryPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	
	@BeforeMethod
	public void	setup() throws Exception {
		System.out.println("Step: Get Url of swag labs");
		initalization();
		login =	new	LoginPage();
		inventoryPage = new InventoryPage();
		cartPage = new CartPage();
		checkoutPage = new CheckoutPage();
		
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
		System.out.println("Step: Click on checkout button");
		cartPage.clickOnCheckoutBtn();
		Thread.sleep(3000);
	}
	
	@Test (enabled = true)
	public void verifyCheckoutPageUrlTest() {
		System.out.println("Step: Verify checkout page url");
		String expUrl = "https://www.saucedemo.com/checkout-step-one.html";
		String actUrl = checkoutPage.getCheckoutPageUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified url");
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyCkoutTitleTest() {
		System.out.println("Step: Verify checkout title");
		String expTitle = "CHECKOUT: YOUR INFORMATION";
		String actTitle = checkoutPage.verifyCkoutTitle();
		Assert.assertEquals(expTitle, actTitle);
		System.out.println("Successfully verified checkout title");
		Reporter.log("Verified checkout title :- "+actTitle);
	}
	
	@Test (enabled = true)
	public void verifyUrlAfterClickOnCancelBtnTest() throws Exception {
		System.out.println("Step: Verify url after click on cancel button");
		String expUrl = "https://www.saucedemo.com/cart.html";
		String actUrl = checkoutPage.getUrlAfterClickOnCancelBtn();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified url");
		Thread.sleep(3000);
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyUrlAfterClickOnContinueBtnTest() throws Exception {
		String fName = "Amar";
		String lName = "Kadam";
		String pCode = "422009";
		
		System.out.println("Step: Verify url after click on continue button");
		String expUrl = "https://www.saucedemo.com/checkout-step-two.html";
		String actUrl = checkoutPage.getUrlAfterClickOnContnBtn(fName, lName, pCode);
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified url");
		Thread.sleep(3000);
		Reporter.log("Verified url :- "+actUrl);
	}
	
	@Test (enabled = true)
	public void verifyErrorMsgForFirstNameTest() throws Exception  {
		String lName = "Kadam";
		String pCode = "422009";
		String error = "FirstNameError";
		
		System.out.println("Step: Verify error message for first name");
		checkoutPage.enterLastName(lName);
		checkoutPage.enterPostalCode(pCode);
		String expError = "Error: First Name is required";
		String actError = checkoutPage.clickOnContinueBtn(error);
		Assert.assertEquals(expError, actError);
		System.out.println("Successfully verified error message");
		Thread.sleep(3000);
		Reporter.log("Verified error message :- "+actError);
	}
	
	@Test (enabled = true)
	public void verifyErrorMsgForLastNameTest() throws Exception  {
		String fName = "Amar";
		String pCode = "422009";
		String error = "LastNameError";
		
		System.out.println("Step: Verify error message for last name");
		checkoutPage.enterFirstName(fName);
		checkoutPage.enterPostalCode(pCode);
		String expError = "Error: Last Name is required";
		String actError = checkoutPage.clickOnContinueBtn(error);
		Assert.assertEquals(expError, actError);
		System.out.println("Successfully verified error message");
		Thread.sleep(3000);
		Reporter.log("Verified error message :- "+actError);
	}
	
	@Test (enabled = true)
	public void verifyErrorMsgForPostalCodeTest() throws Exception  {
		String fName = "Amar";
		String lName = "Kadam";
		String error = "postalCodeError";
		
		System.out.println("Step: Verify error message for postal code");
		checkoutPage.enterFirstName(fName);
		checkoutPage.enterLastName(lName);
		String expError = "Error: Postal Code is required";
		String actError = checkoutPage.clickOnContinueBtn(error);
		Assert.assertEquals(expError, actError);
		System.out.println("Successfully verified error message");
		Thread.sleep(3000);
		Reporter.log("Verified error message :- "+actError);
	}
	
	@AfterMethod
	public void	closeBrowser() {
		driver.close();
	}
}
