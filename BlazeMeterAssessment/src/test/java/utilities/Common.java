package utilities;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import base.BaseClass;

public class Common extends BaseClass {

	public WebElement elementsLocator(By locator) {

		WebElement verify = driver.findElement(locator);
		return verify;
	}

	public void do_click(By locator) {
		
		driver.findElement(locator).click();
	}

	public String checkTitle() {

		String title = driver.getTitle();
		return title;
	}

	public String checkUrl() {

		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public List<WebElement> multipleElementsLocator(By locator) {
		
		List<WebElement> chooseFlight = driver.findElements(locator);
		return chooseFlight;
	}

}
