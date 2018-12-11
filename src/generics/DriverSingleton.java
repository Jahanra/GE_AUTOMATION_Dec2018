package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
	private static DriverSingleton driverSingleton;
	private static WebDriver driver;
	String key = "webdriver.chrome.driver";
	String Value = "./Software/chromedriver.exe";

	/**
	 * Create private construcuctor
	 */
	private DriverSingleton() 
	{
		System.out.println("calling driver singleton--------------------------");
		System.setProperty(key, Value);
		driver = new ChromeDriver();
	}

	/**
	 * Create a static method to get instance.
	 */
	public static DriverSingleton getInstance()
	{
		System.out.println("calling into driver single ton  get instance-----------------");
		if (driverSingleton == null) 
		{
			System.out.println(driverSingleton+"************calling driversingleton************");
			driverSingleton = new DriverSingleton();
		}
		return driverSingleton;
	}
	
	public WebDriver getWebDriver() {
		return driver;
	}
}
