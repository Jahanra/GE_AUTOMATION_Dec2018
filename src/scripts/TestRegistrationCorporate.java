package scripts;



import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

import java.sql.SQLException;
import java.util.PriorityQueue;


public class TestRegistrationCorporate extends BaseTest
{

	RegistrationPage regPageObj;
	HomePage objHomePage;
	PricingPage objPricing;
	LoginPage objlogin;
	ContactUsPage objContactUs;
	//Scenario -1 : Request for demo from home page.

	String name=null;
	String designation=null;
	String company=null;
	String emailId=null;
	String comment=null;
	String subject=null;

	@Test(priority =1)
	public void testRequestForDemoHomePage()
	{
		regPageObj=new RegistrationPage(driver,conn,stmt,resultSet,actions);
		objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
		objPricing=new PricingPage(driver,conn,stmt,resultSet,actions);
		objlogin=new LoginPage(driver,conn,stmt,resultSet,actions);
		objContactUs = new ContactUsPage(driver,conn,stmt,resultSet,actions);
		int rc= Excel.getRowCount(INPUT_PATH, "RegistrationBusiness");

		try {

			regPageObj.clickRequestForDemo();

			for (int i = 1; i <= 2; i++)
			{
				 name = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 0);
				designation = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 1);
				company = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 2);
				 emailId = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 5);
				comment = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 7);
				subject=Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 8);


				if (null!=name && !name.isEmpty())
				{
					objContactUs.setSubjectRequestForDemo();
					objContactUs.setName(name);
				    objContactUs.setDesignation(designation);
				    objContactUs.setCompany(company);
				    objContactUs.setEmailId(emailId);
				    objContactUs.setComment(comment);
				    objContactUs.clickSubmitButton();
					Thread.sleep(2000);
					validateTestRequestForDemo();
					Reporter.log("Request For Demo Has Sent Successfully!!!!!!", true);
				}
			}
		}
        catch(Exception e)
		{
        	e.printStackTrace();
        	Reporter.log("Exception in request for demo  method---->"+getClass());
		}
	}

	@Test(priority = 2)
	public void testRequestForDemoPricingPage()
	{
		regPageObj=new RegistrationPage(driver,conn,stmt,resultSet,actions);
		objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
		objPricing=new PricingPage(driver,conn,stmt,resultSet,actions);
		objlogin=new LoginPage(driver,conn,stmt,resultSet,actions);
		int rc= Excel.getRowCount(INPUT_PATH, "RegistrationBusiness");

		try {

			objHomePage.clickPricingLink();
			Thread.sleep(3000);
			objPricing.clickOnRequestForDemo2();

			for (int i = 3; i <= 5; i++)
			{
				 name = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 0);
				 designation = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 1);
				 company = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 2);
				 emailId = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 5);
				 comment = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 7);
				subject=Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 8);



				if (null!=name && !name.isEmpty())
				{
					objContactUs.setSubjectRequestForDemo();
					objContactUs.setName(name);
					objContactUs.setDesignation(designation);
					objContactUs.setCompany(company);
					objContactUs.setEmailId(emailId);
					objContactUs.setComment(comment);
					objContactUs.clickSubmitButton();
					Thread.sleep(2000);
					validateTestRequestForDemo();
					Reporter.log("Request For Demo Has Sent Successfully from Pricing Page!!!!!!", true);
					objPricing.clickOnRequestForDemo2();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Exception in request for demo  method in pricing page---->"+getClass());
		}
	}

	@Test(priority = 3)
	public  void testRequestForDemoSignIn()
	{
		regPageObj=new RegistrationPage(driver,conn,stmt,resultSet,actions);
		objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
		objPricing=new PricingPage(driver,conn,stmt,resultSet,actions);
		objlogin=new LoginPage(driver,conn,stmt,resultSet,actions);
		int rc= Excel.getRowCount(INPUT_PATH, "RegistrationBusiness");

		try {

			objHomePage.clickSignInLink();
			objlogin.moveToLoginModalWindow();
			Thread.sleep(3000);
			objlogin.clickRequestForDemo();

			for (int i = 3; i <= 5; i++)
			{
				name = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 0);
				designation = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 1);
				company = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 2);
				emailId = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 5);
				comment = Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 7);
				subject=Excel.getCellValue(INPUT_PATH, "RegistrationBusiness", i, 8);



				if (null!=name && !name.isEmpty())
				{
					objContactUs.setSubjectRequestForDemo();
					objContactUs.setName(name);
					objContactUs.setDesignation(designation);
					objContactUs.setCompany(company);
					objContactUs.setEmailId(emailId);
					objContactUs.setComment(comment);
					objContactUs.clickSubmitButton();
					Thread.sleep(2000);
					validateTestRequestForDemo();
					Reporter.log("Request For Demo Has Sent Successfully from Pricing Page!!!!!!", true);
					objPricing.clickOnRequestForDemo2();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Exception in request for demo- Sign In---->"+getClass());
		}
	}

	public void validateTestRequestForDemo() throws SQLException
	{
		regPageObj.validateCorporateRequest
				("SELECT * from contact_us",name,emailId,subject,designation,company,comment);
	}
}