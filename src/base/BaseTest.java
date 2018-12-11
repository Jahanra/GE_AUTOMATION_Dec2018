package base;


import java.sql.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.lang.reflect.Method;

import generics.Listener;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import generics.Utility;

import org.apache.log4j.Logger;

import pages.LoginPage;
@Listeners(Listener.class)
public class BaseTest implements AutomationConstants
{
	public Logger log;
	public WebDriver driver;
	public static ExtentReports eReport;
    
	public static String url;
	public static String un;
	public static String pw;
	public static String homePageURL;
	public static String loginPageURL;
	public static long iTimeout;
	public static long eTimeout;
	public ExtentTest eTest;
	public static boolean loginRequired=true;
	public static boolean logoutRequired=true;
	String dbUrl = "jdbc:mysql://ge-staging-mysql-us-east.mysql.database.azure.com/dev_growth_enabler_ui";
	String username = "Growthenabler@ge-staging-mysql-us-east";
	 String password = "G30WthEn@813r";
	 protected Connection conn;
	 public  Statement stmt;
	public  ResultSet resultSet;
	public Actions actions;
	Properties properties = new Properties();




	public BaseTest() {
			log=Logger.getLogger(this.getClass());
		}
	 
	 @BeforeSuite
		public void initReport()
		{
			String log4jConfPath = "./log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			log.info("initializing ExtentReport");
			String now=Utility.getFormatedDateTime();
			String reportFile=REPORT_PATH+now+".html";
			eReport=new ExtentReports(reportFile);
		}
	@AfterSuite
	public void publishReport()
	{
		log.info("publishing ExtentReport");
		eReport.flush();
	}

	 @BeforeTest
		public void initGlobalVar(){
			log.info("initialize Global variables");
			url=Utility.getPropertyValue(CONFIG_PATH,"URL");
			un=Utility.getPropertyValue(CONFIG_PATH,"UN");
			pw=Utility.getPropertyValue(CONFIG_PATH,"PW");
			iTimeout=Long.parseLong(Utility.getPropertyValue(CONFIG_PATH,"IMPLICIT"));
			eTimeout=Long.parseLong(Utility.getPropertyValue(CONFIG_PATH,"EXPLICIT"));
		}

		@Parameters({"browser"})
		@BeforeClass
		public void initApplication(@Optional("chrome") String  browser) throws SQLException, ClassNotFoundException
		{

			if(browser.equals("chrome")){
				System.setProperty(CHROME_KEY,CHROME_VALUE);
				driver=new ChromeDriver();
				actions = new Actions(driver);
			}
			else{
				System.setProperty(GECKO_KEY,GECKO_VALUE);
				driver=new FirefoxDriver();
				actions = new Actions(driver);
			}
			driver.manage().timeouts().implicitlyWait(iTimeout,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				properties.setProperty("user", username);
				properties.setProperty("password", password);
				properties.setProperty("useSSL", "true");
				properties.setProperty("verifyServerCertificate", "true");
				properties.setProperty("requireSSL", "false");
				properties.setProperty("useUnicode", "true");
				properties.setProperty("serverTimezone", "UTC");
				conn = DriverManager.getConnection(dbUrl,properties);


			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	@BeforeMethod
	public void preCondition(Method method) throws Exception
	{
		System.out.println("calling before method of base test ******************************");
		driver.get(url);
		eTest=eReport.startTest(method.getName());

}
	@AfterMethod
	public void postCondition(ITestResult testNGTestResult)
	{
			   //driver.close();
	  
	   if(testNGTestResult.getStatus()==ITestResult.FAILURE)
		{
			eTest.log(LogStatus.FAIL,"Check log for details");
		}
		else
		{
			eTest.log(LogStatus.PASS,"Script executed successfully");
		}
		eReport.endTest(eTest);
	}

	@AfterClass
	public void closeApplication() throws InterruptedException
	{

		log.info("Closing Browser");
		driver.close();
	}
	@AfterTest
	public void CloseTheConnection() throws SQLException
	{


		// Code to close each and all Object related to Database connection
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}

		driver.quit();
	}
}