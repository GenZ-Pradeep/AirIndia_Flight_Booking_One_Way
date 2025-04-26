package com.ai.steps;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
//import org.testng.Assert;

public class AirIndia_OneWay_ScenOutline_StepDef {
public Playwright playwright = Playwright.create();
public Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

@Test
@Given("user is on the Air India homepage")
public void the_user_is_on_the_air_india_homepage() throws InterruptedException {
	page.navigate("https://www.airindia.com/");
	Thread.sleep(2000);
}

@And("user clicks on Accept All cookies button")
public void the_user_clicks_on_accept_all_cookies_button() throws InterruptedException {
	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept All")).click();
	Thread.sleep(2000);
}

@And("user accepts location dialog")
public void the_User_Blocks_Location_Dialog() {
	page.onDialog(dialog -> {
		String msg = dialog.message();
		System.out.println("Dialog text is: " + msg);
		Assert.assertTrue(msg.contains("Know your location"));
		//dialog.dismiss();
		dialog.accept();
	});
}

@When("^user selects (.*) trip type$")
public void the_user_selects_one_way_trip_type(String tripType) throws InterruptedException {
	//page.getByLabel("One Way").check();
	page.getByLabel(tripType).check();
	Thread.sleep(2000);
}

@And("^user enters departure city as (.*) and selects (.*)$")
public void the_user_enters_departure_city_as(String fromCity, String fromCityTxt) throws InterruptedException {
	page.locator("#originAutoComplete").getByLabel("Search").click();
	//page.locator("#originAutoComplete").getByLabel("Search").fill("del");
	page.locator("#originAutoComplete").getByLabel("Search").fill(fromCity);
	Thread.sleep(2000);
	//page.getByText("Delhi, India, IN").click();
	page.getByText(fromCityTxt).click();
	Thread.sleep(2000);
}

@When("^user enters destination city as (.*) and selects (.*)$")
public void the_user_enters_destination_city_as(String toCity, String toCityTxt) throws InterruptedException {
	page.locator("#destinationAutoComplete").getByLabel("Search").click();
	//page.locator("#destinationAutoComplete").getByLabel("Search").fill("bom");
	page.locator("#destinationAutoComplete").getByLabel("Search").fill(toCity);
	Thread.sleep(2000);
	//page.getByText("Mumbai, India, IN").click();
	page.getByText(toCityTxt).click();
	Thread.sleep(2000);
}

@And("^user selects departure date as (.*) and (.*)$")
public void the_user_selects_departure_date_as(String depDateLabel, String depDateTxt) throws InterruptedException {
	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Depart")).click();
	//page.getByLabel("Thursday, May 1,").getByText("₹").click();
	page.getByLabel(depDateLabel).getByText(depDateTxt).click();
	Thread.sleep(2000);
}

@And("user selects passengers as one adult")
public void theUserSelectsPassangersAsOneAdult() throws InterruptedException {
	page.getByLabel("Passenger(S)").click();
	Thread.sleep(2000);
}

@And("^user selects class as (.*)$")
public void theUserSelectsClassAsBusiness(String selClass) throws InterruptedException {
	page.getByLabel("Class").click();
	Thread.sleep(2000);
	//page.locator("#ai-booking-widget").getByRole(AriaRole.LIST).getByText("Business").click();
	page.locator("#ai-booking-widget").getByRole(AriaRole.LIST).getByText(selClass).click();
	Thread.sleep(2000);
}

@And("user clicks on Search button")
public void the_user_clicks_on() throws InterruptedException {
	page.locator("//button[text()='Search']").click();
	Thread.sleep(2000);
}


@Then("user should see a list of available flights")
public void the_user_should_see_a_list_of_available_flights() throws InterruptedException {
	Thread.sleep(5000);
	playwright.close();
}

}

