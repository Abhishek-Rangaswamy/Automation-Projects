package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	@FindBy(xpath="//button[@class='QqFHMw vslbG+ In9uk2']")
	WebElement Add_cart;


	@FindBy(xpath="//input[@value='1']")
	WebElement Numberofitems;


	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement ClickaddcartBtn() {
		Add_cart.click();
		return Add_cart;
	}

	public WebElement ItemsNumber() {
		return Numberofitems;
	}

}
