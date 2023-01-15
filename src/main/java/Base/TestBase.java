package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ReadData;

public class TestBase {
	
	public static WebDriver driver;	
	
	public void initalization() throws Exception{
		initalization("https://www.saucedemo.com/");
	}
	
	public void initalization(String url) throws Exception{
		System.setProperty("webdriver.chrome.driver","./resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.get(ReadData.readPropertyFile("url"));
		driver.get(url);
	}
}
