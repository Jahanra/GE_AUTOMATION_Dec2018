package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	public static WebDriverWait getDriverWait()
	{
		WebDriver webDriver = DriverSingleton.getInstance().getWebDriver();
		WebDriverWait wait=new WebDriverWait(webDriver,60);
		return wait;
	}
}
