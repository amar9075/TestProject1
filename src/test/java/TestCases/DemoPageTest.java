package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DemoPage;
import Pages.LoginPage;

public class DemoPageTest extends TestBase {

	LoginPage login;
	DemoPage demoPage;

	@BeforeMethod
	public void	setup() throws Exception {
		initalization();
		login =	new	LoginPage();
		demoPage = new DemoPage();

//		final String username = "problem_user";
//		final String password = "secret_sauce";

		System.out.println("Step: Enter username");
		login.enterUserName();
		System.out.println("Step: Enter password");
		login.enterPassword();
		System.out.println("Step: Click on Login button on Login Page");
		login.clickOnLoginButton();
	}

//	private List<String> getExpectedItemsTextAfterSorting(){
//		List<String> itemsText = new ArrayList<String>();
//		itemsText.add("Test.allTheThings() T-Shirt (Red)");
//		itemsText.add("Sauce Labs Onesie");
//		itemsText.add("Sauce Labs Fleece Jacket");
//		itemsText.add("Sauce Labs Bolt T-Shirt");
//		itemsText.add("Sauce Labs Bike Light");
//		itemsText.add("Sauce Labs Backpack");
//
//		return itemsText;
//	}
//	
//	@Test
//	public void verifyZToASortItemsTest() throws Exception {
//		System.out.println("Step: Verify sort items ");
//		List<String> actItemsText = demoPage.getTotalItemSortText();
//		List<String> expItemsText = getExpectedItemsTextAfterSorting();
//		Assert.assertEquals(expItemsText, actItemsText);
//		System.out.println("Successfully verified all items");
//		System.out.println();
//	}
	
	@Test
	public void verifyItemUrlAfterclick() throws Exception {
		System.out.println("Step: Verify item url after click");
		String expItemUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		String actItemUrl = demoPage.clickOnItemAndGetUrl();
		Assert.assertEquals(expItemUrl, actItemUrl);
		System.out.println("Successfully verified item url ");
	}

//	@AfterMethod
//	public void	closeBrowser() {
//		driver.close();
//	}
}
