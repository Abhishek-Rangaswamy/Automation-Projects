package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import BrowserInstance.SingletonWebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchBrowserandUrl {

	static WebDriver driver;

	@Given("^Open the browser (.*)$")
	public void open_the_browser(String BrowserName) {
		System.out.println("Launching browser: "+BrowserName);
		driver=SingletonWebDriver.getDriver(BrowserName);

	}

	@When("^Enter the FlipKart URL (.*)$")
	public void enter_the_flipkart_url(String url) {
		System.out.println("Launching Url: "+url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Then("^Login page title is (.*)$")
	public void title_of_login_page_is(String Title){
		String expectedTitle=Title;
		String actualTitle = driver.getTitle(); 
		assertEquals("Exception! User is not in Login page B'coz title does not match!",expectedTitle, actualTitle);
		System.out.println("Hey, Welcome to FlipKart!");
	}

}
