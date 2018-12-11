package scripts;



import base.BaseTestLogin;
import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class TestLoginStartUp extends BaseTestLogin {

    @BeforeClass
    public void disableAutoLoginLogout()
    {
        loginRequired=false;
        logoutRequired=false;
    }
    LoginPage loginPageObj;
    DashboardPage objdbPage;
    HomePage objHomePage;
    StartUpRegistrationPage objStartUpPage;
    RegistrationPage objRegPage;

    String userName;
    String password;

    @Test(priority = 1)
    public void testLoginStartUpSignIn()
    {

        try {

            Reporter.log("Running the login test ",true);
             loginPageObj = new LoginPage(driver,conn,stmt,resultSet,actions);
            objdbPage=new DashboardPage(driver,conn,stmt,resultSet,actions);

            int rc= Excel.getRowCount(INPUT_PATH, "LoginStartUp");
            for (int i = 1; i <= rc; i++) {

                    userName = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 1);
                    password = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 2);
                loginPageObj.clickSignIn();
                loginPageObj.moveToLoginModalWindow();
                if (!(userName.isEmpty() && password.isEmpty()))
                {
                    loginPageObj.setUserName(userName);
                    Thread.sleep(1000);
                    loginPageObj.setPassword(password);
                    Thread.sleep(1000);
                    loginPageObj.clickLogin();
                    Thread.sleep(6000);
                    validateTestLoginDataStartUp();
                    Reporter.log("Login Done Successfully............!!!!!!!!!!!!!!!!!!!!!!!!!",true);

                    objdbPage.clickOnLogOut();
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Start Up Failed Exception");
        }

    }

    @Test(priority = 2)
    public void testLoginStartPage()
    {
        try
        {
            objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
             objStartUpPage=new StartUpRegistrationPage(driver,conn,stmt,resultSet,actions);
            objRegPage= new RegistrationPage(driver,conn,stmt,resultSet,actions);
            objStartUpPage.clickOnRegisterFree1();
            objRegPage.moveTORegistrationModalWindow();
            Thread.sleep(3000);
            objRegPage.clickSignInRegLink();
            loginPageObj.moveToLoginModalWindow();
            int rc= Excel.getRowCount(INPUT_PATH, "LoginStartUp");
            for (int i = 1; i <= rc; i++) {

                userName = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 1);
                password = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 2);
                loginPageObj.clickSignIn();
                loginPageObj.moveToLoginModalWindow();
                Thread.sleep(3000);
                if (!(userName.isEmpty() && password.isEmpty()))
                {
                    loginPageObj.setUserName(userName);
                    Thread.sleep(1000);
                    loginPageObj.setPassword(password);
                    Thread.sleep(1000);
                    loginPageObj.clickLogin();
                    Thread.sleep(6000);
                    validateTestLoginDataStartUp();
                    Reporter.log("Login Done Successfully............!!!!!!!!!!!!!!!!!!!!!!!!!",true);

                    objdbPage.clickOnLogOut();
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Start Up Failed Exception");
        }

    }




    @Test(priority = 3)
    public  void testLoginStartUpRegisterHere()
    {
        try
        {
            objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
            objRegPage= new RegistrationPage(driver,conn,stmt,resultSet,actions);
            loginPageObj = new LoginPage(driver,conn,stmt,resultSet,actions);

            objHomePage.clickRegisterHere();
            objRegPage.moveTORegistrationModalWindow();
            Thread.sleep(3000);
            objRegPage.clickSignInRegLink();
            loginPageObj.moveToLoginModalWindow();
            int rc= Excel.getRowCount(INPUT_PATH, "LoginStartUp");
            for (int i = 1; i <= rc; i++) {

                userName = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 1);
                password = Excel.getCellValue(INPUT_PATH, "LoginStartUp", i, 2);
                loginPageObj.clickSignIn();
                loginPageObj.moveToLoginModalWindow();
                Thread.sleep(3000);
                if (!(userName.isEmpty() && password.isEmpty()))
                {
                    loginPageObj.setUserName(userName);
                    Thread.sleep(1000);
                    loginPageObj.setPassword(password);
                    Thread.sleep(1000);
                    loginPageObj.clickLogin();
                    Thread.sleep(6000);
                    validateTestLoginDataStartUp();
                    Reporter.log("Login Done Successfully............!!!!!!!!!!!!!!!!!!!!!!!!!",true);

                    objdbPage.clickOnLogOut();
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Login Start Up Failed Exception");
        }

    }


    public  void validateTestLoginDataStartUp()
    {
        loginPageObj.validateLoginDataStartUp
                ("SELECT login, user_category, user_company_id, expiry_date, promo_code_id FROM jhi_user WHERE login LIKE \"%"+
                        userName+"%\"","STARTUP");

    }
}
