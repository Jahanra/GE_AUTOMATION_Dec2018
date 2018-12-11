package scripts;

import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.StartUpRegistrationPage;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class TestRegistrationStartUp extends BaseTest
{
	HomePage objHomePage;
	RegistrationPage objReg;
	StartUpRegistrationPage objStartUpPage;
	LoginPage objlogin;
	String businessEmail;
	String companyName;


 @Test(priority = 1)
 public void testRegisterationStartUpNonExisting() throws InterruptedException
 {
	 objHomePage =new HomePage(driver,conn,stmt,resultSet,actions);
	 objReg=new RegistrationPage(driver,conn,stmt,resultSet,actions);
	 objStartUpPage=new StartUpRegistrationPage(driver,conn,stmt,resultSet,actions);
     objlogin=new LoginPage(driver,conn,stmt,resultSet,actions);
	 int rc= Excel.getRowCount(INPUT_PATH, "RegistrationStartUp");

try {
	objHomePage.clickRegisterHere();
	Thread.sleep(8000);

	for (int i = 1; i <= 2; i++)
	{
		String regStartUpvariation = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 0);
		String regLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 1);
		String startUplLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 2);
		companyName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 3);
		String domainName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 4);
		businessEmail = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 5);
		String name = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 6);
		String password = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 7);
		if (null!=companyName &&!(companyName.isEmpty())) {
			//Enter Company Name
			objStartUpPage.setCompanyName(companyName);
			//Enter Domain Name
			objStartUpPage.setDomainName(domainName);
			//Enter Business Email
			objStartUpPage.setBusinessMail(businessEmail);
			//Enter Name
			objStartUpPage.setName(name);
			//Enter Password
			objStartUpPage.setPassword(password);
			//Check On Agree Terms check box
			objStartUpPage.clickAgreeTerms();
			//Click On Sign Up Button
			objStartUpPage.clickOnRegister();
			Thread.sleep(2000);
			objReg.clickOnClose();
			Thread.sleep(2000);
			objlogin.clickSignIn();
			Thread.sleep(3000);
			objlogin.clickregisterNow();
			Thread.sleep(2000);
            objlogin.clickOnStartUpRegister();
			Reporter.log("variation of start up-------->" + regStartUpvariation, true);
			Reporter.log("Registration For" + regStartUpvariation + " has done successfully!!!!!!", true);
			validateTestRegStartUp();

		}
	}
}
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 Reporter.log("Registartion Startup exception for non- existing startup!!!!!",true);
	 }


 }

    @Test(priority = 2)
    public void testRegisterationStartUpExisting() throws InterruptedException
    {
        objHomePage =new HomePage(driver,conn,stmt,resultSet,actions);
        objReg=new RegistrationPage(driver,conn,stmt,resultSet,actions);
        objStartUpPage=new StartUpRegistrationPage(driver,conn,stmt,resultSet,actions);
        objlogin=new LoginPage(driver,conn,stmt,resultSet,actions);
        int rc= Excel.getRowCount(INPUT_PATH, "RegistrationStartUp");

        try {
            objHomePage.clickRegisterHere();
            Thread.sleep(8000);

            for (int i = 3; i<=3; i++)
            {
                String regStartUpvariation = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 0);
                String regLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 1);
                String startUplLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 2);
                companyName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 3);
                String domainName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 4);
                businessEmail = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 5);
                String name = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 6);
                String password = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 7);
                if (null!=companyName &&!(companyName.isEmpty())) {
                    //Enter Company Name
                    //objStartUpPage.setCompanyName(companyName);
                    objStartUpPage.selectCompanyAuto(companyName);
                    //Enter Domain Name

                    //Enter Business Email
                    objStartUpPage.setBusinessMail(businessEmail);
                    //Enter Name
                    objStartUpPage.setName(name);
                    //Enter Password
                    objStartUpPage.setPassword(password);
                    //Check On Agree Terms check box
                    objStartUpPage.clickAgreeTerms();
                    //Click On Sign Up Button
                    objStartUpPage.clickOnRegister();
                    Thread.sleep(2000);
                    objReg.clickOnClose();
Reporter.log("variation of start up-------->" + regStartUpvariation, true);
                    Reporter.log("Registration For" + regStartUpvariation + " has done successfully!!!!!!", true);
                    validateTestRegStartUp();

                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            Reporter.log("Registeration startup exception for existing one!!!!!",true);
        }


    }






    //Scenario-4: start up link-->Register for free.
    //Scenario-5: start up link-->Register now

    @Test(priority = 3)
 public void testRegisterationStartUpRegisterForFree1()
    {
     objHomePage = new HomePage(driver, conn, stmt, resultSet, actions);
     objReg = new RegistrationPage(driver, conn, stmt, resultSet, actions);
     objStartUpPage = new StartUpRegistrationPage(driver, conn, stmt, resultSet, actions);
     objlogin = new LoginPage(driver, conn, stmt, resultSet, actions);
     int rc = Excel.getRowCount(INPUT_PATH, "RegistrationStartUp");

     try {

         objHomePage.clickStartUpLink();
         Thread.sleep(2000);
         objStartUpPage.clickOnRegisterFree1();
         objStartUpPage.moveToRegisterModal();

         Thread.sleep(2000);

         for (int i = 4; i <= 5; i++)
         {
             String regStartUpvariation = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 0);
             String regLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 1);
             String startUplLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 2);
             companyName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 3);
             String domainName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 4);
             businessEmail = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 5);
             String name = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 6);
             String password = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 7);
             if (null != companyName && !(companyName.isEmpty())) {
                 //Enter Company Name
                 objStartUpPage.setCompanyName(companyName);
                 //Enter Domain Name
                 objStartUpPage.setDomainName(domainName);
                 //Enter Business Email
                 objStartUpPage.setBusinessMail(businessEmail);
                 //Enter Name
                 objStartUpPage.setName(name);
                 //Enter Password
                 objStartUpPage.setPassword(password);
                 //Check On Agree Terms check box
                 objStartUpPage.clickAgreeTerms();
                 //Click On Sign Up Button
                 objStartUpPage.clickOnRegister();
                 Thread.sleep(2000);
                 objReg.clickOnClose();
                 Thread.sleep(2000);
                 objStartUpPage.clickOnRegisterFree1();
                 Reporter.log("variation of start up-------->" + regStartUpvariation, true);
                 Reporter.log("Registration For" + regStartUpvariation + " has done successfully!!!!!!", true);
                 validateTestRegStartUp();

             }
         }


     } catch (Exception e) {
         e.printStackTrace();
         Reporter.log("Register of startups from startups page !!!!!", true);
     }
 }



    @Test(priority = 4)
    public void testRegisterationStartUpRegisterNow1() {
        objHomePage = new HomePage(driver, conn, stmt, resultSet, actions);
        objReg = new RegistrationPage(driver, conn, stmt, resultSet, actions);
        objStartUpPage = new StartUpRegistrationPage(driver, conn, stmt, resultSet, actions);
        objlogin = new LoginPage(driver, conn, stmt, resultSet, actions);
        int rc = Excel.getRowCount(INPUT_PATH, "RegistrationStartUp");

        try {
            objHomePage.clickStartUpLink();
            Thread.sleep(2000);

            objStartUpPage.clickOnRegisterNow2();
            objStartUpPage.moveToRegisterModal();
            for (int i = 6; i <= 7; i++) {
                String regStartUpvariation = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 0);
                String regLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 1);
                String startUplLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 2);
                companyName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 3);
                String domainName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 4);
                businessEmail = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 5);
                String name = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 6);
                String password = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 7);
                if (null != companyName && !(companyName.isEmpty())) {
                    //Enter Company Name
                    objStartUpPage.setCompanyName(companyName);
                    //Enter Domain Name
                    objStartUpPage.setDomainName(domainName);
                    //Enter Business Email
                    objStartUpPage.setBusinessMail(businessEmail);
                    //Enter Name
                    objStartUpPage.setName(name);
                    //Enter Password
                    objStartUpPage.setPassword(password);
                    //Check On Agree Terms check box
                    objStartUpPage.clickAgreeTerms();
                    //Click On Sign Up Button
                    objStartUpPage.clickOnRegister();
                    Thread.sleep(2000);
                    objReg.clickOnClose();
                    Thread.sleep(2000);
                    objStartUpPage.clickOnRegisterNow3();


                    Reporter.log("variation of start up-------->" + regStartUpvariation, true);
                    Reporter.log("Registration For" + regStartUpvariation + " has done successfully!!!!!!", true);
                    validateTestRegStartUp();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Registeration of startup from startup page !!!!!", true);
        }
    }

    @Test(priority = 5)
    public void testRegisterationStartUpSignIn() {
        objHomePage = new HomePage(driver, conn, stmt, resultSet, actions);
        objReg = new RegistrationPage(driver, conn, stmt, resultSet, actions);
        objStartUpPage = new StartUpRegistrationPage(driver, conn, stmt, resultSet, actions);
        objlogin = new LoginPage(driver, conn, stmt, resultSet, actions);
        objHomePage.clickSignInLink();
        objlogin.moveToLoginModalWindow();
        objlogin.clickOnStartUpRegister();
        int rc = Excel.getRowCount(INPUT_PATH, "RegistrationStartUp");
        try {
            for (int i = 1; i <= rc; i++) {
                String regStartUpvariation = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 0);
                String regLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 1);
                String startUplLink = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 2);
                companyName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 3);
                String domainName = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 4);
                businessEmail = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 5);
                String name = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 6);
                String password = Excel.getCellValue(INPUT_PATH, "RegistrationStartUp", i, 7);
                if (null != companyName && !(companyName.isEmpty())) {
                    //Enter Company Name
                    objStartUpPage.setCompanyName(companyName);
                    //Enter Domain Name
                    objStartUpPage.setDomainName(domainName);
                    //Enter Business Email
                    objStartUpPage.setBusinessMail(businessEmail);
                    //Enter Name
                    objStartUpPage.setName(name);
                    //Enter Password
                    objStartUpPage.setPassword(password);
                    //Check On Agree Terms check box
                    objStartUpPage.clickAgreeTerms();
                    //Click On Sign Up Button
                    objStartUpPage.clickOnRegister();
                    Thread.sleep(2000);
                    objReg.clickOnClose();
                    Thread.sleep(2000);

                    Reporter.log("variation of start up-------->" + regStartUpvariation, true);
                    Reporter.log("Registration For" + regStartUpvariation + " has done successfully!!!!!!", true);
                    validateTestRegStartUp();


                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Registeration of startup from sign in link!!!!!", true);
        }
    }



	public void validateTestRegStartUp() throws SQLException
	{
		objReg.validateDataRegStartUp("SELECT login,user_category,user_company_id,expiry_date,promo_code_id FROM jhi_user WHERE login LIKE \"%"+businessEmail+"%\"","SELECT id FROM `company_profile` WHERE company_name LIKE \"%"+companyName+"%\"","UPDATE jhi_user SET activated = 1 WHERE login LIKE \"%"+businessEmail+"%\"");

	}
}
