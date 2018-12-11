package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AdvancedSearchPage;
import pages.AdvancedSearchResultPage;
import pages.StartUpMyProfilePage;

public class TestAdvSearchNavigation  extends BaseTestLogin

{
    StartUpMyProfilePage objMyProfile;
    AdvancedSearchPage objAdvSearch;
    AdvancedSearchResultPage objAdvSearchRes;
    @Test
    public void testAdvSearchNavigation()
    {
        objMyProfile=new StartUpMyProfilePage(driver,conn,stmt,resultSet,actions);
        objAdvSearch=new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        objAdvSearchRes=new AdvancedSearchResultPage(driver,conn,stmt,resultSet,actions);
        try
        {
            
           Reporter.log("--------------------------------------Running advance search navigation scenario---------------------------------",true);
            objAdvSearch.advclickAdvancedSearchLink();
            Thread.sleep(2000);
            objAdvSearch.searchAdvTechnology("Fintech");
            Thread.sleep(3000);
            objAdvSearch.selectAdvTechnology();
            Thread.sleep(2000);
            objAdvSearch.checkAdvTopLevelTechnology();
            Thread.sleep(2000);
           /* objAdvSearch.searchAdvTechnology("Finance and accounting");
            Thread.sleep(3000);
            objAdvSearch.selectAdvTechnology();
            Thread.sleep(2000);*/
           /* objAdvSearch.checkAdvUpperAdvTechnology();
*/            /*Thread.sleep(3000);
            objAdvSearch.clickOnAdvIndustry("Financial Services");
            Thread.sleep(3000);
            objAdvSearch.selectAdvIndustry();
            Thread.sleep(2000);
            objAdvSearch.checkAdvTopLevelIndustry();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvIndustry("Retail");
            Thread.sleep(3000);
            objAdvSearch.selectAdvIndustry();
            Thread.sleep(3000);
            objAdvSearch.checkAdvTopLevelIndustry();
            Thread.sleep(5000);
            objAdvSearch.clickOnAdvSolution("cashless payments");
            Thread.sleep(3000);
            objAdvSearch.selectAdvSolution();
            Thread.sleep(5000);
            objAdvSearch.clickOnAdvSolution("treasury management solutions");
             Thread.sleep(3000);
            objAdvSearch.selectAdvSolution();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvCountry("united states");
             Thread.sleep(3000);
            objAdvSearch.selectAdvCountry();
            Thread.sleep(3000);
            objAdvSearch.clickOnAdvCountry("  united kingdom");
            Thread.sleep(3000);
                        objAdvSearch.selectAdvCountry();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvEmpCount("1 to 10");
             Thread.sleep(3000);
            objAdvSearch.selectAdvEmpCount();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvEmpCount("11 to 50");
             Thread.sleep(3000);
            objAdvSearch.selectAdvEmpCount();
            Thread.sleep(2000);*/
            /*objAdvSearch.clickOnAdvEmpCount("11 to 50");
            Thread.sleep(3000);
            objAdvSearch.selectAdvEmpCount();*/
            /* Thread.sleep(3000);*/
            /*objAdvSearch.clickOnAdvCities("london");
            Thread.sleep(3000);*/
           /* objAdvSearch.selectAdvEmpCount();
            Thread.sleep(3000);*/
           /* objAdvSearch.clickOnAdvCities("new york");
            Thread.sleep(3000);
            objAdvSearch.selectAdvEmpCount();
            Thread.sleep(3000);*/
            /*objAdvSearch.clickOnAdvCities("San Francisco");
            Thread.sleep(3000);
            objAdvSearch.selectAdvEmpCount();
            Thread.sleep(3000);*/
            /*objAdvSearch.clickOnAdvBusinessType("Both");
            Thread.sleep(3000);
            objAdvSearch.selectAdvBusinessType();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvFundingStage("seed");
            Thread.sleep(3000);
            objAdvSearch.selectAdvFundingStage();
            Thread.sleep(3000);
            objAdvSearch.clickOnAdvFundingStage("undisclosed");
            Thread.sleep(3000);
            objAdvSearch.selectAdvFundingStage();
            Thread.sleep(3000);*/
            /*objAdvSearch.clickOnAdvFundingStage("series B");
            Thread.sleep(3000);
            objAdvSearch.selectAdvFundingStage();
            Thread.sleep(3000);*/
            /*objAdvSearch.setMinFounderYear(53, 0);
            Thread.sleep(5000);
            objAdvSearch.setMaxFounderYear(0, 289);
            Thread.sleep(5000);*/
           /* objAdvSearch.clickOnAdvFundingFrom("1");
            Thread.sleep(5000);
            objAdvSearch.clickOnAdvFundingTo("10");
            Thread.sleep(5000);*/
//            objAdvSearch.clickOnAdvInvestors("Y Combinator");
//            Thread.sleep(3000);
//            objAdvSearch.selectAdvInvestors();
           // Thread.sleep(5000);
            /*objAdvSearch.clickOnAdvInvestors("Alexis Ohanian");
            Thread.sleep(3000);
            *///objAdvSearch.selectAdvInvestors();
          /*  Thread.sleep(2000);
            objAdvSearch.clickOnAdvInvestors("Verizon Ventures");
            Thread.sleep(3000);
            objAdvSearch.selectAdvInvestors();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvInvestors("Sequoia Capital");
            Thread.sleep(3000);
            objAdvSearch.selectAdvInvestors();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvInvestors("Endeavor");
            Thread.sleep(3000);
            objAdvSearch.selectAdvInvestors();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvInvestors("Entrepreneurs Roundtable Accelerator");
            Thread.sleep(3000);
            objAdvSearch.selectAdvInvestors();
            Thread.sleep(2000);
            objAdvSearch.clickOnAdvInvestors("Bank Hapoalim");*/
            /*Thread.sleep(3000);
            objAdvSearch.selectAdvInvestors();
*/            Thread.sleep(2000);
            objAdvSearch.clickSearchButton();
            Thread.sleep(5000);
            objAdvSearchRes.clickFirstCompany();
            Thread.sleep(5000);
            objAdvSearchRes.navigateBackSearchedResults();
            Thread.sleep(5000);
            objAdvSearchRes.clickFirstCompany();
            Thread.sleep(5000);
            objMyProfile.callScrollBy();
            Thread.sleep(5000);
            objMyProfile.clickOnCompet1();
            Thread.sleep(5000);
            objAdvSearchRes.navigateBackSearchedResults();


        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in --->"+getClass(),true);
        }
        
    }
}
