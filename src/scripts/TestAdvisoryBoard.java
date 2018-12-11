package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AdvisoryBoardPage;

public class TestAdvisoryBoard extends BaseTestLogin
{
    AdvisoryBoardPage objAdvisoryPage;
    @Test
    public void testAdvisory()throws  InterruptedException
    {
        objAdvisoryPage = new AdvisoryBoardPage(driver, conn, stmt, resultSet, actions);
        try
        {
            objAdvisoryPage.callMyProfilefunc();
            Thread.sleep(2000);
            objAdvisoryPage.callScrollByFunc();
            Thread.sleep(2000);
            objAdvisoryPage.clickOnAddAdvisory();
            Thread.sleep(2000);
            objAdvisoryPage.setExecutiveName("James");
            Thread.sleep(2000);
            objAdvisoryPage.setExecutiveDesignation("Founder");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnPastCompany();
            Thread.sleep(2000);
            objAdvisoryPage.setPastCompany("HDFC Bank");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnPreviousExp();
            Thread.sleep(2000);
            objAdvisoryPage.setPreviousExp("Experience of Product (Head/Manager)");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnUniversity();
            Thread.sleep(2000);
            objAdvisoryPage.setUniversity("Charles University in Prague");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnHighQual();
            Thread.sleep(2000);
            objAdvisoryPage.setHighQualification("Masters (ME/M.Tech/MBA)");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnTotalExp();
            Thread.sleep(2000);
            objAdvisoryPage.setTotalExp("7");
            Thread.sleep(2000);
           // objAdvisoryPage.clickOnNoOfPatentsFiled();
            /*Thread.sleep(2000);
            objAdvisoryPage.setNoOfPatentsFiled("5");
            Thread.sleep(2000);
            objAdvisoryPage.setBioDescription("Woking as a CEO Of Microsoft");
            Thread.sleep(2000);
            objAdvisoryPage.setLinkedInUrl("www.linkedin.com/fred");
            Thread.sleep(2000);
            objAdvisoryPage.setTwitterUrl("www.twitter.com/fred");
            Thread.sleep(200);*/
            objAdvisoryPage.clickSave();
            Thread.sleep(5000);
            objAdvisoryPage.checkResultAdvisory();
            Thread.sleep(5000);
            objAdvisoryPage.clickOnAddAdvisory();
            Thread.sleep(2000);
            objAdvisoryPage.setExecutiveName("Kang");
            Thread.sleep(2000);
            objAdvisoryPage.setExecutiveDesignation("Advisor");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnPastCompany();
            Thread.sleep(2000);
            objAdvisoryPage.setPastCompany("Azur Drones");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnPreviousExp();
            Thread.sleep(2000);
            objAdvisoryPage.setPreviousExp("Experience of Technology/Engineering (CTO)");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnUniversity();
            Thread.sleep(2000);
            objAdvisoryPage.setUniversity("Yale University");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnHighQual();
            Thread.sleep(2000);
            objAdvisoryPage.setHighQualification("Masters (ME/M.Tech/MBA)");
            Thread.sleep(2000);
            objAdvisoryPage.clickOnTotalExp();
            Thread.sleep(2000);
            objAdvisoryPage.setTotalExp("20");
            Thread.sleep(2000);
            //objAdvisoryPage.clickOnNoOfPatentsFiled();
            objAdvisoryPage.setBioDescription("Woking as an advisor  for Azur Drones");
            Thread.sleep(2000);
            objAdvisoryPage.setLinkedInUrl("www.linkedin.com/Kang");
            Thread.sleep(2000);
            objAdvisoryPage.clickSave();


        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in test advisory function ------->"+getClass(),true);
        }

    }
}
