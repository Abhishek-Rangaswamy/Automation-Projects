package BrowserInstance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingletonWebDriver {

	private static WebDriver driver;

	public SingletonWebDriver() {

	}

	public static WebDriver getDriver(String BrowserName) {

		if(BrowserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("FireFox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();

		return driver;

	}

	public static void closeDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}

}
