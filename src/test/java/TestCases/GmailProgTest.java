package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.GmailProg;

public class GmailProgTest extends TestBase{
	
	GmailProg gmailProg;
	@BeforeMethod
	public void	setup() throws Exception {
		initalization("https://www.google.com/");
		gmailProg = new GmailProg();
	}
	
	@Test (enabled = false)
	public void createGmailAccount1() throws Exception {
		Thread.sleep(3000);
		gmailProg.clickOnGmailLink(1);
	}
	
	@Test (enabled = true)
	public void createGmailAccount2() throws Exception {
		Thread.sleep(3000);
		gmailProg.clickOnGmailLink(2);
	}
	
	@Test (enabled = false)
	public void createGmailAccount3() throws Exception {
		Thread.sleep(3000);
		gmailProg.clickOnGmailLink(3);
	}
	
	@AfterMethod
	public void	closeBrowser() {
		driver.close();
	}

}
