package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.PatentsMyProfilePage;

public class TestPatentMyProfile extends BaseTestLogin

{
    PatentsMyProfilePage objPatentPage;
    @Test
    public void testPatent() throws InterruptedException
    {
        objPatentPage=new PatentsMyProfilePage(driver,conn,stmt,resultSet,actions);
        try {
            objPatentPage.callMyProfileFunc();
            Thread.sleep(2000);
            objPatentPage.callScrollByFunc();
            Thread.sleep(2000);
            objPatentPage.clickOnAddPatent();
            Thread.sleep(2000);
            objPatentPage.setPatentName("patent1");
            Thread.sleep(2000);
            objPatentPage.clickOnPatentStatus();
            Thread.sleep(2000);
            objPatentPage.setPatentStatus("Applied");
            Thread.sleep(2000);
            objPatentPage.setPatentDesc("patent1 Desc");
            Thread.sleep(2000);
            objPatentPage.clickSave();
            Thread.sleep(5000);
            objPatentPage.clickOnAddPatent();
            Thread.sleep(2000);
            objPatentPage.setPatentName("patent2");
            Thread.sleep(2000);
            objPatentPage.clickOnPatentStatus();
            Thread.sleep(2000);
            objPatentPage.setPatentStatus("Applied");
            Thread.sleep(2000);
            objPatentPage.setPatentDesc("patent2 Desc");
            Thread.sleep(2000);
            objPatentPage.clickSave();
            Thread.sleep(5000);
            objPatentPage.checkPatents();

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in test patent my profile------->"+getClass(),true);
        }



    }
}
