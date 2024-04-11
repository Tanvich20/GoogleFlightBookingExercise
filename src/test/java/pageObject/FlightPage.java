package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FlightPage {

	WebDriver ldriver;

	public FlightPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//div[@class='Eo39gc']")
	WebElement pageTitle;

	@FindBy(xpath = "//div[@class='RLVa8 GeHXyb']")
	WebElement tripType;

	@FindBy(xpath = "//ul[@aria-label='Select your ticket type.']/li")
	List<WebElement> types;

	@FindBy(css = "[aria-label='Where from?']")
	WebElement whereFrom;

	@FindBy(xpath = "//ul[@class='DFGgtd']/li")
	List<WebElement> locations;

	@FindBy(css = "[aria-label='Where to? ']")
	WebElement whereTo;

	@FindBy(xpath = "//input[@placeholder='Departure']")
	WebElement departure;

	@FindBy(xpath = "//input[@placeholder='Return']")
	WebElement returnn;

	@FindBy(css = "[aria-label='Search']")
	WebElement search;

	@FindBy(xpath = "//div[@class='WXaAwc']/div/button")
	WebElement done;

	@FindBy(xpath = "//ul[@class='Rk10dc']")
	List<WebElement> flightOptions;

	@FindBy(xpath = "//div[@class='AotkO uknidb']")
	WebElement followOrReject;

	@FindBy(css = "[aria-label='All filters']")
	WebElement filterBtn;

	@FindBy(xpath = "//section[@class='Ud9qge PMuGec']/h2")
	List<WebElement> filters;

	@FindBy(css = "[aria-label='Select all airlines']")
	WebElement selectAllBtn;

	@FindBy(xpath = "//ol[@class='bA5b7b']/li")
	List<WebElement> airline;

	@FindBy(css = "[aria-label='Close dialog']")
	WebElement closeFilterBtn;

	public void confirmPageTitle(String title) {
		String titleOnScreen = pageTitle.getText();
		Assert.assertEquals(title, titleOnScreen);
	}

	public void selectTripType(String trip) {
		tripType.click();
		for (int i = 0; i < types.size(); i++) {
			if (types.get(i).getText().equalsIgnoreCase(trip)) {
				types.get(i).click();
			}
		}
		String selectedType=tripType.findElement(By.xpath("//span[@id='i7']")).getText();
		Assert.assertEquals(selectedType, trip);
	}

	public void enterWhereFrom(String from) throws InterruptedException {
		whereFrom.clear();
		whereFrom.sendKeys(from);
		for (int i = 0; i < locations.size(); i++) {
			locations.get(0).click();
		}
	}

	public void enterWhereTo(String to) throws InterruptedException {
		whereTo.clear();
		whereTo.sendKeys(to);
		for (int i = 0; i < locations.size(); i++) {
			locations.get(0).click();
		}
	}

	public void enterDeparture(String dateOfDeparture) throws InterruptedException {
		departure.click();
		departure.sendKeys(dateOfDeparture);
		done.click();
	}

	public void enterReturn(String dateOfReturn) throws InterruptedException {
		returnn.click();
		returnn.sendKeys(dateOfReturn);
		done.click();
	}

	public void clickSearch() throws InterruptedException {
		search.click();
	}

	public void availableFlightOptions() {
		int i = flightOptions.size();
		Assert.assertTrue(i > 0, "Search displayes the flight options");
	}

	public void addFilter(String airlinee) throws InterruptedException {
		filterBtn.click();
		Thread.sleep(2000);
		for (int i = 0; i < filters.size(); i++) {
			if (filters.get(i).getText().equalsIgnoreCase("Airlines")) {
				if(selectAllBtn.getAttribute("aria-checked").equals("true")) {
					selectAllBtn.click();
					Thread.sleep(2000);
				}
			}
		}
		for (int j = 0; j < airline.size(); j++) {
			if (airline.get(j).getText().equalsIgnoreCase(airlinee)) {
				airline.get(j).click();
			}
		}
		closeFilterBtn.click();
		Thread.sleep(2000);
	}

	public void validAirlineDisplayed(String airline) {
		for (int i = 0; i < flightOptions.size(); i++) {
			String airlineName = flightOptions.get(i)
					.findElement(By.xpath("//li/div/div[2]/div/div[2]/div/div[2]/div[2]/span")).getText();
			Assert.assertEquals(airlineName, airline);
		}
	}
}
