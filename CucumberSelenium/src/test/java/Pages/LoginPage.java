package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//span[.='Login']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//input[@name='q']")
	//@CacheLookup
	WebElement Search_field;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickLoginBtn() {
		LoginBtn.click();
	}
	
	public void EnterProduct(String Product) {
		Search_field.sendKeys(Product+Keys.ENTER);
	}
	
	public void ClearSearch() {
		Search_field.clear();
		Search_field.sendKeys(Keys.ENTER);
	}
	
}
