package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class UtilityMethods extends TestBase{
	
	public static void scrollToElement(WebElement element) throws Exception {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(3000);
	}
	
	public static void driverWindowFocusSwitchToAnotherWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext()) {
			String currentWindow = itr.next();
			if(!mainWindow.equals(currentWindow)) {
				driver.switchTo().window(currentWindow);
			}
		}
	}
	
	public static void takeScreenshot(String name) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+name+".png");
		FileHandler.copy(source, dest);
	}

}
