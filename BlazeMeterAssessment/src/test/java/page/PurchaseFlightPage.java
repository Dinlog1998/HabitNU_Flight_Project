package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class PurchaseFlightPage extends BaseClass {

	By totalCost = By.xpath("//em[text()='914.76 ']");
	By clickButton = By.xpath("//input[@type='submit']");
	By givenId = By.xpath("//table[@class='table']//tr/td[text()='Id']/following-sibling::*");
	
	public boolean verifyPage() {
		
		boolean displayed = com.elementsLocator(totalCost).isDisplayed();
		return displayed;
	}
	
	public void purchaseFlightButton() {
		
		com.do_click(clickButton);
	}
	
	public String fetchUrl() {
		
		String checkUrl = com.checkUrl();
		return checkUrl;
	}
	public String fetchId() {
		
		WebElement id = com.elementsLocator(givenId);
		String text = id.getText();
		return text;
		
	}
	
}
