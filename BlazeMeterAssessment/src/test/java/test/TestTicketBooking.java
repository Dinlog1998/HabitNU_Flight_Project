package test;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestTicketBooking extends BaseClass {

	@Test(priority = 0)
	public void verifyWelcomePage() {

		boolean verifyblazeDemoPage = homepage.verifyblazeDemoPage();
		Assert.assertTrue(verifyblazeDemoPage);
	}

	@Test(priority = 1)
	public void verifyHyperlink() {

		homepage.weekDestination();
		String vacationPageUrl = homepage.fetchUrl();
		Assert.assertEquals(vacationPageUrl, "https://blazedemo.com/vacation.html");
		driver.navigate().back();
	}

	@Test(priority = 2)
	public void chooseTravelLocation() {
		Select depatureLocation = homepage.depatureLocation();
		depatureLocation.selectByVisibleText("Mexico City");
		Select destinationLocation = homepage.destinationLocation();
		destinationLocation.selectByVisibleText("London");
		homepage.clickSearchButton();

	}

	@Test(priority = 3)
	public void selectFlight() {

		flight.selectingFlights();
	}

	@Test(priority = 4)
	public void verifyPurchaseFlightPage() {

		boolean verifyPage = purchase.verifyPage();
		Assert.assertTrue(verifyPage);
	}

	@Test(priority = 5)
	public void clickPurchaseFlightButton() {

		purchase.purchaseFlightButton();
	}

	@Test(priority = 6)
	public void confirmUrl() {

		String fetchUrl = purchase.fetchUrl();
		Assert.assertEquals(fetchUrl, "https://blazedemo.com/confirmation.php");

	}
	
	@Test(priority = 7)
	public void confirmId() {
		
		String fetchId = purchase.fetchId();
		System.out.println("Given Id is : "+ fetchId);
	}

}
