package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.ManagementPage;

public class TestManagementTeam extends BaseTestLogin
{
    ManagementPage objManagementPage;

    @Test
    public void testManagement()throws  InterruptedException
    {
        objManagementPage = new ManagementPage(driver, conn, stmt, resultSet, actions);
        try
        {
            objManagementPage.callMyProfilefunc();
            Thread.sleep(2000);
            objManagementPage.scrollByUsingJSFunc();
            Thread.sleep(2000);
            objManagementPage.clickOnAddExecutive();
            Thread.sleep(2000);
            objManagementPage.setExecutiveName("Fred Kangwa");
            Thread.sleep(2000);
            objManagementPage.setExecutiveDesignation("CEO");
            Thread.sleep(2000);
            objManagementPage.clickOnPastCompany();
            Thread.sleep(2000);
            objManagementPage.setPastCompany("Microsoft");
            Thread.sleep(2000);
            objManagementPage.clickOnPreviousExp();
            Thread.sleep(2000);
            objManagementPage.setPreviousExp("Experience as Founder/CEO");
            Thread.sleep(2000);
            objManagementPage.clickOnUniversity();
            Thread.sleep(2000);
            objManagementPage.setUniversity("Harvard University");
            Thread.sleep(2000);
            objManagementPage.clickOnHighQual();
            Thread.sleep(2000);
            objManagementPage.setHighQualification("Mphil/PHD");
            Thread.sleep(2000);
            objManagementPage.clickOnTotalExp();
            Thread.sleep(2000);
            objManagementPage.setTotalExp("14");
            Thread.sleep(2000);
            objManagementPage.clickOnNoOfPatentsFiled();
            Thread.sleep(2000);
            objManagementPage.setNoOfPatentsFiled("5");
            Thread.sleep(2000);
            objManagementPage.setBioDescription("Woking as a CEO Of Microsoft");
            Thread.sleep(2000);
            objManagementPage.setLinkedInUrl("www.linkedin.com/fred");
            Thread.sleep(2000);
            objManagementPage.setTwitterUrl("www.twitter.com/fred");
            Thread.sleep(200);
            objManagementPage.clickSave();


        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in test managemet function ------->"+getClass(),true);
        }
        try
        {
            objManagementPage.checkResultTestManagement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
