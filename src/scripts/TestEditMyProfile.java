package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.StartUpBasicProfilePage;

public class TestEditMyProfile extends BaseTestLogin
{
    StartUpBasicProfilePage objStartUpBasicProfile;
    @Test
    public void testEditBasicProfile() throws InterruptedException
    {
        objStartUpBasicProfile=new StartUpBasicProfilePage(driver,conn,stmt,resultSet,actions);
        Reporter.log("Running test edit basic profile",true);
        objStartUpBasicProfile.callMyProfilefunc();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnEditIcon();
        Thread.sleep(5000);
        objStartUpBasicProfile.clickOnYearOfEstablishment("2000");
        Thread.sleep(5000);
        objStartUpBasicProfile.clickOnNoOfEmployee();
        Thread.sleep(2000);
        objStartUpBasicProfile.setNoOfEmployee("1 to 10");
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnCountry();
        Thread.sleep(2000);
        objStartUpBasicProfile.setCountryName("India");
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnCity();
        Thread.sleep(2000);
       objStartUpBasicProfile.setCity("Bangalore");
        Thread.sleep(2000);
        objStartUpBasicProfile.setShortDescription("An Example test for start up edit profile -Basic profile");
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnTechnology("Fintech");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.checkTopLevelTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnTechnology("Applications");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.checkUpperTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnTechnology("Development Tools");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.checkMiddleTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnTechnology("Smart Locks");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.checkLowerTechnology();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnIndustry("Automotive");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectIndustry();
        Thread.sleep(2000);
        objStartUpBasicProfile.checkTopLevelIndustry();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnIndustry("K-12");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectIndustry();
        Thread.sleep(2000);
        objStartUpBasicProfile.checkUpperIndustry();
        Thread.sleep(5000);
        objStartUpBasicProfile.clickOnIndustry("F&A");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectIndustry();
        Thread.sleep(2000);
        objStartUpBasicProfile.checkMiddleIndustry();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnSolution("Chatbot");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectSolution();
        Thread.sleep(5000);
        objStartUpBasicProfile.setNewSolution("Online Subscribcription");
        Thread.sleep(2000);
        objStartUpBasicProfile.addNewSolution();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnChallenges("Data Management");
        Thread.sleep(2000);
        objStartUpBasicProfile.selectChallenges();
        Thread.sleep(5000);
        objStartUpBasicProfile.setNewChallenges("Product Advertisement");
        Thread.sleep(2000);
        objStartUpBasicProfile.addNewChallenge();
        Thread.sleep(2000);
        objStartUpBasicProfile.clickOnContact("test29@startup.com");
        Thread.sleep(2000);
        objStartUpBasicProfile.clickSaveBasicProfile();
        Thread.sleep(8000);
        objStartUpBasicProfile.checkResultEditBasicProfile();
    }


}
