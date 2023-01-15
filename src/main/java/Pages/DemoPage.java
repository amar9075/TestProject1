package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DemoPage extends TestBase {
	
	@FindBy(xpath = "//div[@class='inventory_item_name']") private List<WebElement> itemName;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement productSortContainer;
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']") private WebElement item1;
	
	public DemoPage() {
		PageFactory.initElements(driver, this);
	}
	
	public List<String> getTotalItemText() {
		List<WebElement> itemsWeb = itemName;
		List<String> itemsText = new ArrayList<String>();
		for(WebElement item : itemsWeb) {
			itemsText.add(item.getText());
		}
		return itemsText;
	}
	
	public List<String> getTotalItemSortText() throws Exception{
//		productSortContainer.click();
		Actions act = new Actions(driver);
		act.moveToElement(productSortContainer).click().build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).click().build().perform();
		Thread.sleep(3000);
//		act.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(3000);
		List<String> itemsText = getTotalItemText();
		return itemsText;
	}
	

	public String clickOnItemAndGetUrl() throws Exception {
		Thread.sleep(5000);
		item1.click();
		 
		Thread.sleep(3000);
		return driver.getCurrentUrl();
	}

}
