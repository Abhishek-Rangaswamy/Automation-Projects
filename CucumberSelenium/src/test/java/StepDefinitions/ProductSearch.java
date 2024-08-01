package StepDefinitions;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Pages.LoginPage;
import Pages.SearchedProduct;
import io.cucumber.java.en.*;

public class ProductSearch {

	WebDriver driver=LaunchBrowserandUrl.driver;
	LoginPage lp=new LoginPage(driver);
	SearchedProduct sp=new SearchedProduct(driver);
	ArrayList<Integer> list;
	ArrayList<WebElement> elements;
	Integer Lowest;
	private WebElement LowestElement;

	@Given("^I want to search (.*)$")
	public void i_want_to_search(String string) {
		System.out.println(string);
		lp.EnterProduct(string);
	}

	@When("{string} products first page displayed")
	public void products_first_page_displayed(String string) {
		System.out.println(string);
		String currenturl = driver.getCurrentUrl();
		String search_content = currenturl.split("q=")[1].split("&")[0].replace("%20", " ");
		System.out.println(currenturl);
		if(search_content.contains(string)) {
			System.out.println("Hey user, "+string+"'s is searched successfully");
		}else {
			System.out.println("Hey user, "+string+"'s search is unsuccessfull");
		}
	}

	@And("Fetch for the Lowest {string}")
	public void fetch_for_the_cheapest(String string) {
		//System.out.println(string);
		list=new ArrayList<Integer>();
		elements=new ArrayList<WebElement>();
		for (WebElement priceElement : sp.getprices()) {
			try {
				// Remove all non-numeric characters
				String priceText = priceElement.getText().replaceAll("[^0-9]", "");
				int price = Integer.parseInt(priceText);
				list.add(price);
				elements.add(priceElement); // Store element corresponding to the price
			} catch (NumberFormatException e) {
				System.out.println("Unable to parse price: " + priceElement.getText());
			}
		}
		System.out.println("Successfully able to parse string to integer");
		System.out.println("Unsorted list: "+list);
		Collections.sort(list); 
		System.out.println("Sorted list: "+list);

		if(!list.isEmpty()) {
			Lowest = list.get(0);
			System.out.println("Cheapest price is: "+Lowest);

			for(WebElement element:elements) { 
				int price =	Integer.parseInt(element.getText().replaceAll("[^0-9]", "")); 
				if (price == Lowest) {
					LowestElement = element; 
					break;
				}
			}
		}

	}

	@Then("Click on it")
	public void click_on_it() {
		System.out.println("Finish");
		if (LowestElement != null) {
			LowestElement.click();
			System.out.println("Successfully clicked on the Element");
		} else {
			System.out.println("No element to click.");
		}
	}

}
