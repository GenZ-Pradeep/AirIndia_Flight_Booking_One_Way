package com.ai.steps;

//package com.ai.step;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)  //requires JUnit dependency
@CucumberOptions(features="src\\test\\java\\com\\ai\\features\\AirIndia_OneWay_Booking.feature",
		glue= {"com.ai.steps"},  //requires Cucumber JUnit dependency
		monochrome = true,
		plugin = {"pretty", "html:target/HtmlReports/Html_GS.html",
				"json:target/JSONReports/report_GS.json",
				"junit:target/JUnitReports/report_GS.xml"}
		//tags="@smokeTest"

)
public class testRunnerAIOWB {

}
