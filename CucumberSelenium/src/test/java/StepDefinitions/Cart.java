package StepDefinitions;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import BrowserInstance.SingletonWebDriver;
import Pages.CartPage;
import io.cucumber.java.en.*;

public class Cart {

	WebDriver driver=LaunchBrowserandUrl.driver;
	CartPage p=new CartPage(driver);

	@Given("User is in product details page and add product to cart")
	public void user_should_be_in_product_details_page() {
		Set<String> windows = driver.getWindowHandles();
		String maintab = driver.getWindowHandle();
		int count=windows.size();
		System.out.println("Count of tabs: "+count);

		for(String tab:windows) {
			System.out.println("Tab_id's:"+tab);
			if(!tab.equals(maintab)) {
				driver.switchTo().window(tab); 
				System.out.println(driver.getCurrentUrl());
				p.ClickaddcartBtn();
				break;
			}
		}
	}

	@And("Verify product in cart")
	public void verify_product_in_cart() {
		if(p.ItemsNumber().getAttribute("value").equals("1")) {
			System.out.println("Product has been added to the cart");
		}else {
			System.out.println("No items in cart!");
		}
	}

	@Then("Close the bowser")
	public void close_the_bowser() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Closing Browser. Thanks for visiting Flipkart!");
		SingletonWebDriver.closeDriver();
	}

}
