package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.UtilityMethods;

public class LoginPageTest extends TestBase{

	LoginPage login;
	
	@BeforeMethod (alwaysRun = true)
	public void	setup() throws Exception{
		System.out.println("Step: Get Url of swag labs");
		initalization();
		login =	new	LoginPage();
	}
	
	@Test (enabled = true)
	public void verifyTitleTest() throws Exception{
		System.out.println("Step: Verify Title");
		String expTitle	= "1Swag Labs";
		String actTitle	= login.verifyTitle();
		Assert.assertEquals(expTitle, actTitle);
		System.out.println("Successfully verified Title");
		Reporter.log("Verified Title :- " +actTitle);
	}
	
	@Test (enabled = false)
	public void verifyCurrentUrlTest() throws Exception {
		System.out.println("Step: Verify current Url");
		String expUrl	= "https://www.saucedemo.com/";
		String actUrl = login.verifyCurrentUrl();
		Assert.assertEquals(expUrl, actUrl);
		System.out.println("Successfully verified Current Url");
		Reporter.log("Verified Current Url :- "+actUrl);
	}
	
	@Test (enabled = false)
	public void verifyLoginLogoTest() {
		System.out.println("Step: Verify login logo");
		boolean actLoginLogo = login.isLoginLogo();
		Assert.assertEquals(true, actLoginLogo);
		System.out.println("Login logo displayed on login page");
		Reporter.log("Login logo displayed on login page");
	}
	
	@Test (enabled = false)
	public void verifyBotLogoTest() {
		System.out.println("Step: Verify bot logo");
		boolean actBotLogo = login.isBotLogo();
		Assert.assertEquals(true, actBotLogo);
		System.out.println("Bot logo displayed on login page");
		Reporter.log("Bot logo displayed on login page");
	}
	
	@Test (enabled = false)
	public void loginCredentialTest() throws Exception {
//		final String username = "problem_user";
//		final String password = "secret_sauce";
		
		System.out.println("Step: Enter username");
		login.enterUserName();
		
		System.out.println("Step: Enter password");
		login.enterPassword();
		
		System.out.println("Step: Click on Login button on Login Page");
		login.clickOnLoginButton();
		Reporter.log("Logged in successfully");
	}
	
	@Test (enabled = false)
	public void verifyProductTitleTest() throws Exception {
//		final String username = "problem_user";
//		final String password = "secret_sauce";
		
		System.out.println("Step: Enter username");
		login.enterUserName();
		System.out.println("Step: Enter password");
		login.enterPassword();
		System.out.println("Step: Click on Login button on Login Page");
		login.clickOnLoginButton();
	
		System.out.println("Step: Verify title 'products' after login");
		boolean actProdTitle = login.isProductsTitleDisplayedAfterLogin();
		Assert.assertEquals(true, actProdTitle);
		System.out.println("Products title displayed after login");
		Reporter.log("Products title displayed after login");
	}
	
	@Test (enabled = false)
	public void verifyPeekLogoTest() throws Exception {
//		final String username = "problem_user";
//		final String password = "secret_sauce";
		
		System.out.println("Step: Enter username");
		login.enterUserName();
		System.out.println("Step: Enter password");
		login.enterPassword();
		System.out.println("Step: Click on Login button on Login Page");
		login.clickOnLoginButton();
	
		System.out.println("Step: Verify peek after login");
		boolean actPeek = login.isPeekDisplayedAfterLogin();
		Assert.assertEquals(true, actPeek);
		System.out.println("Peek displayed after login");
		Reporter.log("Peek displayed after logged in");
	}
	
	@Test (enabled = false)
	public void verifyErrorMessageForPasswordTest() throws Exception {
		System.out.println("Step: Enter invalid username, click on login button and verify error message");
		login.enterUserName("aaa");
		login.clickOnLoginButton();
		String expErrorMsg = "Epic sadface: Password is required";
		String actErrorMsg = login.getForPasswordErrorMessage();
		Assert.assertEquals(expErrorMsg, actErrorMsg);
		System.out.println("Successfully verified error message");
		Reporter.log("Verified error message:- "+ actErrorMsg);
	}
	
	@Test (enabled = false)
	public void verifyErrorMessageForUsernameTest() throws Exception {
		System.out.println("Step: Enter invalid password, click on login button and verify error message");
		login.enterPassword("ada");
		login.clickOnLoginButton();
		String expErrorMsg = "Epic sadface: Username is required";
		String actErrorMsg = login.getForUsernameErrorMessage();
		Assert.assertEquals(expErrorMsg, actErrorMsg);
		System.out.println("Successfully verified error message");
		Reporter.log("Verified error message :- "+ actErrorMsg);
	}
	
	@Test (enabled = false)
	public void verifyErrorMessageTest() throws Exception {
		System.out.println("Step: Enter invalid username, invalid password, click on login button and verify error message");
		login.enterUserName("aaa");
		login.enterPassword("aaa");
		login.clickOnLoginButton();
		String expErrorMsg = "Epic sadface: Username and password do not match any user in this service";
		String actErrorMsg = login.getErrorMessage();
		Assert.assertEquals(expErrorMsg, actErrorMsg);
		System.out.println("Successfully verified error message");
		Reporter.log("Verified error message :- "+ actErrorMsg);
	}
	
	@AfterMethod (alwaysRun = true)
	public void	closeBrowser(ITestResult a) throws IOException {
		if(ITestResult.FAILURE == a.getStatus()) {
			UtilityMethods.takeScreenshot(a.getName());
		}
		driver.close();
	}
}
