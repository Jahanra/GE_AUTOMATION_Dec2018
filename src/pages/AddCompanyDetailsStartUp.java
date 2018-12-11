package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddCompanyDetailsStartUp extends BasePage
{

	public AddCompanyDetailsStartUp(WebDriver driver, Connection conn, Statement stmt, ResultSet resultSet,Actions actions) {

		super(driver,conn,stmt,resultSet,actions);
	}

	
	
	@FindBy(xpath="//section[contains(text(),'User Profile')]")
	private WebElement userProfile;
	
	public void cickOnUserProfile()
	{
		userProfile.click();
	}
	
	
	
	@FindBy(xpath="//section[contains(text(),'Change Preferences')]")
	private WebElement changePreferences;
	
	public void clickOnChangePreferences()
	{
		changePreferences.click();
	}

	
	@FindBy(xpath="//section[contains(text(),'Change Password')]")
	private WebElement changePwd;
	
	public void clickOnChangePassword()
	{
		changePwd.click();
	}

	
}
