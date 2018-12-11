package scripts;

import base.BaseTest;
import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class TestLoginBusiness extends BaseTest
{
        @BeforeClass
        public void disableAutoLoginLogout()
        {
            loginRequired=false;
            logoutRequired=false;
        }
        LoginPage loginPageObj;
    DashboardPage objdbPage;

    String userName;
        String password;

        @Test
        public void testLoginBusiness(){

            try {

                Reporter.log("------------------------------------Running login test----------------------------------------",true);
                loginPageObj = new LoginPage(driver,conn,stmt,resultSet,actions);
                objdbPage=new DashboardPage(driver,conn,stmt,resultSet,actions);
                loginPageObj.clickSignIn();
                int rc= Excel.getRowCount(INPUT_PATH, "LoginBusiness");
                for (int i = 1; i <= rc; i++)
                {
                    userName=Excel.getCellValue(INPUT_PATH,"LoginBusiness",i,1);
                    password=Excel.getCellValue(INPUT_PATH,"LoginBusiness",i,2);
                    loginPageObj.setUserName(userName);
                    Thread.sleep(1000);
                    loginPageObj.setPassword(password);
                    Thread.sleep(1000);
                    loginPageObj.clickLogin();
                    Thread.sleep(6000);
                    valiateTestLoginDataCorporate();
                    System.out.println("Login Done Successfully............!!!!!!!!!!!!!!!!!!!!!!!!!");
                    objdbPage.clickOnLogOut();
                }

            }
            catch (Exception e) {
                e.printStackTrace();
               Reporter.log("Login Business Failed Exception--------->"+getClass(),true);
            }
        }
        public void valiateTestLoginDataCorporate()
        {
            loginPageObj.validateLoginDataCorporate("SELECT login,user_category,user_company_id,expiry_date,promo_code_id FROM jhi_user WHERE login LIKE %"+userName+"%","CORPORATE");
        }


}
