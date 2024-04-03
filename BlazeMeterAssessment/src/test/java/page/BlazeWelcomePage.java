package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class BlazeWelcomePage extends BaseClass {

	By welcomePage = By.xpath("//h1[text()='Welcome to the Simple Travel Agency!']");
	By vacationPage = By.linkText("destination of the week! The Beach!");
	By depCity = By.name("fromPort");
	By destCity = By.name("toPort");
	By submitButton = By.xpath("//input[@type='submit']");

	public boolean verifyblazeDemoPage() {

		boolean displayed = driver.findElement(welcomePage).isDisplayed();
		return displayed;
	}

	public void weekDestination() {

		com.do_click(vacationPage);
	}

	public String fetchUrl() {

		String url = com.checkUrl();
		return url;
	}

	public Select depatureLocation() {

		WebElement depatureCity = com.elementsLocator(depCity);
		Select s = new Select(depatureCity);
		return s;

	}

	public Select destinationLocation() {

		WebElement depatureCity = com.elementsLocator(destCity);
		Select s = new Select(depatureCity);
		return s;
	}
	public void clickSearchButton() {
		
		com.do_click(submitButton);
	}
}