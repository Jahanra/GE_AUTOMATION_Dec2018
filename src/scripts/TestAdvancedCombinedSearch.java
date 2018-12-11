package scripts;

import base.BaseTestLogin;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AdvancedSearchPage;

public class TestAdvancedCombinedSearch extends BaseTestLogin

{

     public TestAdvancedCombinedSearch()
     {
         super();
     }

    AdvancedSearchPage objAdvSearchPage;

    @Test
    public void testCombinedAdvSearch() throws InterruptedException
    {
        objAdvSearchPage=new AdvancedSearchPage(driver,conn,stmt,resultSet,actions);
        try {
            Reporter.log("Running Test Combined Advanced Search FUnction",true);
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(2000);
            objAdvSearchPage.searchAdvTechnology("Fintech");
            Thread.sleep(2000);
            objAdvSearchPage.selectAdvTechnology();
            Thread.sleep(2000);
            objAdvSearchPage.checkAdvTopLevelTechnology();
            Thread.sleep(2000);
            objAdvSearchPage.searchAdvTechnology("Finance and accounting");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvTechnology();
            Thread.sleep(5000);
            objAdvSearchPage.checkAdvUpperAdvTechnology();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvIndustry("Financial Services");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvIndustry();
            Thread.sleep(5000);
            objAdvSearchPage.checkAdvTopLevelIndustry();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvIndustry("Retail");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvIndustry();
            Thread.sleep(3000);
            objAdvSearchPage.checkAdvTopLevelIndustry();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvSolution("cashless payments");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvSolution();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvSolution("treasury management solutions");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvSolution();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvCountry("united states");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvCountry();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvCountry("  united kingdom");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvCountry();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvEmpCount("1 to 10");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvEmpCount();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvEmpCount("11 to 50");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvEmpCount();
            Thread.sleep(3000);
            /*objAdvSearchPage.clickOnAdvEmpCount("11 to 50");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvEmpCount();*/
           /* Thread.sleep(3000);*/
            /*objAdvSearchPage.clickOnAdvCities("london");
            Thread.sleep(3000);*/
           /* objAdvSearchPage.selectAdvEmpCount();
            Thread.sleep(3000);*/
           /* objAdvSearchPage.clickOnAdvCities("new york");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvEmpCount();
            Thread.sleep(3000);*/
            /*objAdvSearchPage.clickOnAdvCities("San Francisco");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvEmpCount();
            Thread.sleep(3000);*/
            objAdvSearchPage.clickOnAdvBusinessType("Both");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvBusinessType();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvFundingStage("seed");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvFundingStage();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvFundingStage("undisclosed");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvFundingStage();
            Thread.sleep(3000);
            objAdvSearchPage.clickOnAdvFundingStage("series B");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvFundingStage();
            Thread.sleep(3000);
            objAdvSearchPage.setMinFounderYear(53, 0);
            Thread.sleep(5000);
            objAdvSearchPage.setMaxFounderYear(0, 289);
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvFundingFrom("1");
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvFundingTo("10");
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvInvestors("Y Combinator");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvInvestors();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvInvestors("Alexis Ohanian");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvInvestors();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvInvestors("Verizon Ventures");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvInvestors();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvInvestors("Sequoia Capital");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvInvestors();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvInvestors("Endeavor");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvInvestors();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvInvestors("Entrepreneurs Roundtable Accelerator");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvInvestors();
            Thread.sleep(5000);
            objAdvSearchPage.clickOnAdvInvestors("Bank Hapoalim");
            Thread.sleep(3000);
            objAdvSearchPage.selectAdvInvestors();
            Thread.sleep(5000);
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);

    }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in Performing test combined search!!!!!!!!!!!",true);
        }
        try{
            validateData();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Reporter.log("Exception in validating data",true);
        }
    }
    public void validateData()
    {
        objAdvSearchPage.validateCombinedAdvancedSearchData("SELECT COUNT(1) FROM company_profile_replica_for_gepii_scoring  \n" +
                "WHERE  ((technology_segments LIKE \"%Finance and accounting%\")\n" +
                "OR (horizontal = 'fintech'))\n" +
                "AND (industry LIKE \"%financial services%\" OR industry LIKE \"%Retail%\")\n" +
                "AND (business_solutions LIKE \"%cashless payments%\" OR business_solutions LIKE \"%treasury management solutions%\")\n" +
                "AND (country LIKE \"%united states%\" OR country LIKE \"%united kingdom%\")\n" +
                "AND (team_size LIKE \"%1 to 10%\" OR team_size LIKE \"%11 to 50%\" OR team_size LIKE \"%51 to 200%\") \n" +
                "AND business_type LIKE \"%both%\"\n" +
                "AND (funding_stage LIKE \"%seed%\" OR funding_stage LIKE \"%undisclosed%\" OR funding_stage LIKE \"%series B%\")\n" +
                "AND founded_year >= '1995' AND founded_year <= '2017'\n" +
                "AND total_raised_funding_amount >= 1 AND total_raised_funding_amount <= 10\n" +
                "AND city LIKE \"%london%\" OR city LIKE \"%new york%\" OR city LIKE \"%San Francisco%\"\n" +
                "AND investor_names LIKE \"%Y Combinator%\" OR investor_names LIKE \"%Alexis Ohanian%\" \n" +
                "OR investor_names LIKE \"%Verizon Ventures%\" OR investor_names LIKE \"%Sequoia Capital%\" \n" +
                "OR investor_names LIKE \"%Endeavor%\" OR investor_names LIKE \"%Entrepreneurs Roundtable Accelerator%\" \n" +
                "OR investor_names LIKE \"%Bank Hapoalim%\" ");
    }

}
