package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedProduct {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='Nx9bqj _4b5DiR']")
	List<WebElement> Product_prices;
	
	public SearchedProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getprices() {
		 return Product_prices;
	}
	
}
