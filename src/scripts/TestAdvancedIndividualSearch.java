package scripts;

import base.BaseTestLogin;
import generics.Excel;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.AdvancedSearchPage;

import java.sql.ResultSet;
import java.sql.Statement;

public class TestAdvancedIndividualSearch extends BaseTestLogin {
    AdvancedSearchPage objAdvSearchPage;
    String technology = null;
    String industry = null;
    String solutions = null;
    String location = null;
    String empCount = null;
    String businessType = null;
    String investors = null;
    String from = null;
    String to = null;
    String x = null;
    String y = null;
    String fundingStage = null;

    @Test(priority = 1)
    public void testAdvancedTechSearch() {
        Reporter.log("Running advanced search top level technology Scenarios", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvTechnology();


        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test technology!!!!!!!!!!!", true);
        }

        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            Reporter.log("calling validate data", true);
            validateTechnology();
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in validate data" + getClass(), true);
        }

    }

    @Test(priority = 2)
    public void testAdvIndusSearch() throws InterruptedException {
        Reporter.log("Running advanced search Upper level  industry Scenarios", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        ;
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvIndustry();
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv  Level Industry!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            validateIndustry();

        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in  result test" + getClass(), true);
        }


    }

    @Test(priority = 3)
    public void testAdvSolutionSearch() {

        Reporter.log("-----------------------Running advanced search solution Scenarios--------------------", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvSolutions();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv solution !!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.checkResultTestSolutions();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(), true);
        }

    }

    @Test(priority = 4)
    public void testAdvLocationSearch() {

        Reporter.log("-----------------------Running advanced search Country Scenarios--------------------", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvLocation();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv location !!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.checkResultCountry();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(), true);
        }

    }

    @Test(priority = 5)
    public void testAdvBusinessTypeSearch() {

        Reporter.log("-----------------------Running advanced search Business Type Scenarios--------------------", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvBusinessType();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv business !!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.checkResultBusinessType();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(), true);
        }

    }

    @Test(priority = 6)
    public void testAdvEmployeeCountSearch() {

        Reporter.log("-----------------------Running advanced search Employee COunt Scenarios--------------------", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvEmpCount();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv employee count !!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.checkResultEmpCount();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(), true);
        }

    }

    @Test(priority = 7)
    public void testAdvFundingStageSearch() {

        Reporter.log("-----------------------Running advanced search funding stage Scenarios--------------------", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvFundingStage();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv funding stage !!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.checkResultFundingStage();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(), true);
        }

    }

    @Test(priority = 8)
    public void testAdvInvestorsSearch() {

        Reporter.log("-----------------------Running advanced search Investors Scenarios--------------------", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvInvestors();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv investors !!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.checkResultInvestors();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(), true);
        }


    }


    @Test(priority = 9)
    public void testAdvTotalFundingSearch() {
        Reporter.log("Running total funding search scenarios", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);

        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvTotalFunding();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in  total funding", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.checkResultTotalFunding();
            Thread.sleep(5000);
        } catch (Exception e)

        {
            e.printStackTrace();
            Reporter.log("Exception in check result test" + getClass(), true);
        }


    }


    @Test(priority = 10)
    public void testAdvFounderYearSearch() {
        Reporter.log("-----------------------Running advanced search founded year Scenarios--------------------", true);
        objAdvSearchPage = new AdvancedSearchPage(driver, conn, stmt, resultSet, actions);
        try {
            objAdvSearchPage.advclickAdvancedSearchLink();
            Thread.sleep(5000);
            testAdvFounderYear();

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv founded year !!!!!!!!!!!!!!", true);
        }
        try {
            objAdvSearchPage.clickSearchButton();
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
            Reporter.log("Exception in test adv search button!!!!!!!!!!!!!!", true);
        }

    }

    public void testAdvTechnology() throws InterruptedException {
        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++) {
            technology = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 0);
            if (null != technology && !technology.isEmpty()) {
                objAdvSearchPage.searchAdvTechnology(technology);
                objAdvSearchPage.selectAdvTechnology();

                if (objAdvSearchPage.checkAdvTopLevelTechnology() == false) {
                    if (objAdvSearchPage.checkAdvUpperAdvTechnology() == false) {
                        if (objAdvSearchPage.checkAdvMiddleTechnology() == false) {
                            objAdvSearchPage.checkAdvLowerTechnology();
                        }
                    }
                } else {
                    break;
                }
            }
        }
    }

    public void testAdvIndustry() throws InterruptedException {
        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++) {

            industry = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 1);

            if (null != industry && !industry.isEmpty()) {
                objAdvSearchPage.clickOnAdvIndustry(industry);
                Thread.sleep(3000);
                objAdvSearchPage.selectAdvIndustry();
                Thread.sleep(5000);
                if (objAdvSearchPage.checkAdvTopLevelIndustry() == false) {
                    objAdvSearchPage.checkAdvUpperIndustry();

                } else {
                    break;
                }


            }
        }
    }

    public void testAdvSolutions() throws InterruptedException {
        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++)

        {

            solutions = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 2);
            if (null != solutions && !solutions.isEmpty()) {
                objAdvSearchPage.clickOnAdvSolution(solutions);
                Thread.sleep(3000);
                objAdvSearchPage.selectAdvSolution();
                Thread.sleep(3000);
            }
        }
    }

    public void testAdvLocation() throws InterruptedException {
        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++)

        {
            location = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 3);
            if (null != location && !location.isEmpty()) {
                objAdvSearchPage.clickOnAdvCountry(location);
                Thread.sleep(3000);
                objAdvSearchPage.selectAdvCountry();
                Thread.sleep(3000);
            } else {
                break;
            }
        }
    }

    public void testAdvEmpCount() throws InterruptedException {
        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++)

        {
            empCount = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 4);
            if (null != empCount && !empCount.isEmpty()) {
                objAdvSearchPage.clickOnAdvEmpCount(empCount);
                Thread.sleep(3000);
                objAdvSearchPage.selectAdvEmpCount();
                Thread.sleep(3000);
            } else {
                break;
            }
        }
    }


    public void testAdvBusinessType() throws InterruptedException {

        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++)

        {
            businessType = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 5);
            if (null != businessType && !businessType.isEmpty()) {
                objAdvSearchPage.clickOnAdvBusinessType(businessType);
                Thread.sleep(3000);
                objAdvSearchPage.selectAdvBusinessType();
                Thread.sleep(3000);
            } else {
                break;
            }
        }

    }


    public void testAdvInvestors() throws InterruptedException {

        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++)

        {
            investors = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 6);
            if (null != investors && !investors.isEmpty()) {
                objAdvSearchPage.clickOnAdvInvestors(investors);
                Thread.sleep(3000);
                objAdvSearchPage.selectAdvInvestors();
                Thread.sleep(5000);
            } else

            {
                break;
            }
        }
    }

    public void testAdvTotalFunding() throws InterruptedException {

        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++)

        {
            from = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 7);
            to = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 8);
            if ((null != from && !from.isEmpty()) && (null != to && !to.isEmpty())) {
                objAdvSearchPage.clickOnAdvFundingFrom(from);

                objAdvSearchPage.clickOnAdvFundingTo(to);
                Thread.sleep(5000);

            } else {
                break;
            }
        }
    }

    public void testAdvFounderYear() throws InterruptedException {

        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++)

        {
            x = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 10);
            int x1 = Integer.parseInt(x);
            y = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 11);
            int y1 = Integer.parseInt(y);
            if (0 != x1 && 0 != y1) {
                objAdvSearchPage.setMinFounderYear(y1, x1);
                Thread.sleep(5000);
                objAdvSearchPage.setMaxFounderYear(x1, y1);
                Thread.sleep(5000);
            }
        }
    }

    public void testAdvFundingStage() throws InterruptedException {

        int rc = Excel.getRowCount(INPUT_PATH, "AdvancedSearch");

        for (int i = 1; i <= rc; i++) {
            fundingStage = Excel.getCellValue(INPUT_PATH, "AdvancedSearch", i, 9);
            if (null != fundingStage && !fundingStage.isEmpty()) {
                objAdvSearchPage.clickOnAdvFundingStage("IPO");
                Thread.sleep(3000);
                objAdvSearchPage.selectAdvFundingStage();
                Thread.sleep(3000);
            } else {
                break;
            }
        }
    }

    public void validateTechnology() throws InterruptedException {

        objAdvSearchPage.checkResultTestTechnology();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*)  ,horizontal FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE horizontal LIKE \"%" + technology + "%\" AND ((not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0)\n" +
                "\n ", "horizontal");
    }

    public void validateIndustry() throws InterruptedException {
        objAdvSearchPage.checkResultTestIndustry();
        Thread.sleep(5000);
        objAdvSearchPage.validateDataBase("SELECT COUNT(*)  ,industry FROM company_profile_replica_for_gepii_scoring \n" +
                "WHERE industry LIKE \"%" + industry + "%\" AND (not_to_display = 'No' OR not_to_display IS NULL) AND marked_as_deleted=0\n" +
                "AND horizontal_priority = 'p'\n" +
                "\n", "industry");

    }

    public void validateBusinessSolution() throws InterruptedException {
        objAdvSearchPage.validateDataBase("", "");
    }
}
