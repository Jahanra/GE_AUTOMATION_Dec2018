package scripts;

import base.BaseTestLogin;
import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.DashboardPage;
import pages.HomePage;
import pages.MyAccountPage;

public class TestChangePassword extends BaseTestLogin
{

    HomePage objHomePage=new HomePage(driver,conn,stmt,resultSet,actions);
    DashboardPage objDashBrd=new DashboardPage(driver,conn,stmt,resultSet,actions);
    MyAccountPage objMyAccount=new MyAccountPage(driver,conn,stmt,resultSet,actions);
    ChangePasswordPage objChangePwd=new ChangePasswordPage(driver,conn,stmt,resultSet,actions);
    String password=null;
    String confirmPassword=null;

    @Test
    public void testChangePassword()
    {
        try {
            int rc = Excel.getRowCount(INPUT_PATH, "ChangePassword");
            for (int i = 1; i <= rc; i++)
            {
                objHomePage.clickSignInLink();
                objDashBrd.clickOnMyProfile();
                objMyAccount.clickChangepassword();
                password=Excel.getCellValue(INPUT_PATH,"ChangePassword",i,1);
                confirmPassword=Excel.getCellValue(INPUT_PATH,"ChangePassword",i,2);
                objChangePwd.setPassword(password);
                objChangePwd.setConfirmPassword(confirmPassword);
                objChangePwd.saveChangePassword();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in change password class",true);
        }
    }

}
