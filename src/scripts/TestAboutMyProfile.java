package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AboutMyProfilePage;

public class TestAboutMyProfile extends BaseTestLogin
{
    AboutMyProfilePage objAboutPage;

    @Test
    public void testAbout() throws InterruptedException
    {
        objAboutPage=new AboutMyProfilePage(driver,conn,stmt,resultSet,actions);
        try
        {
            objAboutPage.callMyProfileFunc();
            Thread.sleep(2000);
            objAboutPage.callScrollByFunc();
            Thread.sleep(2000);
            objAboutPage.clickOnAddAbout();
            Thread.sleep(5000);
            objAboutPage.setAboutCompany("A test for my profile scoring for the start up test");
            Thread.sleep(2000);
            objAboutPage.clickCancel();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in test about my profile ----------->"+getClass(),true);
        }
        try{

            objAboutPage.checkResultTestAbout();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
