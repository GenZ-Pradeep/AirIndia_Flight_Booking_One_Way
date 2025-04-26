package com.ai.steps;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Test;
//import org.testng.Assert;

public class AirIndia_Oneway_Booking_Steps {


public Playwright playwright = Playwright.create();
public Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

@Test
@Given("the user is on the Air India homepage")
public void the_user_is_on_the_air_india_homepage() throws InterruptedException {
	page.navigate("https://www.airindia.com/");
	Thread.sleep(2000);
}

@And("the user clicks on Accept All cookies button")
public void the_user_clicks_on_accept_all_cookies_button() throws InterruptedException {
	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept All")).click();
	Thread.sleep(2000);
}

@And("the user accepts location dialog")
public void the_User_Blocks_Location_Dialog() {
	page.onDialog(dialog -> {
		String msg = dialog.message();
		System.out.println("Dialog text is: " + msg);
		Assert.assertTrue(msg.contains("Know your location"));
		//dialog.dismiss();
		dialog.accept();
	});
}
//@And("user accepts location dialog")
//public void the_User_Blocks_Location_Dialog() {
//	Dialog dialog = page.waitForEvent(Page.EventType.Dialog, () -> {
//		// Action that triggers the dialog
//		page.click("#allowLocationButton"); // <-- trigger inside
//	});
//
//	String msg = dialog.message();
//	System.out.println("Dialog text is: " + msg);
//	Assert.assertTrue(msg.contains("Know your location"));
//	dialog.accept();
//}

@When("the user selects One Way trip type")
public void the_user_selects_one_way_trip_type() throws InterruptedException {
	//page.locator("[value='One Way']").click();
	page.getByLabel("One Way").check();
	Thread.sleep(2000);
}

@And("the user enters departure city as del")
public void the_user_enters_departure_city_as() throws InterruptedException {
	page.locator("#originAutoComplete").getByLabel("Search").click();
	page.locator("#originAutoComplete").getByLabel("Search").fill("del");
	Thread.sleep(2000);
	page.getByText("Delhi, India, IN").click();
	Thread.sleep(2000);
}

@When("the user enters destination city as bom")
public void the_user_enters_destination_city_as() throws InterruptedException {
	page.locator("#destinationAutoComplete").getByLabel("Search").click();
	page.locator("#destinationAutoComplete").getByLabel("Search").fill("bom");
	Thread.sleep(2000);
	page.getByText("Mumbai, India, IN").click();
	Thread.sleep(2000);
}

@And("the user selects departure date as <depDate>")
public void the_user_selects_departure_date_as() throws InterruptedException {
	page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Depart")).click();
	page.getByLabel("Thursday, May 1,").getByText("₹").click();
	Thread.sleep(2000);
}

@And("the user selects passengers as one adult")
public void theUserSelectsPassangersAsOneAdult() throws InterruptedException {
	page.getByLabel("Passenger(S)").click();
	Thread.sleep(2000);
}

@And("the user selects class as business")
public void theUserSelectsClassAsBusiness() throws InterruptedException {
	page.getByLabel("Class").click();
	Thread.sleep(2000);
	page.locator("#ai-booking-widget").getByRole(AriaRole.LIST).getByText("Business").click();
	Thread.sleep(2000);
}

@And("the user clicks on Search button")
public void the_user_clicks_on() throws InterruptedException {
	page.locator("//button[text()='Search']").click();
	Thread.sleep(2000);
}


@Then("the user should see a list of available flights")
public void the_user_should_see_a_list_of_available_flights() throws InterruptedException {
	Thread.sleep(5000);
	playwright.close();
}
}
