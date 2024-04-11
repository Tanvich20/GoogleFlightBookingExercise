package stepDefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.FlightPage;
import utilities.ReadConfig;

public class FlightBookingTest extends BaseClass {

	@Before
	public void setup() {
		readConfig = new ReadConfig();
		String browser = readConfig.getBrowser();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			break;
		default:
			driver = null;
			break;

		}
	}

	@Given("I want to launch the chrome browser")
	public void i_want_to_launch_the_chrome_browser() {
		flightpg = new FlightPage(driver);
	}

	@Given("I want to load the URL")
	public void i_want_to_load_the_url() {
		driver.get(readConfig.getUrl());
	}

	@When("Flight page is displyed")
	public void flight_page_is_displyed() {
		flightpg.confirmPageTitle("Flights");

	}

	@When("I want to book {string} trip")
	public void i_want_to_book_trip(String tripType) {
		flightpg.selectTripType(tripType);
	}

	@Then("Enter details for {string} trip")
	public void enter_details(String s, DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> e : data) {
			flightpg.enterWhereFrom(e.get("whereFrom"));
			flightpg.enterWhereTo(e.get("whereTo"));
			flightpg.enterDeparture(e.get("departure"));
			if (s.equalsIgnoreCase("Round Trip")) {
				flightpg.enterReturn(e.get("return"));
			} else {

			}
		}
	}

	@Then("Click on search button")
	public void click_on_explore_button() throws InterruptedException {
		flightpg.clickSearch();

	}

	@Then("I can see the list of flights")
	public void i_can_see_the_list_of_flights() {
		flightpg.availableFlightOptions();
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
	}

	@When("User applies a filter for {string} flight")
	public void user_applies_a_filter_for_flight(String airlineName) throws InterruptedException {
		flightpg.addFilter(airlineName);
	}

	@Then("User should see only {string} flight options")
	public void user_should_see_only_direct_flight_options(String airlineName) {
		flightpg.validAirlineDisplayed(airlineName);
	}

	@After
	public void teardown(Scenario sc) {
		driver.quit();
	}

}