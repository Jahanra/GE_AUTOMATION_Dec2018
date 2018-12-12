package scripts;

import base.BaseTest;
import generics.Excel;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

public class TestForgotPassword extends BaseTest
{
    HomePage objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
    LoginPage objLogin=new LoginPage(driver,conn,stmt,resultSet,actions);
    ForgotPasswordPage objForgotPwd=new ForgotPasswordPage(driver,conn,stmt,resultSet,actions);
    String registeredEmailId=null;
    @Test
    public void testForgotPassword()
    {
        try {


            int rc= Excel.getRowCount(INPUT_PATH, "ForgotPassword");
            for (int i = 1; i <= rc; i++)
            {
                objHomePage.clickSignInLink();
                objLogin.moveToLoginModalWindow();
                objLogin.clickForgotPwd();
                registeredEmailId=Excel.getCellValue(INPUT_PATH,"ForgotPassword",i,1);
                objForgotPwd.setRegisterdEmailId(registeredEmailId);
                Thread.sleep(3000);
                objForgotPwd.clickResetBtn();
                objForgotPwd.checkAlertMessage();
            }
            }



        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
