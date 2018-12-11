package base;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import generics.Utility;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public  abstract class BasePage
{

	public Logger log=Logger.getLogger(this.getClass());
	public long timeout=Long.parseLong(Utility.getPropertyValue(AutomationConstants.CONFIG_PATH, "EXPLICIT"));
	public WebDriver driver;
	WebDriverWait wait;
	public Connection conn;
	public Statement stmt;
	public ResultSet resultSet;
	public Actions actions;

	public BasePage(WebDriver driver,Connection conn,Statement stmt,ResultSet resultSet,Actions actions)
	{

		this.driver=driver;
		this.actions=actions;
		this.conn=conn;
		this.stmt=stmt;
		this.resultSet=resultSet;

		  PageFactory.initElements(driver,this);
	}
	public void verifyURLhas(String expectedUrl)
	{
		  new WebDriverWait(driver,timeout);
		  wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
	public boolean verifyElementPresentOrNot(String xp)
	{
	 try{
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
		 return true;
		  
	}
	catch(ElementNotVisibleException e)
	{
		System.out.println("Verify URL Excetion");
		  return false;
	}

	}
}
